package com.cucumber.testng.examples;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.ReportBuilder;

/**
 * Created by amit.rawat on 21/12/15.
 */
public class GenerateReport {
	public static void GenerateMasterthoughtReport() {
		try {
			String RootDir = System.getProperty("user.dir");
			File reportOutputDirectory = new File("target/Masterthought");
			List<String> list = new ArrayList<String>();
			// list.add("target/cucumber3.json");
			list.add("target/cucumber4.json");

			String pluginUrlPath = "";
			String buildNumber = "1";
			String buildProject = "cucumber-jvm";
			boolean skippedFails = true;
			boolean pendingFails = true;
			boolean undefinedFails = true;
			boolean missingFails = true;
			boolean flashCharts = true;
			boolean runWithJenkins = false;
			boolean highCharts = false;
			boolean parallelTesting = true;
			boolean artifactsEnabled = false;
			String artifactConfig = "";

			ReportBuilder reportBuilder = new ReportBuilder(list, reportOutputDirectory, pluginUrlPath, buildNumber,
					buildProject, skippedFails, pendingFails, undefinedFails, missingFails, flashCharts, runWithJenkins,
					highCharts, parallelTesting);

			// ReportBuilder reportBuilder = new ReportBuilder(list,
			// reportOutputDirectory, pluginUrlPath, buildNumber,
			// buildProject, skippedFails, undefinedFails, flashCharts,
			// runWithJenkins, artifactsEnabled, artifactConfig,
			// highCharts);
			reportBuilder.generateReports();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		try {
			String RootDir = System.getProperty("user.dir");
			File reportOutputDirectory = new File("target/Masterthought");
			List<String> list = new ArrayList<String>();
			list.add("target/cucumber3.json");
			list.add("target/cucumber4.json");

			String pluginUrlPath = "";
			String buildNumber = "1";
			String buildProject = "cucumber-jvm";
			boolean skippedFails = true;
			boolean pendingFails = true;
			boolean undefinedFails = true;
			boolean missingFails = true;
			boolean flashCharts = true;
			boolean runWithJenkins = false;
			boolean highCharts = false;
			boolean parallelTesting = true;
			boolean artifactsEnabled = false;
			String artifactConfig = "";

			ReportBuilder reportBuilder = new ReportBuilder(list, reportOutputDirectory, pluginUrlPath, buildNumber,
					buildProject, skippedFails, pendingFails, undefinedFails, missingFails, flashCharts, runWithJenkins,
					highCharts, parallelTesting);

			// ReportBuilder reportBuilder = new ReportBuilder(list,
			// reportOutputDirectory, pluginUrlPath, buildNumber,
			// buildProject, skippedFails, undefinedFails, flashCharts,
			// runWithJenkins, artifactsEnabled, artifactConfig,
			// highCharts);
			reportBuilder.generateReports();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
