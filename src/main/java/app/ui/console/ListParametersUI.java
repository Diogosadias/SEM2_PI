package app.ui.console;

import app.controller.ParameterController;

/**
 *
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */

public class ListParametersUI implements Runnable{

    public void run() {
        ParameterController p = new ParameterController();
        p.writeParameters();
    }
}
