package app.ui.console;

import app.controller.SpecifyNewTestTypeController;

/**
 * @author Tomás Pinto <1181835@isep.ipp.pt>
 */
public class ListTypeTestUI implements Runnable{

    public void run() {
        SpecifyNewTestTypeController createTestTypeController = new SpecifyNewTestTypeController();
        createTestTypeController.writeTestType();
    }
}
