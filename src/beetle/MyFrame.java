package beetle;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
	
	private ControlPanel controlPanel;
	private BoardPanel boardPanel;

	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		controlPanel = new ControlPanel(this);
		getContentPane().add(controlPanel, BorderLayout.NORTH);
		
		setBounds(20, 20, 817, 600);
		show();
	}
	
	public ControlPanel getControlPanel() {
		return controlPanel;
	}	
	
	public BoardPanel getBoardPanel() {
		return boardPanel;
	}
	
	public void startBoard() {
		if(boardPanel != null) {
			getContentPane().remove(boardPanel);
			boardPanel = null;
		}
		boardPanel = new BoardPanel(this);
		getContentPane().add(boardPanel, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame();
	}

}