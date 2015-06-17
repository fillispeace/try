import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class GradeFrame extends JFrame implements ActionListener {
	private Color colors;
	ArrayList<Grade> list = new ArrayList<Grade>();
	ArrayList<HwAt> list2 = new ArrayList<HwAt>();
	JTextArea area = new JTextArea();
	JTextField Tf1 = new JTextField("");
	JButton btn1 = new JButton("1");
	JButton btn2 = new JButton("2");
	JButton btn3 = new JButton("3");
	JButton btn4 = new JButton("4");
	JButton btn5 = new JButton("5");
	JButton btn6 = new JButton("6");
	JFrame Frame2 = new JFrame();
	JPanel Frame1 = new JPanel();
	MyDialog dialog;
	MyDialog1 dialog1;
	MyDialog2 dialog2;
	int[] sort = new int [20];
	public GradeFrame() {
		dialog = new MyDialog(this, "Add");
		dialog1 = new MyDialog1(this, "Set");
		dialog2 = new MyDialog2(this, "Erase");
		setTitle("grade");
		// MyActionListener listener = new MyActionListener();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new GridLayout(3, 1));

		JMenuBar mb = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		JMenuItem menuItemOpengrade = new JMenuItem("Opengrade");
		JMenuItem menuItemSavegrade = new JMenuItem("Savegrade");
		JMenuItem menuItemOpenHwAt = new JMenuItem("OpenHwAt");
		JMenuItem menuItemSaveHwAt = new JMenuItem("SaveHwAt");
		JMenuItem menuItemExit = new JMenuItem("Exit");
		menuFile.add(menuItemOpengrade);
		menuFile.add(menuItemSavegrade);
		menuFile.add(menuItemOpenHwAt);
		menuFile.add(menuItemSaveHwAt);
		menuFile.add(menuItemExit);
		mb.add(menuFile);
		setJMenuBar(mb);
		menuItemOpengrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = null;
				JFileChooser fc = new JFileChooser();
				int answer = fc.showOpenDialog(null);
				if (answer == JFileChooser.APPROVE_OPTION) {
					f = fc.getSelectedFile();

				}
				try {
					// throws IOException{
					FileInputStream fin = null;
					ObjectInputStream ois = null;

					try {
						fin = new FileInputStream(f);
						ois = new ObjectInputStream(fin);

						list = (ArrayList) ois.readObject();
						list = (ArrayList) ois.readObject();

						area.append("\n" + "로드되었습니다.");
					} catch (Exception ex) {
					} finally {
						try {
							ois.close();
							fin.close();
						} catch (IOException ioe) {
						}
					} // finally

				} catch (Exception g) {
					System.out.println(g);
					// }
				}
			}

		}

		);
		menuItemSavegrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = null;
				JFileChooser fc = new JFileChooser();
				int answer = fc.showOpenDialog(null);
				if (answer == JFileChooser.APPROVE_OPTION) {
					f = fc.getSelectedFile();

				}
				try {
					FileOutputStream fout = null;
					ObjectOutputStream oos = null;

					try {
						fout = new FileOutputStream(f);
						oos = new ObjectOutputStream(fout);

						oos.writeObject(list);//
						oos.reset();
						oos.writeObject(list);
						oos.reset();

						area.append("\n" + "저장되었습니다.");

					} catch (Exception ex) {
					} finally {
						try {
							oos.close();
							fout.close();
						} catch (IOException ioe) {
						}
					} // finally
				} catch (Exception g) {
					System.out.println(g);
					// }
				}
			}
		});
		menuItemOpenHwAt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = null;
				JFileChooser fc = new JFileChooser();
				int answer = fc.showOpenDialog(null);
				if (answer == JFileChooser.APPROVE_OPTION) {
					f = fc.getSelectedFile();

				}
				try {
					// throws IOException{
					FileInputStream fin = null;
					ObjectInputStream ois = null;

					try {
						fin = new FileInputStream(f);
						ois = new ObjectInputStream(fin);

						list2 = (ArrayList) ois.readObject();
						list2 = (ArrayList) ois.readObject();

						area.append("\n" + "로드되었습니다.");
					} catch (Exception ex) {
					} finally {
						try {
							ois.close();
							fin.close();
						} catch (IOException ioe) {
						}
					} // finally

				} catch (Exception g) {
					System.out.println(g);
					// }
				}
			}

		}

		);
		menuItemSaveHwAt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = null;
				JFileChooser fc = new JFileChooser();
				int answer = fc.showOpenDialog(null);
				if (answer == JFileChooser.APPROVE_OPTION) {
					f = fc.getSelectedFile();

				}
				try {
					FileOutputStream fout = null;
					ObjectOutputStream oos = null;

					try {
						fout = new FileOutputStream(f);
						oos = new ObjectOutputStream(fout);

						oos.writeObject(list2);//
						oos.reset();
						oos.writeObject(list2);
						oos.reset();

						area.append("\n" + "저장되었습니다.");

					} catch (Exception ex) {
					} finally {
						try {
							oos.close();
							fout.close();
						} catch (IOException ioe) {
						}
					} // finally
				} catch (Exception g) {
					System.out.println(g);
					// }
				}
			}
		});
		menuItemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}

		});

		// setLayout(new BorderLayout());

		add(Tf1);
		add(Frame1);
		add(area);
		area.append("\n" + "어떤 작업을 하시겠습니까?" + "\n"
				+ "1.학생추가 2.학생정보 변경 3.학생삭제 4.전체학생목록출력 5.TOP20 6.과제&출석표");
		Frame1.setLayout(new GridLayout(2, 3));

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		Frame1.add(btn1);
		Frame1.add(btn2);
		Frame1.add(btn3);
		Frame1.add(btn4);
		Frame1.add(btn5);
		Frame1.add(btn6);

		btn1.setHorizontalAlignment(SwingConstants.CENTER);
		btn2.setHorizontalAlignment(SwingConstants.CENTER);
		btn3.setHorizontalAlignment(SwingConstants.CENTER);
		btn4.setHorizontalAlignment(SwingConstants.CENTER);
		btn5.setHorizontalAlignment(SwingConstants.CENTER);
		btn6.setHorizontalAlignment(SwingConstants.CENTER);
		colors = Color.CYAN;
		setBackground(colors);
		setSize(1000, 1000);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String a = e.getActionCommand();
		//for(int k=0; k<20; k++){
		//sort[k] = k;}
		if (a == "1") {
			dialog.setVisible(true);
			area.setText("\n"
					+ "추가되었습니다 ");
			area.append("\n" + "어떤 작업을 하시겠습니까?" + "\n"
					+ "1.학생추가 2.학생정보 변경 3.학생삭제 4.전체학생목록출력 5.TOP20 6.과제&출석표");
		} else if (a == "2") {
			dialog1.setVisible(true);
			area.setText("\n"
					+ "수정되었습니다");
			area.append("\n" + "어떤 작업을 하시겠습니까?" + "\n"
					+ "1.학생추가 2.학생정보 변경 3.학생삭제 4.전체학생목록출력 5.TOP20 6.과제&출석표");
		} else if (a == "3") {
			dialog2.setVisible(true);
			area.setText("\n"
					+ "삭제되었습니다");
			area.append("\n" + "어떤 작업을 하시겠습니까?" + "\n"
					+ "1.학생추가 2.학생정보 변경 3.학생삭제 4.전체학생목록출력 5.TOP20 6.과제&출석표");
		} else if (a == "4") {
			area.setText("\n"
					+ "   이름      학번              전공                     중간 기말 출석 과제 총점 성적 ");
			for (int i = 0; i < list.size(); i++) {
				area.append("\n" + "[" + (i + 1) + "]" + list.get(i).getName()
						+ "  " + list.get(i).getStnumber() + "  "
						+ list.get(i).getMajor() + "  "
						+ list.get(i).getMidterm() + "  "
						+ list.get(i).getFinalexam() + "  "
						+ list.get(i).getAttendence() + "  "
						+ list.get(i).getHomework() + " "
						+ list.get(i).getScore() + " " + list.get(i).getGrade());
			}
			area.append("\n" + "어떤 작업을 하시겠습니까?" + "\n"
					+ "1.학생추가 2.학생정보 변경 3.학생삭제 4.전체학생목록출력 5.TOP20 6.과제&출석표");
		} else if (a == "5") {
			area.setText("\n"
					+ "   이름      학번              전공                     중간 기말 출석 과제 총점 성적 ");
			for (int s = 0; s<20; s++){
				sort[s]=s;
			}
			for( int j = 0; j<list.size()-1; j++){
			for (int i = 0; i<list.size()-1; i++) {
				if(list.get(sort[i]).getScore()<list.get(sort[i+1]).getScore()){
						int temp = sort[i];
						sort[i] = sort[i+1];
						sort[i+1] = temp;
				}
			}
			}
			
			for (int h = 0; h<list.size(); h++){
				area.append("\n"+ "[" + (sort[h] + 1) + "]" + list.get(sort[h]).getName()
						+ "  " + list.get(sort[h]).getStnumber() + "  "
						+ list.get(sort[h]).getMajor() + "  "
						+ list.get(sort[h]).getMidterm() + "  "
						+ list.get(sort[h]).getFinalexam() + "  "
						+ list.get(sort[h]).getAttendence() + "  "
						+ list.get(sort[h]).getHomework() + " "
						+ list.get(sort[h]).getScore() + " " + list.get(sort[h]).getGrade());
			}
			area.append("\n" + "어떤 작업을 하시겠습니까?" + "\n"
					+ "1.학생추가 2.학생정보 변경 3.학생삭제 4.전체학생목록출력 5.TOP20 6.과제&출석표");
		}else if (a == "6"){
			area.setText("\n"
					+ "   이름      과제1  과제2   과제3  리포트   결석   지각");
			for (int i = 0; i < list2.size(); i++) {
				area.append("\n" + "[" + (i + 1) + "]" + list2.get(i).getName2()
						+ "  " + list2.get(i).gethw1() + "  "
						+ list2.get(i).gethw2() + "  "
						+ list2.get(i).gethw3() + "  "
						+ list2.get(i).getreport() + "  "
						+ list2.get(i).getabsence() + "  "
						+ list2.get(i).getlate());
			}
			area.append("\n" + "어떤 작업을 하시겠습니까?" + "\n"
					+ "1.학생추가 2.학생정보 변경 3.학생삭제 4.전체학생목록출력 5.TOP20 6.과제&출석표");
		}

	}
	class MyDialog extends JDialog {
		
		JTextField dtf1 = new JTextField();
		JTextField dtf2 = new JTextField();
		JTextField dtf3 = new JTextField();
		JTextField dtf4 = new JTextField();
		JTextField dtf5 = new JTextField();
		JTextField dtf6 = new JTextField();
		JTextField dtf7 = new JTextField();
		JLabel dlb1 = new JLabel("이름");
		JLabel dlb2 = new JLabel("학번");
		JLabel dlb3 = new JLabel("전공");
		JLabel dlb4 = new JLabel("중간");
		JLabel dlb5 = new JLabel("기말");
		JLabel dlb6 = new JLabel("과제");
		JLabel dlb7 = new JLabel("출석");
		JButton okButton = new JButton("OK");

		public MyDialog(JFrame frame, String title) {
			super(frame, title);
			setLayout(new GridLayout(1, 15));
			add(dlb1);
			add(dtf1);
			add(dlb2);
			add(dtf2);
			add(dlb3);
			add(dtf3);
			add(dlb4);
			add(dtf4);
			add(dlb5);
			add(dtf5);
			add(dlb6);
			add(dtf6);
			add(dlb7);
			add(dtf7);

			add(okButton);
			setSize(1000, 200);

			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String name = dtf1.getText();
					int stnumber = Integer.parseInt(dtf2.getText());
					String major = dtf3.getText();
					int midterm = Integer.parseInt(dtf4.getText());
					int finalexam = Integer.parseInt(dtf5.getText());
					int attendence = Integer.parseInt(dtf6.getText());
					int homework = Integer.parseInt(dtf7.getText());
					int score = midterm + finalexam + attendence + homework;
					String grade = null;
					if (95 < score) {
						grade = "A+";
					} else if (90 < score) {
						grade = "A";
					} else if (85 < score) {
						grade = "B+";
					} else if (80 < score) {
						grade = "B";
					} else if (75 < score) {
						grade = "C+";
					} else if (70 < score) {
						grade = "C";
					} else {
						grade = "F";
					}
					list.add(new Grade(name, stnumber, major, midterm, finalexam,
							attendence, homework, score, grade));
					System.out.println("sr");
					setVisible(false);
				}
			});
		}

	}

	class MyDialog1 extends JDialog {
		//ArrayList<Grade> list = new ArrayList<Grade>();
		JTextField dtf0 = new JTextField();
		JTextField dtf1 = new JTextField();
		JTextField dtf2 = new JTextField();
		JTextField dtf3 = new JTextField();
		JTextField dtf4 = new JTextField();
		JTextField dtf5 = new JTextField();
		JTextField dtf6 = new JTextField();
		JTextField dtf7 = new JTextField();
		JLabel dlb0 = new JLabel("번호");
		JLabel dlb1 = new JLabel("이름");
		JLabel dlb2 = new JLabel("학번");
		JLabel dlb3 = new JLabel("전공");
		JLabel dlb4 = new JLabel("중간");
		JLabel dlb5 = new JLabel("기말");
		JLabel dlb6 = new JLabel("과제");
		JLabel dlb7 = new JLabel("출석");
		JButton okButton = new JButton("OK");

		public MyDialog1(JFrame frame, String title) {
			super(frame, title);
			setLayout(new GridLayout(1, 17));
			add(dlb0);
			add(dtf0);
			add(dlb1);
			add(dtf1);
			add(dlb2);
			add(dtf2);
			add(dlb3);
			add(dtf3);
			add(dlb4);
			add(dtf4);
			add(dlb5);
			add(dtf5);
			add(dlb6);
			add(dtf6);
			add(dlb7);
			add(dtf7);

			add(okButton);
			setSize(1000, 200);

			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int change = Integer.parseInt(dtf0.getText());
					String name = dtf1.getText();
					int stnumber = Integer.parseInt(dtf2.getText());
					String major = dtf3.getText();
					int midterm = Integer.parseInt(dtf4.getText());
					int finalexam = Integer.parseInt(dtf5.getText());
					int attendence = Integer.parseInt(dtf6.getText());
					int homework = Integer.parseInt(dtf7.getText());
					int score = midterm + finalexam + attendence + homework;
					String grade = null;
					if (95 < score) {
						grade = "A+";
					} else if (90 < score) {
						grade = "A";
					} else if (85 < score) {
						grade = "B+";
					} else if (80 < score) {
						grade = "B";
					} else if (75 < score) {
						grade = "C+";
					} else if (70 < score) {
						grade = "C";
					} else {
						grade = "F";
					}
					list.set(change, new Grade(name, stnumber, major, midterm,
							finalexam, attendence, homework, score, grade));
					setVisible(false);
				}
			});
		}

	}


	class MyDialog2 extends JDialog {
		JTextField tf2 = new JTextField();
		JButton okButton2 = new JButton("OK");
		JLabel label2 = new JLabel("번호");

		public MyDialog2(JFrame frame2, String title2) {
			super(frame2, title2);
			setLayout(new GridLayout(1, 3));
			add(label2);
			add(tf2);
			add(okButton2);
			setSize(300, 200);

			okButton2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int change = Integer.parseInt(tf2.getText());
					list.remove(change);
					setVisible(false);
				}
			});
		}
	}
	
	public static void main(String args[]) {
		new GradeFrame();
	}
	
}
