Feature: Add, Edit, Delete, View Product

  @SmokeTest
  Scenario: Add Product
    Given user in on product application
    And user clicks on Add New Product
    When user adds product with name "test" price "100.0" description "Amazing description"
    Then user should be redirected to "Product manipulation completed"
    And user should see product id name "test" price "100.0" description "Amazing description"
    And user should see "Add new product" and "To product list" Button

  @SmokeTest
  Scenario: Edit Product
    Given user in on product application
    And user clicks on To product list button
    When user clicks "Edit" product button
    And user update product with name "test003" price "100.0" description "Amazing description"
    Then user should be redirected to "Product manipulation completed"
    And product should be "Edited"
    And user should see product id name "test003" price "100.0" description "Amazing description"
    And user should see "Add new product" and "To product list" Button

  @SmokeTest
  Scenario: Preview Single Product
    Given user in on product application
    And user clicks on To product list button
    When user clicks "Show" product button
    Then user should see product id name "test003" price "100.0" description "Amazing description"

  @SmokeTest
  Scenario: Preview All Products
    Given user in on product application
    When user clicks on To product list button
    Then user should be redirected to "Available products"

  @SmokeTest
  Scenario: Delete Product
    Given user in on product application
    And user clicks on To product list button
    When user clicks "Delete" product button
    Then product should be "Deleted"
