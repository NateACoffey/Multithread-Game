package io.github.nateacoffey;


public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		//Create our new countdown threads
		Countdown down0 = new Countdown();
		Countdown down1 = new Countdown();
		Countdown down2 = new Countdown();
		Countdown down3 = new Countdown();
		Thread t0 = new Thread(down0);
		Thread t1 = new Thread(down1);
		Thread t2 = new Thread(down2);
		Thread t3 = new Thread(down3);
		
		
		//start the threads one after the other
		t0.start();
		Thread.sleep(10);
		t1.start();
		Thread.sleep(10);
		t2.start();
		Thread.sleep(10);
		t3.start();
		
		
		//start console reader to print and read console simultaneously
		ConsoleReader reader = new ConsoleReader();
		Thread tRead = new Thread(reader);
		tRead.start();
		
		
		//timer start
		long startTime = System.nanoTime();
		
		//loop until one thread stops
		while(tRead.isAlive()) {
			
			//grabs console input
			switch(reader.getThreadNumber()) {
				case 0:
					down0.restartCountdown();
					break;
				case 1:
					down1.restartCountdown();
					break;
				case 2:
					down2.restartCountdown();
					break;
				case 3:
					down3.restartCountdown();
					break;
				default:
					break;
			}
			
			
			if(!t0.isAlive() || !t1.isAlive() || !t2.isAlive() || !t3.isAlive()) {
				break;
			}
			
		}
		
		
		//timer end
		long endTime = System.nanoTime();
		
		
		//stop all threads
		t0.interrupt();
		t1.interrupt();
		t2.interrupt();
		t3.interrupt();
		
		
		System.out.println("You lasted: " + (endTime - startTime) / 1000000000.0 + " seconds.");
		
	}

}
