package com.drawing.stepdefs;

import com.drawing.recursive.impl.Canvas;
import com.drawing.recursive.impl.ICommand;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DrawCanvasSteps {
    Canvas canvas;
    ICommand commandImpl;

    @Given("^I need to draw canvas$")
    public void we_have_feature_file() throws Throwable {

        System.out.println("execute Given step");
    }

    @When("^I enter command (.*) with width (\\d+) and height (\\d+)$")
    public void iEnterCommandCommandWithWidthWidthAndHeightHeight(String command, int width, int height) {
        if(command.equalsIgnoreCase("C"))
            canvas = new Canvas(width, height);
    }
    @Then("^Draw canvas (.*)$")
    public void those_steps_should_not_fail(String message) throws Throwable {
        canvas.draw();
    }



}
