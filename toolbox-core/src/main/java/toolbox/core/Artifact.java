package toolbox.core;

class Artifact {
    private String identifier;
    private String name;

    Artifact(final String identifier, final String name) {
        this.identifier = identifier;
        this.name = name;
    }

    @Override public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Artifact artifact = (Artifact) o;

        if (identifier != null ? !identifier.equals(artifact.identifier) : artifact.identifier != null) {
            return false;
        }
        return name != null ? name.equals(artifact.name) : artifact.name == null;
    }

    @Override public int hashCode() {
        int result = identifier != null ? identifier.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
