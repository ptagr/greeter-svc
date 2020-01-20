import config.AppConfig;
import handlers.HealthCheck;
import handlers.GreetingResource;
import io.dropwizard.setup.Environment;

public class Application extends io.dropwizard.Application<AppConfig> {

  public static void main(String[] args) throws Exception {
    new Application().run(args);
  }

  @Override
  public void run(AppConfig configuration, Environment environment) throws Exception {
    final GreetingResource resource = new GreetingResource();
    environment.jersey().register(resource);
    environment.healthChecks().register("default", new HealthCheck());
  }

  @Override
  public String getName() {
    return "greeter-svc";
  }
}
