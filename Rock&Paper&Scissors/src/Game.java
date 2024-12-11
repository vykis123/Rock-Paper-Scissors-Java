import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Game implements ActionListener {
	
	JFrame frame = new JFrame();
	JLabel heading = new JLabel("Rock & Paper & Scissors Game!");
	JLabel info = new JLabel();
	JButton paperBtn = new JButton("Paper");
	JButton rockBtn = new JButton("Rock");
	JButton scissorsBtn = new JButton("Scissors");
	JButton resetBtn = new JButton("Start");
	String selectedVal;
	Boolean gameEnded = false;
	String[] oponentChoices = {"rock", "paper", "scissors"};
	
	Game() {
		heading.setForeground(Color.green);
		heading.setFont(new Font("Ink Free", Font.PLAIN,20));
		heading.setBounds(110,0,400,50);
		
		info.setForeground(Color.green);
		info.setFont(new Font("Ink Free", Font.PLAIN,20));
		info.setBounds(90,300,400,50);
		info.setVisible(false);
		
		paperBtn.setBounds(100,80,80,50);
		paperBtn.setFont(new Font("Ink Free", Font.PLAIN,18));
		paperBtn.setForeground(Color.green);
		paperBtn.setBackground(Color.black);
		paperBtn.setFocusable(false);
		paperBtn.setBorderPainted(false);
		paperBtn.addActionListener(this);
		paperBtn.setFocusPainted(false);
		
		rockBtn.setBounds(200,80,80,50);
		rockBtn.setFont(new Font("Ink Free", Font.PLAIN,18));
		rockBtn.setForeground(Color.green);
		rockBtn.setBackground(Color.black);
		rockBtn.setFocusable(false);
		rockBtn.setBorderPainted(false);
		rockBtn.addActionListener(this);
		rockBtn.setFocusPainted(false);
		
		scissorsBtn.setBounds(300,80,100,50);
		scissorsBtn.setFont(new Font("Ink Free", Font.PLAIN,18));
		scissorsBtn.setForeground(Color.green);
		scissorsBtn.setBackground(Color.black);
		scissorsBtn.setFocusable(false);
		scissorsBtn.setBorderPainted(false);
		scissorsBtn.addActionListener(this);
		scissorsBtn.setFocusPainted(false);
		
		resetBtn.setBounds(175,175,120,60);
		resetBtn.setFont(new Font("Ink Free", Font.BOLD,22));
		resetBtn.setForeground(Color.green);
		resetBtn.setBackground(Color.black);
		resetBtn.setFocusable(false);
		resetBtn.setBorder(new LineBorder(Color.green));
		resetBtn.addActionListener(this);
		resetBtn.setFocusPainted(false);
		resetBtn.setContentAreaFilled(false);
		resetBtn.setOpaque(true);

		frame.add(heading);
		frame.add(paperBtn);
		frame.add(rockBtn);
		frame.add(scissorsBtn);
		frame.add(resetBtn);
		frame.add(info);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground( Color.black );
		frame.setTitle("Rock, Paper, Scissors Game");
		frame.setSize(500,500);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == paperBtn) {
			selectedVal = "paper";
		}
		
		if(e.getSource() == rockBtn) {
			selectedVal = "rock";
		}
		
		if(e.getSource() == scissorsBtn) {
			selectedVal = "scissors";
		}
		
		if(e.getSource() == resetBtn && gameEnded == false) {
			if(selectedVal == null) {
				info.setText("Please select value and start a game!");
				info.setVisible(true);
				return;
			} 

			startGame();
			return;
		}
		
		if(e.getSource() == resetBtn && gameEnded == true ) {
			reset();
		}
		
	}
	
	void startGame() {
		resetBtn.setText("Reset");
		gameEnded = true;
		String oponentResult = getOponentChoice();
		
		if(oponentResult == "scissors" && selectedVal == "rock") {
			info.setText("You Win! Oponent chose scissors!");
			info.setVisible(true);
			return;
		}
		
		if(oponentResult == "scissors" && selectedVal == "paper") {
			info.setText("You Lose! Oponent chose scissors!");
			info.setVisible(true);
			return;
		}
		
		if(oponentResult == "rock" && selectedVal == "paper") {
			info.setText("You Win! Oponent chose rock!");
			info.setVisible(true);
			return;
		}
		
		if(oponentResult == "rock" && selectedVal == "scissors") {
			info.setText("You Lose! Oponent chose rock!");
			info.setVisible(true);
			return;
		}
		
		if(oponentResult == "paper" && selectedVal == "rock") {
			info.setText("You Lose! Oponent chose paper!");
			info.setVisible(true);
			return;
		}
		
		if(oponentResult == "paper" && selectedVal == "scissors") {
			info.setText("You Win! Oponent chose paper!");
			info.setVisible(true);
			return;
		}
		
		if(oponentResult == "paper" && selectedVal == "paper") {
			info.setText("It's a draw. You both choose paper!");
			info.setVisible(true);
			return;
		}
		
		if(oponentResult == "rock" && selectedVal == "rock") {
			info.setText("It's a draw. You both choose rock!");
			info.setVisible(true);
			return;
		}
		
		if(oponentResult == "scissors" && selectedVal == "scissors") {
			info.setText("It's a draw. You both choose scissors!");
			info.setVisible(true);
			return;
		}

	}
	
	void reset() {
		resetBtn.setText("Start");
		gameEnded = false;
		selectedVal = null;
		info.setText("");
		info.setVisible(true);
	}
	
	String getOponentChoice() {
		int randomNumber = (int) (Math.random() * 3);
		return oponentChoices[randomNumber];
	}

}
