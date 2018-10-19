package Reto2.RunnerTags;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features="src/test/resources/features/CotizacionBanco.feature",
		tags= "@tag",
		glue="Reto2.StepDefinitions",
		snippets=SnippetType.CAMELCASE		)
public class RunnerTags {
}
