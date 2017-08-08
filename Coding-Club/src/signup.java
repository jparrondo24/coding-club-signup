/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 19279
 */
public class signup {
    public static void main(String[] args) {
        System.out.println("Welcome to Coding Club Signup");
        System.out.println(capitalizeLastName("MY NAME IS JEFF"));
    }
    public static String capitalizeFirstName(String fName) {
        // TODO: Return meaningful response
        
        return "Justin";
    }
    
    public static String capitalizeLastName(String lName) {
        // TODO: Return meaningful response
        String[] words = lName.split(" ");
        for (int i = 0; i < words.length;i++){
            words[i] = words[i].substring(0,1).toUpperCase() + words[i].substring(1).toLowerCase();
        }
        return String.join(" ", words);
    }
    
    public static boolean isValidColumbushsEmail(String email) {
        // TODO: Return meaningful response
        
        return true;
    }
    
    public static void prompt(){
        // TODO: Put prompt and logic in this function
    }
    
    public static void submitInformation(String fName, String lName, String email) {
        
    }
}
