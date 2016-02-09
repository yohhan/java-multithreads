import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {
	final static int NTHREADS = 3;

	public static void main(String[] args) {
		final CountDownLatch startSignal = new CountDownLatch(1); // prevent worker threads
		final CountDownLatch doneSignal = new CountDownLatch(NTHREADS); // cause main thread to wait
		Runnable r = new Runnable() {

			@Override
			public void run() {
				try {
					report("entered run()");
					startSignal.await(); // wait until told to ... 
					report("doing work"); // ... main thread proceed when reach 0
					Thread.sleep((int) (Math.random() * 1000));
					doneSignal.countDown(); // reduce count on which
					// main thread is ...
				} // waiting
				catch (InterruptedException ie) {
					System.err.println(ie);
				}
			}

			void report(String s) {
				System.out.println(System.currentTimeMillis() + ": " + Thread.currentThread() + ": " + s);
			}
		};
		ExecutorService executor = Executors.newFixedThreadPool(NTHREADS);
		for (int i = 0; i < NTHREADS; i++)
			executor.execute(r);
		try {
			System.out.println("main thread doing something");
			Thread.sleep(1000); // sleep for 1 second
			startSignal.countDown(); // let all worker threads proceed
			System.out.println("main thread doing something else");
			doneSignal.await(); // wait for all threads to finish
			executor.shutdownNow();
		} catch (InterruptedException ie) {
			System.err.println(ie);
		}
	}
}