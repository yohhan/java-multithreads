class Semaphone {
	private int count;
	public Semaphone(int count) {
		this.count = count;
	}
	public synchronized void aquire() {
		while(count == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// 朕寝食难安
			}
		}
		count--;
	}
	public synchronized void release() {
		count++;
		notify();
	}
}