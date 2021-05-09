package app.domain.shared;

/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class GeneratePassword {
    public static String makeRandomPass(){
        String password = "";
        for(int i= 0; i<10; i++){
            password = password+randomCharacter("abcdefghijklmnopqrstuvwxyz0123456789");
        }
        return password;
    }
    public static String randomCharacter(String chars){
        int length = chars.length();
        int position = (int)(length*Math.random());
        return chars.substring(position,position+1);
    }
}
