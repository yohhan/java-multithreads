public class ThreadLocalDemo {
	private static volatile ThreadLocal<String> userID = 
		new ThreadLocal<String>();
		
		public static void main(String[] args) {
			Runnable r = new Runnable() {
				
				@Override
				public void run() {
					String name = Thread.currentThread().getName();
					if (name.equals("A")) {
						userID.set("foxtrot");
					}
					else {
						userID.set("charlie");
					}
					System.out.println(name + " " + userID.get());
				}
			};	
			
			Thread t1 = new Thread(r);
			t1.setName("A");
			Thread t2 = new Thread(r);
			t2.setName("B");
			t1.start();
			t2.start();
		}
}