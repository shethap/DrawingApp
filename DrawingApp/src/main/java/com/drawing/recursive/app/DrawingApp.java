package com.drawing.recursive.app;

import com.drawing.recursive.impl.Canvas;
import com.drawing.recursive.constants.DrawingAppConstants;
import com.drawing.recursive.dto.CommandRequestDTO;
import com.drawing.recursive.exception.DrawingException;
import com.drawing.recursive.factory.CommandFactory;
import com.drawing.recursive.impl.FillCommandImpl;
import com.drawing.recursive.util.DrawingUtil;
import com.drawing.recursive.validator.CommandValidator;

import java.util.Scanner;

/**
 * Main class to access the drawing App
 */
public class DrawingApp {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            Canvas canvas = null;
            while (true) {
                DrawingUtil.getMenu();
                String commandWithParams = scanner.nextLine();
                String commands[] = commandWithParams.split(" ");
                if (CommandValidator.validate(commands)) {

                    switch (commands[0]) {
                        case "C":
                        case "c":
                            canvas = new Canvas(
                                    DrawingUtil.convertStringToInt(commands[1]),
                                    DrawingUtil.convertStringToInt(commands[2]));
                            canvas.draw();
                            break;
                        case "L":
                        case "l":
                        case "R":
                        case "r":
                            if (canvas == null) {
                                System.err.println(DrawingAppConstants.CANVAS_NOT_INITILIZED);
                                break;
                            }
                            CommandRequestDTO commandRequestDTO = DrawingUtil.prepareCommandRequest(commands[0], canvas,
                                    commands[1], commands[2], commands[3], commands[4]);
                            CommandFactory.getCommand(commandRequestDTO).draw();
                            break;
                        case "B":
                        case "b":
                            if (canvas == null) {
                                System.err.println(DrawingAppConstants.CANVAS_NOT_INITILIZED);
                                break;
                            }
                            FillCommandImpl fillCommandImpl = new FillCommandImpl(
                                    canvas);
                            fillCommandImpl.fill(canvas.getCanvas(),
                                    new boolean[canvas.getCanvas().length][canvas.getCanvas()[0].length],
                                    DrawingUtil.convertStringToInt(commands[2]),
                                    DrawingUtil.convertStringToInt(commands[1]),
                                    commands[3]);
                            fillCommandImpl.draw();
                            break;
                        case "Q":
                        case "q":
                            System.out.println(DrawingAppConstants.GOODBYE_MESSAGE);
                            System.exit(0);
                        default:
                            System.err.println(DrawingAppConstants.INVALID_COMMAND);
                            break;

                    }
                }
            }
        } catch (NumberFormatException | DrawingException e) {
            e.printStackTrace();
        }

    }
}
