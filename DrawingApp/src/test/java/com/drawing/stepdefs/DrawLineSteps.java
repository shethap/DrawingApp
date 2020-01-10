package com.drawing.stepdefs;

import com.drawing.recursive.impl.Canvas;
import com.drawing.recursive.impl.ICommand;
import com.drawing.recursive.exception.DrawingException;
import com.drawing.recursive.factory.CommandFactory;
import com.drawing.recursive.util.DrawingUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DrawLineSteps {
    Canvas canvas;
    ICommand commandImpl;


    @Given("^I need to draw line$")
    public void iNeedToDrawLine() {
    }

    @And("^canvas of (\\d+) and (\\d+) exists$")
    public void canvasOfWidthAndHeightExists(int width, int height) {
        if (canvas == null) {
            canvas = new Canvas(width, height);
        }
        canvas.draw();
    }

    @When("^I enter command (.*) with coordinates (.*) (.*) (.*) (.*)$")
    public void iEnterCommandCommandWithCoordinatesXYXY(char command, String x1, String y1, String x2, String y2) throws DrawingException {
        commandImpl = CommandFactory.getCommand(command, canvas,
                DrawingUtil.convertStringToInt(x1),
                DrawingUtil.convertStringToInt(y1),
                DrawingUtil.convertStringToInt(x2),
                DrawingUtil.convertStringToInt(y2));

    }

    @Then("^Draw Line$")
    public void drawLine() {
        commandImpl.draw();
    }


}
