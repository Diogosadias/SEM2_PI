package app.ui.console;

import app.controller.CreateTestTypeController;
import app.controller.SpecifyNewTestTypeController;

public class ListTypeTestUI implements Runnable{

    public void run() {
        SpecifyNewTestTypeController createTestTypeController = new SpecifyNewTestTypeController();
        createTestTypeController.writeTestType();
    }
}
