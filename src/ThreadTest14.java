import java.util.ArrayList;

class Table14{
	String[] dishNames = {"dount", "dount", "burger"}; // 음식 재료ㅕ
	final int MAX_FOOD = 6;
	private ArrayList<String> dishes = new ArrayList<>();
	
	// 테이블 음식추가 동기화 처리
	public synchronized void add(String dish) {
		if(dishes.size() >= MAX_FOOD) { // 테이블 추가된 음식 개수가 6가지를 초과하면 음식추가 중단
			return; // 종료 기능
		}
		dishes.add(dish); //컬렉션 음식추가
		System.out.println("추가된 음식 목록: " + dishes.toString());
	}// add()
	
	// 테이블 음식 제거
	public boolean remove(String dishName) {
		synchronized (this) {
			while (dishes.size() == 0) { // size() 메소드는 컬렉션 원소개수를 변환
				String name = Thread.currentThread().getName(); // 현재 실행중인 스레드 이름을 반환
				System.out.println(name + " is waiting."); // 소비자 스레드를 기다리게한다.
				
				try {Thread.sleep(500);
				
				}catch(InterruptedException ie) {}
			}// while
			for (int i = 0; i < dishes.size(); i++) {
				if(dishName.equals(dishes.get(i))){ // 먹을 음식과 일치하면
					dishes.remove(i); // 컬렉션으로 부터 먹을 음식을 제거
					return true; // 소비자가 원하는 음식을 먹으면 ture 반환
				}// if
			}// for
		}// 동기화 처리
		return false; // 소비자가 음식을 못먹으면 false
	}// remove
	
	public int dishNum() {
		return dishNames.length; // 음식 재료 갯수 반환 
	}
}// Table14 class 


// 소비자 스레드 클래스
class Customer14 implements Runnable{
	private Table14 table;
	private String food;
	
	public Customer14() {}
	
	public Customer14(Table14 table, String food) {
		this.table = table;
		this.food = food;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			}catch(InterruptedException ie) {
				
			}
			String name = Thread.currentThread().getName();
		}// while
	} // run
	
	boolean eatFood() {
		return table.remove(food);
	}
}

public class ThreadTest14 {
	public static void main(String[] args) {
		
	}
}




































