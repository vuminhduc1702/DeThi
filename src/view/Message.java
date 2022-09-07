package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Message {

	public static void getMessage(String mess) {
		JOptionPane.showMessageDialog(new JFrame(), mess, "Dialog", JOptionPane.ERROR_MESSAGE);
	}
}
