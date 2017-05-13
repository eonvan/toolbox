package toolbox.rest;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @Autowired
    private CommandGateway gateway;

    @PostMapping(path = "/events")
    public void handle(@RequestBody final Event event) {
        gateway.send(event.getPayload(), LoggingCallback.INSTANCE);
    }

}
