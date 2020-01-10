package com.drawing.recursive.impl;

import com.drawing.recursive.constants.DrawingAppConstants;
import com.drawing.recursive.dto.Point;

public class FillCommandImpl {

	Canvas canvas = null;
	Point point = null;

	public FillCommandImpl(Canvas canvas) {
		this.canvas = canvas;
	}

	public void fill(String[][] grid, boolean[][] visited, int r, int c, String inputColor) {
		// quit if off the grid:
		if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length)
			return;

		// Quit if visited already.
		if (visited[r][c])
			return;
		visited[r][c] = true;

		// Quit if hit borders
		if (grid[r][c].equalsIgnoreCase(DrawingAppConstants.PIPE_SYMBOL)
				|| grid[r][c].equalsIgnoreCase(DrawingAppConstants.HYPHEN_SYMBOL)
				|| grid[r][c].equalsIgnoreCase(DrawingAppConstants.CROSS_SYMBOL))
			return;

		// To visit places with space in them:
		if (grid[r][c].equalsIgnoreCase(" "))
			grid[r][c] = inputColor;

		// recursively fill in all directions
		fill(grid, visited, r + 1, c, inputColor);
		fill(grid, visited, r - 1, c, inputColor);
		fill(grid, visited, r, c + 1, inputColor);
		fill(grid, visited, r, c - 1, inputColor);
	}

	public void draw() {
		for (int i = 0; i < canvas.getCanvas().length; i++) {
			for (int j = 0; j < canvas.getCanvas()[0].length; j++) {
				System.out.print(canvas.getCanvas()[i][j]);
			}

		}
	}
}
