package handlers;

import api.Greeting;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/greet")
@Produces(MediaType.APPLICATION_JSON)
public class GreetingResource {

  private final AtomicLong counter;

  public GreetingResource() {
    this.counter = new AtomicLong();
  }

  @GET
  public Greeting greet(@QueryParam("name") Optional<String> name) {
    final String value = name.orElse("person");
    return new Greeting(counter.incrementAndGet(), "Hello "+value);
  }
}
