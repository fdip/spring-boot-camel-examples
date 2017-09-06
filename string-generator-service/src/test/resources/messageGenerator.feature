@MessagesEndpoint
Feature: Generate random message.
  As a site owner
  I want to generate random string message
  In order to send it to requesting client.

  Scenario: User is polling for new message.
    When user try to get new message
    Then I should generate random valid message
    