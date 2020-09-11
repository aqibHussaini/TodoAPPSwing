/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingtodo;

import com.dao.TodoDao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Home extends JFrame implements ActionListener {

    JLabel main, header, home;
    JButton add, view, delete, update;
    JPanel sidebar, h_cont, center;

    public Home() {
        this.setBounds(200, 100, 900, 700);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        main = new JLabel();
        main.setLayout(null);
        // h_cont
        h_cont = new JPanel(null);
        h_cont.setBounds(250, 0, 645, 100);
        h_cont.setBackground(new Color(137, 208, 226, 90));
        //   center
        center = new JPanel();
        center.setLayout(null);
        center.setBounds(250, 100, 645, 600);
        center.setBackground(new Color(67, 108, 208, 90));
        // sidebar
        sidebar = new JPanel();
        sidebar.setLayout(null);
        add = new JButton("Add Todo");
        home = new JLabel("Home");
        update = new JButton("update");
        view = new JButton("View Todo");
        delete = new JButton("Delete Todo");
        sidebar.add(add);
        sidebar.add(view);
        sidebar.add(delete);
        sidebar.add(update);
        sidebar.add(home);
        this.add(main);
        main.add(sidebar);
        // header 
        header = new JLabel("ToDo Application...");
        header.setFont(new Font("lato", Font.BOLD, 30));
        add.setFont(new Font("lato", Font.BOLD, 25));
        home.setFont(new Font("lato", Font.BOLD, 25));
        view.setFont(new Font("lato", Font.BOLD, 25));
        update.setFont(new Font("lato", Font.BOLD, 25));
        delete.setFont(new Font("lato", Font.BOLD, 25));
        add.setHorizontalAlignment(SwingConstants.CENTER);
        home.setHorizontalAlignment(SwingConstants.CENTER);
        view.setHorizontalAlignment(SwingConstants.CENTER);
        update.setHorizontalAlignment(SwingConstants.CENTER);
        delete.setHorizontalAlignment(SwingConstants.CENTER);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        sidebar.setBackground(new Color(252, 65, 54));
        sidebar.setBounds(0, 0, 250, 700);
        add.setBounds(20, 150, 200, 70);
        home.setBounds(20, 50, 200, 70);
        view.setBounds(20, 250, 200, 70);
        delete.setBounds(20, 350, 200, 70);
        update.setBounds(20, 450, 200, 70);
        header.setBounds(250, 0, 300, 80);
        header.setForeground(Color.BLUE);
        add.setForeground(Color.white);
        home.setForeground(Color.white);
        add.setForeground(Color.white);
        view.setForeground(Color.white);
        update.setForeground(Color.white);
        delete.setForeground(Color.white);
        add.setBackground(new Color(252, 65, 54));
        view.setBackground(new Color(252, 65, 54));
        update.setBackground(new Color(252, 65, 54));
        delete.setBackground(new Color(252, 65, 54));
        add.addActionListener(this);
        view.addActionListener(this);
        update.addActionListener(this);
        delete.addActionListener(this);
        h_cont.add(header);
        main.add(h_cont);
        main.add(center);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            this.setVisible(false);
            new TodoForm();
        } else if (e.getSource() == view) {
            try {
                this.setVisible(false);
                new ViewTodo();

            } catch (Exception ex) {

            }
        } else if (e.getSource() == update) {
            JTextField IDjtf;
            try {
                Dialog d = new Dialog(this, "this is a Update Dialog");
                d.setLayout(new GridLayout(2, 2));
                d.setSize(800, 600);
                JLabel heading = new JLabel("Enter ID...");
                heading.setForeground(Color.BLACK);
                heading.setFont(new Font("lato", Font.BOLD, 25));
                heading.setHorizontalAlignment(SwingConstants.CENTER);
                IDjtf = new JTextField();
                IDjtf.setFont(new Font("lato", Font.BOLD, 25));
                IDjtf.setBackground(Color.white);
                JButton Load = new JButton("Load Data");
                Load.setFont(new Font("lato", Font.BOLD, 30));
                Load.setForeground(Color.white);
                Load.setBackground(new Color(26, 160, 96));
                Load.setForeground(Color.white);
                JButton Back = new JButton("Back");
                Back.setFont(new Font("lato", Font.BOLD, 30));
                Back.setBackground(new Color(26, 160, 96));
                Back.setForeground(Color.white);
                d.add(heading);
                d.add(IDjtf);
                d.add(Back);
                d.add(Load);
                d.setVisible(true);
                Load.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       int id= Integer.parseInt(IDjtf.getText());
                        try {
                            new  Update(id);
                        } catch (Exception ex) {
                        }
                   }
                });
            } catch (Exception ex) {

            }
        } else if (e.getSource() == delete) {
            this.setVisible(false);
            JButton back = new JButton("Back");
            JButton delete = new JButton("Delete");
            JLabel id = new JLabel("Enter ID..");
            JTextField jtf = new JTextField();
            id.setBounds(10, 100, 200, 80);
            jtf.setBounds(240, 100, 300, 80);
            back.setBounds(40, 220, 200, 80);
            delete.setBounds(270, 220, 200, 80);
            id.setFont(new Font("lato", Font.BOLD, 40));
            jtf.setFont(new Font("lato", Font.BOLD, 40));
            back.setFont(new Font("lato", Font.BOLD, 40));
            delete.setFont(new Font("lato", Font.BOLD, 40));
            Dialog d = new Dialog(this, "this is a Delete Dialog");
            d.setVisible(true);
            d.setLayout(null);
            d.setSize(800, 600);
            d.setBackground(new Color(252, 65, 54));
            d.add(id);
            d.add(back);
            d.add(jtf);
            d.add(delete);
            id.setForeground(Color.WHITE);
            back.setBackground(new Color(252, 65, 54));
            back.setForeground(Color.WHITE);
            delete.setBackground(new Color(252, 65, 54));
            delete.setForeground(Color.WHITE);
            back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    d.setVisible(false);
                    new Home();
                }
            });

            delete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String text = jtf.getText();
                    int id, i = -999;
                    if (text.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please enter ID.........");
                    } else if (text.startsWith("ab") || text.startsWith("AB") || text.startsWith("@")) {
                        JOptionPane.showMessageDialog(null, "Please enter ID in integer form.........");
                    } else {
                        id = Integer.parseInt(text);
                        if (id > 0) {
                            try {
                                i = TodoDao.Delete(id);
                            } catch (Exception exception) {
                            }
                            if (i == 1) {
                                JOptionPane.showMessageDialog(null, "Data deleted");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter ID in integer form.........");
                        }
                    }
                }
            });
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
