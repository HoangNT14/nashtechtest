package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import core.Constant;
import core.Test2Modal;

public class Test2 {
	private Test2Modal testMod = new Test2Modal();
	private WebDriver driver;
	private String path;

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("https://encodable.com/uploaddemo/");
		driver.manage().window().maximize();
		path = System.getProperty("user.dir") + "/" + Constant.fileName;
	}

	@Test
	public void testUploadFile() {
		testMod.selectUploadFile(driver, path);
		testMod.selectWhereToUpdateFile(driver, Constant.folder);
		testMod.inputSubFolderName(driver, Constant.subFolder);
		testMod.inputEmailAndFirstName(driver, Constant.email, Constant.firstName);
		testMod.clickUploadButton(driver);
		if (testMod.waitForUploadDoneContainerVisible(driver, 50)) {
			testMod.verifyFileInfo(driver, Constant.email, Constant.firstName, Constant.fileName);
		} else {
			Assert.assertTrue(false, "Upload Done Container does not display");
		}
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
