Feature:WebSite

Scenario:Verify login Page
Given user should be on login page
Then  User should see Header txt on login page
@Login
Scenario:Verify User Register link
Given user should be on login page
When Click on Register a new membership link
Then User should be on Register page
Then user enter regitration details
| Mitesh | 1234567890 | mitesh@gmail.com | 123456 |
Then Click on Sign button






