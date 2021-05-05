package app.ui.console;

import app.controller.CreateTestTypeController;

public class ListTypeTestUI implements Runnable{

    public void run() {
        CreateTestTypeController createTestTypeController = new CreateTestTypeController();
        createTestTypeController.writeTestType();
    }
}
