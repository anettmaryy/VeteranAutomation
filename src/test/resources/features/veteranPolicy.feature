Feature: Veteran Plan Policy Creation

  Background:
    Given User launches the Veteran Plan home page

  @TC01 @Regression
  Scenario Outline:Create a Veteran Policy with Activity Group 1, a Basic Cover Plan, and Direct Debit Annual Payment.
    When user select checkbox for Horse details
    And user enters the required Horse details from Excel "<data>"
    Then user will lands on PolicyHolderDetails page
    When user fills policyholder details
    Then user navigate to activity group page
    When user selecting activity "Group1"
    Then user navigate to cover selection page
    When user selects Basic Cover and "not opting" Optional Cover
    Then user lands on quote page
    When user agree above details
    Then user navigate to history page
    When user answers all underwriting history details as No and acknowledge it
    Then user lands on Payment Summary
    When user select the "DD Annually" Payment method
    Then user lands on Summary
    And review the provided details
    When user proceeds checkout
    Then user lands on Payment section
    When user completes the "Direct Debit Annually" payment successfully
    Then Policy details should be displayed


    Examples:
      |data|
      |TC01d01|



  @TC02 @Regression
  Scenario Outline:Create a Veteran Policy with Activity Group 2, a Basic Cover Plan, a Optional Cover with VF and Direct Debit Monthly Payment.
    When user select checkbox for Horse details
    And user enters the required Horse details from Excel "<data>"
    Then user will lands on PolicyHolderDetails page
    When user fills policyholder details
    Then user navigate to activity group page
    When user selecting activity "Group2"
    Then user navigate to cover selection page
    When user selects Basic Cover and "vf" Optional Cover
    Then user lands on quote page
    When user agree above details
    Then user navigate to history page
    When user answers all underwriting history details as No and acknowledge it
    Then user lands on Payment Summary
    When user select the "DD Monthly" Payment method
    Then user lands on Summary
    And review the provided details
    When user proceeds checkout
    Then user lands on Payment section
    When user completes the "Direct Debit Monthly" payment successfully
    Then Policy details should be displayed



    Examples:
      |data|
      |TC02d01|

  @TC03 @Regression
  Scenario Outline:Create a Veteran Policy with Activity Group 3, a Basic cover plan, a Optional cover with Disposal and Credit/Debit Payment.
    When user select checkbox for Horse details
    And user enters the required Horse details from Excel "<data>"
    Then user will lands on PolicyHolderDetails page
    When user fills policyholder details
    Then user navigate to activity group page
    When user selecting activity "Group3"
    Then user navigate to cover selection page
    When user selects Basic Cover and "disposal" Optional Cover
    Then user lands on quote page
    When user agree above details
    Then user navigate to history page
    When user answers all underwriting history details as No and acknowledge it
    Then user lands on Payment Summary
    When user select the "CC" Payment method
    Then user lands on Summary
    And review the provided details
    When user proceeds checkout
    Then user lands on Payment CreditorDebit section
    When user completes the "Credit/Debit card" payment successfully
    Then Policy details should be displayed




    Examples:
      |data|
      |TC03d01|

  @TC04 @Regression
  Scenario Outline:Create a Veteran Policy with Activity Group 4, a Basic cover plan, a Optional cover with Saddlery&Tack and Direct Debit Annual Payment.
    When user select checkbox for Horse details
    And user enters the required Horse details from Excel "<data>"
    Then user will lands on PolicyHolderDetails page
    When user fills policyholder details
    Then user navigate to activity group page
    When user selecting activity "Group4"
    Then user navigate to cover selection page
    When user selects Basic Cover and "saddlery&tack" Optional Cover
    Then user lands on quote page
    When user agree above details
    Then user navigate to history page
    When user answers all underwriting history details as No
    Then user lands on Payment Summary
    When user select the "DD Annually" Payment method
    Then user lands on Summary
    And review the provided details
    When user proceeds checkout
    Then user lands on Payment section
    When user completes the "Direct Debit Annually" payment successfully
    Then Policy details should be displayed


    Examples:
      |data|
      |TC04d01|

  @TC05 @Regression
  Scenario Outline:Create a Veteran Policy with Activity Group 5, a Basic cover plan, a Optional cover with HorseTrailer and Direct Debit Monthly Payment.
    When user select checkbox for Horse details
    And user enters the required Horse details from Excel "<data>"
    Then user will lands on PolicyHolderDetails page
    When user fills policyholder details
    Then user navigate to activity group page
    When user selecting activity "Group5"
    Then user navigate to cover selection page
    When user selects Basic Cover and "horsetrailer" Optional Cover
    Then user lands on quote page
    When user agree above details
    Then user navigate to history page
    When user answers all underwriting history details as No
    Then user lands on Payment Summary
    When user select the "DD Monthly" Payment method
    Then user lands on Summary
    And review the provided details
    When user proceeds checkout
    Then user lands on Payment section
    When user completes the "Direct Debit Monthly" payment successfully
    Then Policy details should be displayed





    Examples:
      |data|
      |TC05d01|


  @TC06 @Regression
  Scenario Outline:Create a Veteran Policy with Activity Group 6, a Basic Cover Plan, and Credit/Debit card payment.
    When user select checkbox for Horse details
    And user enters the required Horse details from Excel "<data>"
    Then user will lands on PolicyHolderDetails page
    When user fills policyholder details
    Then user navigate to activity group page
    When user selecting activity "Group6"
    Then user navigate to cover selection page
    When user selects Basic Cover and "not opting" Optional Cover
    Then user lands on quote page
    When user agree above details
    Then user navigate to history page
    When user answers all underwriting history details as No and acknowledge it
    Then user lands on Payment Summary
    When user select the "CC" Payment method
    Then user lands on Summary
    And review the provided details
    When user proceeds checkout
    Then user lands on Payment CreditorDebit section
    When user completes the "Credit/Debit card" payment successfully
    Then Policy details should be displayed



    Examples:
      |data|
      |TC06d01|