package app.ui.console;

import app.controller.ParameterCategoryController;

import java.util.List;

public class ListParameterCategoryUI implements Runnable{

    public ListParameterCategoryUI(){

    }
    public void run() {
        ParameterCategoryController pc = new ParameterCategoryController();
        pc.writeParameters();
    }
}
