package core;

public class WebPageObject {

	public static String uploadImageXpath() {
		return "//*[@id='uploadname1']";
	}

	public static String selectStorePlaceXpath() {
		return "//*[@name='subdir1']";
	}

	public static String emailXpath() {
		return "//*[@id='formfield-email_address']";
	}

	public static String firstNameXpath() {
		return "//*[@id='formfield-first_name']";
	}

	public static String uploadBtnXpath() {
		return "//*[@id='uploadbutton']";
	}

	public static String subFolderXpath() {
		return "//*[@id='newsubdir1']";
	}

	public static String emailInfoXpath() {
		return "//*[@id='fcuploadsummary']/dd[4]";
	}

	public static String firstNameInfoXpath() {
		return "//*[@id='fcuploadsummary']/dd[5]";
	}

	public static String fileNameInfoXpath() {
		return "//*[@id='fcuploadsummary']/dt[3]/a";
	}

	public static String uploadDoneContainter() {
		return "//*[@id='uploadDoneContainer']";
	}
}
