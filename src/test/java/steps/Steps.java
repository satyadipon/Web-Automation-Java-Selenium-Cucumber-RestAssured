package steps;


import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.Navbar;

public class Steps 
{
	@Given("^User in on login page$")
    public void user_in_on_login_page() throws Throwable {
		HomePage home = new HomePage();
        boolean isHeaderDisplayed = home.isHeaderDisplayed();
        Assert.assertTrue(isHeaderDisplayed);
    }

    @When("^User login into application with (.+) and (.+)$")
    public void user_login_into_application_with_and(String email, String password) throws Throwable {
    	Navbar nav = new Navbar();
    	nav.clickLogin();
    	
    	LoginPage login = new LoginPage();
    	login.login(email, password);
    }

    @Then("^User lands into the home page$")
    public void user_lands_into_the_home_page() throws Throwable {
    	HomePage home = new HomePage();
        boolean isHeaderDisplayed = home.isHeaderDisplayed();
        Assert.assertTrue(isHeaderDisplayed);
    }

    @And("^(.+) displays in the navbar$")
    public void displays_in_the_navbar(String username) throws Throwable {
    	Navbar nav = new Navbar();
    	String currentUsername = nav.getCurrentUserName();
    	Assert.assertEquals(username, currentUsername);
    }

}
