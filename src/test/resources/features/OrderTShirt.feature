@demo   @wip
Feature: Delegate Journey Planner
  As a customer
  I want to access website
  So that I can checkout order and update my details


  Scenario: Order t-shirt
    Given the application "ecom_website"
    And I login with valid credential "user1"
    When I add T-shirt to cart
    #TODO enhancement 1: instead of hardcoding T-shirt, it can be passes parameter from feature file
    And I checkout
    Then I have order in order history


    Scenario: Update Firstname
      Given the application "ecom_website"
      And I login with valid credential "user1"
      When I update my firstname to "updFirstName"
      Then I received success Alert message "Your personal information has been successfully updated."
      And display name updated to have "updFirstName"