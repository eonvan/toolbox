package toolbox.core;

import org.axonframework.commandhandling.model.AggregateMember;

import java.util.HashMap;
import java.util.Map;

class Project {

    private String identifier;
    private String name;
    private String group;
    private String packageName;

    @AggregateMember
    private Map<String, Artifact> artifacts = new HashMap<>();

    Project(final String identifier, final String name, final String group, final String packageName) {
        this.identifier = identifier;
        this.name = name;
        this.group = group;
        this.packageName = packageName;
    }

    @Override public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Project project = (Project) o;

        if (identifier != null ? !identifier.equals(project.identifier) : project.identifier != null) {
            return false;
        }
        if (name != null ? !name.equals(project.name) : project.name != null) {
            return false;
        }
        if (group != null ? !group.equals(project.group) : project.group != null) {
            return false;
        }
        return packageName != null ? packageName.equals(project.packageName) : project.packageName == null;
    }

    @Override public int hashCode() {
        int result = identifier != null ? identifier.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (packageName != null ? packageName.hashCode() : 0);
        return result;
    }
}
