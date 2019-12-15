package com.perscholas.testng_project.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/com/perscholas/testng_project/features/perscholasLocationInfo.feature", 
				glue = "com/perscholas/testng_project/step_def")
public class PerScholasLocationInfoRunner extends AbstractTestNGCucumberTests {

}
