// 동기화가 처리된 출금 작업 스레드
// 은행 계좌 클래스
class Account07{
	private int balance = 1000;
	
	public int getBalance() {
		return balance;
	}
	
	// 동기화가 처리된 출금 -> 락을 걸어서 하나의 쓰레드에 의해서만 출금 작업이 이루어진다.
	public synchronized void whthdraw(int money) {
		if(balance >= money) {
			try {Thread.sleep(1000);
		}catch(InterruptedException ie) {}
			balance = balance - money;
			
		}
	}	// synchronized 키워드 
}
class Thread07 extends Thread{
	Account07 acc = new Account07();

	@Override
	public void run() {
		while(acc.getBalance() > 0) {
			int money = (int)(Math.random() * 3 + 1) * 100;
			acc.whthdraw(money); //출금
			System.out.println("계좌 잔액: " + acc.getBalance());
		}
	}
	
} // 쓰레드 클래스

public class ThreadTest07 {
	public static void main(String[] args) {
		new Thread07().start();
		Thread07 th = new Thread07();
		th.start();
	}
}
