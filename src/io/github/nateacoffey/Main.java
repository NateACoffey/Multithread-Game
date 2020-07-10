package io.github.nateacoffey;


public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		//Create our new countdown threads
		Thread t0 = new Thread(new Countdown());
		Thread t1 = new Thread(new Countdown());
		Thread t2 = new Thread(new Countdown());
		Thread t3 = new Thread(new Countdown());
		
		
		//start the threads one after the other
		t0.start();
		Thread.sleep(10);
		t1.start();
		Thread.sleep(10);
		t2.start();
		Thread.sleep(10);
		t3.start();
		
		
		//start console reader to print and read console simultaneously
		Thread read = new Thread(new ConsoleReader());
		read.start();
		
		//loop until one thread stops
		while(read.isAlive()) {
			
			if(!t0.isAlive() || !t1.isAlive() || !t2.isAlive() || !t3.isAlive()) {
				break;
			}
			
		}
		
		
		//stop all threads
		t0.interrupt();
		t1.interrupt();
		t2.interrupt();
		t3.interrupt();
		
		
	}

}
