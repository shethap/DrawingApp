import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/drawLine.feature"},
        glue = {"com.drawing.stepdefs"})
public class LineTest {
}
