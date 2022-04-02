package com.example.resttwo.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

  public Connection getConnection() {
    Connection con = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      String url = System.getenv("JDBC_DATABASE_URL") != null ? System.getenv("JDBC_DATABASE_URL") : "jdbc:mysql://localhost:3306/productDB";
      String user = System.getenv("JDBC_DATABASE_USERNAME") != null ? System.getenv("JDBC_DATABASE_USERNAME") : "root";
      String password = System.getenv("JDBC_DATABASE_PASSWORD") != null ? System.getenv("JDBC_DATABASE_PASSWORD") : "mysespw";
      con = DriverManager.getConnection(url, user, password);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return con;
  }

}
