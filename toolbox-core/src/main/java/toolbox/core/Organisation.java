package toolbox.core;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateMember;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class Organisation {

    @AggregateIdentifier
    private String organisationId;

    @AggregateMember //Use a map here to avoid the need to specify a routing key
    private Map<String, Space> spaces = new HashMap<>();

    Organisation() {
    }

    @CommandHandler
    protected Organisation(final RegisterOrganisation command) {
        apply(new OrganisationRegistered(command.getOrganisationId(), command.getName()));
    }

    @CommandHandler
    protected void on(final RenameOrganisation command) {
        apply(new OrganisationRenamed(organisationId, command.getName()));
    }

    @EventSourcingHandler
    protected void handle(final OrganisationRegistered event) {
        this.organisationId = event.getOrganisationId();
    }

    @CommandHandler
    protected void on(final RegisterSpace command) {
        if (spaces.containsKey(command.getSpaceId())) {
            apply(new SpaceRegistrationFailed(organisationId, command.getSpaceId(),
                    MessageFormat.format("Space with id {0} already registered with org {1}", command.getSpaceId(), command.getOrganisationId())));
        } else {
            apply(new SpaceRegistered(organisationId, command.getSpaceId(), command.getName()));
        }
    }

    @EventSourcingHandler
    protected void handle(final SpaceRegistered event) {
        spaces.put(event.getSpaceId(), new Space(event.getSpaceId(), event.getName()));
    }

    @CommandHandler
    protected void on(final RenameSpace command) {
        if (spaces.containsKey(command.getSpaceId())) {
            apply(new SpaceUpdateFailed(command.getOrganisationId(), command.getSpaceId(),
                    MessageFormat.format("No space with id {0} registered with organisation {1}", command.getSpaceId(), command.getOrganisationId())));
        } else {
            apply(new SpaceRenamed(organisationId, command.getSpaceId(), command.getName()));
        }
    }

    @CommandHandler
    protected void on(final GenerateArtifacts command) {
        apply(new ArtifactsGenerated(organisationId, command.getIdentifier()));
    }

    @CommandHandler
    protected void on(final RegisterProject command) {
        apply(new ProjectRegistered(organisationId, command.getSpaceId(), command.getIdentifier(), command.getName(), command.getPackageName(), command.getGroup()));
    }

    @CommandHandler
    protected void on(final DeployProject command) {
        apply(new ProjectDeployed(organisationId, command.getIdentifier()));
    }

    @CommandHandler
    protected void on(final ArchiveProject command) {
        apply(new ProjectArchived(organisationId, command.getIdentifier()));
    }

    @CommandHandler
    protected void on(final RegisterService command) {
        apply(new ServiceRegistered(organisationId, command.getIdentifier(), command.getName()));
    }

    @CommandHandler
    protected void on(final RenameService command) {
        apply(new ServiceRenamed(organisationId, command.getIdentifier(), command.getName()));
    }

}
