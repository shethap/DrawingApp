package com.drawing.recursive.impl;

import com.drawing.recursive.constants.DrawingAppConstants;
import com.drawing.recursive.dto.Point;

public class RectangleCommandImpl implements ICommand {

    private Point point1;
    private Point point2;
    String[][] matrix;
    Canvas canvas;

    public RectangleCommandImpl(Canvas canvas, int x1, int y1, int x2, int y2) {
        point1 = new Point(x1, y1);
        point2 = new Point(x2, y2);
        this.canvas = canvas;
        matrix = canvas.getCanvas();
        prepareCommand(this.getPoint1(), this.getPoint2(), this.getPoint1()
                .getX(), this.getPoint1().getY());
    }

    void prepareShapeWithoutRecursion() {

        for (int i = point1.getX(); i <= point2.getX(); i++) {
            matrix[point1.getY()][i] = DrawingAppConstants.CROSS_SYMBOL;
            matrix[point2.getY()][i] = DrawingAppConstants.CROSS_SYMBOL;
        }
        for (int i = point1.getY(); i <= point2.getY(); i++) {
            matrix[i][point1.getX()] = DrawingAppConstants.CROSS_SYMBOL;
            matrix[i][point2.getX()] = DrawingAppConstants.CROSS_SYMBOL;
        }
        draw();

    }

    private boolean validate() {

        if (this.point1.getX() <= 0
                || this.point2.getX() > canvas.getHeight() - 1
                || this.point1.getY() <= 0
                || this.point2.getY() > canvas.getWidth() - 2) {
            System.err.println(DrawingAppConstants.INVALID_COORDINATES);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;

    }

    /**
     * xIncrement & yIncrement is taken to not to change Point object due to
     * recursive nature of the function.
     *
     * @param point1
     * @param point2
     * @param xIncrement
     * @param yIncrement
     */

    public void prepareCommand(Point point1, Point point2, int xIncrement,
                               int yIncrement) {

        if (!validate())
            return;
        if (xIncrement <= point2.getX() && yIncrement == point1.getY()) {

            matrix[point1.getY()][xIncrement] = DrawingAppConstants.CROSS_SYMBOL;
            matrix[point2.getY()][xIncrement] = DrawingAppConstants.CROSS_SYMBOL;
            prepareCommand(point1, point2, xIncrement + 1, point1.getY());

        }
        if (yIncrement <= point2.getY() && xIncrement == point1.getX()) {
            matrix[yIncrement][point1.getX()] = DrawingAppConstants.CROSS_SYMBOL;
            matrix[yIncrement][point2.getX()] = DrawingAppConstants.CROSS_SYMBOL;

            prepareCommand(point1, point2, point1.getX(), yIncrement + 1);

        }
    }

    public void draw() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }

        }
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

}
