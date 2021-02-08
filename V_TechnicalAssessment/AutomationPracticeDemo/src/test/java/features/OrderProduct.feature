Feature: Order a specific product

  In order to order a product
  As a new user
  I need to create an account and complete the purchase process

  Scenario: order a product successfully
    Given the user enters a registration email
    When the user create an account
    And complete the purchase process
    Then the user can find the product in the order history