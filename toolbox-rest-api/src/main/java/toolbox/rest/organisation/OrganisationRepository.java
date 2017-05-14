package toolbox.rest.organisation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by eon on 2017/05/13.
 */
@RepositoryRestResource(path = "organisations")
public interface OrganisationRepository extends JpaRepository<Organisation, String> {
}
