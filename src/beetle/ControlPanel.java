package beetle;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class ControlPanel extends JPanel{
	private JTextField tf_1;
	private JTextField tf_2;
	private JTextField tf_3;
	private JTextField tf_4;
	private JLabel lb1;
	private JLabel lb2;
	private JLabel lb3;
	private JLabel lb4;
	private JLabel lb5;
	private JLabel lb6;
	private JLabel lb7;
	private JLabel lb8;
	private JLabel lb9;
	private JComboBox cbm;
	private JButton btn_1;
	
	private MyFrame myFrame= null;
	private Calculator calculator = new Calculator();
	
	private SimpleDateFormat formatter; 
	private long[] defTime; // 프로그램 실행 별 수행 시간
	private int[] movePoint; // 프로그램 실행 별 총 방문 횟수
	private int[][] cellPoint; // 프로그램 실행 별 모든 방 방문 횟수
	private int k=0;
	
	public ControlPanel(MyFrame myFrame) {
		this.myFrame = myFrame;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{50, 30, 30, 30, 30, 30, 30, 40, 30, 60, 30, 30, 30, 0};
		gridBagLayout.rowHeights = new int[]{21, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		tf_1 = new JTextField();
		tf_1.setColumns(10);
		GridBagConstraints gbc_tf_1 = new GridBagConstraints();
		gbc_tf_1.fill = GridBagConstraints.BOTH;
		gbc_tf_1.insets = new Insets(0, 0, 5, 5);
		gbc_tf_1.gridx = 3;
		gbc_tf_1.gridy = 0;
		add(tf_1, gbc_tf_1);
		
		tf_2 = new JTextField();
		tf_2.setColumns(10);
		GridBagConstraints gbc_tf_2 = new GridBagConstraints();
		gbc_tf_2.fill = GridBagConstraints.BOTH;
		gbc_tf_2.insets = new Insets(0, 0, 5, 5);
		gbc_tf_2.gridx = 6;
		gbc_tf_2.gridy = 0;
		add(tf_2, gbc_tf_2);
		
		tf_3 = new JTextField();
		tf_3.setColumns(10);
		GridBagConstraints gbc_tf_3 = new GridBagConstraints();
		gbc_tf_3.insets = new Insets(0, 0, 5, 5);
		gbc_tf_3.fill = GridBagConstraints.BOTH;
		gbc_tf_3.gridx = 10;
		gbc_tf_3.gridy = 0;
		add(tf_3, gbc_tf_3);
		
		tf_4 = new JTextField();
		tf_4.setColumns(10);
		GridBagConstraints gbc_tf_4 = new GridBagConstraints();
		gbc_tf_4.insets = new Insets(0, 0, 5, 5);
		gbc_tf_4.fill = GridBagConstraints.BOTH;
		gbc_tf_4.gridx = 11;
		gbc_tf_4.gridy = 0;
		add(tf_4, gbc_tf_4);
		
		lb1 = new JLabel("프로그램 실행횟수");
		GridBagConstraints gbc_lb1 = new GridBagConstraints();
		gbc_lb1.gridwidth = 3;
		gbc_lb1.insets = new Insets(0, 0, 5, 5);
		gbc_lb1.gridx = 0;
		gbc_lb1.gridy = 0;
		add(lb1, gbc_lb1);
		
		lb2 = new JLabel("방의 크기");
		GridBagConstraints gbc_lb2 = new GridBagConstraints();
		gbc_lb2.gridwidth = 2;
		gbc_lb2.insets = new Insets(0, 0, 5, 5);
		gbc_lb2.gridx = 4;
		gbc_lb2.gridy = 0;
		add(lb2, gbc_lb2);
		
		lb3 = new JLabel("딱정벌레 시작위치(x,y)");
		GridBagConstraints gbc_lb3 = new GridBagConstraints();
		gbc_lb3.gridwidth = 3;
		gbc_lb3.insets = new Insets(0, 0, 5, 5);
		gbc_lb3.gridx = 7;
		gbc_lb3.gridy = 0;
		add(lb3, gbc_lb3);
		
		lb4 = new JLabel("페이지");
		GridBagConstraints gbc_lb4 = new GridBagConstraints();
		gbc_lb4.insets = new Insets(0, 0, 0, 5);
		gbc_lb4.anchor = GridBagConstraints.EAST;
		gbc_lb4.gridx = 0;
		gbc_lb4.gridy = 1;
		add(lb4, gbc_lb4);
		
		lb5 = new JLabel("소요시간");
		GridBagConstraints gbc_lb5 = new GridBagConstraints();
		gbc_lb5.gridwidth = 2;
		gbc_lb5.insets = new Insets(0, 0, 0, 5);
		gbc_lb5.gridx = 4;
		gbc_lb5.gridy = 1;
		add(lb5, gbc_lb5);
		
		lb6 = new JLabel("");
		GridBagConstraints gbc_lb6 = new GridBagConstraints();
		gbc_lb6.gridwidth = 3;
		gbc_lb6.insets = new Insets(0, 0, 0, 5);
		gbc_lb6.gridx = 6;
		gbc_lb6.gridy = 1;
		add(lb6, gbc_lb6);
		
		lb7 = new JLabel("이동횟수");
		GridBagConstraints gbc_lb7 = new GridBagConstraints();
		gbc_lb7.insets = new Insets(0, 0, 0, 5);
		gbc_lb7.anchor = GridBagConstraints.EAST;
		gbc_lb7.gridx = 9;
		gbc_lb7.gridy = 1;
		add(lb7, gbc_lb7);
		
		lb8 = new JLabel("");
		GridBagConstraints gbc_lb8 = new GridBagConstraints();
		gbc_lb8.gridwidth = 2;
		gbc_lb8.insets = new Insets(0, 0, 0, 5);
		gbc_lb8.gridx = 10;
		gbc_lb8.gridy = 1;
		add(lb8, gbc_lb8);
		
		lb9 = new JLabel("회");
		GridBagConstraints gbc_lb9 = new GridBagConstraints();
		gbc_lb9.gridx = 12;
		gbc_lb9.gridy = 1;
		add(lb9, gbc_lb9);
		
		cbm = new JComboBox();
		cbm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbm.getItemCount() == calculator.getCount()) { // 콤보박스에 인자의 수가 프로그램 실행 횟수와 같을 경우
					int a = cbm.getSelectedIndex(); // 콤보박스에서 선택한 값의 index 값
					String b = Integer.toString(movePoint[a]);
					lb8.setText(b); // 총 이동 횟수 
					SimpleDateFormat formatter = new SimpleDateFormat ("mm:ss:SSS", Locale.KOREA);
					String c = formatter.format(defTime[a]);
					lb6.setText(c); // 소요 시간
					
					for(int j =0; j<calculator.getSize()*calculator.getSize(); j++) { // 각 타일들의 방문 횟수
						if(j%calculator.getSize()==0)
							System.out.println();
						System.out.print(cellPoint[a][j]+" ");
					}
					System.out.println();
					System.out.println();
				}
			}
		});
		GridBagConstraints gbc_cbm = new GridBagConstraints();
		gbc_cbm.gridwidth = 3;
		gbc_cbm.insets = new Insets(0, 0, 0, 5);
		gbc_cbm.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbm.gridx = 1;
		gbc_cbm.gridy = 1;
		add(cbm, gbc_cbm);
		
		btn_1 = new JButton("시작");
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf_1.getText().equals("") | tf_2.getText().equals("") | tf_3.getText().equals("") | tf_4.getText().equals("")) { // 4개의 텍스트 필드에 숫자를 다 넣었는지 확인
					JOptionPane.showMessageDialog(null, "입력이 완료되지 않았습니다.숫자를 다 넣은 후 다시누르세요.", "Message", JOptionPane.ERROR_MESSAGE); 
					return;
				}
				
				
				String a = tf_1.getText();
				String b = tf_2.getText();
				String c = tf_3.getText();
				String d = tf_4.getText();
				if(isStringInteger(a) == false || isStringInteger(b) == false || isStringInteger(c) == false || isStringInteger(d) == false) {
					JOptionPane.showMessageDialog(null, "숫자가 아닙니다. 숫자를 입력하세요.", "Message", JOptionPane.ERROR_MESSAGE); 
					return;
				}
				int a1=Integer.parseInt(a);
				int b1=Integer.parseInt(b);
				int c1=Integer.parseInt(c);
				int d1=Integer.parseInt(d);
				if((a1 < 5) | (b1 < 5)) { // 프로그램 실행횟수와 방의 크기를 5이상으로 설정
					JOptionPane.showMessageDialog(null, "프로그램 실행횟수 및 방의 크기를 5이상으로 입력하세요.", "Message", JOptionPane.ERROR_MESSAGE); 
					return;
				}
				if((c1 >= b1) | (d1 >= b1)) { // 딱정벌레의 좌표를 방의 크기보다 작게 설정
					JOptionPane.showMessageDialog(null, "방의 크기보다 작은 좌표를 입력하세요.", "Message", JOptionPane.ERROR_MESSAGE); 
					return;
				}
				
				calculator.setCount(a); // 프로그램 실행 횟수
				calculator.setSize(b); // 방 크기
				calculator.setBase(c,d); // 딱정벌레 시작 지점
				
				movePoint = new int[calculator.getCount()]; // 프로그램 실행 횟수만큼을 저장할수있는 딱정벌레의 총 이동횟수의 배열
				defTime = new long[calculator.getCount()]; // 프로그램 실행 횟수만큼을 저장할수있는 소요 시간의 배열
				cellPoint = new int[calculator.getCount()][calculator.getSize()*calculator.getSize()]; // 프로그램 실행 횟수만큼을 저장할수있는 각 방의 방문 횟수의 배열
				for(int i=0; i<calculator.getCount(); i++) { // 콤보박스에 값 삽입
					cbm.addItem(i+1);
				}
				ControlPanel.this.myFrame.startBoard(); // BoardPanel 시작
			}

			public boolean isStringInteger(String a) {
				try {
					Integer.parseInt(a);
					return true;
				} catch(Exception e) {
					return false;
				}
			}
		});
		GridBagConstraints gbc_btn_1 = new GridBagConstraints();
		gbc_btn_1.insets = new Insets(0, 0, 5, 0);
		gbc_btn_1.gridx = 12;
		gbc_btn_1.gridy = 0;
		add(btn_1, gbc_btn_1);
	}
	
	public Calculator getCalculator() {
		return calculator;
	}	
	
	public void setmovePoint(int a) { // 딱정벌레의 총 이동 횟수
		movePoint[k]=a;
	}
	
	public void setdefTime(long a) { // 프로그램 소요 시간
		defTime[k]=a;
	}
	
	public void setcellPoint(int[] a) { // 각 타일 별 이동 횟수
		cellPoint[k]=a;
		k++;
	}

}
