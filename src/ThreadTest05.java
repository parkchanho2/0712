import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// AWT GUI + 멀티스레드가 결합된 프로그램으로 awt 프레임 윈도우에 스레드에 의해서 지나가는 글자를 출력

class Thread05 extends Frame implements Runnable{
	int x = 1; // 프레임 윈도우 x 좌표를 저장할 변수
	
	public Thread05() {
		setBackground(new Color(0,0,0)); // 프레임 배경색을 R:red, G:green, B:blue 색상코드로 지정, 배경색을 검정으로 지정함
		setSize(680,360); //프레임 폭과 높이
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0); // 프레임 윈도우 닫기 
			}// 현재 프레임 윈도우 닫기 했을 때 호출
		});// 익명 클래스 문법으로 프레임 윈도우 닫기 이벤트 처리
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(100); // 스레드를 일정시간 대기 상태로 둔다. 즉 잠시 쉰다.
				
			}catch(InterruptedException ie) {}
			repaint(); //다시 그리고자 그리기 메소드 호출
			x += 5; //스레드 x좌표가 5씩 증가
		}
	} // 스레드 문장 구현

	@Override
	public void paint(Graphics g) {
		Dimension d; //Dimension은 폭 과 높이를 가지는 클래스
		d = getSize(); // 프레임 윈도우 창 크기를 구현
		g.setColor(Color.ORANGE); 
		Font f = new Font("궁서체", Font.BOLD, 20);
		g.setFont(f);
		g.drawString("내일부터 장마가 시작됩니다. 시간당 00mm가 내리니 주의하시길 바랍니다.", x, d.height/2);
		
		
		// 글자크기 키우기 글꼴 궁서체 진하게 프레임 윈도우 폭을 벗어나면 다시 돌아오게 하기
	}// 무엇을 그리고자 호출되는 메소드 
}


public class ThreadTest05 {
	public static void main(String[] args) {
		Thread05 th = new Thread05();
		
		Thread th1 = new Thread(th);
		th1.start(); // 멀티스레드 시작
	}
}
