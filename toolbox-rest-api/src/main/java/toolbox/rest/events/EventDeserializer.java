package toolbox.rest.events;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EventDeserializer extends StdDeserializer<Event> {

    private ObjectMapper mapper;

    public EventDeserializer() {
        this(null);
    }

    public EventDeserializer(final Class<Event> t) {
        super(t);
    }

    public void setMapper(final ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override public Event deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        final TreeNode node = jsonParser.getCodec().readTree(jsonParser);

        final String guid = ((TextNode) node.get("guid")).asText();

        final String timestamp = ((TextNode) node.get("timestamp")).asText();

        final LocalDateTime formatDateTime = LocalDateTime.parse(timestamp, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS"));

        final String objectType = ((TextNode) node.get("type")).asText();

        deserializationContext.setAttribute("type", objectType);

        final ObjectNode payloadNode = (ObjectNode) node.get("payload");

        Object payload = null;

        try {
            payload = mapper.convertValue(payloadNode, Class.forName(objectType));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        final Event event = new Event(guid,
                formatDateTime, objectType, payload);

        return event;
    }
}
