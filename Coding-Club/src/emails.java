import java.util.Arrays;
import java.io.FileWriter;

public class emails {
    public static void main(String[] args) {
        MySQLAccess sql = new MySQLAccess();
        String emails[] = sql.getEmails();
        try {
            FileWriter fw = new FileWriter("out.txt");

            for (int i = 0; i < emails.length; i++) {
                fw.write(emails[i] + "\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println("Something with FileWriter went wrong");
            System.out.println(e.toString());
        }
        sql.closeConnection();
    }
}