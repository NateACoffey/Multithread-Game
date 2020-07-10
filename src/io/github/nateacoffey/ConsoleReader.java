package io.github.nateacoffey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements Runnable {
	
	public void run() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = "";
		
		
		try {
			//thread end once y is entered
			while(!input.equalsIgnoreCase("q")) {
				input = br.readLine();
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
