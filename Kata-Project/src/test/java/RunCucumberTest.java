import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Created By wegrzyna on 13.11.2019
 */
@CucumberOptions(
        features = "src/test/resources/features/",
        plugin = {"pretty", "html:target/cucumber"})
@RunWith(Cucumber.class)
public class RunCucumberTest {
}
