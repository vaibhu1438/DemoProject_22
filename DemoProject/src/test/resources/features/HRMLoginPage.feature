Feature: Login to HRM Application 
 
   @ValidCredentials
   Scenario: Login with valid credentials
     
    Given User is on HRMLogin page
    When User enters username as "Admin" and password as "admin123"
    Then User should be able to login and new page open