package core;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Test2Modal {

	public void selectUploadFile(WebDriver driver, String path) {
		this.uploadFile(driver, WebPageObject.uploadImageXpath(), path);
	}

	public void selectWhereToUpdateFile(WebDriver driver, String folder) {
		Select storeFileDD = new Select(driver.findElement(By.xpath(WebPageObject.selectStorePlaceXpath())));
		storeFileDD.selectByVisibleText(folder);
	}

	public void selectWhereToUpdateFile(WebDriver driver) {

	}

	public void selectFolder(WebDriver driver, String folder) {
		// TODO Auto-generated method stub

	}

	public void inputSubFolderName(WebDriver driver, String subFolder) {
		driver.findElement(By.xpath(WebPageObject.subFolderXpath())).sendKeys(subFolder);
	}

	public void inputEmailAndFirstName(WebDriver driver, String email, String firstName) {
		driver.findElement(By.xpath(WebPageObject.emailXpath())).sendKeys(email);
		driver.findElement(By.xpath(WebPageObject.firstNameXpath())).sendKeys(firstName);

	}

	public void clickUploadButton(WebDriver driver) {
		driver.findElement(By.xpath(WebPageObject.uploadBtnXpath())).click();

	}

	public void verifyFileInfo(WebDriver driver, String email, String firstName, String fileName) {
		this.verifyEmail(driver, email);
		this.verifyFirstName(driver, firstName);
		this.verifyFileName(driver, fileName);
	}

	private void verifyFileName(WebDriver driver, String fileName) {
		String actualFileNameInfo = driver.findElement(By.xpath(WebPageObject.fileNameInfoXpath())).getText();
		System.out.println("Actual file name: " + actualFileNameInfo);
		Assert.assertEquals(actualFileNameInfo, fileName, "File Name does not match");

	}

	private void verifyFirstName(WebDriver driver, String firstName) {
		String actualFirstNameInfo = driver.findElement(By.xpath(WebPageObject.firstNameInfoXpath())).getText();
		String expectedFirstNameInfo = "First Name: " + firstName;
		System.out.println("Actual First Name: " + actualFirstNameInfo);
		Assert.assertEquals(actualFirstNameInfo, expectedFirstNameInfo, "First Name does not match");

	}

	private void verifyEmail(WebDriver driver, String email) {
		String actualEmailInfo = driver.findElement(By.xpath(WebPageObject.emailInfoXpath())).getText();
		String expectedEmailInfo = "Email Address: " + email;
		System.out.println("Actual Email: " + actualEmailInfo);
		Assert.assertEquals(actualEmailInfo, expectedEmailInfo, "Email does not match");
	}

	public Boolean waitForUploadDoneContainerVisible(WebDriver driver, int timeWait) {
		return this.waitElementVisible(driver, WebPageObject.uploadDoneContainter(), timeWait);
	}

	public Boolean waitElementVisible(WebDriver driver, String xpathLocator, int timeWait) {
		try {
			(new WebDriverWait(driver, timeWait))
					.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpathLocator))));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void uploadFile(WebDriver driver, String xpathOfButton, String pathOfFile) {
		try {
			File f = new File(pathOfFile);
			if (f.isFile()) {
				driver.findElement(By.xpath(xpathOfButton)).click();
				// click(driver, xpathOfButton);
				Thread.sleep(500);

				StringSelection filePath = new StringSelection(f.getAbsolutePath());
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_A);

				r.keyRelease(KeyEvent.VK_A);
				r.keyRelease(KeyEvent.VK_CONTROL);

				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_V);

				r.keyRelease(KeyEvent.VK_V);
				r.keyRelease(KeyEvent.VK_CONTROL);

				Thread.sleep(1000);
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
			}
			Thread.sleep(5000);
		} catch (AWTException e) {
			System.console().writer().write("Unable to upload file");
		} catch (InterruptedException e) {
			System.console().writer().write("Unable to upload file");
		}
	}

}
