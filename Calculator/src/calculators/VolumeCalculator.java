package calculators;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class VolumeCalculator {
	
	ButtonGroup choiceGroup = new ButtonGroup();

	private JFrame frame;
	private JTextField radiusField;
	private JTextField heightField;
	private JTextField answerField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VolumeCalculator window = new VolumeCalculator();
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
	public VolumeCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 342, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu file = new JMenu("File");
		menuBar.add(file);
		JMenuItem clear = new JMenuItem("Clear");
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new CloseListener());
		clear.addActionListener(new ClearListener());
		file.add(clear);
		file.add(exit);
		
		JMenu help = new JMenu("Help");
		menuBar.add(help);
		JMenuItem helpItem = new JMenuItem("Help");
		JMenuItem infoItem = new JMenuItem("Info");
		infoItem.addActionListener(new InfoListener());
		helpItem.addActionListener(new HelpListener());
		help.add(helpItem);
		help.add(infoItem);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(frame.getContentPane(), popupMenu);
		JMenuItem clear2 = new JMenuItem("Clear");
		JMenuItem helpItem2 = new JMenuItem("Help");
		clear2.addActionListener(new ClearListener());
		helpItem2.addActionListener(new HelpListener());
		popupMenu.add(clear2);
		popupMenu.add(helpItem2);
		
		JRadioButton checkbox1 = new JRadioButton("Sphere");
		checkbox1.setBounds(10, 10, 95, 22);
		frame.getContentPane().add(checkbox1);
		
		JRadioButton checkbox2 = new JRadioButton("Cone");
		checkbox2.setBounds(115, 10, 95, 22);
		frame.getContentPane().add(checkbox2);
		
		JRadioButton checkbox3 = new JRadioButton("Cylinder");
		checkbox3.setBounds(220, 10, 95, 22);
		frame.getContentPane().add(checkbox3);
		
		choiceGroup.add(checkbox1);
		choiceGroup.add(checkbox2);
		choiceGroup.add(checkbox3);
		
		radiusField = new JTextField();
		radiusField.setBounds(162, 192, 153, 20);
		frame.getContentPane().add(radiusField);
		radiusField.setColumns(10);
		radiusField.setEnabled(false);
		
		heightField = new JTextField();
		heightField.setBounds(162, 223, 153, 20);
		frame.getContentPane().add(heightField);
		heightField.setColumns(10);
		heightField.setEnabled(false);
		
		JLabel radiusLabel = new JLabel("Radius");
		radiusLabel.setBounds(10, 195, 86, 14);
		frame.getContentPane().add(radiusLabel);
		
		JLabel heightLabel = new JLabel("Height");
		heightLabel.setBounds(10, 226, 86, 14);
		frame.getContentPane().add(heightLabel);
		
		JButton calculateButton = new JButton("CALCULATE");
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(checkbox1.isSelected()) {
						if(Double.parseDouble(radiusField.getText())>=0)
							answerField.setText(String.valueOf(sphereVolume(Double.parseDouble(radiusField.getText()))));
						else
							dataErrorMessage();
					} else if(checkbox2.isSelected()) {
						if(Double.parseDouble(radiusField.getText())>=0 && Double.parseDouble(heightField.getText())>=0)
							answerField.setText(String.valueOf(coneVolume(Double.parseDouble(radiusField.getText()), Double.parseDouble(heightField.getText()))));
						else
							dataErrorMessage();
					} else if(checkbox3.isSelected()) {
						if(Double.parseDouble(radiusField.getText())>=0 && Double.parseDouble(heightField.getText())>=0)
							answerField.setText(String.valueOf(cylinderVolume(Double.parseDouble(radiusField.getText()), Double.parseDouble(heightField.getText()))));
						else
							dataErrorMessage();
					}
				} catch(NumberFormatException exception) {
					dataErrorMessage();
				}
			}
		});
		calculateButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		calculateButton.setBounds(10, 283, 306, 50);
		frame.getContentPane().add(calculateButton);
		
		JLabel answerLabel = new JLabel("Volume equals:");
		answerLabel.setBounds(10, 359, 111, 14);
		frame.getContentPane().add(answerLabel);
		
		answerField = new JTextField();
		answerField.setBounds(162, 356, 153, 20);
		frame.getContentPane().add(answerField);
		answerField.setColumns(10);
		answerField.setEditable(false);
		
		ImageIcon coneImage = new ImageIcon(getClass().getResource("cone.jpg"));
		
		JLabel lblNewLabel = new JLabel(coneImage);
		lblNewLabel.setSize(100, 100);
		lblNewLabel.setBounds(115, 39, 95, 93);
		frame.getContentPane().add(lblNewLabel);
		
		ImageIcon cylinderImage = new ImageIcon(getClass().getResource("cylinder.jpg"));
		
		JLabel label = new JLabel(cylinderImage);
		label.setBounds(220, 39, 95, 93);
		frame.getContentPane().add(label);
		
		ImageIcon sphereImage = new ImageIcon(getClass().getResource("sphere.jpg"));
		
		JLabel label_1 = new JLabel(sphereImage);
		label_1.setBounds(10, 39, 95, 93);
		frame.getContentPane().add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("Author: \u0141ukasz Parulski");
		lblNewLabel_1.setBounds(172, 387, 143, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		checkbox1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            radiusField.setEnabled(true);
	            heightField.setEnabled(false);
	        }
	    });
		
		checkbox2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            radiusField.setEnabled(true);
	            heightField.setEnabled(true);
	        }
	    });
		
		checkbox3.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            radiusField.setEnabled(true);
	            heightField.setEnabled(true);
	        }
	    });
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	private class CloseListener implements ActionListener{
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        System.exit(0);
	    }
	}
	
	private class ClearListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			choiceGroup.clearSelection();
			heightField.setText("");
			radiusField.setText("");
			answerField.setText("");
			heightField.setEnabled(false);
			radiusField.setEnabled(false);
		}
	}
	
	private class InfoListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "This program calculates approximate volume of cone, sphere or cylinder. \n"
											  + "It was created by £ukasz Parulski.");
		}
	}
	
	private class HelpListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Firstly, select type of the solid by choosing the right button \n"
											  + "Then enter proper data into the text boxes and click CALCULATE button\n"
											  + "You can read the volume of the solid at the bottom of the window");
		}
	}
	
	private double sphereVolume(double radius) {
		return 4.1867*radius*radius*radius;
	}
	
	private double cylinderVolume(double radius, double height) {
		return 3.14*radius*radius*height;
	}
	
	private double coneVolume(double radius, double height) {
		return 1.0467*radius*radius*height;
	}
	
	private void dataErrorMessage() {
		JOptionPane.showMessageDialog(null, "Please enter valid numbers");
		radiusField.setText("");
		heightField.setText("");
		answerField.setText("");
	}
}
