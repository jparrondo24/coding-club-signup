import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ArrayList;

public class MySQLAccess {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/signup";

    static final String USER = "root";
    static final String PASS = "Danjus17";

    static Connection conn = null;
    static Statement stmt = null;
    public MySQLAccess() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }
    public void addUser(int id, String name, String email) {
        try {
            stmt = conn.createStatement();
        } catch (Exception e) {
            System.out.println("Couldn't create statement");
        }
        String sql = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";
        // System.out.println(sql);
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, email);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Couldn't do the statement");
            System.out.println(e.toString());
        }
    }
    public void closeConnection() {
        try {
            if (stmt != null)
                stmt.close();
        } catch (SQLException se2) {

        }// nothing we can do
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    public String[] getEmails() {
        ArrayList<String> emailList = new ArrayList<String>();
        String sql = "SELECT email FROM users";
        try {
            Statement emailStatement = conn.createStatement();
            // System.out.println("Created statement");
            emailStatement.executeQuery(sql);
            // System.out.println("Executed query");
            ResultSet rs = emailStatement.getResultSet();
            // System.out.println("Got result set");
            while (rs.next()) {
                emailList.add(rs.getString("email"));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        String[] emails = new String[emailList.size()];
        for (int i = 0; i < emails.length; i++) {
            emails[i] = emailList.get(i);
        }

        return emails;
    }
}
