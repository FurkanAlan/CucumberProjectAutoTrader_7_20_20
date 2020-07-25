#Feature:
#
#  Background: chrome testing
#
#  Scenario: User goes to Car Rental System Website
#    Given User is in landing page
#    Then User can find cars based on "location".
#    Then User can "pick up" and "drop off" a car at different locations.
#    Then User can "reserve" a car and "pay in person", at time of pick up, or "online".
#    Then User can pay via "credit card" or "coupon code".
#    Then User can "create an account" and save their information for later or "reserve as a guest".
#
#
#  Scenario Outline: testing the multiple entry
#    Given: User is in search page
#
#    Examples:
#      | number of seats | type of car | car class |
#      | 4               | sedan       | economy   |
#      | 5               | SUV         | midsize   |
#      | 6               | sport       | luxury    |
#
