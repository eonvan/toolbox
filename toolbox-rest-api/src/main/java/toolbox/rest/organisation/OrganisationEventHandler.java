package toolbox.rest.organisation;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;
import toolbox.core.OrganisationRegistered;
import toolbox.core.ProjectRegistered;
import toolbox.core.RegisterOrganisation;
import toolbox.core.SpaceRegistered;

import javax.inject.Inject;

/**
 * Created by eon on 2017/05/13.
 */
@Component
public class OrganisationEventHandler {

    @Inject
    private OrganisationRepository repository;

    @EventHandler
    void handle(OrganisationRegistered event) {
        repository.save(new Organisation(event.getOrganisationId(), event.getName()));
    }

    @EventHandler
    void handle(SpaceRegistered event) {
        Space space = new Space(event.getSpaceId(), event.getName());
        Organisation organisation = repository.findOne(event.getOrganisationId());

        organisation.addSpace(space);

        repository.save(organisation);
    }

    @EventHandler
    void handle(ProjectRegistered event) {
        Project project = new Project(event.getIdentifier(), event.getName());

        Organisation organisation = repository.findOne(event.getOrganisationId());

        Space space = organisation.findSpace(event.getSpaceId());

        space.addProject(project);

        repository.save(organisation);
    }
}
