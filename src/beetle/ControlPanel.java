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
	private long[] defTime; // ���α׷� ���� �� ���� �ð�
	private int[] movePoint; // ���α׷� ���� �� �� �湮 Ƚ��
	private int[][] cellPoint; // ���α׷� ���� �� ��� �� �湮 Ƚ��
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
		
		lb1 = new JLabel("���α׷� ����Ƚ��");
		GridBagConstraints gbc_lb1 = new GridBagConstraints();
		gbc_lb1.gridwidth = 3;
		gbc_lb1.insets = new Insets(0, 0, 5, 5);
		gbc_lb1.gridx = 0;
		gbc_lb1.gridy = 0;
		add(lb1, gbc_lb1);
		
		lb2 = new JLabel("���� ũ��");
		GridBagConstraints gbc_lb2 = new GridBagConstraints();
		gbc_lb2.gridwidth = 2;
		gbc_lb2.insets = new Insets(0, 0, 5, 5);
		gbc_lb2.gridx = 4;
		gbc_lb2.gridy = 0;
		add(lb2, gbc_lb2);
		
		lb3 = new JLabel("�������� ������ġ(x,y)");
		GridBagConstraints gbc_lb3 = new GridBagConstraints();
		gbc_lb3.gridwidth = 3;
		gbc_lb3.insets = new Insets(0, 0, 5, 5);
		gbc_lb3.gridx = 7;
		gbc_lb3.gridy = 0;
		add(lb3, gbc_lb3);
		
		lb4 = new JLabel("������");
		GridBagConstraints gbc_lb4 = new GridBagConstraints();
		gbc_lb4.insets = new Insets(0, 0, 0, 5);
		gbc_lb4.anchor = GridBagConstraints.EAST;
		gbc_lb4.gridx = 0;
		gbc_lb4.gridy = 1;
		add(lb4, gbc_lb4);
		
		lb5 = new JLabel("�ҿ�ð�");
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
		
		lb7 = new JLabel("�̵�Ƚ��");
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
		
		lb9 = new JLabel("ȸ");
		GridBagConstraints gbc_lb9 = new GridBagConstraints();
		gbc_lb9.gridx = 12;
		gbc_lb9.gridy = 1;
		add(lb9, gbc_lb9);
		
		cbm = new JComboBox();
		cbm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbm.getItemCount() == calculator.getCount()) { // �޺��ڽ��� ������ ���� ���α׷� ���� Ƚ���� ���� ���
					int a = cbm.getSelectedIndex(); // �޺��ڽ����� ������ ���� index ��
					String b = Integer.toString(movePoint[a]);
					lb8.setText(b); // �� �̵� Ƚ�� 
					SimpleDateFormat formatter = new SimpleDateFormat ("mm:ss:SSS", Locale.KOREA);
					String c = formatter.format(defTime[a]);
					lb6.setText(c); // �ҿ� �ð�
					
					for(int j =0; j<calculator.getSize()*calculator.getSize(); j++) { // �� Ÿ�ϵ��� �湮 Ƚ��
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
		
		btn_1 = new JButton("����");
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf_1.getText().equals("") | tf_2.getText().equals("") | tf_3.getText().equals("") | tf_4.getText().equals("")) { // 4���� �ؽ�Ʈ �ʵ忡 ���ڸ� �� �־����� Ȯ��
					JOptionPane.showMessageDialog(null, "�Է��� �Ϸ���� �ʾҽ��ϴ�.���ڸ� �� ���� �� �ٽô�������.", "Message", JOptionPane.ERROR_MESSAGE); 
					return;
				}
				
				
				String a = tf_1.getText();
				String b = tf_2.getText();
				String c = tf_3.getText();
				String d = tf_4.getText();
				if(isStringInteger(a) == false || isStringInteger(b) == false || isStringInteger(c) == false || isStringInteger(d) == false) {
					JOptionPane.showMessageDialog(null, "���ڰ� �ƴմϴ�. ���ڸ� �Է��ϼ���.", "Message", JOptionPane.ERROR_MESSAGE); 
					return;
				}
				int a1=Integer.parseInt(a);
				int b1=Integer.parseInt(b);
				int c1=Integer.parseInt(c);
				int d1=Integer.parseInt(d);
				if((a1 < 5) | (b1 < 5)) { // ���α׷� ����Ƚ���� ���� ũ�⸦ 5�̻����� ����
					JOptionPane.showMessageDialog(null, "���α׷� ����Ƚ�� �� ���� ũ�⸦ 5�̻����� �Է��ϼ���.", "Message", JOptionPane.ERROR_MESSAGE); 
					return;
				}
				if((c1 >= b1) | (d1 >= b1)) { // ���������� ��ǥ�� ���� ũ�⺸�� �۰� ����
					JOptionPane.showMessageDialog(null, "���� ũ�⺸�� ���� ��ǥ�� �Է��ϼ���.", "Message", JOptionPane.ERROR_MESSAGE); 
					return;
				}
				
				calculator.setCount(a); // ���α׷� ���� Ƚ��
				calculator.setSize(b); // �� ũ��
				calculator.setBase(c,d); // �������� ���� ����
				
				movePoint = new int[calculator.getCount()]; // ���α׷� ���� Ƚ����ŭ�� �����Ҽ��ִ� ���������� �� �̵�Ƚ���� �迭
				defTime = new long[calculator.getCount()]; // ���α׷� ���� Ƚ����ŭ�� �����Ҽ��ִ� �ҿ� �ð��� �迭
				cellPoint = new int[calculator.getCount()][calculator.getSize()*calculator.getSize()]; // ���α׷� ���� Ƚ����ŭ�� �����Ҽ��ִ� �� ���� �湮 Ƚ���� �迭
				for(int i=0; i<calculator.getCount(); i++) { // �޺��ڽ��� �� ����
					cbm.addItem(i+1);
				}
				ControlPanel.this.myFrame.startBoard(); // BoardPanel ����
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
	
	public void setmovePoint(int a) { // ���������� �� �̵� Ƚ��
		movePoint[k]=a;
	}
	
	public void setdefTime(long a) { // ���α׷� �ҿ� �ð�
		defTime[k]=a;
	}
	
	public void setcellPoint(int[] a) { // �� Ÿ�� �� �̵� Ƚ��
		cellPoint[k]=a;
		k++;
	}

}
