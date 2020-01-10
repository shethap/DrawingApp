package com.drawing.recursive.enums;

/**
 * Command enumaration to hold/validate the command
 */
public enum CommandEnum {
	CANVAS("C"), LINE("L"), RECTANGLE("R"), FILL("B"), QUIT("Q");

	private final String command;

	private CommandEnum(String command) {
		this.command = command;
	}

	public String getValue() {
		return this.command;
	}

	public static boolean contains(String input) {

		for (CommandEnum c : CommandEnum.values()) {
			if (c.command.equalsIgnoreCase(input)) {
				return true;
			}
		}
		return false;
	}

	public static CommandEnum fromString(String inputCommand) {
		for (CommandEnum b : CommandEnum.values()) {
			if (b.command.equalsIgnoreCase(inputCommand)) {
				return b;
			}
		}
		return null;
	}
}
