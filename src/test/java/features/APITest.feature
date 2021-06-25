Feature: Add, Edit, Delete, View Product

  @SmokeTest
  Scenario: Add Product
    Given the users endpoint "/v1/products" exists
    When I send a valid "add" product payload with name "test" price "100.0" description "Amazing description"
    Then response status code should be "201"
    And response should contain id name "test" price "100.0" description "Amazing description"

  @SmokeTest
  Scenario: Edit Product
    Given the users endpoint "/v1/products" exists
    When I send a valid "edit" product payload with name "test" price "100.0" description "Amazing description"
    Then response status code should be "201"
    And response should contain id name "test" price "100.0" description "Amazing description"

  @SmokeTest
  Scenario: Preview Single Product
    Given the users endpoint "/v1/products" exists
    When I send a valid GET request to preview "single" product
    Then response status code should be "200"
    And response should contain "single" product

  @SmokeTest
  Scenario: Preview All Product
    Given the users endpoint "/v1/products" exists
    When I send a valid GET request to preview "all" product
    Then response status code should be "200"
    And response should contain "all" product

  @SmokeTest
  Scenario: Delete Product
    Given the users endpoint "/v1/products" exists
    When I send a valid DELETE request
    Then response status code should be "200"
