package app.ui.console;

import app.controller.ParameterController;

public class ListParametersUI implements Runnable{
    public ListParametersUI(){

    }
    public void run() {
        ParameterController p = new ParameterController();
        p.writeParameters();
    }
}
