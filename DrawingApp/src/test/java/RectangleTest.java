import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/drawRectangle.feature"},
        glue = {"com.drawing.stepdefs"})
public class RectangleTest {
}
