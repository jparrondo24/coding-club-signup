
import java.util.Scanner;

/**
 *
 * @author 19279
 */
public class signup {
    public static void main(String[] args) {
        System.out.println("Welcome to Coding Club Signup!");
	    MySQLAccess dataBase = new MySQLAccess();
        System.out.println();
        System.out.println();
        while (true) {
            Scanner fNameScan = new Scanner(System.in);
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.print("Enter First Name: ");
            String fName = capitalizeFirstName(fNameScan.next());

            if (fName.equals("exit")) {
                dataBase.closeConnection();
                System.exit(0);
            }

            Scanner lNameScan = new Scanner(System.in);
            System.out.print("Enter Last Name: ");
            String lName = capitalizeLastName(lNameScan.nextLine());
            
            Scanner emailScan = new Scanner(System.in);
            String email = promptEmail(emailScan, 0);
            int id = extractId(email);
            System.out.println();
            System.out.println("Is this correct? [yes/no]");
            System.out.println(fName + " " + lName + "\t" + email);
            System.out.println();
            Scanner answerScan = new Scanner(System.in);
            String answer = answerScan.next();
            if (!answer.toLowerCase().equals("yes")) {
                continue;
            } else {
                dataBase.addUser(id, String.format("%s %s", fName, lName), email);
                System.out.println();
                System.out.println("Thank you for signing up " + fName + "!");
                System.out.println("------------------------------------------------------------");
            }
        }
    }
    public static String capitalizeFirstName(String fName) {
        String word = fName.substring(0, 1).toUpperCase() + fName.substring(1).toLowerCase();
        
        return word;
    }
    
    public static String capitalizeLastName(String lName) {
        String[] words = lName.split(" ");
        for (int i = 0; i < words.length;i++){
            words[i] = words[i].substring(0,1).toUpperCase()
                       + words[i].substring(1).toLowerCase();
        }
        return String.join(" ", words);
    }
    
    public static boolean isValidColumbushsEmail(String email) {
        // TODO: Return meaningful response
        String[] s = email.split("@");
        if (s.length != 2 ) {
            System.out.println("Invalid email. Try again.");
            return false;
        }
        if (!s[1].equals("columbushs.com")){
            return false;
        }
        
        if(!s[0].matches("^[a-z0-9-]+$")){
            System.out.println("Invalid email. Try again.");
            return false;
        }
        return true;
    }
    public static int extractId(String e) {
        int id;
        String strId;
        char idCells[] = {0, 0, 0, 0, 0};
        for (int i = 0; i < e.length(); i++) {
            if (e.charAt(i) >= '0' && e.charAt(i) <= '9') {
                for (int j = 0; j < 5; j++) {
                    idCells[j] = e.charAt(i + j);
                }
                break;
            }
        }
        strId = new String(idCells);
        id = Integer.parseInt(strId);
        return id;
    }
    public static String promptEmail(Scanner sc, int i) {
        String email = "";
        if (i < 1) {
            System.out.print("Enter Columbus email: ");
            email = sc.next();
            if (!isValidColumbushsEmail(email)) {
                return promptEmail(sc, i + 1);
            } else {
                return email;
            }
        } else {
            System.out.print("Use columbushs email!: ");
            email = sc.next();
            if (!isValidColumbushsEmail(email)) {
                return promptEmail(sc, i + 1);
            } else {
                return email;
            }
        }
    }
}
