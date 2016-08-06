import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.System;
/**
 * Instant Insanity content using JPanel. 
 * Adds buttons and labels to the screen.
 * Interface for cube color combination input and solution output.
 * @author Rachel Naidich
 */
public class CubePanel extends JPanel
{
   private JLabel label;
   public int[][] cubeColor = new int[4][6];
   private JButton[] button = new JButton[6];
   private Color[] colors = new Color[]{Color.red, Color.blue, Color.green, Color.white};
   public static String[][] solution = new String[4][6];
   private int snum = 0;
   
   private int cubeNum = 1;
   /**
   * Constructs Instant Insanity screen.
   * Adds buttons and labels.
   * Has buttons to input colors of 4 cube combinations.
   * Displays color combination solution output for 4 cubes.
   */
   public CubePanel()
   {
      try {
         UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   
   
      JPanel p = new JPanel(new GridLayout(0, 3));
      JPanel c1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
      JPanel c2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
      JPanel c3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
      JPanel c4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
      setLayout(new GridLayout(0,1));
      
      label = new JLabel("Cube 1");
      label.setFont(new Font("Serif", Font.BOLD, 15));
      label.setForeground(Color.blue);
      p.add(label);
      
      JButton next = new JButton("Next");
      next.addActionListener(new Listener1());
      next.setOpaque(true);
      p.add(next);
      
      JButton quit = new JButton("Quit");
      quit.addActionListener(new Listener3());
      quit.setOpaque(true);
      p.add(quit);
      
      for(int y = 0; y<4; y++){
         for(int x = 0; x<6; x++){
            cubeColor[y][x] = 0;
         }  
      }    
      for(int x = 0; x<6; x++)
      {
         button[x] = new JButton();
         button[x].setFont(new Font("Serif", Font.PLAIN, 15));
         button[x].setBackground(Color.red);
         button[x].setPreferredSize(new Dimension(90,90));
         button[x].addActionListener(new Listener2());
         button[x].setOpaque(true);
      }
      button[0].setText("back");
      button[1].setText("left");
      button[2].setText("top");
      button[3].setText("right");
      button[4].setText("front");
      button[5].setText("bottom");
      
      c1.add(button[0]);
      c2.add(button[1]);
      c2.add(button[2]);
      c2.add(button[3]);
      c3.add(button[4]);
      c4.add(button[5]);
      add(p);
      add(c1);
      add(c2);
      add(c3);
      add(c4);
      
   }
   /**
   * Class Listener1, which is connected to the next button.
   */
   private class Listener1 implements ActionListener
   {
      /**
      * Goes to the next Cube or the next solution when next is pressed.
      */
      public void actionPerformed(ActionEvent e)
      {
         if(cubeNum<4){
            cubeNum++;
            label.setText("Cube " + cubeNum);
            for(int x=0; x<6; x++){
               button[x].setBackground(Color.red);
            }
         }
         else{
            Puzzler.solve(cubeColor);
            if(snum < 4){
               for(int x=0;x<6;x++){
                  if(solution[snum][x] == "R"){
                     button[x].setBackground(Color.red);
                  }
                  else if(solution[snum][x] == "B"){
                     button[x].setBackground(Color.blue);
                  }
                  else if(solution[snum][x] == "G"){
                     button[x].setBackground(Color.green);
                  }
                  else{
                     button[x].setBackground(Color.white);
                  }
               }
               snum++;
               label.setText("Solution Cube " + snum);
               
            }
            //solve();
         }
         
      }
   }
   /**
   * Class Listener2, which is connected to the cube buttons.
   */
   private class Listener2 implements ActionListener
   {
      /**
      * Changes the color of the cube face when clicked.
      */
      public void actionPerformed(ActionEvent e)
      {
         
         for(int y = 0; y<6; y++){
            if(e.getSource() == button[y]){
              
               if(cubeColor[cubeNum-1][y]<3)
                  cubeColor[cubeNum-1][y]++;
               else
                  cubeColor[cubeNum-1][y] = 0;
               button[y].setBackground(colors[cubeColor[cubeNum-1][y]]);
            }
         }
         
      }
   }
   /**
   * Class Listener3, which is connected to the quit button.
   */
   private class Listener3 implements ActionListener
   {
      /**
      * Exits the program.
      */
      public void actionPerformed(ActionEvent e)
      {
         System.exit(0);
      }
   }
}