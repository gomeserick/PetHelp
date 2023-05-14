package com.example.pethelp.sql;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlSetup {

    private static final String USER = "root";
    private static final String PASSWORD = "";
    private Connection connection = null;

    public MySqlSetup(){

        Connection conn = null;

        String url = "jdbc:mysql://192.168.0.105:3306/pethelpdatabase";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,USER,PASSWORD);
            Log.d("Mysql", "Conectado");
        } catch (Exception e){
            e.printStackTrace();
            Log.d("Mysql","Não Conectado");
        }
        Log.d("Mysql", "Teste");
        connection = conn;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
