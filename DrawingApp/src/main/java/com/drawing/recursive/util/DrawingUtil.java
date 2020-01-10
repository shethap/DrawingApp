package com.drawing.recursive.util;

import com.drawing.recursive.dto.CommandRequestDTO;
import com.drawing.recursive.exception.DrawingException;
import com.drawing.recursive.impl.Canvas;

public class DrawingUtil {

    public static void getMenu() {

        System.out.println();
        System.out.println("*****Available Options*****");

        System.out.println("1. Press C to draw Canvas");
        System.out.println("   For Ex: C 20 4");
        System.out.println();

        System.out.println("2. Press L to draw Line");
        System.out.println("   For Ex: L 1 2 6 2");
        System.out.println();

        System.out.println("3. Press R to draw Rectangle");
        System.out.println("   For Ex: R 14 1 18 3");
        System.out.println();

        System.out.println("4. Press B to Fill Bucket");
        System.out.println("   For Ex: B 10 3 o");
        System.out.println();

        System.out.println("5. Press Q to Quit");
        System.out.print("Enter Command: ");
    }

    public static int convertStringToInt(String number) throws DrawingException {
        Integer convertedString = null;
        try {
            convertedString = Integer.parseInt(number);
        } catch (Exception e) {
            throw new DrawingException(e.getMessage());
        }
        return convertedString;
    }

    public static CommandRequestDTO prepareCommandRequest(String commandType, Canvas canvas, String x1, String y1, String x2, String y2)
            throws DrawingException {

        CommandRequestDTO commandDetailsDTO = new CommandRequestDTO();
        commandDetailsDTO.setCommandType(commandType);
        commandDetailsDTO.setCanvas(canvas);
        commandDetailsDTO.setX1(DrawingUtil.convertStringToInt(x1));
        commandDetailsDTO.setY1(DrawingUtil.convertStringToInt(y1));
        commandDetailsDTO.setX2(DrawingUtil.convertStringToInt(x2));
        commandDetailsDTO.setY2(DrawingUtil.convertStringToInt(y2));

        return commandDetailsDTO;
    }
}
