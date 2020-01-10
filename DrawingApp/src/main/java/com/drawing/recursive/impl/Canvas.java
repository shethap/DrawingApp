package com.drawing.recursive.impl;

import com.drawing.recursive.constants.DrawingAppConstants;

public class Canvas {

	private int width;
	private int height;
	String canvas[][];

	public Canvas(int height, int width) {
		this.width = width + 2;
		this.height = height + 1;
		canvas = new String[this.width][this.height];
	}

	public void draw() {
		for (int i = 0; i < canvas.length; i++) {
			for (int j = 0; j < canvas[0].length; j++) {
				if ((i == 0 || i == (canvas.length - 1))
						&& j != canvas[0].length) {

					canvas[i][j] = DrawingAppConstants.HYPHEN_SYMBOL;
				}
				if ((i > 0 && i < canvas.length - 1)
						&& (j == 0 || j == canvas[0].length - 2)) {
					canvas[i][j] = DrawingAppConstants.PIPE_SYMBOL;
				}
				if ((i > 0 && i < canvas.length - 1)
						&& (j > 0 && j < canvas[0].length - 2)) {
					canvas[i][j] = DrawingAppConstants.SPACE;
				}
				if (j == canvas[0].length - 1) {
					canvas[i][j] = DrawingAppConstants.NEW_LINE;
				}
			}
		}

		drawFinally();
	}

	void drawFinally() {
		for (int i = 0; i < canvas.length; i++) {
			for (int j = 0; j < canvas[0].length; j++) {
				System.out.print(canvas[i][j]);
			}

		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String[][] getCanvas() {
		return canvas;
	}

	public void setCanvas(String[][] canvas) {
		this.canvas = canvas;
	}

}
