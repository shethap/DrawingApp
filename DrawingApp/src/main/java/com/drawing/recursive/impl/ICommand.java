package com.drawing.recursive.impl;

import com.drawing.recursive.dto.Point;

public interface ICommand {

	void prepareCommand(Point point1, Point point2, int xIncrement,
                        int yIncrement);

	void draw();

}
