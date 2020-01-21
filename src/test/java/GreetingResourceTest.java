import api.Greeting;
import handlers.GreetingResource;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class GreetingResourceTest {

  @ClassRule
  public static final ResourceTestRule resources =
      ResourceTestRule.builder().addResource(new GreetingResource()).build();

  @Test
  public void testGreetingWithNoNameSent() {
    final Greeting response = resources.target("/greet").request().get(Greeting.class);
    assertThat(response.getContent()).isEqualTo("Hello person");
  }

  @Test
  public void testGreetingWithNameSent() {
    final Greeting response =
        resources.target("/greet").queryParam("name", "punit").request().get(Greeting.class);
    assertThat(response.getContent()).isEqualTo("Hello punit");
  }
}
