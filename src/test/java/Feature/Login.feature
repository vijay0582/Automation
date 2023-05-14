Feature: login functionality


Background: usernaigate to sauce demo application 
Given user launch site URL
 Scenario: Verify successful login when username and password is correct
 When user enter username and password
 And click on login button
 Then Validate Success login
