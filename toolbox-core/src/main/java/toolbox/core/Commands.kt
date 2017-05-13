package toolbox.core

import org.axonframework.commandhandling.TargetAggregateIdentifier

/**
 * Created by eon on 5/10/17.
 */
data class RegisterOrganisation(@TargetAggregateIdentifier val organisationId: String, val name: String)

data class RenameOrganisation(@TargetAggregateIdentifier val organisationId: String, val name: String)

data class RegisterSpace(@TargetAggregateIdentifier val organisationId: String, val spaceId: String, val name: String)

data class RenameSpace(@TargetAggregateIdentifier val organisationId: String, val spaceId: String, val name: String)

data class RegisterProject(@TargetAggregateIdentifier val organisationId: String, val spaceId: String, val identifier: String, val name: String, val packageName: String, val group: String)

data class GenerateArtifacts(@TargetAggregateIdentifier val organisationId: String, val identifier: String)

data class DeployProject(@TargetAggregateIdentifier val organisationId: String, val identifier: String)

data class ArchiveProject(@TargetAggregateIdentifier val organisationId: String, val identifier: String)

data class RegisterService(@TargetAggregateIdentifier val organisationId: String, val spaceId: String, val identifier: String, val name: String)

data class RenameService(@TargetAggregateIdentifier val organisationId: String, val spaceId: String, val identifier: String, val name: String)
