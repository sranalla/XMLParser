package com.virtusa.xml.parser;

import java.util.Scanner;

import com.virtusa.xml.parser.common.InputReader;

public class Application {

	public static void main(String[] args) {
		
		// Prompt the user
		System.out.println( "********** XML PARSER **********" );
		System.out.println("Please input the file with xml to parse");
		
		// 1. Input the file
		Scanner scanner = new Scanner( System.in );
		String inputFile = scanner.nextLine();
		System.out.println( "You choose file: " + inputFile  + ", Let us parse it");
		
		// 2. Parse the file
		// later modify it to parse each input file in separate thread and in parallel
		Application application = new Application();
		application.parseXML(inputFile);
		
		// 3. Release resources
		scanner.close();

	}
	
	public void parseXML(String inputfile) {
		
		try {
			
			InputReader xmlParser = new InputReader();
	        xmlParser.parseInput(inputfile);
	        System.out.println( "********** XML PARSED SUCCESSFULLY **********" );
	        
		}catch(Exception e) {
			System.err.println("We are unable to parse document this time because of below error");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}

}