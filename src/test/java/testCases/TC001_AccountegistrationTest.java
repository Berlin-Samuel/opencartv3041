package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountegistrationTest extends BaseClass {

	@Test(groups = { "regression", "master" })
	public void verify_account_registration() {

		logger.info("*************** Starting TC001_AccountegistrationTest ***************");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on myaccount link");

			hp.clickRegister();
			logger.info("clicked on register link");

			AccountRegistrationPage accountreg = new AccountRegistrationPage(driver);
			logger.info("Providing customer details....");

			accountreg.setFirstName(randomeString().toUpperCase());
			accountreg.setLastName(randomeString().toUpperCase());
			accountreg.setEmail(randomeString() + "@gmail.com");
			accountreg.setTelephone(randomeNumber());
			String password = randomeAlphaNumeric();
			accountreg.setPassword(password);
			accountreg.setConfirmPassword(password);
			accountreg.setPrivacyPolicy();
			accountreg.clickContinue();
			logger.info("Validating expected message.....");

			String confrmmsg = accountreg.getConfirmationMsg();
			if (confrmmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("Test failed");
				logger.debug("Debug logs");
				Assert.assertTrue(false);
			}
			// Assert.assertEquals(confrmmsg, "Your Account Has Been Created!");
		} catch (Exception e) {

			Assert.fail();
		}
		logger.info("*************** Finished TC001_AccountegistrationTest ***************");

	}

}
