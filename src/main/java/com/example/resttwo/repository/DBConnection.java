package com.example.resttwo.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

  public Connection getConnection() {
    Connection con = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");

      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productDB", "root", "mysespw");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return con;
  }

}
