package toolbox.rest.events;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@JsonSerialize(contentUsing = EventSerializer.class)
@JsonDeserialize(contentUsing = EventDeserializer.class)
public class Event {
    private String guid;
    private LocalDateTime timestamp;
    private String objectType;
    private Object payload;

    protected Event() {

    }

    public Event(final String guid, final LocalDateTime timestamp, final String objectType, final Object payload) {
        this.guid = guid;
        this.timestamp = timestamp;
        this.objectType = objectType;
        this.payload = payload;
    }

    public String getGuid() {
        return guid;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getObjectType() {
        return objectType;
    }

    public Object getPayload() {
        return payload;
    }
}
