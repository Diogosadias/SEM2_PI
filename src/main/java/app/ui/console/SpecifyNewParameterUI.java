package app.ui.console;

import java.util.Scanner;

public class SpecifyNewParameterUI implements Runnable{
    public SpecifyNewParameterUI() {

    }
    public void run(){

        String code;
        String name;
        String description;
        String categoryselect;

        Scanner read = new Scanner(System.in);
        do {
            System.out.println("New code (5 alphanumeric characters): ");
            code = read.next();
        }while(code.length()>5|| code.equals(null));
        do {
            System.out.println("Name (max. 8 characters): ");
            name = read.next();
        }while(name.length()>5 || name.equals(null));
        do {
            System.out.println("Description (max. 20 characters): ");
            description = read.next();
        }while(description.length()>20 ||name.equals(null));

        //fazer trim() dos nomes, e tambem verificar se name tem numeros ou se code tem caracteres especiais....(extras)

        System.out.println("Select parameter category: ");

        //listar categorias e ler qual categoria selecionada...

        System.out.print("\n->");
        categoryselect = read.next();


    }
}
