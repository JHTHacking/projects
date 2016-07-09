package main;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {
		final JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setVisible(true);
		final JPanel content = new JPanel();
		content.setVisible(true);
		content.setSize(frame.getWidth(), frame.getHeight());
		final JTextField name = new JTextField("Your name!");
		final JTextField host = new JTextField("Host/IP (by default localhost)");
		JButton button = new JButton("Launch!");
		button.setBounds(new Rectangle(400, 100));
		final JLabel lbl = new JLabel("");
		button.setSize(400, 100);
		content.add(name);
		content.add(button);
		content.add(lbl);
		content.add(host);
		frame.setTitle("Launcher");
		frame.setContentPane(content);
		content.validate();
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent args) {
				System.out.println("Name: "+name.getText());
				if(!name.getText().isEmpty()){
					frame.setEnabled(false);
					frame.setVisible(false);

					Ventana v = new Ventana(name.getText(),host.getText());
					v.setEnabled(true);

				}else{
					lbl.setText("Please do enter your name!");
					content.validate();
				}

			}
		});

	}

}
