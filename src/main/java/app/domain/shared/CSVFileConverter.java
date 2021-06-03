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


    private ClientStore clientStore;
    private TestStore testStore;
    private TestTypeStore testTypeStore;
    private ParameterStore parameterStore;
    private Company company;

    public CSVFileConverter(){
        this.company = App.getInstance().getCompany();
        this.clientStore = company.getClientStore();
        this.testStore = company.getTestStore();
        this.testTypeStore = company.getTestTypeStore();
        this.parameterStore = company.getParameterStore();
    }




    public void convertToObject() throws FileNotFoundException {





        Scanner sc = new Scanner(new File("blood.csv"));

        List<String[]> lString = new ArrayList<>();
        List <String[]> category = new ArrayList<>();




        while(sc.hasNext()){
            lString.add(sc.nextLine().split(";"));

        }


        String [] header = lString.get(0);


        lString.remove(0);
        for(String[] s : lString) {
            Email email = null;
            try {

                email = new Email(s[getIndex(header, "E-mail")]);
                Client c = new Client(email, s[getIndex(header, "Name")], Long.valueOf(s[getIndex(header, "NHS_Number")]), Long.valueOf(s[getIndex(header, "CitizenCard_Number")]), Long.valueOf(s[getIndex(header, "TIN")]), new Date(s[getIndex(header, "BirthDay")]), Long.valueOf(s[getIndex(header, "PhoneNumber")]));
                clientStore.saveClients(c,"123");

                int count = 0;

                for(int i = 0 ; i < s.length; i++){

                    if(s[i].equals("Category")){

                        String [] temp = new String[1000000];
                        while(!s[i+1].equals("NA") && !s[i+1].equals("Category")){
                            temp[count] = s[i+1];
                        }
                        category.add(temp);
                        count++;
                    }
                }
                TestType type = this.testTypeStore.getTestTypeByCode(s[getIndex(header,"TestType")]);
                Test test = new Test(type,type.getCollectingMethod(),c);
                test.setCode(s[getIndex(header,"Test_Code")]);
                test.setNhsCode(s[getIndex(header,"NHS_Code")]);
                test.setDateRegistered(this.checkDate(s[getIndex(header,"Test_Reg_DateHour")]));
                Parameter param = new Parameter("","","",s[getIndex(header,"Category")]);
                test.setDateChemical(this.checkDate(s[getIndex(header,"Test_Chemical_DateHour")]));
                test.setDateDiagnosis(this.checkDate(s[getIndex(header,"Test_Doctor_DateHour")]));
                test.setDateValidation(this.checkDate(s[getIndex(header,"Test_Validation_DateHour")]));



                int index = getIndex(header,"Category");

                if( s[index].equals("Covid") ){


                    if(!s[index+1].equals("NA")){


                    }
                }

                else if( s[index].equals("Blood")){

                }




                testStore.addTest(test);



            }catch (IllegalArgumentException e) {
                System.out.println("line " + (lString.indexOf(s) + 2) + " - Client: " + s[getIndex(header, "Name")] + " has invalid data.");
            }

        }




    }

    private int getIndex(String [] header, String s){

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
        return new Date(date);
    }



}





