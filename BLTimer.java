import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;


public class BLTimer {

	private JFrame frmBootleggersTimer;
	private JTextField crimesTextBox;
	private JTextField gtaTextBox;
	private JTextField trainTextBox;
	private JTextField gymTextBox;
	private Timer crimesTimer;
	private Timer gtaTimer;
	private Timer trainTimer;
	private Timer gymTimer;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			System.out.println("Error setting native LAF: " + e);
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BLTimer window = new BLTimer();
					window.frmBootleggersTimer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BLTimer() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBootleggersTimer = new JFrame();
		frmBootleggersTimer.setResizable(false);
		frmBootleggersTimer.setAlwaysOnTop(true);
		frmBootleggersTimer.setTitle("Bootleggers Timer");
		frmBootleggersTimer.setBounds(100, 100, 370, 230);
		frmBootleggersTimer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBootleggersTimer.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 354, 192);
		frmBootleggersTimer.getContentPane().add(panel);
		panel.setLayout(null);
		
		final JButton crimesButton = new JButton("Crimes");
		crimesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crimesButton.setEnabled(false);
				crimesTextBox.setBackground(Color.RED);
				crimesTimer = new Timer(1000, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (Integer.parseInt(crimesTextBox.getText()) > 0)
							crimesTextBox.setText(Integer.toString(Integer.parseInt(crimesTextBox.getText()) - 1));
						else {
							if(crimesTimer.isRunning()){
								crimesTimer.stop();
								Toolkit.getDefaultToolkit().beep();
								crimesButton.setEnabled(true);
								crimesTextBox.setBackground(Color.GREEN);
								crimesTextBox.setText("120");
							}
						}
					}
				});
				crimesTimer.start();
			}
		});
		crimesButton.setBounds(10, 11, 122, 30);
		panel.add(crimesButton);
		
		JButton crimesUpTime = new JButton("\u25B2");
		crimesUpTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!crimesTextBox.getText().equals("120"))
					crimesTextBox.setText(Integer.toString(Integer.parseInt(crimesTextBox.getText()) + 1));
			}
		});
		crimesUpTime.setFont(new Font("Arial", Font.PLAIN, 7));
		crimesUpTime.setBounds(145, 11, 43, 14);
		panel.add(crimesUpTime);
		
		JButton crimesDownTime = new JButton("\u25BC");
		crimesDownTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!crimesTextBox.getText().equals("0"))
					crimesTextBox.setText(Integer.toString(Integer.parseInt(crimesTextBox.getText()) - 1));
			}
		});
		crimesDownTime.setFont(new Font("Arial", Font.PLAIN, 7));
		crimesDownTime.setBounds(145, 27, 43, 14);
		panel.add(crimesDownTime);
		
		crimesTextBox = new JTextField();
		crimesTextBox.setHorizontalAlignment(SwingConstants.CENTER);
		crimesTextBox.setText("120");
		crimesTextBox.setBackground(Color.GREEN);
		crimesTextBox.setBounds(198, 11, 38, 30);
		panel.add(crimesTextBox);
		crimesTextBox.setColumns(10);
		
		JLabel lblS = new JLabel("s");
		lblS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblS.setBounds(246, 17, 11, 14);
		panel.add(lblS);
		
		final JButton gtaButton = new JButton("Grand Theft Auto");
		gtaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gtaButton.setEnabled(false);
				gtaTextBox.setBackground(Color.RED);
				gtaTimer = new Timer(1000, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (Integer.parseInt(gtaTextBox.getText()) > 0)
							gtaTextBox.setText(Integer.toString(Integer.parseInt(gtaTextBox.getText()) - 1));
						else {
							if(gtaTimer.isRunning()){
								gtaTimer.stop();
								Toolkit.getDefaultToolkit().beep();
								gtaButton.setEnabled(true);
								gtaTextBox.setBackground(Color.GREEN);
								gtaTextBox.setText("240");
							}
						}
					}
				});
				gtaTimer.start();
			}
		});
		gtaButton.setBounds(10, 54, 122, 30);
		panel.add(gtaButton);
		
		gtaTextBox = new JTextField();
		gtaTextBox.setText("240");
		gtaTextBox.setHorizontalAlignment(SwingConstants.CENTER);
		gtaTextBox.setColumns(10);
		gtaTextBox.setBackground(Color.GREEN);
		gtaTextBox.setBounds(198, 52, 38, 30);
		panel.add(gtaTextBox);
		
		JLabel label = new JLabel("s");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(246, 60, 11, 14);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Workout", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(263, 11, 81, 114);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		final JRadioButton twoMins = new JRadioButton("2 mins");
		buttonGroup.add(twoMins);
		twoMins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gymTextBox.setText("120");
			}
		});
		twoMins.setSelected(true);
		twoMins.setFont(new Font("Tahoma", Font.PLAIN, 10));
		twoMins.setBounds(6, 16, 68, 30);
		panel_1.add(twoMins);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(40, 16, 34, 30);
		panel_1.add(label_3);
		
		final JRadioButton fiveMins = new JRadioButton("5 mins");
		buttonGroup.add(fiveMins);
		fiveMins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gymTextBox.setText("300");
			}
		});
		fiveMins.setFont(new Font("Tahoma", Font.PLAIN, 10));
		fiveMins.setBounds(6, 46, 68, 30);
		panel_1.add(fiveMins);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(40, 46, 34, 30);
		panel_1.add(label_4);
		
		final JRadioButton tenMins = new JRadioButton("10 mins");
		buttonGroup.add(tenMins);
		tenMins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gymTextBox.setText("600");
			}
		});
		tenMins.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tenMins.setBounds(6, 77, 68, 30);
		panel_1.add(tenMins);
		
		final JButton trainButton = new JButton("Train Station");
		trainButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trainButton.setEnabled(false);
				trainTextBox.setBackground(Color.RED);
				trainTimer = new Timer(1000, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (Integer.parseInt(trainTextBox.getText()) > 0)
							trainTextBox.setText(Integer.toString(Integer.parseInt(trainTextBox.getText()) - 1));
						else {
							if(trainTimer.isRunning()){
								trainTimer.stop();
								Toolkit.getDefaultToolkit().beep();
								trainButton.setEnabled(true);
								trainTextBox.setBackground(Color.GREEN);
								trainTextBox.setText("5400");
							}
						}
					}
				});
				trainTimer.start();
			}
		});
		trainButton.setBounds(10, 95, 122, 30);
		panel.add(trainButton);
		
		trainTextBox = new JTextField();
		trainTextBox.setText("5400");
		trainTextBox.setHorizontalAlignment(SwingConstants.CENTER);
		trainTextBox.setColumns(10);
		trainTextBox.setBackground(Color.GREEN);
		trainTextBox.setBounds(198, 95, 38, 30);
		panel.add(trainTextBox);
		
		JLabel label_1 = new JLabel("s");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(246, 101, 11, 14);
		panel.add(label_1);
		
		final JButton gymButton = new JButton("Gymnasium");
		gymButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String gymValue = gymTextBox.getText();
				twoMins.setEnabled(false);
				fiveMins.setEnabled(false);
				tenMins.setEnabled(false);
				gymButton.setEnabled(false);
				gymTextBox.setBackground(Color.RED);
				gymTimer = new Timer(1000, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (Integer.parseInt(gymTextBox.getText()) > 0)
							gymTextBox.setText(Integer.toString(Integer.parseInt(gymTextBox.getText()) - 1));
						else {
							if(gymTimer.isRunning()){
								gymTimer.stop();
								Toolkit.getDefaultToolkit().beep();
								gymButton.setEnabled(true);
								gymTextBox.setBackground(Color.GREEN);
								gymTextBox.setText(gymValue);
								twoMins.setEnabled(true);
								fiveMins.setEnabled(true);
								tenMins.setEnabled(true);
							}
						}
					}
				});
				gymTimer.start();
			}
		});
		gymButton.setBounds(10, 136, 122, 30);
		panel.add(gymButton);
		
		gymTextBox = new JTextField();
		gymTextBox.setText("120");
		gymTextBox.setHorizontalAlignment(SwingConstants.CENTER);
		gymTextBox.setColumns(10);
		gymTextBox.setBackground(Color.GREEN);
		gymTextBox.setBounds(198, 136, 38, 30);
		panel.add(gymTextBox);
		
		JLabel label_2 = new JLabel("s");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(246, 142, 11, 14);
		panel.add(label_2);
		
		JLabel lblMadeByJacksylvane = new JLabel("Made by JackSylvane 2012");
		lblMadeByJacksylvane.setHorizontalAlignment(SwingConstants.CENTER);
		lblMadeByJacksylvane.setBounds(0, 177, 354, 14);
		panel.add(lblMadeByJacksylvane);
		
		JButton gtaUpButton = new JButton("\u25B2");
		gtaUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!gtaTextBox.getText().equals("240"))
					gtaTextBox.setText(Integer.toString(Integer.parseInt(gtaTextBox.getText()) + 1));
			}
		});
		gtaUpButton.setFont(new Font("Arial", Font.PLAIN, 7));
		gtaUpButton.setBounds(145, 52, 43, 14);
		panel.add(gtaUpButton);
		
		JButton gtaDownButton = new JButton("\u25BC");
		gtaDownButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!gtaTextBox.getText().equals("0"))
					gtaTextBox.setText(Integer.toString(Integer.parseInt(gtaTextBox.getText()) - 1));
			}
		});
		gtaDownButton.setFont(new Font("Arial", Font.PLAIN, 7));
		gtaDownButton.setBounds(145, 68, 43, 14);
		panel.add(gtaDownButton);
		
		JButton trainUpButton = new JButton("\u25B2");
		trainUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!trainTextBox.getText().equals("5400"))
					trainTextBox.setText(Integer.toString(Integer.parseInt(trainTextBox.getText()) + 1));
			}
		});
		trainUpButton.setFont(new Font("Arial", Font.PLAIN, 7));
		trainUpButton.setBounds(145, 95, 43, 14);
		panel.add(trainUpButton);
		
		JButton trainDownButton = new JButton("\u25BC");
		trainDownButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!trainTextBox.getText().equals("0"))
					trainTextBox.setText(Integer.toString(Integer.parseInt(trainTextBox.getText()) - 1));
			}
		});
		trainDownButton.setFont(new Font("Arial", Font.PLAIN, 7));
		trainDownButton.setBounds(145, 111, 43, 14);
		panel.add(trainDownButton);
		
		JButton gymUpButton = new JButton("\u25B2");
		gymUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!gymTextBox.getText().equals("120") && !gymTextBox.getText().equals("300") && !gymTextBox.getText().equals("600"))
					gymTextBox.setText(Integer.toString(Integer.parseInt(gymTextBox.getText()) + 1));
			}
		});
		gymUpButton.setFont(new Font("Arial", Font.PLAIN, 7));
		gymUpButton.setBounds(145, 136, 43, 14);
		panel.add(gymUpButton);
		
		JButton gymDownButton = new JButton("\u25BC");
		gymDownButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!gymTextBox.getText().equals("0"))
					gymTextBox.setText(Integer.toString(Integer.parseInt(gymTextBox.getText()) - 1));
			}
		});
		gymDownButton.setFont(new Font("Arial", Font.PLAIN, 7));
		gymDownButton.setBounds(145, 152, 43, 14);
		panel.add(gymDownButton);
	}
}
