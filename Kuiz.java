
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Kuiz {

	private JFrame frame;
	private JPanel p1, p2, p3;
	// Vargjet e labelave ku secila labele ka 1 pyetje
	private JLabel[] arrayLabels;
	// Alternativat e pyetjeve (radio butonat)
	private JRadioButton[] arrayRButtons;
	// Grupet e radio butonave me nga 4 anetare
	private ButtonGroup[] arrayGroups;
	// Vargje te panelave ku 1 panele ka 1 pyetje me alternativat e saj
	private JPanel[] Panleat;
	// Shfaqja e paneles kryesore ne forme te kartave njera pas tjetres
	private CardLayout cl;
	// Butonat per nderrim te pyetjes(butoni1) dhe per konfirmim te
	// pergjigjes(butoni2)
	private JButton butoni1, butoni2;
	// Numri i pikeve si rezultat i pergjigjeve ne kuiz
	// Secila pyetje e sakte vleresohet me 5 pike
	// Secila pyetje e gabuar vleresohet me 0 pike
	// Gjithsej 100 pike (20 pyetje * 5 pike)
	private int piket;

	public Kuiz() {
		frame = new JFrame();
		frame.setSize(700, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		frame.setTitle("Kuizi");
		p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		cl = new CardLayout();
		p2 = new JPanel();
		p2.setLayout(cl);
		Panleat = new JPanel[20];
		// Shfaqja e pyetjeve dhe e pergjigjeve
		for (int i = 0; i < Panleat.length; i++) {
			Panleat[i] = new JPanel();
			p2.add(Panleat[i], String.valueOf(i));
			Panleat[i].setLayout(new GridLayout(0, 1));
		}
		// Alternativat e pyetjeve (radio butonat)
		// 4 alternativa per secilen pyetje * 20 pyetje
		arrayRButtons = new JRadioButton[80];
		for (int i = 0; i < arrayRButtons.length; i++) {
			arrayRButtons[i] = new JRadioButton();
		}
		arrayRButtons[0].setText("-128 to 127");
		arrayRButtons[1].setText("-32768 to 32767");
		arrayRButtons[2].setText("-2147483648 to 2147483647");
		arrayRButtons[3].setText("None of the mentioned");
		arrayRButtons[4].setText("int");
		arrayRButtons[5].setText("long");
		arrayRButtons[6].setText("byte");
		arrayRButtons[7].setText("float");
		arrayRButtons[8].setText("1.7e-308");
		arrayRButtons[9].setText("3.4e-038");
		arrayRButtons[10].setText("1.7e+308");
		arrayRButtons[11].setText("3.4e-050");
		arrayRButtons[12].setText("int");
		arrayRButtons[13].setText("long");
		arrayRButtons[14].setText("byte");
		arrayRButtons[15].setText("float");
		arrayRButtons[16].setText("-128 to 127");
		arrayRButtons[17].setText("0 to 256");
		arrayRButtons[18].setText("0 to 32767");
		arrayRButtons[19].setText("0 to 65535");
		arrayRButtons[20].setText("ASCII");
		arrayRButtons[21].setText("ISO-LATIN-1");
		arrayRButtons[22].setText("UNICODE");
		arrayRButtons[23].setText("None of the mentioned");
		arrayRButtons[24].setText("True & False");
		arrayRButtons[25].setText("0 & 1");
		arrayRButtons[26].setText("Any integer value");
		arrayRButtons[27].setText("true");
		arrayRButtons[28].setText("ASCII");
		arrayRButtons[29].setText("ISO-LATIN-1");
		arrayRButtons[30].setText("None of the mentioned");
		arrayRButtons[31].setText("ASCII and ISO-LATIN1");
		arrayRButtons[32].setText("boolean b1 = 1;");
		arrayRButtons[33].setText("boolean b2 = ‘false’;");
		arrayRButtons[34].setText("boolean b3 = false;");
		arrayRButtons[35].setText("boolean b4 = ‘true’");
		arrayRButtons[36].setText("prototype( )");
		arrayRButtons[37].setText(" prototype(void)");
		arrayRButtons[38].setText("public prototype(void)");
		arrayRButtons[39].setText("public prototype( )");
		arrayRButtons[40].setText("long");
		arrayRButtons[41].setText("int");
		arrayRButtons[42].setText("double");
		arrayRButtons[43].setText("float");
		arrayRButtons[44].setText(" Floating-point value assigned to an integer type.");
		arrayRButtons[45].setText("Integer value assigned to floating type.");
		arrayRButtons[46].setText("Floating-point value assigned to an Floating type.");
		arrayRButtons[47].setText(" Integer value assigned to floating type.");
		arrayRButtons[48].setText("if");
		arrayRButtons[49].setText("switch");
		arrayRButtons[50].setText("if & switch");
		arrayRButtons[51].setText("None of the mentioned");
		arrayRButtons[52].setText(" if()");
		arrayRButtons[53].setText("for()");
		arrayRButtons[54].setText("continue");
		arrayRButtons[55].setText("break");
		arrayRButtons[56].setText("do-while");
		arrayRButtons[57].setText("while");
		arrayRButtons[58].setText("for");
		arrayRButtons[59].setText("None of the mentioned");
		arrayRButtons[60].setText("break");
		arrayRButtons[61].setText("return");
		arrayRButtons[62].setText("exit");
		arrayRButtons[63].setText("continue");
		arrayRButtons[64].setText("switch statement is more efficient than a set of nested ifs.");
		arrayRButtons[65].setText("two case constants in the same switch can have identical values.");
		arrayRButtons[66].setText("switch statement can only test for equality, whereas if statement can evaluate any type of boolean expression.");
		arrayRButtons[67].setText("it is possible to create a nested switch statements.");
		arrayRButtons[68].setText("numeric");
		arrayRButtons[69].setText("boolean");
		arrayRButtons[70].setText("characters");
		arrayRButtons[71].setText("both numeric and characters");
		arrayRButtons[72].setText("Integers");
		arrayRButtons[73].setText("Floating- point numbers");
		arrayRButtons[74].setText("Both integers and floating-point numbers.");
		arrayRButtons[75].setText("None of the mentioned");
		arrayRButtons[76].setText("1");
		arrayRButtons[77].setText("2");
		arrayRButtons[78].setText("3");
		arrayRButtons[79].setText("4");
		

		// Grupet e butonave me nga 4 anetare
		// (meqe vetem njera nga alternativat eshte e sakte)
		arrayGroups = new ButtonGroup[20];
		int j = 0;
		for (int i = 0; i < arrayGroups.length; i++) {
			arrayGroups[i] = new ButtonGroup();
			arrayGroups[i].add(arrayRButtons[j]);
			arrayGroups[i].add(arrayRButtons[j + 1]);
			arrayGroups[i].add(arrayRButtons[j + 2]);
			arrayGroups[i].add(arrayRButtons[j + 3]);
			j += 4;
		}
		// 20 Pyetje
		arrayLabels = new JLabel[20];
		for (int i = 0; i < arrayLabels.length; i++) {
			arrayLabels[i] = new JLabel();
		}
		arrayLabels[0].setText("1. What is the range of data type short in Java?");
		arrayLabels[1].setText("2. An expression involving byte, int, and literal numbers is promoted to which of these ?");
		arrayLabels[2].setText("3. Which of these literals can be contained in a data type float variable ?");
		arrayLabels[3].setText("4. Which data type value is returned by all transcendental math functions?");
		arrayLabels[4].setText("5. What is the numerical range of a char in Java?");
		arrayLabels[5].setText("6. Which of these coding types is used for data type characters in Java?");
		arrayLabels[6].setText("7. Which of these values can a boolean variable contain?");
		arrayLabels[7].setText(
				"8. Which of these occupy first 0 to 127 in Unicode character set used for characters in Java?");
		arrayLabels[8].setText("9. Which one is a valid declaration of a boolean?");
		arrayLabels[9].setText("10.What is the prototype of the default constructor of this class? public class prototype { }");
		arrayLabels[10].setText("11. If an expression contains double, int, float, long, then whole expression will promoted into which of these data types?");
		arrayLabels[11].setText("12. What is Truncation is Java?");
		arrayLabels[12].setText("13. Which of these selection statements test only for equality?");
		arrayLabels[13].setText("14. Which of these are selection statements in Java?");
		arrayLabels[14].setText("15. Which of the following loops will execute the body of loop even when condition controlling the loop is initially false?");
		arrayLabels[15].setText("16. Which of these jump statements can skip processing remainder of code in its body for a particular iteration? ");
		arrayLabels[16].setText("17. Which of these statement is incorrect?");
		arrayLabels[17].setText("18. Which of the following can be operands of arithmetic operators?");
		arrayLabels[18].setText("19. Modulus operator, %, can be applied to which of these?");
		arrayLabels[19].setText("20.Decrement operator, –, decreases value of variable by what number?");

		p3 = new JPanel();
		p3.setLayout(new FlowLayout());
		// Rrotullo panelat me pyetje
		butoni1 = new JButton("Kalo te pyetja tjeter");
		butoni1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.next(p2);
				butoni1.setText("Kalo te pyetja tjeter");
			}
		});
		butoni2 = new JButton("Pergjigju pyetjes");
		butoni2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Pergjigjet e sakte
				if (arrayRButtons[1].isSelected() || arrayRButtons[4].isSelected() || arrayRButtons[8].isSelected()
						|| arrayRButtons[13].isSelected() || arrayRButtons[19].isSelected()
						|| arrayRButtons[22].isSelected() || arrayRButtons[24].isSelected()
						|| arrayRButtons[31].isSelected() || arrayRButtons[34].isSelected()
						|| arrayRButtons[39].isSelected() || arrayRButtons[42].isSelected()
						|| arrayRButtons[44].isSelected() || arrayRButtons[49].isSelected()
						|| arrayRButtons[52].isSelected() || arrayRButtons[56].isSelected()
						|| arrayRButtons[63].isSelected() || arrayRButtons[65].isSelected()
						|| arrayRButtons[71].isSelected() || arrayRButtons[74].isSelected()) {
					piket += 5;
					JOptionPane.showMessageDialog(null, "E sakte");
				}
				// Pergjigja e fundit e sakte
				else if (arrayRButtons[76].isSelected()) {
					piket += 5;
					JOptionPane.showMessageDialog(null, "E sakte, ju fituat: " + piket + " / 100" + " pike");
					butoni1.setText("Rifillo kuizin nga fillimi");
				}
				// Pergjigja e fundit e gabuar
				else if (arrayRButtons[76].isSelected() || arrayRButtons[77].isSelected()
						|| arrayRButtons[79].isSelected()) {
					JOptionPane.showMessageDialog(null, "Gabim, ju fituat: " + piket + " / 100" + " pike");
					butoni1.setText("Rifillo kuizin nga fillimi");
				}
				// Pergjigjet e gabuara
				else {
					JOptionPane.showMessageDialog(null, "Gabim");
				}
				for (int i = 0; i < 20; i++) {
					arrayGroups[i].clearSelection();
				}
			}
		});
	}

	private void initialize() {
		p3.add(butoni1);
		p3.add(butoni2);
		int q = 0;
		for (int w = 0; w < 20; w++) {
			Panleat[w].add(arrayLabels[w]);
			Panleat[w].add(arrayRButtons[q]);
			Panleat[w].add(arrayRButtons[q + 1]);
			Panleat[w].add(arrayRButtons[q + 2]);
			Panleat[w].add(arrayRButtons[q + 3]);
			q += 4;
		}
		frame.add(p1, BorderLayout.NORTH);
		frame.add(p2, BorderLayout.CENTER);
		frame.add(p3, BorderLayout.SOUTH);
		cl.show(p2, "0");
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		Kuiz klasa = new Kuiz();
		klasa.initialize();
	}
}