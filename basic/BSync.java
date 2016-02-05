/**
 * methods of Object :
 * wait(), notify(), notifyAll();
 * wait until all threads complete their job
 * 
 */
public class BSync {
	int totalThreads;
	int currentThreads;
	public BSync(int totalThreads) {
		this.totalThreads = totalThreads;
		currentThreads = 0;
	}
	public synchronized void waitForAll() {
		currentThreads++;
		if (currentThreads < totalThreads) {
			try {
				wait();
			} catch(Exception e) {}
		}
		else {
			currentThreads = 0;
			notifyAll();
		}
	}
}