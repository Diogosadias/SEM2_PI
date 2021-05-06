package app.ui.console;

import app.controller.ParameterCategoryController;
import app.controller.ParameterController;
import app.domain.model.Parameter;

import java.util.Scanner;

/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
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
            code = read.next().trim();
        }while(code.length()>5|| code.equals(null));
        do {
            System.out.println("Name (max. 8 characters): ");
            name = read.next().trim();
        }while(name.length()>5 || name.equals(null));
        do {
            System.out.println("Description (max. 20 characters): ");
            description = read.next().trim();
        }while(description.length()>20 ||name.equals(null));

        //fazer trim() dos nomes, e tambem verificar se name tem numeros ou se code tem caracteres especiais....(extras)


        System.out.println("\nSelect parameter category: ");
        ParameterCategoryController pc = new ParameterCategoryController();
        pc.writeParameterCategories();


        System.out.print("\n->");
        categoryselect = read.next();

        ParameterController p = new ParameterController();
        boolean created = p.createParameter(code,name,description,categoryselect);

        if(created){
            System.out.println("Parameter Created!");
        }
        else {
            System.out.println("Unsuccesfully created the Parameter");
        }
    }
}
