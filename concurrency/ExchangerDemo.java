import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
	final static Exchanger<DataBuffer> exchanger = 
		new Exchanger<DataBuffer>();
	final static DataBuffer initialEmptyBuffer = new DataBuffer();
	final static DataBuffer initialFullBuffer = new DataBuffer("I");

	public static void main(String[] args) {
		class FillingLoop implements Runnablle {
			int count = 0;

			@Override
			public void run() {
				DataBuffer currentBuffer = initialEmptyBuffer;
				
			}
		}
	}
}