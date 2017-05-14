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
class Organisation {

    Organisation() {
        spaces = new HashSet<>();
    }

    public Organisation(String id, String name) {
        this();
        this.id = id;
        this.name = name;
    }

    @Id
    private String id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Space> spaces;

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

    public Set<Space> getSpaces() {
        return spaces;
    }

    void addSpace(Space space) {
        this.spaces.add(space);
    }

    Space findSpace(String spaceId) {
        Optional<Space> space = spaces.stream().filter(s -> s.getId().equals(spaceId)).findFirst();
        if (space.isPresent()) return space.get();
        throw new RuntimeException("Space not found");
    }
}