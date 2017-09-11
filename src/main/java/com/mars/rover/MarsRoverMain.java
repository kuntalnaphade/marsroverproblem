package com.mars.rover;

import java.util.Scanner;

import com.mars.rover.util.MarsRoverUtil;

public class MarsRoverMain {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		MarsRoverUtil marsRoverUtil = new MarsRoverUtil();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the area dimension A[][]: ");
	
		String area = sc.nextLine();
		System.out.println("Entered area dimension is: " + area);
		area = marsRoverUtil.parseInput(area);
		while (sc.hasNext()) {
			String roverPosition = sc.nextLine();
			roverPosition = marsRoverUtil.parseInput(roverPosition);
			System.out.println("Before: Rover position: " + roverPosition);
			String commands = sc.nextLine();
			roverPosition = marsRoverUtil.parseInput(commands);
			System.out.println("After: Rover position: " + roverPosition);
		}
	}
}
