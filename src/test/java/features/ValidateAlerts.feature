Feature: Validate Alerts in toolsQA page
 
#Background:
#Given User Launch Broswer specified in properties file and load the DemoQA Url

Scenario: Validate Nomal Alert present in Tools QA page
Given User is on Login Page of Alerts 
When User clicks on click me button of the nommal alert
Then validate text of the normal alert and accept

Scenario: Validate Timer Alert on DemoQA Page
Given User is on Login Page of Alerts
When User clicks on click me button of the Timer alert
Then validate text of the Timer alert and accept