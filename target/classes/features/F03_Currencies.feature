@smoke
Feature: F03_Currencies | User could switch currency between Dollar and Euro from the dropdown list on the top left of home page

  Scenario: user could Select Euro currency
    When user select currency type and choose Euro
    Then verify Euro Symbol (€) is shown on the four products displayed in Home page
