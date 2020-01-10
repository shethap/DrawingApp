Feature: Draw Canvas

  Scenario Outline: Canvas is drawn successfully
    Given I need to draw canvas
    When  I enter command <command> with width <width> and height <height>
    Then  Draw canvas <warning>
    Examples:
      | command | width| height  | warning                       |
      | C       | 10   | 4       | Canvas is drawn successfully. |
      | C       | 25   | 10      | Canvas is drawn successfully. |


