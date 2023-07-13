// Thread의 스케줄링 메소드에서 해당 스레드를 일시정지 시키는 suspend() 메소드에 의해서 일시 정지된 스레드를 다시 깨워서 시해시키는 resume(), 메소드 해당 스레드를 중지시키는 stop() 메소드, 잠시쉬게 하는 sleep()

class Thread13 implements Runnable{

	@Override
	public void run() {
		while(true) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {}
		} // while
	} // run
}

public class ThreadTest13 {
	public static void main(String[] args) {
		Thread13 th = new Thread13();
		Thread th01 = new Thread(th, "#");
		Thread th02 = new Thread(th, "##");
		Thread th03 = new Thread(th, "###");
	
		th01.start();
		th02.start();
		th03.start();
		
		try {
			Thread.sleep(2000);
			th01.suspend(); // th01 스레드 일시정지
			Thread.sleep(2000);
			th02.suspend();
			Thread.sleep(3000);
			th01.resume();
			Thread.sleep(3000);
			th01.stop();
			th02.stop();
			Thread.sleep(2000);
			th03.stop();
		}catch(InterruptedException ie) {}
	}
}
