package toolbox.rest.events;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toolbox.core.RegisterOrganisation;
import toolbox.rest.LoggingCallback;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
public class EventController {

    @Autowired
    private CommandGateway gateway;

    @PostMapping(path = "/events")
    public void handle(@RequestBody final Event event) {
        gateway.send(event.getPayload(), LoggingCallback.INSTANCE);
    }

}
