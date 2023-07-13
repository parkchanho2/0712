import javax.swing.JOptionPane;

// 해당 스레드의 인터럽트를 호출해서 인터럽트 된 상태를 false에서 true로 변경해서 카운터 실행을 중간에 중단하는 예제

class Thread11 extends Thread{

	@Override
	public void run() {
		int i = 10;
		
		while(i != 0 && !isInterrupted()) {
			System.out.println(i--);
			for(long x = 0; x < 2500000000L; x++);
		}
		System.out.println("카운터 종료");
	}
	
}

public class ThreadTest11 {
	public static void main(String[] args) {
		Thread11 th = new Thread11();
		th.start();
		
		String name = JOptionPane.showInputDialog("이름입력");
		System.out.println("입력하신 이름: " + name);
		
		th.interrupt(); // 스레드 인터럽트 된 상태가 false 에서 true 로 변경
		System.out.println("isInterrupted() 된 상태: " + th.isInterrupted());
	}
}
