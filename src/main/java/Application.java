import config.AppConfig;
import handlers.HealthCheck;
import handlers.ParserResource;
import io.dropwizard.setup.Environment;

public class Application extends io.dropwizard.Application<AppConfig> {

  public static void main(String[] args) throws Exception {
    new Application().run(args);
  }

  @Override
  public void run(AppConfig configuration, Environment environment) throws Exception {
    final ParserResource resource = new ParserResource();
    environment.jersey().register(resource);
    environment.healthChecks().register("default", new HealthCheck());
  }

  @Override
  public String getName() {
    return "pdf-parser-svc";
  }
}
