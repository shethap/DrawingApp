package com.drawing.recursive.validator;

import com.drawing.recursive.constants.DrawingAppConstants;
import com.drawing.recursive.enums.CommandEnum;

public class CommandValidator {

    public static Boolean validate(String[] command) {
        Boolean isValidCommand = Boolean.TRUE;

        if (!CommandEnum.contains(command[0])) {
            isValidCommand = Boolean.FALSE;
        } else if (((CommandEnum.CANVAS.getValue().equalsIgnoreCase(command[0]) && command.length != 3)
                || (CommandEnum.FILL.getValue().equalsIgnoreCase(command[0]) && command.length != 4) && !isInteger(command))) {
            isValidCommand = Boolean.FALSE;
        } else if ((CommandEnum.LINE.getValue().equalsIgnoreCase(command[0]) || CommandEnum.RECTANGLE
                .getValue().equalsIgnoreCase(command[0])) && command.length != 5 || (command.length == 5 && !isInteger(command))) {
            isValidCommand = Boolean.FALSE;
        }
        if (!isValidCommand) {
            System.err.println(DrawingAppConstants.INVALID_COMMAND);
        }
        return isValidCommand;

    }

    private static boolean isInteger(String[] number) {
        Boolean bool = Boolean.TRUE;
        for (int i = 1; i < number.length; i++) {
            if (!(bool = number[i].matches("\\d+"))) {
                break;
            }
        }

        return bool;
    }
}
