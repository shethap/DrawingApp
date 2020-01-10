Feature: Draw Line

  Scenario Outline: Line is drawn successfully within canvas
    Given I need to draw line
    And canvas of <width> and <height> exists
    When  I enter command <command> with coordinates <x1> <y1> <x2> <y2>
    Then  Draw Line
    Examples:
      | command | x1 | y1 | x2 | y2 | width | height |
      | L       | 1  | 2  | 6  | 2  | 20    | 4      |
      | L       | 1  | 2  | 6  | 2  | 20    | 4      |
      | L       | 1  | 2  | 6  | 3  | 20    | 4      |
      | L       | 6  | 3  | 6  | 4  | 20    | 4      |
      | L       | 6  | 3  | 7  | 4  | 20    | 4      |
      | L       | 21 | 3  | 7  | 5  | 20    | 4      |


