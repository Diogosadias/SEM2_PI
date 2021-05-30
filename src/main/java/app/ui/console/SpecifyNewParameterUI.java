package app.ui.console;

import app.controller.ParameterCategoryController;
import app.controller.ParameterController;
import app.domain.model.ParameterCategory;

import java.util.Scanner;

/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */

public class SpecifyNewParameterUI implements Runnable{

    public void run() {

        String code;
        String name;
        String description;
        String categoryselect;

        Scanner read = new Scanner(System.in);
        do {
            System.out.println("New code (5 alphanumeric characters): ");
            code = read.next().trim();
        } while (code.length() != 5);
        read.nextLine();
        do {
            System.out.println("Name (max. 8 characters): ");
            name = read.nextLine().trim();
        } while (name.length() > 8);
        do {
            System.out.println("Description (max. 20 characters): ");
            description = read.nextLine().trim();
        } while (description.length() > 20);

        //fazer trim() dos nomes, e tambem verificar se name tem numeros ou se code tem caracteres especiais....(extras)
        ParameterCategory codeparameter;
        do {
            System.out.println("\nSelect parameter category: ");
            ParameterCategoryController pcc = new ParameterCategoryController();
            pcc.writeParameterCategories();


            System.out.print("\n->");
            categoryselect = read.next();

            codeparameter = pcc.getParameterCategory(categoryselect);
            if (codeparameter == null) {
                System.out.println("Parameter category doesn't exist!");
            }
        }while(codeparameter==null);
        ParameterController p = new ParameterController();
        boolean created = p.createParameter(code, name, description, categoryselect);

        if (created) {
            System.out.println("Parameter Created!");
        } else {
            System.out.println("Unsuccesfully created the Parameter");
        }

    }
}
