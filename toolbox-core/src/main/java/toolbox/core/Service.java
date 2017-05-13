package toolbox.core;

class Service {

    private String identifier;
    private String name;

    Service(final String identifier, final String name) {
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

        final Service service = (Service) o;

        if (identifier != null ? !identifier.equals(service.identifier) : service.identifier != null) {
            return false;
        }
        return name != null ? name.equals(service.name) : service.name == null;
    }

    @Override public int hashCode() {
        int result = identifier != null ? identifier.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
