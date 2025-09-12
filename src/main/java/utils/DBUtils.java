package utils;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {

    private static Connection connection;

    // Connect to DB
    public static void connectDB(String url, String username, String password) throws Exception {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("DB Connected Successfully");
        }
    }

 // Fetch ALL credentials from DB
    public static List<Map<String, String>> getAllCredentials(String query) throws Exception {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        List<Map<String, String>> credentialsList = new ArrayList<>();

        while (rs.next()) {
            Map<String, String> record = new HashMap<>();
            record.put("username", rs.getString("UserName"));

            // If password is Base64 encoded -> decode it
            String encryptedPwd = rs.getString("Pwd");
            String decryptedPwd = CryptoUtils.base64Decode(encryptedPwd); // Or decryptAesBase64 if AES

            record.put("password", decryptedPwd);

            credentialsList.add(record);
        }
        rs.close();
        stmt.close();
        return credentialsList;
    }
    public class CryptoUtils {

        // If the DB only stores Base64 of the plain password
        public static String base64Decode(String base64Encoded) {
            if (base64Encoded == null) return null;
            byte[] decoded = Base64.getDecoder().decode(base64Encoded);
            return new String(decoded, StandardCharsets.UTF_8);
        }
    }    
    // Execute any query
    public static ResultSet executeQuery(String query) throws Exception {
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(query);
    }

    // Close DB Connection
    public static void closeDB() throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("DB Connection Closed");
        }
    }
}
