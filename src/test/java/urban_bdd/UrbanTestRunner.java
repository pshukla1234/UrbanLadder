package urban_bdd;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
		features = {"src/test/java/urban_bdd/Urban.feature"},
		glue = {"urban_bdd"},
		tags = "@Urbanladder"
		)
@RunWith(Cucumber.class)
public class UrbanTestRunner
{


}


