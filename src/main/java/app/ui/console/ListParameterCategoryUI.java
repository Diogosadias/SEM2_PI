package app.ui.console;

import app.controller.ParameterCategoryController;

import java.util.List;

/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class ListParameterCategoryUI implements Runnable{

    public ListParameterCategoryUI(){

    }
    public void run() {
        ParameterCategoryController pc = new ParameterCategoryController();
        pc.writeParameterCategories();
    }
}
