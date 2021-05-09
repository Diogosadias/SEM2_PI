package app.domain.shared;

public class GeneratePassword {
    public static String makerandompass(){
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
