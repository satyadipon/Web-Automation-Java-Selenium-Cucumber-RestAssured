package steps;


import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddProductPage;
import pages.AvailableProductsPage;
import pages.LandingPage;
import pages.ProductManipulationPage;
import pages.UpdateProductPage;
import setup.Setup;

public class Steps 
{
    
    @Given("^user in on product application$")
    public void user_in_on_product_application() throws Throwable {
    	
    	Assert.assertTrue(new LandingPage().landingPageHeader.isDisplayed());
    }

    @When("^user adds product with name \"([^\"]*)\" price \"([^\"]*)\" description \"([^\"]*)\"$")
    public void user_adds_the_product_with_name_something_product_something_description_something(String name, String price, String description) throws Throwable {
    	
    	AddProductPage product = new AddProductPage();
    	product.name.sendKeys(name);
    	product.price.sendKeys(price);
    	product.description.sendKeys(description);
    	product.save.click();
    }

    @When("^user update product with name \"([^\"]*)\" price \"([^\"]*)\" description \"([^\"]*)\"$")
    public void user_update_the_product_with_name_something_product_something_description_something(String name, String price, String description) throws Throwable {
    	
    	UpdateProductPage product = new UpdateProductPage();
    	product.name.clear();
    	product.name.sendKeys(name);
    	product.price.clear();
    	product.price.sendKeys(price);
    	product.description.clear();
    	product.description.sendKeys(description);
    	product.update.click();
    	
    }

    @Then("^user should be redirected to \"([^\"]*)\"$")
    public void user_should_be_redirected_to_something(String text) throws Throwable {
    	
    	if(text.toLowerCase().contains("manipulation"))
    	Assert.assertEquals(new ProductManipulationPage().pageHeader.getText(), text);
    	
    	if(text.toLowerCase().contains("available"))
    		Assert.assertEquals(new AvailableProductsPage().pageHeader.getText(), text);
    }

    @And("^user clicks on Add New Product$")
    public void user_clicks_on_add_new_product() throws Throwable {
    	
    	new LandingPage().add_product.click();
    }

    String product_id = "";
    @And("^user should see product id name \"([^\"]*)\" price \"([^\"]*)\" description \"([^\"]*)\"$")
    public void user_should_see_product_id_name_something_price_something_description_something(String name, String price, String description) throws Throwable {
    	
    	ProductManipulationPage productManipulation = new ProductManipulationPage();
    	Assert.assertTrue(productManipulation.idValue.isDisplayed());
    	product_id = productManipulation.idValue.getText();
    	Assert.assertEquals(productManipulation.nameValue.getText(), name);
    	Assert.assertEquals(productManipulation.priceValue.getText(), price);
    	Assert.assertEquals(productManipulation.descValue.getText(), description);
    }

    @And("^user should see \"([^\"]*)\" and \"([^\"]*)\" Button$")
    public void user_should_see_something_and_something(String strArg1, String strArg2) throws Throwable {
    	
    	ProductManipulationPage productManipulation = new ProductManipulationPage();
    	Assert.assertEquals(productManipulation.add_new_product.getText().trim(), strArg1);
    	Assert.assertEquals(productManipulation.to_producty_list.getText().trim(), strArg2);
    }
    
    @When("^user clicks on To product list button$")
    public void user_clicks_on_to_product_list_button() throws Throwable {
    	new LandingPage().get_products.click();
    	
    }
    
    @When("^user clicks \"([^\"]*)\" product button$")
    public void user_clicks_edit_product_button(String button) throws Throwable {
    	
    	switch(button) {
    	case "Edit": new AvailableProductsPage().editProduct.get(0).click();
    	break;
    	case "Show": new AvailableProductsPage().showProduct.get(0).click();
    	break;
    	case "Delete": 
    		product_id = new AvailableProductsPage().productId.get(0).getText();
    		new AvailableProductsPage().deleteProduct.get(0).click();
    	break;
    	}
    }
    
    @Then("^product should be \"([^\"]*)\"$")
    public void product_should_be_something(String action) throws Throwable {
    	
    	switch(action) {
    	case "Edited": Assert.assertNotEquals(new AvailableProductsPage().productId.get(0).getText(), product_id);
    	break;
    	case "Deleted": Assert.assertNotEquals(new AvailableProductsPage().productId.get(0).getText(), product_id);
    	break;
    	}
    	
    	
    	
    	
    }
    
    
    
    
    
    
    
    
    
    

}
