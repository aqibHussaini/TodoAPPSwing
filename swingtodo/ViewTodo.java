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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bhatti
 */
public class ViewTodo extends JFrame implements ActionListener  {
    JButton back;
    JTable table;
    DefaultTableModel dtm;

    public ViewTodo()throws Exception{
        this.setBounds(0, 0, 900, 600);
        this.setDefaultCloseOperation(3);
        this.setLayout(new BorderLayout());
         back =new JButton("Back");
        back.setFont(new Font("lato", Font.BOLD, 30));
        back.setBounds(100, 480, 200, 70);
        back.setBackground(new Color(252, 65, 54));
        back.setForeground(Color.white);
        
        String t_head[] = {"Id", "T_name", "T_description", "Time", "Status"};
        dtm = new DefaultTableModel(t_head, 0);
        
        List<Todo> todolist=TodoDao.select();
        for(Todo o:todolist)
        {
            SimpleDateFormat sdf=new SimpleDateFormat("yy/mm/dd hh:mm:ss");
            String date=sdf.format(o.getTime());
            String data[]={""+o.getId(),o.getName(),o.getDescription(),date,o.getStatus()};
            dtm.addRow(data);
        }
        table = new JTable(dtm);
        // setting table header decoration
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(new Color(32, 136, 203));
        table.getTableHeader().setForeground(new Color(255, 255, 255));
        table.setRowHeight(30);
        // table body decoration
        table.setRowHeight(35);
        table.getTableHeader().setFont(new Font("Segoe", Font.BOLD, 14));
        table.setFont(new Font("poppins", Font.BOLD, 14));
        JScrollPane jsp = new JScrollPane(table);
        this.add(jsp, BorderLayout.CENTER);
        this.add(back, BorderLayout.SOUTH);
        this.setVisible(true);
        back.addActionListener(this);
      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==back)
{
    this.setVisible(false);
    new Home();
}
    }

    
}
