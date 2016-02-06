public class TimerDemo {
	public static void main(String[] args) {
		TimerTask tmask = new TimerTask(){

			@Override
			public void run() {
				System.out.println("clock,clock");
				System.exit(0);
			}
		};
		Timer timer = new Timer();
		timer.schedule(task,2000); // 2-second delay
		// interval 1-second
		// timer.schedule(task,0,1000)  
	}
}