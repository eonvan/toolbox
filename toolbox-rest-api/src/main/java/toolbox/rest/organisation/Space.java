package toolbox.rest.organisation;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by eon on 2017/05/13.
 */
@Entity
class Space {

    Space() {
        projects = new HashSet<>();
        services = new HashSet<>();
    }

    Space(String id, String name) {
        this();
        this.id = id;
        this.name = name;
    }

    @Id
    private String id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Project> projects;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Service> services;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void addProject(Project project) {
        this.projects.add(project);
    }

    Project findProject(String projectId) {
        Optional<Project> project = this.projects.stream().filter(p -> p.getId().equals(projectId)).findFirst();
        if (project.isPresent()) return project.get();
        throw new RuntimeException("Project not found in this space");
    }

    void addService(Service service) {
        this.services.add(service);
    }

    Service findService(String serviceId) {
        Optional<Service> service = this.services.stream().filter(s -> s.getId().equals(serviceId)).findFirst();
        if (service.isPresent()) return service.get();
        throw new RuntimeException("Service not found in this space");
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public Set<Service> getServices() {
        return services;
    }
}
