# US 8 - Register new clinical analysis laboratory and specify tests done there

## 1. Requirements Engineering

*In this section, it is suggested to capture the requirement description and specifications as provided by the client as well as any further clarification on it. It is also suggested to capture the requirements acceptance criteria and existing dependencies to other requirements. At last, identfy the involved input and output data and depicted an Actor-System interaction in order to fulfill the requirement.*


### 1.1. User Story Description

*As an administrator, I want to register a new clinical analysis laboratory stating which kind of test(s) it operates.*

### 1.2. Customer Specifications and Clarifications 


**From the Specifications Document:**

* "Many Labs is a company that operates in the English market, it has headquarters in London and has
  a network of clinical analysis laboratories in England where analysis of blood (samples are
  collected) are performed, as well as Covid-19 tests."
  
  
* "All Many Labs clinical analysis laboratories perform clinical blood tests and a subset of
  these laboratories also performs Covid-19 tests."

**From the client clarifications:**

* Q1: "And what about the Clinical Analysis Laboratory and Chemical Laboratory? Do they have common attributes like an identification number, number of employees who work there, location, etc.?"
* A1: "Each Clinical Analysis Laboratory is characterized by the following attributes:
  Laboratory ID;
  Name;
  Address;
  Phone Number;
  TIN number."
  

* Q2: " it is possible for a given employee to work at more than one lab? "
* A2: "Each Receptionist and each Medical Lab Technician can work in any Clinical Analysis Laboratory of the Many Labs network."


### 1.3. Acceptance Criteria

* AC1: A CAL's must have an attribute specifying if it performs Covid-19 Test.
* AC2: A CAL's must always perform blood tests.
* AC3: A CAL cannot be registered without Laboratory ID, Name, Address, Phone Number, TIN number and the information if it performs Covid-19 Tests.


### 1.4. Found out Dependencies

This user story will be dependent on the US7 - register new Employees. 

### 1.5 Input and Output Data

**Input Data**

* Typed data: Lab Name, Address, Phone Number and TIN number.

* Selected data: Performs Covid-19 Test (Yes or No).

**Output Data**
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)


![US8-SSD](US8-SSD.svg)


### 1.7 Other Relevant Remarks

US7 may be needed to add employees to the CAL created.

## 2. OO Analysis

### 2.1. Relevant Domain Model Excerpt 

![US8-MD](US8-MD.svg)

### 2.2. Other Remarks

Some Classes needed may not be represented in the Domain Model Excerpt presented, because they may not be represented in the main Domain Model.

## 3. Design - User Story Realization 

### 3.1. Rationale

**The rationale grounds on the SSD interactions and the identified input/output data.**

| Interaction ID | Question: Which class is responsible for... | Answer  | Justification (with patterns)  |
|:-------------  |:--------------------- |:------------|:---------------------------- |
| Step 1  : starts new CAL	 |		...creating a new CAL?   |  Company -> CALStore           |Based on the Creator standard (Company used to store the list of all CAL ) on the MD, the responsibility is attributed to the Company. By application of HC + LC in Company the responsibility is delegated to CALStore|
| Step 2  : requests data(i.e., Lab ID, Lab Name, Address, Phone Number, TIN Number, performs covid-19 tests)		 |			n/a				 |             |                              |
| Step 3  : types requested data		 |			...saving the input data? 				 |    CAL       | IE: the object created in the first step has knowledge of its own data.                             |
| Step 4  : shows the data and requests confirmation	 |		...validate that the data is according to AC?					 |  CAL         |   IE: Know its own creation rules.                           |
| Step 4  : shows the data and requests confirmation		 |		...validate the data persistence?					 |        Company -> CALStore     |  Based on the IE (Company used to know all the CAL Objects ) but, with the application of HC+LC in Company, the responsibility it's know delegated to CALStore| |              
| Step 5  : confirms data		 |				...saving the CAL registered?			 |      Company -> CALStore         | Based on the IE standard on the MD, the responsibility is attributed to the Company. By application of HC + LC in Company the responsibility is delegated to CALStore, as previously stated. |              
| Step 6  : informs operation success		 |			...informing operation success?				 |      UI       |    IE:Responsible for user interaction.                          |              

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * Company
 * CAL

Other software classes (i.e. Pure Fabrication) identified: 
 * RegisterNewCALUI  (applying the "pure fabrication" pattern)
 * RegisterNewCALController (applying the "Controller" pattern)
 * CALStore (applying the "HC+LC" pattern)


## 3.2. Sequence Diagram (SD)


![US8-SD](US8-SD.svg)

## 3.3. Class Diagram (CD)


![US8-CD](US8-CD.svg)

# 4. Tests 
*In this section, it is suggested to systematize how the tests were designed to allow a correct measurement of requirements fulfilling.* 

**_DO NOT COPY ALL DEVELOPED TESTS HERE_**

### **Creation**

* RegisterNewCALController


      @Test
      public void testRegisterNewCAL() {
        //arrange
        RegisterNewCALController controller = new RegisterNewCALController();
        //preparing
        boolean b1 = controller.registerNewCAL("11asd","labNams",12345678524L,"Adress",1234567891,true);


        //testing
        assertEquals(true,b1);
        try{
            controller.registerNewCAL("11as","labNams",12345678524L,"Adress",1234567891,true);
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("Lab Id must have 5 chars.",ex.getMessage());
        }




	


### **Validation**

* CALStore 
  

      @Test
      public void testValidateCAL() {
      //preparations
      CAL cal1 = new CAL("11asd","labNams",12345678524L,"Adress",1234567891,true);
      CAL cal2 = new CAL("11a85","labNams",12345678523L,"Adress",1234567891,true);

        CALStore calList = new CALStore();


        boolean b = calList.validateCAL(cal1);

        //testing
        assertEquals(true,b);
        calList.saveCAL(cal1);
        assertEquals(false,calList.validateCAL(cal2));

       }





  * CAL


        @Test
       public void testCheckLabIDrules() {
        //arrange
        //testing

        try{
            CAL cal = new CAL("11as","labName",12345678524L,"Adress",1234567891,true);
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("Lab Id must have 5 chars.",ex.getMessage());
        }
        try{
            CAL cal = new CAL("11as12","labName",12345678524L,"Adress",1234567891,true);
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("Lab Id must have 5 chars.",ex.getMessage());
        }
        try{
            CAL cal = new CAL("","labName",12345678524L,"Adress",1234567891,true);
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("Laboratory Id cannot be blank.",ex.getMessage());
        }
        }

        @Test
        public void testCheckaddressrules() {
        //arrange
        //testing

        try{
            CAL cal = new CAL("11asa","labName",12345678524L,"",1234567891,true);
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("Address cannot be blank.",ex.getMessage());
        }
        try{
            CAL cal = new CAL("11as1","labName",12345678524L,"Lorem Ipsum is simply dummy text of the printing and typesetting industry. ",1234567891,true);
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("Address must have no more than 30 characters.",ex.getMessage());
        }

        }

        @Test
        public void testCheckphoneNumberrules() {
        //arrange
        //testing

        try{
            CAL cal = new CAL("11asa","labName",0,"asasa",1234567891,true);
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("Phone Number must have 11 chars.",ex.getMessage());
        }
        try{
            CAL cal = new CAL("11as1","labName",2345678524L,"asasa ",1234567891,true);
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("Phone Number must have 11 chars.",ex.getMessage());
        }
        try{
            CAL cal = new CAL("11as1","labName",234567238524L,"asasa ",1234567891,true);
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("Phone Number must have 11 chars.",ex.getMessage());
        }
        }

        @Test
        public void testCheckTINrules() {
        //arrange

        //testing

        try{
            CAL cal = new CAL("11as1","labName",23672318524L,"asasa ",123467891,true);
            fail();
        }catch(IllegalArgumentException ex){
            assertEquals("TIN must have 10 chars.",ex.getMessage());
        }
        }

        @Test
        public void testCheckNamerules() {
        //arrange
        //testing
        try{
        CAL cal = new CAL("11as1","",23672318524L,"asasa ",1231467891,true);
        fail();
        }catch(IllegalArgumentException ex){
        assertEquals("Laboratory Name cannot be blank.",ex.getMessage());
        }
        try{
        CAL cal = new CAL("11as1","Lorem Ipsum is simply dummy text of the printing and typesetting industry.",23672318524L,"asasa ",1231467891,true);
        fail();
        }catch(IllegalArgumentException ex){
        assertEquals("Laboratory Name must have no more than 20 characters.",ex.getMessage());
        }
        }



###**Adding**

  * CALStore


        @Test
        public void saveCAL() {
        CAL cal1 = new CAL("11asd","labNams",12345678524L,"Adress",1234567891L,true);
        CAL cal2 = new CAL("11a85","labNams",12345678523L,"Adress",1234567891L,true);
        CAL cal3 = new CAL("11aqw","labNams",12345688523L,"Route X",2234567891L,false);

        CALStore calList = new CALStore();


        boolean b = calList.saveCAL(cal1);

        //testing
        assertEquals(false,calList.validateCAL(cal1));
        assertEquals(false,calList.validateCAL(cal2));
        assertEquals(true,calList.validateCAL(cal3));
        }

* RegisterNewCALController

      
        @Test
        public void testSaveCAL() {
        //arrange
        RegisterNewCALController controller = new RegisterNewCALController();
        CAL cal = new CAL("11as2","labName",23672118524L,"wsasa ",1334678921,true);
        controller.registerNewCAL("11as1","labName",23672318524L,"asasa ",1234678921,true);
        //preparing
        boolean b1 = controller.saveCAL();

        //testing
        assertEquals(true,b1);
        controller.registerNewCAL("11as2","labName",23672118524L,"wsasa ",1334678921,true);
        assertEquals(true,controller.saveCAL());
        controller.registerNewCAL("11as2","labName",23672118524L,"wsasa ",1334678921,true);
        assertEquals(false,controller.saveCAL());

        }


### **Getting**
  * Company


        @Test
        public void testGetCalStore() {
        //preparations
        CAL cal1 = new CAL("11asd","labNams",12345678524L,"Adress",1234567891,true);
        CAL cal2 = new CAL("11asd","labNams",12345678524L,"Adress",1234567891,true);
        CALStore calList = new CALStore();
        Company comp1 = new Company("asd");
        Company comp2 = new Company("qwe");
        calList.saveCAL(cal1);
        comp1.setCalStore(calList);
        comp2.setCalStore(calList);
        CALStore calList2 = calList;

        //testing
        assertEquals(comp1.getCalStore(),comp2.getCalStore());
        calList2.saveCAL(cal2);
        comp2.setCalStore(calList2);
        assertEquals(comp1.getCalStore(),comp2.getCalStore());
        calList.saveCAL(cal2);
        assertEquals(comp1.getCalStore(),(comp2.getCalStore()));
        }

*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)

*In this section, it is suggested to provide, if necessary, some evidence that the construction/implementation is in accordance with the previously carried out design. Furthermore, it is recommeded to mention/describe the existence of other relevant (e.g. configuration) files and highlight relevant commits.*

*It is also recommended organizing this content by subsections.* 

* Company


    public class Company {
    private String designation;
    private CALStore calStore;

    
    public CALStore getCalStore() {
        return calStore;
    }

    public void setCalStore(CALStore calStore) {
        this.calStore = calStore;
    }
    }


* CALStore


    public class CALStore {
    private ArrayList<CAL> calList;


    public CALStore(){
        calList = new ArrayList<CAL>();
    }

    public CAL registerNewCAL(String labId, String labName, long phoneNumber, String address, int tin, boolean answer ){
        return new CAL(labId, labName, phoneNumber, address, tin, answer);
    }

    public boolean validateCAL(CAL cal){
        if(cal == null)
            return false;
        for (CAL cal1: this.calList) {
            if(cal1.getLaboratoryId().equals(cal.getLaboratoryId()) || cal1.getPhoneNumber()==cal.getPhoneNumber() ||
                cal1.getTinNumber()==cal.getTinNumber() || cal1.getAddress().equals(cal.getAddress())){
                return false;
            }
        }
        return true;
    }

    public boolean saveCAL(CAL cal){
        if(!validateCAL(cal))
            return false;
        return this.calList.add(cal);
    }
    }
    


* CAL
  

    public class CAL {

    private String labName;
    private String address;
    private long phoneNumber;
    private long tinNumber;
    private boolean performsCovidTest;
    private String laboratoryId;
    private List<TestType> testsAvailable;

    
    public CAL(String labId, String labName, long phoneNumber, String address, int tin, boolean answer){
        checkLabIDrules(labId);
        checkaddressrules(address);
        checkphoneNumberrules(phoneNumber);
        checkTINrules(tin);
        checkNamerules(labName);
        
        this.laboratoryId=labId;
        this.labName = labName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.tinNumber = tin;
        this.performsCovidTest = answer;
    }


     public void checkLabIDrules(String labId) {
        if (labId.length() == 0)
            throw new IllegalArgumentException("Laboratory Id cannot be blank.");
        if ( labId.length() != 5)
            throw new IllegalArgumentException("Lab Id must have 5 chars.");
    }

    public void checkaddressrules(String address) {
        if (address.length() == 0)
            throw new IllegalArgumentException("Address cannot be blank.");
        if ( address.length() > 30)
            throw new IllegalArgumentException("Address must have no more than 30 characters.");
    }

    public void checkphoneNumberrules(long phoneNumber) {
        String temp = String.valueOf(phoneNumber);
        if (temp.length() == 0)
            throw new IllegalArgumentException("Phone Number cannot be blank.");
        if ( temp.length() != 11)
            throw new IllegalArgumentException("Phone Number must have 11 chars.");
    }

    public void checkTINrules(long tin) {
        String temp = String.valueOf(tin);
        if (temp.length() == 0)
            throw new IllegalArgumentException("TIN cannot be blank.");
        if ( temp.length() != 10)
            throw new IllegalArgumentException("TIN must have 10 chars.");
    }

    public void checkNamerules(String labName) {
        if (labName.length() == 0)
            throw new IllegalArgumentException("Laboratory Name cannot be blank.");
        if ( labName.length() > 20)
            throw new IllegalArgumentException("Laboratory Name must have no more than 20 characters.");
    }


    }

* RegisterNewCALUI

    
    public class RegisterNewCALUI{
    public RegisterNewCALUI();
    }


* RegisterNewCALController


    public class RegisterNewCALController{
    private Company company;
    private CAL cal;
    private CALStore calStore;
    
        
    public boolean registerNewCAL(String labId, String labName, long phoneNumber, String address, int tin, boolean answer){
        this.cal = this.calStore.registerNewCAL(labId, labName, phoneNumber, address, tin, answer);
        return this.calStore.validateCAL(this.cal);
    }

    public boolean saveCAL(){
        return this.calStore.saveCAL(cal);
    }
    }

# 6. Integration and Demo 

In relation with the US7, the team assumed it was better that the worker knew where he worked than to the CAL to know all it's employees.

# 7. Observations


In this US it's assumed that the administrator is logged in the System with validated access. 
Because of this the team didn't felt the need to add information about these steps in this US.



