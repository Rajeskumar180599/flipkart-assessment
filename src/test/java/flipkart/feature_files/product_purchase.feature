Feature: Automate the testing of an e-commerce website's main functionalities

#  Scenario:  User Registration
#    Given user Navigate to the registration page
#    When Fill in the registration form with valid details
#    And Submit the registration form
#    Then Verify that the user is registered successfully and redirected to the dashboard or homepage

  Scenario: User Login
    When Navigate to the login page
    And  Fill in the login form with valid credentials
    And  Submit the login form
    Then Verify that the user is logged in successfully and redirected to the dashboard or homepage

  Scenario: Product Search
    When Navigate to the homepage
    And Use the search functionality to find a specific product
    Then Verify that the search results contain the desired product

  Scenario:  Product Purchase
    When Select a product from the search results
    And Add the product to the cart
    And Navigate to the cart and proceed to checkout
    And Fill in the checkout details

  Scenario: Logout
    When  Logout from the application
    Then Verify that the user is logged out and redirected to the login page