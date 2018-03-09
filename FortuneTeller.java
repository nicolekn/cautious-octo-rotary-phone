// This is the Fortune Teller applet

import java.awt.*;
import javax.swing.*;
import java.applet.AudioClip;
import java.net.*;
import java.io.IOException.*;

public class FortuneTeller extends JApplet
    implements ActionListener
 	
{
  // Declare an array of "fortunes" (strings):

   Image background;
  private JTextField display;
  private AudioClip ding;

  public void init()
  {
  	background = getImage(getCodeBase(), "fortunecookie,jpg");
    ding = getAudioClip(getDocumentBase(), "ding.wav");

    display = new JTextField("  Press \"Next\" to see your fortune...", 30);
    display.setBackground(Color.WHITE);
    display.setEditable(false);
    JButton go = new JButton("Next");
    go.addActionListener(this);
	go.setBackground(Color.GRAY);
	go.setFont(new Font("Courier", Font.BOLD, 18));
	go.setForeground(Color.WHITE);
    Container c = getContentPane();
    
    c.setLayout(new FlowLayout());
    c.add(display);
    c.add(go);
	c.setBackground(Color.BLACK);
 

};
  public String chooseFortune()
  {
  	String [] fortunes=
    {"A golden egg of opportunity falls into your lap this month."
    ,"All your hard work will soon pay off.",
    "Be careful or you could fall for some tricks today.",
    "Don’t worry; prosperity will knock on your door soon.",
    "It is worth reviewing some old lessons.",
    "Miles are covered one step at a time.",
    "People find it difficult to resist your persuasive manner.",
    "Resting well is as important as working hard.",
    "Success is a journey, not a destination.",
    "The best prediction of future is the past.",
    "Today, your mouth might be moving but no one is listening.",
    "You can’t steal second base and keep your foot on first.",
    "You will inherit a large sum of money."};
  	int num=(int)(Math.random()*13);
  	return fortunes[num];
  }

  public void actionPerformed(ActionEvent e)
  {
    ding.play();
    display.setText("  " + chooseFortune() );
  }
}
//fortunes from https://joshmadison.com/2008/04/20/fortune-cookie-fortunes/
