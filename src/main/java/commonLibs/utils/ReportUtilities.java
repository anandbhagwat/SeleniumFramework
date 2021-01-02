package commonLibs.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportUtilities {

        ExtentHtmlReporter extentHtmlReporter;
        ExtentReports extentReports;
        ExtentTest extentTest;

        public ReportUtilities(String htmlReportFile){
            htmlReportFile = htmlReportFile.trim();
            extentHtmlReporter = new ExtentHtmlReporter(htmlReportFile);

            extentReports = new ExtentReports();

            extentReports.attachReporter(extentHtmlReporter);

        }

        public void createATestCase(String testCaseName){
            extentTest = extentReports.createTest(testCaseName);

        }

        public void addTestlogs(Status status, String comment){
            extentTest.log(status, comment);
        }

        public void flushReport(){
            extentReports.flush();
        }
}
