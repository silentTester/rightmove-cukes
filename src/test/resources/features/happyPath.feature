Feature: Find home happy path

Scenario Outline: Should find homes for sale based on postcode
Given user enters property "<postcode>"
When user clicks button "<button>"
And user clicks find properties
Then list of properties for "<button>" in "<postcode>"
And number of properties found is <expectedCount>

Examples:
|postcode   |button | expectedCount |
|SL7 1RR    | buy   | 2|

Scenario Outline: Should not find any homes based on incorrect postcode
Given user enters property "<postcode>"
When user clicks button "<button>"
Then not found is displayed for "<postcode>"

Examples:
|postcode   |button |
|Bougus     | buy   |