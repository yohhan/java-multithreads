
public class ThreadDemo {

	public static void main(String[] args) {
		boolean isDaemon = args.length != 0;
		Runnable r = new Runnable() {

			@Override
			public void run() {
				Thread t1 = Thread.currentThread();
				while (true)
					System.out.printf("%s is %salive and in %s state%n", t1.getName(), t1.isAlive() ? "" : " not ",
							t1.getState());

			}
		};
		Thread thd1 = new Thread(r, "t1");
		if (isDaemon)
			thd1.setDaemon(true);
		System.out.printf("%s is %salive and in %s state%n", thd1.getName(), thd1.isAlive() ? "" : " not ",
				thd1.getState());
		Thread thd2 = new Thread(r);
		thd2.setName("t2");
		if (isDaemon)
			thd2.setDaemon(true);
		System.out.printf("%s is %salive and in %s state%n", thd2.getName(), thd2.isAlive() ? "" : " not ",
				thd2.getState());
		thd1.start();
		thd2.start();
	}
}
