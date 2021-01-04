Feature: Login into Application

Scenario Outline: Positive test validation test
Given Initialize browser with chrome
And Navigate to page "http://qaclickacademy.com"
And Click to login button to go sign in page
When User enters <username> and <password> then <userinfo> to log in
Then Verify that user is succesfully logged in
Then close browsers

Examples:
|username         |password  | userinfo   |
|test99@gmail.com |123456    |valid user  |
|test12@gmail.com |123453    |invalid user|