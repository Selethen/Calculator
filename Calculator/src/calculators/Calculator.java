package calculators;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Calculator {
	
	Double firstNumber = Double.NaN;
	String operator;

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 250, 350);
		frame.setSize(315, 345);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 34));
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(10, 11, 290, 50);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText("0");
		
		
		JButton oneButton = new JButton("1");
		oneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteZero();
				if(!isTooLong(textField.getText())) {
					String enteredNumber = textField.getText() + oneButton.getText();
					textField.setText(enteredNumber);
				}
			}
		});
		oneButton.setBounds(10, 72, 50, 50);
		frame.getContentPane().add(oneButton);
		
		JButton twoButton = new JButton("2");
		twoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteZero();
				if(!isTooLong(textField.getText())) {
					String enteredNumber = textField.getText() + twoButton.getText();
					textField.setText(enteredNumber);
				}
			}
		});
		twoButton.setBounds(70, 72, 50, 50);
		frame.getContentPane().add(twoButton);
		
		JButton threeButton = new JButton("3");
		threeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteZero();
				if(!isTooLong(textField.getText())) {
					String enteredNumber = textField.getText() + threeButton.getText();
					textField.setText(enteredNumber);
				}
			}
		});
		threeButton.setBounds(130, 72, 50, 50);
		frame.getContentPane().add(threeButton);
		
		JButton fourButton = new JButton("4");
		fourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteZero();
				if(!isTooLong(textField.getText())) {
					String enteredNumber = textField.getText() + fourButton.getText();
					textField.setText(enteredNumber);
				}
			}
		});
		fourButton.setBounds(10, 133, 50, 50);
		frame.getContentPane().add(fourButton);
		
		JButton fiveButton = new JButton("5");
		fiveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteZero();
				if(!isTooLong(textField.getText())) {
					String enteredNumber = textField.getText() + fiveButton.getText();
					textField.setText(enteredNumber);
				}
			}
		});
		fiveButton.setBounds(70, 133, 50, 50);
		frame.getContentPane().add(fiveButton);
		
		JButton sixButton = new JButton("6");
		sixButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteZero();
				if(!isTooLong(textField.getText())) {
					String enteredNumber = textField.getText() + sixButton.getText();
					textField.setText(enteredNumber);
				}
			}
		});
		sixButton.setBounds(130, 133, 50, 50);
		frame.getContentPane().add(sixButton);
		
		JButton sevenButton = new JButton("7");
		sevenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteZero();
				if(!isTooLong(textField.getText())) {
					String enteredNumber = textField.getText() + sevenButton.getText();
					textField.setText(enteredNumber);
				}
			}
		});
		sevenButton.setBounds(10, 194, 50, 50);
		frame.getContentPane().add(sevenButton);
		
		JButton eightButton = new JButton("8");
		eightButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteZero();
				if(!isTooLong(textField.getText())) {
					String enteredNumber = textField.getText() + eightButton.getText();
					textField.setText(enteredNumber);
				}
			}
		});
		eightButton.setBounds(70, 194, 50, 50);
		frame.getContentPane().add(eightButton);
		
		JButton nineButton = new JButton("9");
		nineButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteZero();
				if(!isTooLong(textField.getText())) {
					String enteredNumber = textField.getText() + nineButton.getText();
					textField.setText(enteredNumber);
				}
			}
		});
		nineButton.setBounds(130, 194, 50, 50);
		frame.getContentPane().add(nineButton);
		
		JButton zeroButton = new JButton("0");
		zeroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().isEmpty() && !textField.getText().equals("0")) {
					if(!isTooLong(textField.getText())) {
						String enteredNumber = textField.getText() + zeroButton.getText();
						textField.setText(enteredNumber);
					}
				}
			}
		});
		zeroButton.setBounds(70, 255, 50, 50);
		frame.getContentPane().add(zeroButton);
		
		JButton plusButton = new JButton("+");
		plusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!firstNumber.equals(Double.NaN)) {
					firstNumber = doOperation(operator, firstNumber, Double.parseDouble(textField.getText()));
					operator = "+";
					textField.setText("0");
				}
				else {
					firstNumber = Double.parseDouble(textField.getText());
					operator = "+";
					textField.setText("0");
				}
			}
		});
		
		JButton backButton = new JButton("\u2190");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String backspace;
				
				if(textField.getText().length() > 0 && !(textField.getText().equals("0"))) {
					StringBuilder strB = new StringBuilder(textField.getText());
					strB.deleteCharAt(textField.getText().length()-1);
					backspace = strB.toString();
					textField.setText(backspace);
				}
				
			}
		});
		backButton.setBounds(190, 72, 50, 50);
		frame.getContentPane().add(backButton);
		plusButton.setBounds(190, 133, 50, 50);
		frame.getContentPane().add(plusButton);
		
		JButton minusButton = new JButton("-");
		minusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!firstNumber.equals(Double.NaN)) {
					firstNumber = doOperation(operator, firstNumber, Double.parseDouble(textField.getText()));
					operator = "-";
					textField.setText("0");
				}
				else {
					firstNumber = Double.parseDouble(textField.getText());
					operator = "-";
					textField.setText("0");
				}
			}
		});
		minusButton.setBounds(250, 133, 50, 50);
		frame.getContentPane().add(minusButton);
		
		JButton divideButton = new JButton("/");
		divideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!firstNumber.equals(Double.NaN)) {
					firstNumber = doOperation(operator, firstNumber, Double.parseDouble(textField.getText()));
					operator = "/";
					textField.setText("0");
				}
				else {
					firstNumber = Double.parseDouble(textField.getText());
					operator = "/";
					textField.setText("0");
				}
			}
		});
		divideButton.setBounds(190, 194, 50, 50);
		frame.getContentPane().add(divideButton);
		
		JButton multiplicationButton = new JButton("*");
		multiplicationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!firstNumber.equals(Double.NaN)) {
					firstNumber = doOperation(operator, firstNumber, Double.parseDouble(textField.getText()));
					operator = "*";
					textField.setText("0");
				}
				else {
					firstNumber = Double.parseDouble(textField.getText());
					operator = "*";
					textField.setText("0");
				}
			}
		});
		multiplicationButton.setBounds(250, 194, 50, 50);
		frame.getContentPane().add(multiplicationButton);
		
		JButton plusMinusButton = new JButton("\u00B1");
		plusMinusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double number = Double.parseDouble(textField.getText());
				number = -number;
				if(number==(int)number)
					textField.setText(String.valueOf((int)number));
				else
					textField.setText(String.valueOf(number));
			}
		});
		plusMinusButton.setBounds(10, 255, 50, 50);
		frame.getContentPane().add(plusMinusButton);
		
		JButton dotButton = new JButton(".");
		dotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!dotUsed(textField.getText())) {
					String enteredNumber = textField.getText() + dotButton.getText();
					textField.setText(enteredNumber);
				}
					
			}
		});
		dotButton.setBounds(130, 255, 50, 50);
		frame.getContentPane().add(dotButton);
		
		JButton equalsButton = new JButton("=");
		equalsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!firstNumber.equals(Double.NaN)) {
					textField.setText(String.valueOf(doOperation(operator, firstNumber, Double.parseDouble(textField.getText()))));
					firstNumber = Double.parseDouble(textField.getText());
					operator="";
				}
			}
		});
		equalsButton.setBounds(190, 255, 110, 50);
		frame.getContentPane().add(equalsButton);
		
		JButton clearButton = new JButton("C");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstNumber = Double.NaN;
				textField.setText("0");
			}
		});
		clearButton.setBounds(250, 72, 50, 50);
		frame.getContentPane().add(clearButton);
	}
	
	private void deleteZero() {
		if(textField.getText().equals("0"))
			textField.setText("");
	}
	
	private boolean dotUsed (String string) {
		for(int i=0;i<string.length();i++) {
			if(string.charAt(i)=='.')
				return true;
		}
		return false;
	}
	
	private double doOperation(String operator, double firstNum, double secNum) {
		switch(operator) {
		case "+": {
			return firstNum + secNum;
		}
		case "-": {
			return firstNum - secNum;
		}
		case "*": {
			return firstNum * secNum;
		}
		case "/": {
			if(secNum==0) {
				JOptionPane.showMessageDialog(null, "Nie dziel przez zero! \n Wychodzenie z programu...");
				System.exit(0);
			}
			return firstNum / secNum;
		}
		case "": {
			return firstNum;
		}
		}
		return 0.00;
	}
	
	private boolean isTooLong(String word) {
		if(word.length()>8)
			return true;
		else
			return false;
	}
}
