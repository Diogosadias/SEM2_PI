package app.ui.console;

import app.controller.ParameterCategoryController;

/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */

public class ListParameterCategoryUI implements Runnable{

    public void run() {
        ParameterCategoryController pc = new ParameterCategoryController();
        pc.writeParameterCategories();
    }
}
