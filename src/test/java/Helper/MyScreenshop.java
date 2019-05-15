package Helper;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class MyScreenshop {

	public static void makeScreenshot(WebDriver driver) {
		String screenshotPath = "src\\test\\resources\\screenshots\\screenshots" + UUID.randomUUID() + ".png";

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenshotFile, new File(screenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
