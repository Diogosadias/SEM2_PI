package app.domain.shared;

/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class GeneratePassword {
    /**
     *  Method to generate a random alphanumeric password
     * @return password - return the generated password
     */
    public static String makeRandomPass(){
        String password = "";
        for(int i= 0; i<10; i++){
            password = password+randomCharacter("abcdefghijklmnopqrstuvwxyz0123456789");
        }
        return password;
    }

    /**
     * Method to select a random character from a given string "chars".
     *
     * @param chars - recieves a string
     * @return a single character picked from the string
     */
    public static String randomCharacter(String chars){
        int length = chars.length();
        int position = (int)(length*Math.random());
        return chars.substring(position,position+1);
    }
}
