/**
 *
 * @author 19279
 */
public class signup {
    public static void main(String[] args) {
        System.out.println("Welcome to Coding Club Signup");
        System.out.println(capitalizeFirstName("FULANO"));
        System.out.println(capitalizeLastName("DE TAL"));
        System.out.println(isValidColumbushsEmail("d1@gmail.com"));
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
            System.out.println("Use columbushs email!");
            return false;
        }
        
        if(!s[0].matches("^[a-z0-9]+$")){
            System.out.println("Invalid email. Try again.");
            return false;
        }
        return true;
    }
    
    public static void prompt(){
        // TODO: Put prompt and logic in this function
    }
    
    public static void submitInformation(String fName, String lName, String email) {
        
    }
}
