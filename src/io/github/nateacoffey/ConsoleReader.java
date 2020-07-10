package io.github.nateacoffey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements Runnable {
	
	
	int threadNumber = -1;
	
	public void run() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = "";
		
		
		try {
			//thread end once y is entered
			while(!input.equalsIgnoreCase("q")) {
				input = br.readLine();
				
				try {
					switch(Integer.parseInt(input)) {
						case 0:
							threadNumber = 0;
							break;
						case 1:
							threadNumber = 1;
							break;
						case 2:
							threadNumber = 2;
							break;
						case 3:
							threadNumber = 3;
							break;
						default:
							threadNumber = -1;
							break;
					}
				}catch(NumberFormatException ife) {
					
				}
				
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public int getThreadNumber() {
		int temp = threadNumber;
		threadNumber = -1;
		
		return temp;
	}
	
}
