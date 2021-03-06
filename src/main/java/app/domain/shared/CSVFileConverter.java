package app.domain.shared;

import app.controller.App;
import app.domain.model.*;
import auth.domain.model.Email;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CSVFileConverter {


    private final ClientStore clientStore;
    private final TestStore testStore;
    private final TestTypeStore testTypeStore;
    private final ParameterStore parameterStore;
    private final ParameterCategoryStore categoryStore;
    private final ReportStore reportStore;

    public CSVFileConverter(){
        Company company = App.getInstance().getCompany();
        this.clientStore = company.getClientStore();
        this.testStore = company.getTestStore();
        this.testTypeStore = company.getTestTypeStore();
        this.parameterStore = company.getParameterStore();
        this.categoryStore = company.getParameterCategoryStore();
        this.reportStore = company.getReportStore();
    }




    public boolean convertToObject(String fileName) throws FileNotFoundException {

        if(!fileName.contains(".csv")) {
            fileName += ".csv";
        }
        Scanner sc = new Scanner(new File(fileName));

        List<String[]> file = new ArrayList<>();

        while(sc.hasNext()){
            file.add(sc.nextLine().split(";"));
        }



        String [] header = file.get(0);
        file.remove(0);

        for(String[] line : file) {
            List <String[]> parameters = new ArrayList<>();
            try {
                Email email = new Email(line[getColumnIndex(header, "E-mail")]);
                Client client = new Client(email, line[getColumnIndex(header, "Name")], Long.valueOf(line[getColumnIndex(header, "NHS_Number")]), Long.valueOf(line[getColumnIndex(header, "CitizenCard_Number")]), Long.valueOf(line[getColumnIndex(header, "TIN")]), new Date(line[getColumnIndex(header, "BirthDay")]), Long.valueOf(line[getColumnIndex(header, "PhoneNumber")]));
                if (this.clientStore.validateClient(client)) {
                    clientStore.saveClients(client,"123");
                } else {
                    Client c = this.clientStore.getClientByCC(client.getCitizenCard());
                    if(c == null) throw new IllegalArgumentException("CC (client) is not registered.");
                    if(!c.equals(client)) {
                        throw new IllegalArgumentException("Client is registered with different attributes.");
                    }
                    client=c;
                }
                TestType type = this.testTypeStore.getTestTypeByCode(line[getColumnIndex(header,"TestType")]);
                if (type == null) {
                    throw new IllegalArgumentException("Test Type does not exist.");
                }
                Test test = new Test(type,type.getCollectingMethod(),client);
                test.setCode(line[getColumnIndex(header,"Test_Code")]);
                test.setLabId(line[getColumnIndex(header, "Lab_ID")]);
                test.setNhsCode(line[getColumnIndex(header,"NHS_Code")]);
                for(int i = getColumnIndex(header,"Category") ; i < header.length; i++){
                    int count = 0;
                    String [] temp = new String[header.length];
                    if(header[i].equals("Category") && !line[i].equals("NA") && !line[i+1].equals("NA")){
                        i++;
                        while(!line[i].equals("NA") && checkParameter(header[i])){
                            temp[count] = header[i];
                            count++;
                            temp[count] = line[i];
                            count++;
                            i++;
                        }
                        parameters.add(temp);
                    }
                }
                if(parameters.isEmpty()) {
                    throw new IllegalArgumentException("No valid Parameters.");
                }
                Date date = this.checkDate(line[getColumnIndex(header,"Test_Reg_DateHour")]);
                test.setDateRegistered(date);
                for(String[] vector : parameters) {
                    String parameterCode = "";
                    for(String str : vector) {
                        if (str == null){
                            break;
                        } else {
                            if(checkParameter(str)) {
                                parameterCode = str;
                                String catCode = this.parameterStore.getParameterByCode(parameterCode).getCategory();
                                test.addCategory(this.categoryStore.getParameterCategoryByCode(catCode));
                                test.addParameter(this.parameterStore.getParameterByCode(parameterCode));
                            } else {
                                str = str.replace(",",".");
                                double metric = Double.parseDouble(str);
                                //Missing Result
                                test.addTestResult(parameterCode,"Not Defined",metric);
                                test.addResultToList();
                                String diagnosis = "To be defined";
                                if(parameterCode.equals("IgGAN")) {
                                    if(metric > 1.4) {
                                        diagnosis = "Positive";
                                    } else if (metric >= 0 && metric <= 1.4) {
                                        diagnosis = "Negative";
                                    } else {
                                        throw new IllegalArgumentException("Parameter value is negative");
                                    }

                                }
                                Report report = this.reportStore.createReport(diagnosis,test);
                                if(!this.reportStore.saveReport(report)) {
                                    throw new IllegalArgumentException();
                                }
                            }
                        }

                    }
                }
                test.setDateChemical(this.checkDate(line[getColumnIndex(header,"Test_Chemical_DateHour")]));
                // Missing Diagnosis
                test.setDateDiagnosis(this.checkDate(line[getColumnIndex(header,"Test_Doctor_DateHour")]));
                test.setDateValidation(this.checkDate(line[getColumnIndex(header,"Test_Validation_DateHour")]));
                this.testStore.setTest(test);
                if(this.testStore.validateTest()) {
                    this.testStore.addTest(test);
                } else {
                    throw new IllegalArgumentException();
                }

            }catch (IllegalArgumentException | NullPointerException e) {
                System.out.println("line " + (file.indexOf(line) + 2) + " - " + line[0] + " has invalid data.");
            }

        }



        return true;
    }

    private int getColumnIndex(String [] header, String s){

        for(int i = 0; i < header.length; i++){


            if(header[i].trim().equals(s.trim())){
                return  i;
            }


        }
        return -1;

    }

    private Date checkDate(String date){
        if(date.trim().equals("NA")){
            throw new IllegalArgumentException(date + " is null.");
        }
        String[] temp = date.split(" ");
        String[] temp1 = temp[0].split("/");
        String dateFormated = temp1[2] + "/" + temp1[1] + "/" + temp1[0] + " " + temp[1];
        return new Date(dateFormated);
    }

    private boolean checkParameter (String code) {
        if (code == null) {
            return false;
        }
        return this.parameterStore.getParameterByCode(code) != null;
    }



}





