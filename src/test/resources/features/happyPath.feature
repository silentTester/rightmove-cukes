Feature: Find home happy path

Scenario Outline: Should find home based on postcode and button
Given user enters property "<postcode>"
When user clicks button "<button>"
And user clicks find properties
Then list of properties for "<button>" in "<postcode>"
And number of properties found is <expectedCount>

Examples:
|postcode   |button | expectedCount |
|SL7 1RR    | buy   | 2|


