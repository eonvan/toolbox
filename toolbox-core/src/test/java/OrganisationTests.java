import org.axonframework.eventsourcing.eventstore.EventStoreException;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.Test;
import toolbox.core.Organisation;
import toolbox.core.OrganisationRegistered;
import toolbox.core.RegisterOrganisation;
import toolbox.core.RegisterSpace;
import toolbox.core.SpaceRegistered;
import toolbox.core.SpaceRegistrationFailed;

public class OrganisationTests {
    private FixtureConfiguration fixture;

    @Before
    public void setUp() {
        fixture = new AggregateTestFixture(Organisation.class);
    }

    @Test
    public void when_testRegisterOrganisation_Expect_SuccessfulCreation() {
        fixture.givenNoPriorActivity()
                .when(new RegisterOrganisation("1", "Testable Tech Inc"))
                .expectSuccessfulHandlerExecution()
                .expectEvents(new OrganisationRegistered("1", "Testable Tech Inc"));
    }

    @Test
    public void when_testRegisterDuplicateOrganisation_Expect_Failure() {
        fixture.given(new OrganisationRegistered("1", "Testable Tech Inc"))
                .when(new RegisterOrganisation("1", "Testable Tech Inc"))
                .expectException(EventStoreException.class);
    }

    @Test
    public void when_testRegisterSpace_Expect_SuccessfulCreation() {
        fixture.given(new OrganisationRegistered("1", "Testable Tech Inc"))
                .when(new RegisterSpace("1", "1", "Test Space"))
                .expectEvents(new SpaceRegistered("1", "1", "Test Space"));
    }

    @Test
    public void when_testRegisterDuplicateSpace_Expect_Failure() {
        fixture.given(new OrganisationRegistered("1", "Testable Tech Inc"), new SpaceRegistered("1", "1", "Test Space"))
                .when(new RegisterSpace("1", "1", "Test Space"))
                .expectEvents(new SpaceRegistrationFailed("1", "1", "Space with id 1 already registered with org 1"));
    }

}
