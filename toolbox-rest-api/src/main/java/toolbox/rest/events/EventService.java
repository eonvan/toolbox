package toolbox.rest.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.atmosphere.config.managed.Decoder;
import org.atmosphere.config.managed.Encoder;
import org.atmosphere.config.service.Disconnect;
import org.atmosphere.config.service.ManagedService;
import org.atmosphere.config.service.Message;
import org.atmosphere.config.service.Ready;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

/**
 * Created by eon on 2017/05/14.
 */
@ManagedService(path = "/event")
public class EventService {

    private final Logger logger = LoggerFactory.getLogger(EventService.class);

    @Ready
    public void onReady(final AtmosphereResource resource) {
        this.logger.info("Connected", resource.uuid());
    }

    @Disconnect
    public void onDisconnect(AtmosphereResourceEvent event) {
        this.logger.info("Client {} disconnected [{}]", event.getResource().uuid(),
                (event.isCancelled() ? "cancelled" : "closed"));
    }

    @org.atmosphere.config.service.Message(encoders = JacksonEncoderDecoder.class, decoders = JacksonEncoderDecoder.class)
    public Event onEvent(Event event) throws IOException {
        this.logger.info("Received event {} {} {}", event.getGuid(),
                event.getTimestamp().format(DateTimeFormatter.ISO_DATE_TIME), event.getObjectType());
        return event;
    }

    public static class JacksonEncoderDecoder implements Encoder<Event, String>,
            Decoder<String, Event> {

        private final ObjectMapper mapper = new ObjectMapper();

        @Override
        public String encode(Event m) {
            try {
                return this.mapper.writeValueAsString(m);
            }
            catch (IOException ex) {
                throw new IllegalStateException(ex);
            }
        }

        @Override
        public Event decode(String s) {
            try {
                return this.mapper.readValue(s, Event.class);
            }
            catch (IOException ex) {
                throw new IllegalStateException(ex);
            }
        }

    }

}
