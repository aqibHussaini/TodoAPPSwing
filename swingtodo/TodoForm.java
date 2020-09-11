/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingtodo;

import com.TodoPojo.Todo;
import com.dao.TodoDao;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Bhatti
 */
public class TodoForm extends JFrame implements ActionListener {

    JTextField todo_Name;
    JTextArea todo_Description;
    JLabel todo_NameL, todo_DescriptionL, main, pic, heading;
    JPanel form;
    JButton save,back;
    public TodoForm() {
        this.setBounds(220, 100, 1200, 700);
        this.setDefaultCloseOperation(3);
        this.setTitle("MyTodo Form");
        this.setLayout(null);
        main = new JLabel();
        main.setBounds(0, 0, 1200, 700);
        this.add(main);
        pic = new JLabel();
        pic.setBounds(0, 0, 600, 700);
        this.add(pic);
        form = new JPanel(null);
        form.setBounds(600, 0, 600, 700);
        form.setBackground(new Color(252, 65, 54));
        this.add(form);
        // labels....
        heading = new JLabel("Todo Form");
        heading.setFont(new Font("lato", Font.BOLD, 25));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setBounds(200, 20, 200, 70);
        heading.setForeground(Color.WHITE);
         form.add(heading);
        todo_NameL = new JLabel("Todo Name ");
        todo_NameL.setFont(new Font("lato", Font.BOLD, 25));
        todo_NameL.setHorizontalAlignment(SwingConstants.CENTER);
        todo_NameL.setBounds(40, 120, 200, 40);
        todo_NameL.setForeground(Color.WHITE);
        form.add(todo_NameL);
        todo_DescriptionL = new JLabel("Todo Description ");
        todo_DescriptionL.setFont(new Font("lato", Font.BOLD, 25));
        todo_DescriptionL.setHorizontalAlignment(SwingConstants.CENTER);
        todo_DescriptionL.setBounds(40, 220, 250, 70);
        todo_DescriptionL.setForeground(Color.WHITE);
        form.add(todo_DescriptionL);
       // textfileds
        todo_Name = new JTextField();
        todo_Name.setFont(new Font("lato", Font.BOLD, 25));
        todo_Name.setBounds(280, 120, 250, 40);
        todo_Name.setBackground(Color.white);
        form.add(todo_Name);
        todo_Description = new JTextArea();
        todo_Description.setFont(new Font("lato", Font.BOLD, 25));
        todo_Description.setBounds(280, 220, 250, 200);
        todo_Description.setBackground(Color.white);
        form.add(todo_Description);
        // button
        save=new JButton("Save");
        save.setFont(new Font("lato", Font.BOLD, 30));
        save.setBounds(320, 480, 200, 70);
        save.setBackground(new Color(252, 65, 54));
        save.setForeground(Color.white);
        form.add(save);
        back =new JButton("Back");
        back.setFont(new Font("lato", Font.BOLD, 30));
        back.setBounds(100, 480, 200, 70);
        back.setBackground(new Color(252, 65, 54));
        back.setForeground(Color.white);
        form.add(back);
        ImageIcon ii = new ImageIcon("C:\\Users\\Bhatti\\Documents\\NetBeansProjects\\mavenproject10\\SwingToDo\\src\\img\\img.jpg");
        Image i = ii.getImage();
        Image i1 = i.getScaledInstance(600, 700, Image.SCALE_SMOOTH);
        pic.setIcon(new ImageIcon(i1));
        main.add(pic);
        this.setVisible(true);
        back.addActionListener(this);
        save.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back)
        {
            this.setVisible(false);
            new Home();
        }
        else if(e.getSource()==save)
        {
           String T_description=todo_Description.getText();
           String T_name=todo_Name.getText();
          Todo obj=new Todo();
           obj.setName(T_name);
           obj.setDescription(T_description);
           try
           {
               int i=TodoDao.Save(obj);
               if(i==1)
               {
                   JOptionPane.showMessageDialog(null, "Todo Data saved.........");
               }
               else
               {
                    JOptionPane.showMessageDialog(null, "something went wrong....");
               }
           }
           catch(Exception exception)
           {
                JOptionPane.showMessageDialog(null, ""+exception.getMessage());
           }
          
           
        }
            
    }

    

}
