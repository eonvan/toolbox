package toolbox.rest.events;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class EventSerializer extends StdSerializer<Event> {

    public EventSerializer() {
        this(null);
    }

    public EventSerializer(final Class<Event> t) {
        super(t);
    }

    @Override
    public void serialize(
            final Event value, final JsonGenerator jgen, final SerializerProvider provider)
            throws IOException, JsonProcessingException {
        jgen.writeStartObject();

        jgen.writeStringField("guid", value.getGuid());
        jgen.writeStringField("type", value.getObjectType());
        jgen.writeStringField("timestamp", value.getTimestamp().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")));
        jgen.writeStringField("type", value.getObjectType());
        jgen.writeObjectField("payload", value.getPayload());

        jgen.writeEndObject();
    }
}
