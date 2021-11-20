
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Wintest {
	public static void main(String[] args) {
		JPanel panel = new JPanel();
		JFrame frame = new JFrame("STEGANOGRAPHY PROJECT");
		frame.setSize(900, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		
		
		panel.setLayout(null);
		
		JLabel label = new JLabel("PROJET JAVA DAMODARANE training");
		label.setBounds(10,20,80,25);
		panel.add(label);
		frame.setVisible(true);
	}
}
