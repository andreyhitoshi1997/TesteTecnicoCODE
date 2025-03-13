Feature: Amazon Mobile Navigation

  Scenario: Verify autocomplete suggestions
    Given user is on Amazon homepage
    When user types "liv" in search bar
    Then suggestions should appear

  Scenario: Menu abre e e navegavel
    Given user is on Amazon homepage in mobile mode
    When user clicks on the menu
    Then the menu should be displayed and navigable

  Scenario: Pagina carrega em menos de 3 segundos
    Given user is on Amazon homepage in mobile mode
    Then the page should load in less than 3 seconds