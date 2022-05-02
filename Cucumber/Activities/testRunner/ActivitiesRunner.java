package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features/Activity5.feature",
        glue = {"stepDefinition"},
        tags = "@activity5"
)

public class ActivitiesRunner {
    //empty
}
