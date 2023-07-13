// 멀티 스레드 입/출금 작업에서는 한번에 하나의 스레드에 의해서만 입 출금 작업이 이루어 지도록 동기화 즉 임계영역을 지정해야한다. 

class Atm{
	private int money;
	
	public Atm() {}
	
	public Atm(int money) {
		this.money = money;
	}
	
	synchronized void deposit(int amount,String name) {
		money += amount;
		System.out.println(name + " 입금금액: " + amount);
	}
	
	synchronized void withdraw(int amount, String name) {
		if((money - amount) > 0) {
			money -= amount;
			System.out.println(name + " 출금금액: " + amount);
		}else {
			System.out.println(name + "잔액부족 으로 출금 X");
		}
	}
	                                                             
	public void getMoney() {
		System.out.println("계좌잔액: " + money);
	}
}

class AtmUser extends Thread{
	boolean flag = false; //입출금 분기 해주는 변수
	Atm obj;
	
	public AtmUser() {}
	
	public AtmUser(Atm obj, String name) {
		super(name); // 스레드 이름을 구함
		this.obj = obj;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 5; i++) {
			try { sleep(500);} catch(InterruptedException ie) {}
			
			if(flag == true) { // ==true 는 생략 가능
				obj.deposit((int)(Math.random() * 10 + 2) * 100, getName());
				
				obj.getMoney();
				
			}else {
				obj.withdraw((int)(Math.random()* 10 + 2) * 100, getName());
			}
			flag = !flag;
		}// for
	} // 스레드 문장 구현
} // 스레드 클래스

public class ThreadTest08 {
	public static void main(String[] args) {
		Atm obj = new Atm(1000); //계좌 개설시 1000원 입금
		AtmUser user01 = new AtmUser(obj, "홍길동");
		AtmUser user02 = new AtmUser(obj, "이순신");
		AtmUser user03 = new AtmUser(obj, "강감찬");
		
		user01.start();
		user02.start();
		user03.start();
	
		
	}
}
