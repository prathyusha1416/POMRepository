package tests;

import java.sql.*;


public class hardcode {
    public static void main(String[] args) {
        String url = "jdbc\\:sqlserver\\://192.168.0.179\\\\MSSQLSERVER;databaseName\\=prosertech1Latest;encrypt=true;trustServerCertificate=true;";
        String user ="sa";
        String pass = "Tek@123";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            System.out.println("✅ Connected successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

