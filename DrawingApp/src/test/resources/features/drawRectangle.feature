Feature: Draw Line

  Scenario Outline: Rectangle is drawn successfully within canvas
    Given I need to draw rectangle
    And canvas of <width> and <height> exists to draw rectangle
    When  I enter Rectangle command <command> with coordinates <x1> <y1> <x2> <y2>
    Then  Draw Rectangle
    Examples:
      | command | x1 | y1 | x2 | y2 | width | height |
      | R       | 14 | 1  | 18 | 3  | 20    | 4      |



