@MessagesEndpoint
Feature: CRUD support for message objects.
  As a site owner
  I want to enable CRUD operations on messages in my app for different people
  In order to build active community around this awesome new feature.

  Scenario Outline: User is posting new message.
    Given message with <content>
    When user try to save message
    Then I should see valid <response>

    Examples:
      | content  | response |
      | message1 | message1 |
      | message2 | message2 |
