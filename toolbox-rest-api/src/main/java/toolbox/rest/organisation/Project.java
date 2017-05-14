package toolbox.rest.organisation;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by eon on 2017/05/13.
 */
@Entity
class Project {

    Project() {
    }

    Project(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    private String id;

    private String name;

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
}
