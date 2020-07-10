package io.github.nateacoffey;

import java.util.Random;

public class Countdown implements Runnable {
	
	private int countdown;
	
	public void run() {
		
		//set countdown to random int between 60 - 100
		countdown = new Random().nextInt(41) + 60;
		int sleepCounter = 400;
		
		try {
			
			while(!Thread.interrupted()) {
				
				--countdown;
				
				//print countdown value
				System.out.println(Thread.currentThread().getName() + " " + countdown);
				
				//stops thread if countdown reaches 0
				if(countdown < 1) {
					Thread.currentThread().interrupt();
				}
				
				//lower sleep counter by 2 until it hits zero
				if(sleepCounter >= 2) {
					sleepCounter -= 2;
				}
				
				Thread.sleep(sleepCounter);
				
			}
			
		}catch(InterruptedException ie) {
			
			System.out.println( (Thread.currentThread().getName()) + ((countdown <= 0) ? " has reached zero." : " has stopped."));
			
		}
		
	}
	
	public void restartCountdown() {
		countdown = 100;
	}
	
}
