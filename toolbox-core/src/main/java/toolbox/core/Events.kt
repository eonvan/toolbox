package toolbox.core

import org.axonframework.commandhandling.model.AggregateIdentifier

/**
 * Created by eon on 5/10/17.
 */
data class OrganisationRegistered(val organisationId: String, val name: String)

data class OrganisationUpdateFailed(@AggregateIdentifier val organisationId: String, val failureReason: String)

data class OrganisationRenamed(@AggregateIdentifier val organisationId: String, val name: String)

data class SpaceRegistered(@AggregateIdentifier val organisationId: String, val spaceId: String, val name: String)

data class SpaceRegistrationFailed(@AggregateIdentifier val organisationId: String, val spaceId: String, val reason: String)

data class SpaceRenamed(@AggregateIdentifier val organisationId: String, val spaceId: String, val name: String)

data class SpaceUpdateFailed(@AggregateIdentifier val organisationId: String, val spaceId: String, val reason: String)

data class ProjectRegistered(@AggregateIdentifier val organisationId: String, val spaceId: String, val identifier: String, val name: String, val packageName: String, val group: String)

data class ArtifactsGenerated(@AggregateIdentifier val organisationId: String, val identifier: String)

data class ArtifactGenerationFailed(@AggregateIdentifier val organisationId: String, val identifier: String, val reason: String)

data class ProjectDeployed(@AggregateIdentifier val organisationId: String, val identifier: String)

data class ProjectDeploymentFailed(@AggregateIdentifier val organisationId: String, val identifier: String, val reason: String)

data class ProjectArchived(@AggregateIdentifier val organisationId: String, val identifier: String)

data class ProjectArchiveFailed(@AggregateIdentifier val organisationId: String, val identifier: String, val reason: String)

data class ServiceRegistered(@AggregateIdentifier val organisationId: String, val identifier: String, val name: String)

data class ServiceRenamed(@AggregateIdentifier val organisationId: String, val identifier: String, val name: String)
