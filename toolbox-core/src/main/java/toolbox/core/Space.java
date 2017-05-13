package toolbox.core;

import org.axonframework.commandhandling.model.AggregateMember;
import org.axonframework.eventsourcing.EventSourcingHandler;

import java.util.HashMap;
import java.util.Map;

class Space {

    private String identifier;
    private String name;

    Space(final String identifier, final String name) {
        this.identifier = identifier;
        this.name = name;
    }

    @AggregateMember
    private Map<String, Project> projects = new HashMap<>();

    @AggregateMember
    private Map<String, Service> services = new HashMap<>();

    @Override public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Space space = (Space) o;

        return identifier.equals(space.identifier);
    }

    @Override public int hashCode() {
        return identifier.hashCode();
    }

    @EventSourcingHandler
    void on(final SpaceRegistered event) {
        this.identifier = event.getSpaceId();
        this.name = event.getName();
    }

    @EventSourcingHandler
    void on(final SpaceRenamed event) {
        this.name = event.getName();
    }

}
