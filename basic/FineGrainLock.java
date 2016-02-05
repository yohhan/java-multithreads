public class FineGrainLock {
	MymemberClass x,y;
	object xlock = new Object(), ylock = new Object();
	public void foo() {
		synchronized(xlock) {
			// access x
		}
		synchronized(ylock) {
			// access y
		}

		// not shared resource
	}
	public void bar() {
		synchronized(this) {
			// access x and y
		}
		//not shared  resource
	}
}