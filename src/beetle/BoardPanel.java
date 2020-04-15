package beetle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BoardPanel extends JPanel implements ActionListener{
	
	private MyFrame myFrame;
	private Timer timer; // 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
	private Calendar startTime; // 占쏙옙占쏙옙
	private Calendar endTime; // 占쏙옙占쏙옙
	private boolean isEnd = false; // 占쏙옙占쏙옙
	private int beetleX; // 占쏙옙占쏙옙 x占쏙옙표(占쌓뤄옙占싫쏙옙占쏙옙)
	private int beetleY; // 占쏙옙占쏙옙 y占쏙옙표(占쌓뤄옙占싫쏙옙占쏙옙)
	private int x; // 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 x占쏙옙표(占썼열占쏙옙)
	private int y; // 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 y占쏙옙표(占썼열占쏙옙)
	private int maxX; // 占쏙옙占쏙옙 크占썩를 홀占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占싹깍옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙 크占썩를 占쏙옙占쏙옙
	private int maxY;
	private int[] beetlexy=new int[2]; // 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 8占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙
	private int size; // 占쏙옙크占쏙옙
	private boolean [][] cell; // 占썸문占쏙옙 占싯아븝옙 占쏙옙 占쌍댐옙 占쏙옙
	private int[] cellPoint; // 占쏙옙 占썸별 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占썸문 횟占쏙옙
	private long defTime; // 占쏙옙占쌜시곤옙
	private int movePoint; // 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占썸문 횟占쏙옙 占쏙옙占쏙옙
	private int count; // 占쌥븝옙횟占쏙옙
	//占쌕몌옙 타占싱몌옙
	
	public BoardPanel(MyFrame myFrame) {
		this.myFrame = myFrame;
		count = myFrame.getControlPanel().getCalculator().count;
		size = myFrame.getControlPanel().getCalculator().getSize();
		maxX = 800-800%size;
		maxY = 500-500%size;
		init();
	}
	
	private void init() {
		startTime = Calendar.getInstance();
		timer = new Timer(0, this);
		timer.start();
		beetleX = myFrame.getControlPanel().getCalculator().getBasex()*(800/size)+1;
		beetleY = myFrame.getControlPanel().getCalculator().getBasey()*(500/size)+1;
		x=myFrame.getControlPanel().getCalculator().getBasex();
		y=myFrame.getControlPanel().getCalculator().getBasey();
		movePoint=0;
		defTime=0;
		isEnd = false;
		cell = new boolean[size][size];
		cellPoint = new int[size*size];
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				cell[i][j]=false;
			}
		}
		for(int i=0; i<size*size; i++) {
			cellPoint[i]=0;
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		drawBackground(g);
		drawMove(g);
		visitMove(g);
	}
	
	private void drawBackground(Graphics g) { // 占쏙옙轢놂옙占�
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, maxX, maxY);
		for(int i=0; i<size+1; i++) {
			g.setColor(Color.RED);
			g.drawLine(0, maxY-(maxY-i*(maxY/size)), maxX, maxY-(maxY-i*(maxY/size)));
			g.drawLine(maxX-(maxX-i*(maxX/size)), 0, maxX-(maxX-i*(maxX/size)), maxY);
		}
	}
	
	private void drawMove(Graphics g) { // 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
		g.setColor(Color.BLUE);
		g.fillRect(beetleX, beetleY, maxX/size-1, maxY/size-1);
	}
	
	private void visitMove(Graphics g) { // 占썸문占쏙옙 타占쏙옙 확占쏙옙
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(cell[i][j]==true) {
					if(i !=x || j != y){
						g.setColor(Color.PINK);
						g.fillRect(i*(maxX/size), j*(maxY/size), maxX/size-1, maxY/size-1);
					}
				}
			}
		}
		for(int i=0; i<size+1; i++) {
			g.setColor(Color.RED);
			g.drawLine(0, maxY-(maxY-i*(maxY/size)), maxX, maxY-(maxY-i*(maxY/size)));
			g.drawLine(maxX-(maxX-i*(maxX/size)), 0, maxX-(maxX-i*(maxX/size)), maxY);
		}
	}
	
	private void move() { // 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占싯삼옙 占쏙옙 8占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙
		beetlexy= myFrame.getControlPanel().getCalculator().move();
		int a= x+beetlexy[0];
		int b= y+beetlexy[1];
		if((a > size-1) || (a < 0) || (b > size-1) || (b < 0)){
			return;
		}
		else { // 占쏙옙占쏙옙占쏙옙 占썸에占쏙옙 占쏙옙占쏙옙占싱댐옙 占쏙옙占�
			x=a;
			y=b;
			beetleX=beetleX + (maxX/size)*beetlexy[0];
			beetleY=beetleY + (maxY/size)*beetlexy[1];
			cell[x][y]=true;
			movePoint++;
			cellPoint[x+y*size]++;
		}
		
		int c=0;
		for(int i = 0; i<size; i++) {
			for(int j = 0 ; j<size; j++) {
				if(cell[i][j]==true)
					c++;
			}
		}
		if(c==size*size) // 占쏙옙占� 타占쏙옙占쏙옙 占썸문占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙
			isEnd=true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!isEnd) // 占쏙옙占� 타占쏙옙占쏙옙 占쏙옙 占썸문占쌀띰옙 占쏙옙占쏙옙
			move();
		else {
			timer.stop();
			endTime = Calendar.getInstance();
			defTime = endTime.getTimeInMillis() - startTime.getTimeInMillis();
			myFrame.getControlPanel().setmovePoint(movePoint);
			myFrame.getControlPanel().setdefTime(defTime);
			myFrame.getControlPanel().setcellPoint(cellPoint);

			if(count-1> 0) { // 占쏙옙占쏙옙 횟占쏙옙占쏙옙큼 占쌥븝옙
				count--;
				init();
			}
		}
		repaint();
	}
}
