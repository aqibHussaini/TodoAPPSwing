/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.TodoPojo.Todo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bhatti
 */
public class TodoDao {

    public static int Save(Todo obj) throws Exception
    {
        String sql = "insert into `todo`(`name`,`description`,`status`) values (?,?,?)";
        int i = 0;
        Connection con = getConnection.getConn();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, obj.getName());
        ps.setString(2, obj.getDescription());
        ps.setString(3, "pending");
        i = ps.executeUpdate();
        return i;
    }
     public static Todo Search(int id) throws Exception
    {
          String sql = "SELECT * FROM `todo` where id = "+id;
        Todo t=new Todo();
        Connection con = getConnection.getConn();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.next();
             t.setId(rs.getInt("id"));
            t.setName(rs.getString("name"));
            t.setDescription(rs.getString("description"));
            t.setStatus(rs.getString("status"));
            t.setTime(rs.getTimestamp("time"));
        return t;
    }
    public static int Update(int id,String status) throws Exception
    {
        String sql = "UPDATE `todo` SET `status`=? WHERE  `id` = "+id;
        int i = 0;
        Connection con = getConnection.getConn();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, status);
        i = ps.executeUpdate();
        return i;
    }
    public static int Delete(int id) throws Exception
    {
        String sql = "delete * `todo` where `id` = "+id ;
        int i = 0;
        Connection con = getConnection.getConn();
        PreparedStatement ps = con.prepareStatement(sql);
        i = ps.executeUpdate();
        return i;
    }
    public static List<Todo> select() throws Exception 
    {
        String sql = "SELECT * FROM `todo`";
        List<Todo> list = new ArrayList<Todo>();
        Connection con = getConnection.getConn();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Todo t = new Todo();
            t.setId(rs.getInt("id"));
            t.setName(rs.getString("name"));
            t.setDescription(rs.getString("description"));
            t.setStatus(rs.getString("status"));
            t.setTime(rs.getTimestamp("time"));
            list.add(t);
        }
        return list;
    }
}
