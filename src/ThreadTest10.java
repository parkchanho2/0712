import javax.swing.JOptionPane;

class Thread10 extends Thread{

	@Override
	public void run() {
		String cityName = JOptionPane.showInputDialog("도시 이름을 입력하세요 !");
		System.out.println("도시이름: " + cityName);
		
		for(int i = 10; i >= 1; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException ie) {}
		}
	}
}

public class ThreadTest10 {
	public static void main(String[] args) {
		
		Thread10 th1 = new Thread10();
		Thread10 th2 = new Thread10();
		
		th1.start();
		th2.start();
		
		
		// 문제 10 부터 1 까지 1초간격으로 카운터 하는 멀티스레드 프로그램을 만들자 . 10부터 1까지 카운터 하는 중간에 도시이름이 출력되는 동시 작업이 이루어지게 개발
	}
}
