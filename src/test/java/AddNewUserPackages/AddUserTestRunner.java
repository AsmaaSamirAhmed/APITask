package AddNewUserPackages;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/AddNewUserPackages/AddNewUserFeature.feature"
        ,plugin ="json:target/jsonReports/cucumber-report.json"
        ,glue = {"AddNewUserPackages"})
public class AddUserTestRunner extends AbstractTestNGCucumberTests {
}
