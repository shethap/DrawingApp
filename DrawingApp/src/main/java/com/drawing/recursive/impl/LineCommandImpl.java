package com.drawing.recursive.impl;

import com.drawing.recursive.constants.DrawingAppConstants;
import com.drawing.recursive.dto.Point;
import com.drawing.recursive.exception.DrawingException;

/**
 * @author Apurv
 */
public class LineCommandImpl implements ICommand {

    private Point point1;
    private Point point2;
    String[][] matrix;
    Canvas canvas;

    /**
     * Constructor
     *
     * @param canvas
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public LineCommandImpl(Canvas canvas, int x1, int y1, int x2, int y2)
            throws DrawingException {
        point1 = new Point(x1, y1);
        point2 = new Point(x2, y2);
        this.matrix = canvas.getCanvas();
        this.canvas = canvas;
        prepareCommand(this.getPoint1(), this.getPoint2(), this.getPoint1()
                .getX(), this.getPoint1().getY());
    }

    /**
     * Normal Function with traditional for loop
     */
    void prepareShapeWithoutRecursion() {
        if (point1.getY() == point2.getY()) {
            for (int i = point1.getX(); i <= point2.getX(); i++) {
                matrix[point1.getY()][i] = DrawingAppConstants.CROSS_SYMBOL;
            }
        }
        if (point1.getX() == point2.getX()) {
            for (int i = point1.getY(); i <= point2.getY(); i++) {
                matrix[i][point1.getX()] = DrawingAppConstants.CROSS_SYMBOL;
            }
        }
        draw();
    }

    public void prepareCommand(Point point1, Point point2, int xIncrement,
                               int yIncrement) {

        if (!validate())
            return;
        if (point1.getY() == point2.getY() && xIncrement <= point2.getX()
                && yIncrement == point1.getY()) {
            matrix[point1.getY()][xIncrement] = DrawingAppConstants.CROSS_SYMBOL;
            prepareCommand(point1, point2, xIncrement + 1, yIncrement);

        }
        if (point1.getX() == point2.getX() && yIncrement <= point2.getY()
                && xIncrement == point1.getX()) {
            matrix[yIncrement][point1.getX()] = DrawingAppConstants.CROSS_SYMBOL;
            prepareCommand(point1, point2, xIncrement, yIncrement + 1);
        }
    }

    public void draw() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }

        }
    }

    private boolean validate() {

        if (this.point1.getX() <= 0
                || this.point2.getX() > canvas.getHeight() - 1
                || this.point1.getY() <= 0
                || this.point2.getY() > canvas.getWidth() - 2) {
            System.err.println(DrawingAppConstants.INVALID_COORDINATES);
            return Boolean.FALSE;
        }

        // To check if line is congruent or not
        if (this.point1.getX() > this.point2.getX()
                || this.point1.getY() > this.point2.getY()) {
            System.err.println(DrawingAppConstants.COORDINATES_NOT_CONGRUENT);
            return Boolean.FALSE;
        }
        // To allow only Horizontal & vertical lines allowed
        if (this.point1.getX() != this.point2.getX()
                && this.point1.getY() != this.point2.getY()) {
            System.err.println(DrawingAppConstants.COORDINATES_NOT_CONGRUENT);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;

    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

}
