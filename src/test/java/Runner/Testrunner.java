package Runner;

import org.checkerframework.checker.units.qual.C;
import org.junit.runner.RunWith;

import io.cucumber.core.backend.StepDefinition;
import io.cucumber.core.options.CucumberProperties;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Javaconcept",glue=("StepDefinition"),tags="@Reg")
public class Testrunner {

}
