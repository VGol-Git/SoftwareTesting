package test.java.ru.miet.testing;



import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/ru/miet/testing/features",
        glue = "test.java.ru.miet.testing",
        tags = "@WebSite",
        snippets = SnippetType.CAMELCASE
)
public class FeatureTest {
}
