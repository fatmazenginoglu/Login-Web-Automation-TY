@Login
Feature: Login Test
  Background:
    Given Go to "www.trendyol.com"
    When Click the “Sign In”

  @Unregistered
  Scenario: 1.21 Login-Unregistered
    When Enter a unregistered mail "validMail" in the Email field (Must not be a previously registered email)
    And Enter a valid password "validPassword" in the password field
    And Click the “Sign In” button
    Then The user cannot log in successfully
    And The warning message1 "Your e-mail address and-or password is not correct" is displayed

  @ValidMailInvalid(Lenght)Password
  Scenario: 1.22 Login-Valid Mail-Invalid(Lenght) Password
    When Enter a valid mail "registeredMail" in the Email field (Must be a previously registered email)
    And Enter a invalid(lenght) password "invalidPasswordLenght" in the password field
    And Click the “Sign In” button
    Then The user cannot log in successfully
    And The warning message1 "Your e-mail address and-or password is not correct" is displayed

  @ValidMailInvalid(OnlyCharacter)Password
  Scenario: 1.23 Login-Valid Mail-Invalid(Character) Password
    When Enter a valid mail "registeredMail" in the Email field (Must be a previously registered email)
    And Enter a invalid(character) password "invalidPasswordCharacter" in the password field
    And Click the “Sign In” button
    Then The user cannot log in successfully
    And The warning message1 "Your e-mail address and-or password is not correct" is displayed

  @ValidMailInvalid(OnlyNumeric)Password
  Scenario: 1.24 Login-Valid Mail-Invalid(Numeric) Password
    When Enter a valid mail "registeredMail" in the Email field (Must be a previously registered email)
    And Enter a invalid(numeric) password "invalidPasswordNumeric" in the password field
    And Click the “Sign In” button
    Then The user cannot log in successfully
    And The warning message1 "Your e-mail address and-or password is not correct" is displayed

  @InvalidMailValidPassword
  Scenario: 1.25 Login-Invalid Mail-Valid Password
    When Enter a invalid mail "invalidMail" in the Email field
    And Enter a valid password "validPassword" in the password field
    And Click the “Sign In” button
    Then The user cannot log in successfully
    And The warning message2 "Please enter a valid email address" is displayed

  @InvalidMailInvalid(Lenght)Password
  Scenario: 1.26 Login-Invalid Mail-Invalid(Lenght) Password
    When Enter a invalid mail "invalidMail" in the Email field
    And Enter a invalid(lenght) password "invalidPasswordLenght" in the password field
    And Click the “Sign In” button
    Then The user cannot log in successfully
    And The warning message2 "Please enter a valid email address" is displayed

  @InvalidMailInvalid(Character)Password
  Scenario: 1.27 Login-Invalid Mail-Invalid(Only Character) Password
    When Enter a invalid mail "invalidMail" in the Email field
    And Enter a invalid(character) password "invalidPasswordCharacter" in the password field
    And Click the “Sign In” button
    Then The user cannot log in successfully
    And The warning message2 "Please enter a valid email address" is displayed

  @InvalidMailInvalid(Numeric)Password
  Scenario: 1.28 Login-Invalid Mail-Invalid(Only Numeric) Password
    When Enter a invalid mail "invalidMail" in the Email field
    And Enter a invalid(numeric) password "invalidPasswordNumeric" in the password field
    And Click the “Sign In” button
    Then The user cannot log in successfully
    And The warning message2 "Please enter a valid email address" is displayed

  @BlankMailInvalidPassword
  Scenario: 1.29 Login-Blank Mail-Blank Password
    When Leave the email "blankMail" field blank
    And Leave the password "blankPassword" field blank
    And Click the “Sign In” button
    Then The user cannot log in successfully
    And The warning message2 "Please enter a valid email address" is displayed

  @BlankMailValidPassword
  Scenario: 1.30 Login-Blank Mail-Valid Password
    When Leave the email "blankMail" field blank
    And Enter a valid password "validPassword" in the password field
    And Click the “Sign In” button
    Then The user cannot log in successfully
    And The warning message2 "Please enter a valid email address" is displayed

  @BlankMailValidPassword
  Scenario: 1.31 Login-Valid Mail-Blank Password
    When Enter a valid mail "validMail" in the Email field
    And Leave the password "blankPassword" field blank
    And Click the “Sign In” button
    Then The user cannot log in successfully
    And The warning message3 "Please enter your password" is displayed

  @PasswordAppearingButon
  Scenario: 1.32 Login-Valid Mail-Valid Password And Remember me
    When Enter a valid password "validPassword" in the password field
    And Click on the show password button
    Then The characters written in the password field are visible
    When Click on the show password button again
    Then Characters written in the password field appear as asterisks

  @ForgotPassword
  Scenario: 1.33 Login-Forgot Password
    When Click the "Forgot Password" button
    Then Redirects to the password renewal page

  @ValidMailValidPasswordAndRememberMe
  Scenario: 1.34 Login-Valid Mail-Valid Password And Remember Me
    When Enter a valid mail "registeredMail" in the Email field (Must be a previously registered email)
    And Enter a valid password "validPassword" in the password field
    And Click the “Sign In” button
    Then The user can log in successfully
    When Reopen the browser
    Then The user can log in successfully

  @LoginFormElementsControlforBrowsers
  Scenario: 1.35 Login Form Elements Control for Browsers
    Then The email field is visible
    Then The password field is visible
    Then The “Sign In” button is visible
    Then The “Show Password” button is visible
    Then The "Forgot Password" button is visible




