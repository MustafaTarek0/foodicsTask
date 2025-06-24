@UI
@test
Feature: amazon

  Scenario Outline: user should be able to add items in amazon
    Given user navigate to amazon EG
    Given user click on sign in
    And user insert phone number "<phoneNumber>"
    And user clicks continue
    And user insert password "<password>"
    And user clicks sign in
    When user clicks on all side menu
    And user clicks on see all
    And user clicks on video games "<category>"
    And user clicks on all video games "<subCategory>"
    Then user verifies that he is navigated to all video games page
    When user clicks on free shipping checkbox
    And user clicks on new condition
    And user clicks on sort by dropdown list
    And user sorts by high to low price "<sortKey>"
    And user randomly selects a product below <price> and if not available he will click next page then repeat searching then clicks on cart to make sure that it's already added
    And user clicks on add to cart
    Then user should be navigated to cart page
    And user validates that the cart isn't empty
    And user validate that's proceed to buy is visible
    When user clicks on proceed to buy button
    Then user validates that value payment method is visible
    When user clicks on value payment method radio button
    Then user validates that change delivery address is visible
    When user clicks on change delivery address button
    Then add new delivery address button should be displayed
    When user clicks on new delivery address button
    And user insert full name "<fullName>"
    And user insert full mobileNumber "<mobileNumber>"
    And user insert street name "<streetName>"
    And user insert building name "<buildingName>"
    And user insert city "<city>"
    And user insert district "<district>"
    And user insert Governorate "<Governorate>"
    #And user clicks on use this address button

    Examples:
      |category   |subCategory|phoneNumber|password|sortKey|price|fullName|mobileNumber|streetName|buildingName|city|district|Governorate|
      |Video Games|Xbox One|+4915755457595|@Desha0097|Price: Low to High|15000|mustafa|1063710097|test|testing |cairo|Settlement)|cairo|
