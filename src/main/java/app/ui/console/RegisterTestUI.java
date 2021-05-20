package app.ui.console;

import app.controller.RegisterTestController;
import app.domain.dto.ParameterDto;
import app.domain.dto.TestTypeDto;
import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.domain.shared.Constants;
import app.ui.console.utils.Utils;

import java.util.List;

import static app.domain.shared.Constants.SPECIALIST_DOCTOR;

public class RegisterTestUI implements Runnable {

    private RegisterTestController m_controller;

    public RegisterTestUI () {
        this.m_controller = new RegisterTestController();
    }


    @Override
    public void run() {
        System.out.println("\nRegister Test: \n");
        if(checkClient())   {
            if(registerData())
            {
                presentsData();
                if (Utils.confirm("Do you confirm the data? (Y/N)")) {
                    m_controller.confirmTest();
                    System.out.println("Test registered successfully!");
                } else
                {
                    System.out.println("Operation cancelled.");
                }
            } else {
                System.out.println("Error: Operation cancelled.");
            }
        }
        else
        { if(Utils.confirm("Do you want to register a new Client? (Y/N)"))   {
            new CreateClientUI().run();
        } else {
            System.out.println("Operation cancelled.");
            }
        }
    }

    private boolean checkClient() {
        long cc = (long) Utils.readDoubleFromConsole("\nClient - CC number: (16 digits)");
        if(!m_controller.checkRegisteredClient(cc)) {
            System.out.println("\nClient with CC: " + cc + " is not registered.\n");
            return false;
        }
        return true;
    }

    private boolean registerData() {
        // select TestType from a list of TestType dto
        List<TestTypeDto> typesDto = m_controller.getListTestType();
        TestTypeDto typeDto = (TestTypeDto)Utils.showAndSelectOne(typesDto, "\nList of Types of Test:\n");
        if (typeDto != null) {
            // get list of ParameterCategories from selected TestType
            List<ParameterCategory> categories = typeDto.getListCategories();
            ParameterCategory category = (ParameterCategory)Utils.showAndSelectOne(categories, "\n" + typeDto.getDescription() + " - List of ParameterCategory:\n");
            if (category != null) {
                String type = typeDto.getCode();
                this.m_controller.newTest(type);
                // select Parameter(s) from a list of Parameter dto (filtered with category selected)
                List<ParameterDto> parametersDto = m_controller.getListParameters(category.getCode());
                String answer = Constants.ANS_YES;
                while(answer.equals(Constants.ANS_YES) ) {
                    // add Parameter to list of Parameters in Test
                    ParameterDto parameter = (ParameterDto)Utils.showAndSelectOne(parametersDto, "\n" + category.getDescription() + " - List of Parameters:\n");
                    if (parameter == null) {
                        System.out.println("\nParameter is null.\n");;
                    } else {
                        this.m_controller.addParameterToTest(parameter.getCode());
                        if (!Utils.confirm("Do you want to add another Parameter? (Y/N)")){
                            answer = Constants.ANS_NO;
                        }
                    }
                }
                // Request Data: nhsCode
                String nhsCode = Utils.readLineFromConsole("Nhs Code: ");
                this.m_controller.addNhsCodeToTest(nhsCode);
                return (this.m_controller.validateTest());
            } else {
                System.out.println("\nParameterCategory is null.\n");
                return false;
            }
        }
        System.out.println("\nTestType is null.\n");
        return false;
    }

    private void presentsData()
    {
        System.out.println("\nTest: \n" + m_controller.getTestStore().getTestToString());
    }

}
