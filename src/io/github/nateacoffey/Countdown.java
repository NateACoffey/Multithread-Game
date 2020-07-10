package io.github.nateacoffey;

import java.util.Random;

public class Countdown implements Runnable {
	
	private int countdown;
	
	public void run() {
		
		//set countdown to random int between 60 - 99
		countdown = new Random().nextInt(41) + 60;
		int sleepCounter = 500;
		
		try {
			
			while(!Thread.interrupted()) {
				
				--countdown;
				
				//prints random int between 60 - 99
				System.out.println(Thread.currentThread().getName() + " " + countdown);
				
				if(countdown < 1) {
					Thread.currentThread().interrupt();
				}
				
				Thread.sleep( (sleepCounter -= 2) );//run every half second
				
			}
			
		}catch(InterruptedException ie) {
			
			System.out.println( (Thread.currentThread().getName()) + ((countdown <= 0) ? " has reached zero." : " has stopped."));
			
		}
		
	}
	
	public void restartCountdown() {
		countdown = 100;
	}
	
	
}
