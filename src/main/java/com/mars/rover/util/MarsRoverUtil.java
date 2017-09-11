package com.mars.rover.util;

import static com.mars.rover.util.MarsRoverConstants.*;

import java.util.LinkedList;
import java.util.Queue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarsRoverUtil {
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

	public static String DIRECTION = "";
	public static int X_CORDINATE = 0;
	public static int Y_CORDINATE = 0;
	public static String COMMANDS = "LRM";
	public static String LEFT = "L";
	public static String RIGHT = "R";
	public static String MOVE = "M";
	public static String DIRECTIONS = "NSEW";
	public static String NORTH = "N";
	public static String SOUTH = "S";
	public static String EAST = "E";
	public static String WEST = "W";

	public String parseInput(String inputString) {

		Queue<String> elements = new LinkedList<String>();
		Boolean isIntFlag = false;

		String[] inputArray = inputString.split(" ");
		for (int i = 0; i < inputArray.length; i++) {
			String input = inputArray[i];
			LOGGER.debug(INPUT + input);
			if (input.length() > 1) {
				executeCommand(input);
			} else {
				isIntFlag = isInt(input);
				LOGGER.debug(IS_INTFLAG + isIntFlag);
				if (isIntFlag) {
					elements.add(input);
					LOGGER.debug(ELEMENT_SIZE + elements.size());
					if (elements.size() == 2) {
						getXYCordinates(elements);
					}
				} else if (DIRECTIONS.indexOf(input) >= 0) {
					DIRECTION = input;
					LOGGER.debug(DIRECTION_CONST + DIRECTION);
				} else if (COMMANDS.indexOf(input) >= 0) {
					LOGGER.debug(INPUT + input);
					inputCommand(input);
				}
			}
		}
		return X_CORDINATE + " " + Y_CORDINATE + " " + DIRECTION;
	}

	public void executeCommand(String input) {

		String inputCmd;
		char[] cmdArray = input.toCharArray();
		for (int j = 0; j < cmdArray.length; j++) {
			inputCmd = String.valueOf(cmdArray[j]);
			inputCommand(inputCmd);
		}
	}

	public void getXYCordinates(Queue<String> elements) {
		X_CORDINATE = Integer.parseInt(elements.poll());
		Y_CORDINATE = Integer.parseInt(elements.poll());
		LOGGER.debug(XCORD_CONST + X_CORDINATE + YCORD_CONST + Y_CORDINATE);
	}

	public void moveToDir() {

		switch (DIRECTION) {
		case "N":
			LOGGER.debug(NORTH);
			Y_CORDINATE++;
			break;
		case "E":
			LOGGER.debug(EAST);
			X_CORDINATE++;
			break;
		case "S":
			LOGGER.debug(SOUTH);
			Y_CORDINATE--;
			break;
		case "W":
			LOGGER.debug(WEST);
			X_CORDINATE--;
			break;
		}
	}

	public void turnToDir(String dir) {
		DIRECTION = ((DIRECTIONS.indexOf(dir) >= 0) || (COMMANDS.indexOf(dir) >= 0)) ? dir : DIRECTION;
		LOGGER.debug(DIRECTION_CONST + dir + DIRECTION_CONST_1 + DIRECTION);
	}

	public void inputCommand(String command) {
		LOGGER.debug(COMMAND + command);
		switch (command) {
		case "L":
			LOGGER.debug(COMMAND + LEFT);
			switch (DIRECTION) {
			case "N":
				LOGGER.debug(TURN_TO_DIR + WEST);
				turnToDir(WEST);
				break;
			case "E":
				LOGGER.debug(TURN_TO_DIR + NORTH);
				turnToDir(NORTH);
				break;
			case "W":
				LOGGER.debug(TURN_TO_DIR + SOUTH);
				turnToDir(SOUTH);
				break;
			case "S":
				LOGGER.debug(TURN_TO_DIR + EAST);
				turnToDir(EAST);
				break;
			}
			break;
		case "R":
			LOGGER.debug(COMMAND + RIGHT);
			switch (DIRECTION) {
			case "N":
				LOGGER.debug(TURN_TO_DIR + EAST);
				turnToDir(EAST);
				break;
			case "E":
				LOGGER.debug(TURN_TO_DIR + SOUTH);
				turnToDir(SOUTH);
				break;
			case "W":
				LOGGER.debug(TURN_TO_DIR + NORTH);
				turnToDir(NORTH);
				break;
			case "S":
				LOGGER.debug(TURN_TO_DIR + WEST);
				turnToDir(WEST);
				break;
			}
			break;
		case "M":
			LOGGER.debug(MOVE_TO_DIR + DIRECTION);
			moveToDir();
			break;
		}
	}

	public boolean isInt(String theValue) {
		return theValue.matches("\\d+");
	}

}
