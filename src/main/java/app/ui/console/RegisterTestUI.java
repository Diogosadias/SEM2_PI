package app.ui.console;

import app.controller.RegisterTestController;
import app.domain.dto.ParameterDto;
import app.domain.dto.TestTypeDto;
import app.domain.dto.ParameterCategoryDto;
import app.domain.shared.Constants;
import app.ui.console.utils.Utils;

import java.util.List;

/**
 *
 * @author Tiago Rocha <1181445@isep.ipp.pt>
 * @author Márcio Ramos <1201682@isep.ipp.pt>
 */
public class RegisterTestUI implements Runnable {

    private RegisterTestController m_controller;

    public RegisterTestUI () {
        this.m_controller = new RegisterTestController();
    }


    @Override
    public void run() {
        String answer = Constants.ANS_YES;
        while (answer.equals(Constants.ANS_YES)) {
            System.out.println("\nRegister Test: \n");
            if (checkClient()) {
                if (registerData()) {
                    presentsData();
                    if (Utils.confirm("Do you confirm the data? (Y/N)")) {
                        m_controller.confirmTest();
                        System.out.println("Test registered successfully!");
                    } else {
                        System.out.println("Operation cancelled.");
                    }
                } else {
                    System.out.println("Error: Operation cancelled.");
                }
            } else {
                if (Utils.confirm("Do you want to register a new Client? (Y/N)")) {
                    new CreateClientUI().run();
                }
            }
            if (!Utils.confirm("Do you want to register another Test? (Y/N)")) {
                answer = Constants.ANS_NO;
                System.out.println("Operation cancelled. Returning to Menu.");
            }
        }
    }

    private boolean checkClient() {
        long tin = Utils.readLongFromConsole("\nClient - TIN number: (12 digits)");
        if(!m_controller.checkRegisteredClient(tin)) {
            System.out.println("\nClient with TIN: " + tin + " is not registered.\n");
            return false;
        }
        return true;
    }

    private boolean registerData() {
        // select TestType from a list of TestType dto
        List<TestTypeDto> typesDto = m_controller.getListTestType();
        TestTypeDto typeDto = (TestTypeDto)Utils.showAndSelectOne(typesDto, "\nList of Types of Test:\n");
        if (typeDto != null) {
            this.m_controller.newTest(typeDto.getCode());
            // get list of ParameterCategories from selected TestType
            List<ParameterCategoryDto> categoriesDto = typeDto.getListCategories();
            String answer = Constants.ANS_YES;
            while (answer.equals(Constants.ANS_YES) && !categoriesDto.isEmpty()) {
                ParameterCategoryDto category = (ParameterCategoryDto) Utils.showAndSelectOne(categoriesDto, "\n" + typeDto.getDescription() + " - List of ParameterCategory:\n");
                if (category != null) {
                    // select Parameter(s) from a list of Parameter dto (filtered with category selected)
                    List<ParameterDto> parametersDto = m_controller.getListParameters(category.getCode());
                    while (answer.equals(Constants.ANS_YES) && !parametersDto.isEmpty()) {
                        // add Parameter to list of Parameters in Test
                        ParameterDto parameter = (ParameterDto) Utils.showAndSelectOne(parametersDto, "\n" + category.getDescription() + " - List of Parameters:\n");
                        if (parameter == null) {
                            answer = Constants.ANS_NO;
                        } else {
                            this.m_controller.addParameterToTest(parameter.getCode());
                            parametersDto.remove(parameter);
                            if (!Utils.confirm("Do you want to add another Parameter? (Y/N)")) {
                                answer = Constants.ANS_NO;
                            } else if (parametersDto.isEmpty()) {
                                System.out.println("\nNo more parameters to choose from the list.\n");
                            }
                        }
                    }
                    categoriesDto.remove(category);
                    answer = Constants.ANS_YES;
                    if (!Utils.confirm("Do you want to add another ParameterCategory? (Y/N)")) {
                        answer = Constants.ANS_NO;
                    } else if (categoriesDto.isEmpty()) {
                        System.out.println("\nNo more categories to choose from the list.\n");
                    }
                }else{
                    answer = Constants.ANS_NO;
                }

            }
            // Request Data: nhsCode
            String nhsCode = Utils.readLineFromConsole("Nhs Code: ");
            this.m_controller.addNhsCodeToTest(nhsCode);
            return (this.m_controller.validateTest());
        }
        else {
            System.out.println("\nTestType is null.\n");
            return false;
        }
    }

    private void presentsData()    {
        System.out.println("\nTest: \n" + m_controller.getTestStore().getTestToString());
    }

}
