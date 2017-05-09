package com.cucumber.testng.examples;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.ReportBuilder;

/**
 * Created by amit.rawat on 28/12/15.
 */
public class masterthought_report {
	public static void main(String args[]) throws IOException {
		File reportOutputDirectory = new File("target");
		List<String> list = new ArrayList<String>();
		// list.add("cucumber3.json");
		list.add("cucumber4.json");

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

		ReportBuilder reportBuilder = new ReportBuilder(list, reportOutputDirectory, pluginUrlPath, buildNumber,
				buildProject, skippedFails, pendingFails, undefinedFails, missingFails, flashCharts, runWithJenkins,
				highCharts, parallelTesting);
		reportBuilder.generateReports();
	}
}
