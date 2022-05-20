Feature: Login into application

Scenario: Negative test validating login
 Given Initialize the browser with Chrome
 And Navigate to "https://qaclickacademy.com/" site
 And Click on No Thanks popup
 And Click on Login in HomePage to land on secure sign in page
 When User enters "bsnbdjnk@gmail.com" and "123hbxnxnm456" and logs in
 Then Verify user is not logged in