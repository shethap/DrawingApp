package com.drawing.recursive.factory;

import com.drawing.recursive.impl.Canvas;
import com.drawing.recursive.impl.ICommand;
import com.drawing.recursive.constants.DrawingAppConstants;
import com.drawing.recursive.dto.CommandRequestDTO;
import com.drawing.recursive.enums.CommandEnum;
import com.drawing.recursive.exception.DrawingException;
import com.drawing.recursive.impl.LineCommandImpl;
import com.drawing.recursive.impl.RectangleCommandImpl;

/**
 * Factory to produce commands based on inputs.
 */
public class CommandFactory {

    /**
     * @param commandType
     * @param canvas
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     * @throws DrawingException
     */
    public static ICommand getCommand(char commandType, Canvas canvas, int x1,
                                      int y1, int x2, int y2) throws DrawingException {

        if (commandType == 'L' && canvas != null) {
            return new LineCommandImpl(canvas, x1, y1, x2, y2);
        } else if (commandType == 'R' && canvas != null) {
            return new RectangleCommandImpl(canvas, x1, y1, x2, y2);
        } else {
            System.err.println(DrawingAppConstants.INVALID_COMMAND);
        }
        return null;
    }

    public static ICommand getCommand(CommandRequestDTO commandRequestDTO) throws DrawingException {

        if (CommandEnum.fromString(commandRequestDTO.getCommandType()) == CommandEnum.LINE && commandRequestDTO.getCanvas() != null) {
            return new LineCommandImpl(commandRequestDTO.getCanvas(), commandRequestDTO.getX1(), commandRequestDTO.getY1(),
                    commandRequestDTO.getX2(), commandRequestDTO.getY2());

        } else if (CommandEnum.fromString(commandRequestDTO.getCommandType()) == CommandEnum.RECTANGLE && commandRequestDTO.getCanvas() != null) {
            return new RectangleCommandImpl(commandRequestDTO.getCanvas(), commandRequestDTO.getX1(), commandRequestDTO.getY1(),
                    commandRequestDTO.getX2(), commandRequestDTO.getY2());

        } else {
            System.err.println(DrawingAppConstants.INVALID_COMMAND);
        }
        return null;
    }


}
