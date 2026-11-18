package reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import com.remo.base.BaseClass;
import com.remo.reader.ConfigUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentUtility extends BaseClass {

	WebDriver driver;

	public ExtentUtility(WebDriver driver) {
		this.driver = driver;

	}

	public static void createReport(String reportName, String env, String browser) {

		ConfigUtil prop = new ConfigUtil();
		String testUrl = prop.getProperty(env);
		System.out.println("Starting tetsing on URL: " + testUrl);

		String directory = System.getProperty("user.dir") + "/ExtentReports/";
		String directory1 = System.getProperty("user.dir") + "/ExtentReports/ReportsWithTimeStamp/";

		spark = new ExtentSparkReporter(directory + reportName + ".html");
		spark1 = new ExtentSparkReporter(
				directory1 + reportName + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()) + ".html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.attachReporter(spark1);

		/* Extent Environment */

		env = env.replace("URL", "");

		extent.setSystemInfo("OS", "Windows 11");
		extent.setSystemInfo("Browser", browser);
		extent.setSystemInfo("Test Environment", env);
		extent.setSystemInfo("Test Url", testUrl);
		extent.setSystemInfo("Tester", "Remosys Testing Team");

		/* configuration to change looks of the report */

		// try {
		// spark.loadJSONConfig(new
		// File(System.getProperty("user.dir")+"/Resource/ExtentConfig.json"));
		// spark1.loadJSONConfig(new
		// File(System.getProperty("user.dir")+"/Resource/ExtentConfig.json"));
		//
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		spark.config().setDocumentTitle("M360 Testing Report");
		spark1.config().setDocumentTitle("M360 Testing Report");
		spark.config().setReportName("M360 Testing Report");
		spark1.config().setReportName("M360 Testing Report");
		spark.config().setTheme(Theme.STANDARD);
		spark1.config().setTheme(Theme.STANDARD);
		spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
		spark1.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
		spark.config().thumbnailForBase64(true);
		spark1.config().thumbnailForBase64(true);
		spark.config().setEncoding("utf-8");
		spark.config().setProtocol(Protocol.HTTPS);
		spark1.config().setEncoding("utf-8");
		spark1.config().setProtocol(Protocol.HTTPS);

	}

	public static void createReport(String reportName) {

		String directory = System.getProperty("user.dir") + "/ExtentReports/";
		String directory1 = System.getProperty("user.dir") + "/ExtentReports/ReportsWithTimeStamp/";

		spark = new ExtentSparkReporter(directory + reportName + ".html");
		spark1 = new ExtentSparkReporter(
				directory1 + reportName + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()) + ".html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.attachReporter(spark1);

		/* Extent Environmental */

		extent.setSystemInfo("OS", "Windows 11");
		extent.setSystemInfo("Browser", "chrome");
		extent.setSystemInfo("Tester", "Remosys Testing Team");

		/* configuration to change looks of the report */

		spark.config().setDocumentTitle("M360 Testing Report");
		spark1.config().setDocumentTitle("M360 Testing Report");
		spark.config().setReportName("M360 Testing Report");
		spark1.config().setReportName("M360 Testing Report");
		spark.config().setTheme(Theme.STANDARD);
		spark1.config().setTheme(Theme.STANDARD);
		spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");
		spark1.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a'('zzz')'");

	}

	public static ExtentTest createTest(ExtentTest test, String name) {
		test = extent.createTest(name);
		return test;
	}

	public static void quitReport() {

		extent.flush();
	}

}
