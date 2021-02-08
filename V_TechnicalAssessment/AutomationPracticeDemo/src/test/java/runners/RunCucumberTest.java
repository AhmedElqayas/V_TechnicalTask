package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features", glue={"test/tests"}, plugin = { "pretty", "html:target/site/cucumber-pretty",
        "json:target/cucumber.json" })
public class RunCucumberTest {
}
