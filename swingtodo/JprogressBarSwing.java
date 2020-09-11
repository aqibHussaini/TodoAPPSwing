/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingtodo;
import javax.swing.*;
import java.awt.*;

public class JprogressBarSwing extends JFrame {
    static  JProgressBar  jpb;
    public JprogressBarSwing() {
     JFrame frame=new JFrame("This is a Loader....");
        frame.setSize(900,700);
        frame.setLocation(200,100);
        frame.getContentPane().setBackground(Color.decode("#334BB5"));
        frame.setLayout(null);
        frame.setDefaultCloseOperation(3);
        ImageIcon ii=new ImageIcon("C:\\Users\\Bhatti\\Documents\\NetBeansProjects\\mavenproject10\\SwingToDo\\src\\img\\woman-coding-on-computer-3861958.jpg");
        Image i=ii.getImage();
        Image i1=i.getScaledInstance(900,500,Image.SCALE_SMOOTH);
        JLabel jl=new JLabel();
        jl.setLayout(null);
        JLabel heading=new JLabel("My ToDo Application....");
        heading.setFont(new Font("lato",Font.BOLD,40));
        heading.setBounds(130,50,450,120);
        heading.setForeground(Color.BLACK);
        JLabel text=new JLabel("Loading...");
        jl.setIcon(new ImageIcon(i1));
        jl.add(heading);
        jpb =new JProgressBar(0,200);
        jpb.setValue(0);
        jpb.setForeground(Color.RED);
        jpb.setBorderPainted(true);
        frame.add(jpb);
        frame.add(text);
        frame.add(jl);
        text.setFont(new Font("san-serif",Font.BOLD,50));
        text.setBounds(320,520,300,70);
        text.setForeground(Color.WHITE);
        jl.setBounds(0,0,900,500);
        jpb.setBounds(0,501,900,9);
        frame.setVisible(true);
        setValue();
        frame.setDefaultCloseOperation(3);
        frame.setVisible(false);
        new Home();
    }
    
  
public  void setValue()
{
    int i=0;
    while(i<=200)
    {
        jpb.setValue(i);
        try
        {
            Thread.sleep(200);
        }
        catch (Exception e)
        {

        }

        i+=20;
    }
}
}
