Feature: Validation of New User API's
  @User
  Scenario: Verify if new User Added successfully
    Given Add User Payload
    When call "AddUserAPI" with "Post" http Request
    Then the API call got success with status code 201
    And return User id
    And verify "firstname" created maps to "name" using "getUserAPI" with id


