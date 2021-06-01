package app.ui.console;

import app.controller.ValidateTestController;
import app.domain.dto.TestDto;
import app.domain.shared.Constants;
import app.ui.console.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ValidateTestUI implements Runnable {

    private ValidateTestController controller;

    public ValidateTestUI () {
        this.controller = new ValidateTestController();
    }

    @Override
    public void run() {
        List<TestDto> testsDto = controller.getDiagnosedTestList();
        String answer = Constants.ANS_YES;
        while (answer.equals(Constants.ANS_YES) && !testsDto.isEmpty()) {
            TestDto dto = (TestDto) Utils.showAndSelectOne(testsDto, "\nList of Diagnosed Tests:\n");
            showData(dto);
            if (Utils.confirm("\nDo you want to validate the Test dates? (Y/N)")) {
                if (!controller.newValidTest(dto)){
                    System.out.println("\nThis test is already validated.");
                }
                testsDto.remove(dto);
            }
            if (!Utils.confirm("\nDo you want to validate another Test? (Y/N)")) {
                answer = Constants.ANS_NO;
            }
        }
        if(controller.changeTestsToValidated()) {
            System.out.println("\nTests were validated successfully.");
        } else {
            System.out.println("\nNo Tests were selected to be validated. Returning to menu.");
        }
    }

    private void showData (TestDto dto) {
        System.out.println(dto.validatedDates_toString());
    }
}
