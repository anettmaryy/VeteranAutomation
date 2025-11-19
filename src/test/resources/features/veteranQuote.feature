Feature: Veteran Plan Quote Creation

  Background:
    Given User launches the Veteran Plan home page

  @TC07 @Regression
  Scenario Outline:Create a Veteran Quote with Activity Group 1 and a Basic Cover Plan.
    When user select checkbox for Horse details
    And user enters the required Horse details from Excel "<data>"
    Then user will lands on PolicyHolderDetails page
    When user fills policyholder details
    Then user navigate to activity group page
    When user selecting activity "Group1"
    Then user navigate to cover selection page
    When user selects Basic Cover and "not opting" Optional Cover
    Then user lands on quote page
    When user select declaration and the save quote
    Then Quote Reference Number and Quote details are captured

    Examples:
      |data|
      |TC07d01|


  @TC08 @Regression
  Scenario Outline:Create a Veteran Quote with Activity Group 2, a Basic Cover Plan, and Optional Cover with VF.
    When user select checkbox for Horse details
    And user enters the required Horse details from Excel "<data>"
    Then user will lands on PolicyHolderDetails page
    When user fills policyholder details
    Then user navigate to activity group page
    When user selecting activity "Group2"
    Then user navigate to cover selection page
    When user selects Basic Cover and "vf" Optional Cover
    Then user lands on quote page
    When user select declaration and the save quote
    Then Quote Reference Number and Quote details are captured

    Examples:
      |data|
      |TC08d01|


  @TC09 @Regression
  Scenario Outline:Create Veteran Quote with Activity Group 3, a Basic cover plan, and Optional cover with Disposal.
    When user select checkbox for Horse details
    And user enters the required Horse details from Excel "<data>"
    Then user will lands on PolicyHolderDetails page
    When user fills policyholder details
    Then user navigate to activity group page
    When user selecting activity "Group3"
    Then user navigate to cover selection page
    When user selects Basic Cover and "disposal" Optional Cover
    Then user lands on quote page
    When user select declaration and the save quote
    Then Quote Reference Number and Quote details are captured

    Examples:
      |data|
      |TC09d01|



  @TC10 @Regression
  Scenario Outline:Create Veteran Quote with Activity Group 4, a Basic cover plan, and Optional cover with Saddlery&Tack.
    When user select checkbox for Horse details
    And user enters the required Horse details from Excel "<data>"
    Then user will lands on PolicyHolderDetails page
    When user fills policyholder details
    Then user navigate to activity group page
    When user selecting activity "Group4"
    Then user navigate to cover selection page
    When user selects Basic Cover and "saddlery&tack" Optional Cover
    Then user lands on quote page
    When user select declaration and the save quote
    Then Quote Reference Number and Quote details are captured

    Examples:
      |data|
      |TC10d01|

  @TC11 @Regression
  Scenario Outline:Create Veteran Quote with Activity Group 5, a Basic cover plan, and Optional cover with HorseTrailer.
    When user select checkbox for Horse details
    And user enters the required Horse details from Excel "<data>"
    Then user will lands on PolicyHolderDetails page
    When user fills policyholder details
    Then user navigate to activity group page
    When user selecting activity "Group5"
    Then user navigate to cover selection page
    When user selects Basic Cover and "horsetrailer" Optional Cover
    Then user lands on quote page
    When user select declaration and the save quote
    Then Quote Reference Number and Quote details are captured

    Examples:
      |data|
      |TC11d01|

  @TC12 @Regression

  Scenario Outline:Create a Veteran Quote with Activity Group 6 and a Basic Cover Plan.
    When user select checkbox for Horse details
    And user enters the required Horse details from Excel "<data>"
    Then user will lands on PolicyHolderDetails page
    When user fills policyholder details
    Then user navigate to activity group page
    When user selecting activity "Group6"
    Then user navigate to cover selection page
    When user selects Basic Cover and "not opting" Optional Cover
    Then user lands on quote page
    When user select declaration and the save quote
    Then Quote Reference Number and Quote details are captured


    Examples:
      |data|
      |TC12d01|