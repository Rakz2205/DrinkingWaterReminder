import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Insets;
import java.awt.Toolkit;

import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;



import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class PopUpUsingJFrame {

      static JFrame frame = new JFrame();;

      public static void main(String[] args) throws AWTException {
            // TODO Auto-generated method stub

            int MINUTES = 60; // The delay in minutes
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                  @Override
                  public void run() { // Function runs every MINUTES minutes.
                        // Run the code you want here
                        try {
                              displayPopUp();
                              Thread.sleep(5000); // time after which pop up will be disappeared.
                              System.exit(0);
                              //frame.dispose();
                        } catch (AWTException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                        } catch (InterruptedException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
                        }
                  }
            }, 0, 1000 * 30 * MINUTES);

      }

      public static void displayPopUp() throws AWTException {
            String message = "Your mind and body will thank you later.<br> I will be back in an hour";
            //String header = "Reminder for Drinking Water ";
            frame = new JFrame();
            frame.setSize(350,165);
            frame.setUndecorated(true);
            frame.setLayout(new GridBagLayout());
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.weightx = 1.0f;
            constraints.weighty = 1.0f;
            constraints.insets = new Insets(5,5,5,5);
            constraints.fill = GridBagConstraints.BOTH;
            // ImageIcon headingIcon = new
            // ImageIcon(PopUpUsingJFrame.class.getResource("Water.png"));
            JLabel headingLabel = new JLabel("");
            /*BufferedImage img = null;
            try {
                  img = ImageIO.read(PopUpUsingJFrame.class.getResource("Water.png"));

            } catch (IOException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
            }
            */
            //Image dimg = img.getScaledInstance(60, 70, Image.SCALE_SMOOTH);
            
            URL url=PopUpUsingJFrame.class.getResource("DrinkWater.gif");
            ImageIcon headingIcon = new ImageIcon(url);
            headingLabel.setFont(new Font("Serif", Font.ITALIC, 22));
            headingLabel.setIcon(headingIcon); // --- use image icon you want to be as heading image.
            headingLabel.setOpaque(false);
            frame.add(headingLabel, constraints);
            constraints.gridx++;
            constraints.weightx = 0f;
            constraints.weighty = 0f;
            constraints.fill = GridBagConstraints.NONE;
            constraints.anchor = GridBagConstraints.NORTH;

            
            // JButton closeButton = new JButton(new AbstractAction("X") {
            /**
                  * 
                  */
                        // private static final long serialVersionUID = 1L;
                          
                         // public void actionPerformed(final ActionEvent e) 
                          {
                              // System.exit(0); //frame.dispose();
                          } 
                          //}); frame.add(closeButton, constraints);
                        
            constraints.gridx = 0;
            constraints.gridy++;
            constraints.weightx = 1.0f;
            constraints.weighty = 1.0f;
            constraints.insets = new Insets(5, 5, 5, 5);
            constraints.fill = GridBagConstraints.BOTH;
            JLabel messageLabel = new JLabel("<HtMl>" + message);
            messageLabel.setFont(new Font("Serif", Font.BOLD, 20));
            frame.add(messageLabel, constraints);
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            frame.setVisible(true);
            frame.setAlwaysOnTop(true);
            Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();// size of the screen
            Insets toolHeight = Toolkit.getDefaultToolkit().getScreenInsets(frame.getGraphicsConfiguration());// height of
                                                                                                                                                                  // the task
                                                                                                                                                                  // bar
            frame.setLocation(scrSize.width - frame.getWidth(), scrSize.height - toolHeight.bottom - frame.getHeight());

      }
}
