package steps;


import static io.restassured.RestAssured.given;

import org.junit.Assert;

import io.cucumber.gherkin.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import setup.PropertiesCache;

public class APISteps 
{

	private String path;
	private Response response;

	String payload = "{\r\n  \"name\": \"$name\",\r\n  \"price\": \"$price\",\r\n  \"description\": \"$description\"\r\n}";
	String product_id = "";
	String product_name = "";
	String product_price = "";
	String product_description = "";

	PropertiesCache cache = PropertiesCache.getInstance();


	@Given("^the users endpoint \"([^\"]*)\" exists$")
	public void the_users_endpoint_exists(String endpoint) throws Throwable {
		RestAssured.baseURI = "http://localhost:8080";
		path = endpoint;
	}

	@When("^I send a valid \"([^\"]*)\" product payload with name \"([^\"]*)\" price \"([^\"]*)\" description \"([^\"]*)\"$")
	public void i_send_a_valid_add_product_payload_with_name_something_price_something_description_something(String action, String name, String price, String description) throws Throwable {

		String _payload = payload.replace("$name", name).replace("$price", price).replace("$description", description);

		switch(action) {

		case "add":
			response = given()
			.header("Accept", "*/*")
			.contentType(ContentType.JSON)
			.body(_payload)
			.log().all()
			.when()
			.post(path)
			.then().log().all().extract().response();
			break;
		case "edit":
			response = given()
			.header("Accept", "*/*")
			.contentType(ContentType.JSON)
			.body(_payload)
			.log().all()
			.when()
			.patch(path+("/").concat(PropertiesCache.getInstance().getProperty("product_id")))
			.then().log().all().extract().response();
			break;

		}


	}

	@When("^I send a valid GET request to preview \"([^\"]*)\" product$")
	public void getProduct(String action) throws Throwable {

		switch(action) {

		case "single":
			response = given()
			.header("Accept", "*/*")
			.contentType(ContentType.JSON)
			.log().all()
			.get(path+("/").concat(PropertiesCache.getInstance().getProperty("product_id")))
			.then().log().all().extract().response();
			break;
		case "all":
			response = given()
			.header("Accept", "*/*")
			.contentType(ContentType.JSON)
			.log().all()
			.get(path)
			.then().log().all().extract().response();
			break;

		}
	}

	@When("^response should contain \"([^\"]*)\" product$")
	public void verifyProduct(String action) throws Throwable {
		
		
		switch(action) {

		
		case "single":
			
			String[] array1 = response.asString().split("},");
			Assert.assertTrue(array1.length==1);
			break;
		case "all":

			String[] array2 = response.asString().split("},");
			Assert.assertTrue(array2.length>=1);
			break;

		}
	}
	
	@When("^I send a valid DELETE request$")
	public void deleteProduct() throws Throwable {
	
		response = given()
				.header("Accept", "*/*")
				.log().all()
				.delete(path+("/").concat(PropertiesCache.getInstance().getProperty("product_id")))
				.then().log().all().extract().response();
	}


	@Then("^response status code should be \"([^\"]*)\"$")
	public void response_status_code_should_be_201(String code) throws Throwable {
		Assert.assertEquals(code, String.valueOf(response.getStatusCode()));
	}

	@And("^response should contain id name \"([^\"]*)\" price \"([^\"]*)\" description \"([^\"]*)\"$")
	public void response_should_contain_id_name_something_price_something_description_something(String name, String price, String description) throws Throwable {

		product_description = response.jsonPath().get("description");
		product_price = response.jsonPath().get("price").toString();
		product_name = response.jsonPath().get("name");
		product_id = response.jsonPath().get("id").toString();

		Assert.assertEquals(name, product_name);
		Assert.assertEquals(price, product_price);
		Assert.assertEquals(description, product_description);
		Assert.assertNotNull(product_id);

		cache.setProperty("product_id", product_id);
		PropertiesCache.getInstance().flush();

	}









	/*@Given("^user in on product application$")
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
		}*/






}
