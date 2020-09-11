/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingtodo;

import com.TodoPojo.Todo;
import com.dao.TodoDao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Bhatti
 */
public class Update extends JFrame implements ActionListener {
   JLabel ID,Name,Description,Time;
    JComboBox<Object> jcb;
     Todo t;
    public Update(int id) throws Exception {
       t = TodoDao.Search(id);
        setBounds(0, 0, 500, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(3);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        JLabel heading = new JLabel("Update Todo");
        heading.setFont(new Font("lato", Font.BOLD, 25));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setBounds(200, 20, 200, 70);
        JPanel panel = new JPanel(new GridLayout(6, 1));
        panel.setBackground(new Color(252, 65, 54));
       ID  = new JLabel();
        ID.setText("" + t.getId());
        Name = new JLabel();
        Name.setText("Name : " + t.getName());
        Description = new JLabel();
        Description.setText("Description : " + t.getDescription());
         Time = new JLabel();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss yyyy/mm/dd");
        String time = sdf.format(t.getTime());
        Time.setText("Time : " + time);
         jcb=new JComboBox();
        if(t.getStatus().equals("pending")||t.getStatus().equals("Pending"))
        {
          jcb.addItem(t.getStatus());
          jcb.addItem("Done");   
        }
        else
        {
         jcb.addItem(t.getStatus());
        jcb.addItem("Pending");    
        }
       
        JButton update=new JButton("Update");
        ID.setFont(new Font("lato", Font.BOLD, 25));
        jcb.setFont(new Font("lato", Font.BOLD, 25));
        Name.setFont(new Font("lato", Font.BOLD, 25));
        Description.setFont(new Font("lato", Font.BOLD, 25));
        Time.setFont(new Font("lato", Font.BOLD, 25));
        ID.setHorizontalAlignment(SwingConstants.CENTER);
        update.setFont(new Font("lato", Font.BOLD, 25));
        update.setHorizontalAlignment(SwingConstants.CENTER);
        Name.setHorizontalAlignment(SwingConstants.CENTER);
        Description.setHorizontalAlignment(SwingConstants.CENTER);
        Time.setHorizontalAlignment(SwingConstants.CENTER);
        ID.setForeground(Color.white);
        Name.setForeground(Color.white);
        Description.setForeground(Color.white);
        Time.setForeground(Color.white);
        update.setForeground(Color.white);
        update.setBackground(new Color(252, 65, 54));
        panel.add(ID);
        panel.add(Name);
        panel.add(Description);
        panel.add(jcb);
        panel.add(Time);
        panel.add(update);
        add(heading, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        setVisible(true);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i=999;
               int id=Integer.parseInt(ID.getText());
                String status= (String) jcb.getSelectedItem();
                try
                {
                    
                i=TodoDao.Update(id,status);
                }
                catch(Exception ex)
                {
                    
                }
                if(i==1)
                JOptionPane.showMessageDialog(null, "Todo updated!");
                else
                   JOptionPane.showMessageDialog(null, "Ooops! Something went wrong...");    
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
}
