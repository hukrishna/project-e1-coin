Feature: Coinbase application simple test for exercise

  Scenario: Navigate to the coinbase market
    Given navigate to the coinbase application
    And close all the start pop up event listener
    When filter show column to display specified rows
    Then Capture all the content of the page for price name position attributes
    And Filter by Algorithm for PoW
    Then Add more filters
    And toggle the mineable
    Then on the popup content select All Cryptocurrencies
    And select price
    And select price set min and max value
    Then apply the filter
    And capture all the content of the page
    Then compare the page content with the previous page content
