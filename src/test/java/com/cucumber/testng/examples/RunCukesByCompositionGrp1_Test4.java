package com.cucumber.testng.examples;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * An example of using TestNG when the test class does not inherit from
 * AbstractTestNGCucumberTests.
 */


@CucumberOptions(features = "src/test/resources/com.cucumber.testng.examples/Login.feature", tags = "@positive", format = { "pretty",
        "html:target/site/cucumber-pretty1",
        "json:target/cucumber4.json" })

//dryRun: ** **if dryRun option is set to true then cucumber only checks if all the steps have their corresponding step definitions defined or not. The code mentioned in the Step definitions is not executed. This is used just to validate if we have defined a step definition for each step or not.
//Strict: ** **if strict option is set to false then at execution time if cucumber encounters any undefined/pending steps then cucumber does not fail the execution and undefined steps are skipped and BUILD is SUCCESSFUL. 
//Monochrome: if monochrome option is set to False, then the console output is not as readable as it should be. may be the output images will make this more clear.
//Features: * features option is to specify the path to feature files. when cucumber starts execution, Cucumber looks for .feature files at the path/folder mentioned in features option. Whichever files are with .feature extension ( if there are no compilation errors) at the path/folder mentioned in features, are executed. 

public class RunCukesByCompositionGrp1_Test4 extends BaseTestCase {
    @BeforeSuite
    
    public void beforeSuite() {
    	System.out.println("This is beforeSuite");
    	
    }
    @BeforeClass
    public void beforeClass() {
        System.out.println("This is beforeClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This is beforeMethod");
    }
    /**
     * Create one test method that will be invoked by TestNG and invoke the
     * Cucumber runner within that method.
     */
    @Test(groups = "examples-testng", description = "Example of using TestNGCucumberRunner to invoke Cucumber")
    public void runCukes() {
        new TestNGCucumberRunner(getClass()).runCukes();
    }
}
