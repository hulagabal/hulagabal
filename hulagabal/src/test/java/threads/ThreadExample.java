package threads;

public class ThreadExample {

	public static void main(String[] args) {
		/*OneThread oneThread = new OneThread();
		oneThread.start();
		*/
		
		
		TwoThread twoThread = new TwoThread();
		Thread thread = new Thread(twoThread);
		thread.start();

	}
}
