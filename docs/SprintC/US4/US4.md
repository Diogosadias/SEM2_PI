# US 4 - Register a Test

## 1. Requirements Engineering

*In this section, it is suggested to capture the requirement description and specifications as provided by the client as well as any further clarification on it. It is also suggested to capture the requirements acceptance criteria and existing dependencies to other requirements. At last, identfy the involved input and output data and depicted an Actor-System interaction in order to fulfill the requirement.*


### 1.1. User Story Description

*As a receptionist of the laboratory, I intend to register a test to be performed to a registered client.*

### 1.2. Customer Specifications and Clarifications 

**From the Specification Document:**

"...receptionist asks the client?s citizen card number, the lab order (which contains the type of test and parameters to be measured), and registers in the application the test to be performed to that client."

"Many Labs performs two types of tests. Each test is characterized by an internal code, an NHS code, a description that identifies the sample collection method, the date and time when the samples were collected, the date and time of the chemical analysis, the date and time of the diagnosis made by the specialist doctor, the date and time when the laboratory coordinator validated the test, and the test type (whether it is blood test or Covid test)." 

**From the client clarifications:**

Q:	When the receptionist chooses the test type, should the categories appear, and then when selecting the category, the receptionist can choose the parameters for the test? Or when the Receptionist chooses the test type, should appear all the parameters that it includes immediately?
A:  Firstly, the receptionist should choose a test type. Then choose a category from a set of categories. Last, the receptionist should choose a parameter.

Q:	What are the attributes of a test and the acceptance criteria?
A:  -Test code : Sequential number with 12 digits. The code is automatically generated.
	-NHS code: 12 alphanumeric characters.

Q:	I wanted to ask if the NHS code of which test is unique or not.
A:	Yes.

Q: when the receptionist is registering a test for a client, the test can have more than one category and many parameters of the chosen categories or it only can have one category?
A: Each test can have more than one category.

"In US4 the receptionist of the laboratory should ask the client to get his TIN number."

### 1.3. Acceptance Criteria

* AC1: : The receptionist must select the parameters to be analysed from all possible parameters in accordance with the test type.

### 1.4. Found out Dependencies
At least one:

Receptionist needs to be registered in US7. 

Type of test needs to be specified in US9.

Parameter needs to be specified in US10.

ParameterCategory needs to be specified in US11.

### 1.5 Input and Output Data

**Input Data:** Client TIN, Nhs Code

**Selected Data:** TestType, ParameterCategory, Parameter(s)

**Output Data:** (in)sucess of the operation 

### 1.6. System Sequence Diagram (SSD)

*Insert here a SSD depicting the envisioned Actor-System interactions and throughout which data is inputted and outputted to fulfill the requirement. All interactions must be numbered.*

![US4-SSD](US4-SSD.svg)


### 1.7 Other Relevant Remarks

* Test code is generated in application.

## 2. OO Analysis

### 2.1. Relevant Domain Model Excerpt 
*In this section, it is suggested to present an excerpt of the domain model that is seen as relevant to fulfill this requirement.* 

![US4-MD](US4-MD.svg)

### 2.2. Other Remarks

*Use this section to capture some aditional notes/remarks that must be taken into consideration into the design activity. In some case, it might be usefull to add other analysis artifacts (e.g. activity or state diagrams).* 



## 3. Design - User Story Realization 

### 3.1. Rationale

**The rationale grounds on the SSD interactions and the identified input/output data.**

| Interaction ID | Question: Which class is responsible for... | Answer  | Justification (with patterns)  |
|:-------------  |:--------------------- |:------------|:---------------------------- |
| Step 1: asks to register a Test																		|	...interacting with the user?							 				|  RegisterTestUI			|  	PureFabrication: responsible for user interaction.                          |
| 																										|	...instantiating a new Test?						 					|  TestStore				|  	HC + LC: Company delegates responsability to the TestStore.                            |
| 																										|	...having the store information?					 					|  RegisterTestController	|	PureFabrication: Company uses controller.                            |
| Step 2: requests Client TIN number						 											|	n/a					 													|             				|                          					|
| Step 3: types the TIN number  																		|	...checking if Client is registered?									|  ClientStore				|  	HC + LC: Company delegates responsability to the ClientStore.                            |
|																										|	...saving the client?							 						|  TestStore				|  	HC + LC: Test is requested by Client.                            |
| Step 4: asks if wants to register a new Client or cancel operation									|	n/a					 													|             				|                           				|
| Step 4: chooses an option																				|	...registering a new client?								 			|  RegisterClientUI			|  	PureFabrication: responsible for user interaction.                            |
| Step 5: lists all the TestType and asks to select one													|	...knowing all the TesType?												|  TestTypeStore			|   HC + LC: Company delegates responsability to the TestStore.                      |
|																										|	...listing the TesType list?											|  TestTypeMapper 			|   DTO: TestTypeDto has the TestType list.                          |
| Step 6: selects the TestType  												 						|	...saving the TestType selected?						 				|  TestStore    			|  	HC + LC: Test is of TestType.                            |
| Step 7: lists all the Parameter Categories of the TestType selected and asks to select at least one	|	...listing the ParameterCategory list?									|  TestTypeMapper 			|   DTO: TestType has ParameterCategory list.                          |
| Step 8: selects the ParameterCategory  												 				|	...saving the ParameterCategory selected?						 		|  TestStore    			|  	HC + LC: Each TestType is presented under ParameterCategory.                            |
| Step 9: shows list of Parameters according to the Category selected and asks to choose at least one	|	...knowing all the Parameters?											|  ParameterStore			|   HC + LC: Company delegates responsability to the ParameterStore.                      |
|																										|	...listing the Parameters list?							 				|  ParameterMapper  		|   DTO: ListParameterDto has the list of Parameters.                           |
| Step 10: selects the Parameter(s)  																	|	...saving the list of Parameters selected?								|  TestStore    			|  	HC + LC: Test requests analysis of Parameter(s).                            |
| Step 11: requests additional data ( nhsCode ) 														|	n/a						 												|               			|                              											|
| Step 12: types requested data  		 																|	...saving the input data?						 						|  TestStore    			|  	IE: Test created in step 1.                       				   |
| Step 13: validates and shows all the data, asking for confirmation  		 							|	...validating the data locally(eg.: mandatory vs non-mandatory data)?	|  Test		        		|   IE: knows its own data.                         					 |
|   		 																							|	...validating the data globally(eg.: duplicated)?					 	|  TestStore	    		|   HC+LC: knows all the Test objects.                         |
| Step 14: confirms all the data  		 																|	...saving the created Test												|  TestStore   				|   IE: adopts/records all the Test objects.                          |
| Step 15: informs Test registered to Client sucessfully  		 										|	...informing operation success?						 					|  RegisterTestUI			|   PureFabrication8: responsible for user interaction                          |              

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

Client, 
TestType, 
Parameter, 
ParameterCategory, 
Test

Other software classes (i.e. Pure Fabrication) identified: 

RegisterTestUI (applying the "pure fabrication" pattern),
RegisterClientUI (applying the "pure fabrication" pattern),
RegisterTestController (applying the "controller" pattern),
TestStore (HC+LC),
ClientStore (HC+LC),
TestTypeStore (HC+LC),
ParameterStore(HC+LC),
ParameterCategoryStore(HC+LC),
TestTypeMapper ("DTO" pattern),
ParameterMapper ("DTO" pattern),
TestTypeDTO ("DTO" pattern),
ParameterDTO ("DTO" pattern)

## 3.2. Sequence Diagram (SD)

*In this section, it is suggested to present an UML dynamic view stating the sequence of domain related software objects' interactions that allows to fulfill the requirement.* 

*Main Diagram:*

![MainDiagram](US4-SD.svg)


*TestType_toDto_List Diagram:*

![TestType_toDto_List](TestType_toDto_List.svg)


*Parameter_toDto_List Diagram:*

![Parameter_toDto_List](Parameter_toDto_List.svg)


## 3.3. Class Diagram (CD)

*In this section, it is suggested to present an UML static view representing the main domain related software classes that are involved in fulfilling the requirement as well as and their relations, attributes and methods.*

![US4-CD](US4-CD.svg)

# 4. Tests 
*In this section, it is suggested to systematize how the tests were designed to allow a correct measurement of requirements fulfilling.* 

**_DO NOT COPY ALL DEVELOPED TESTS HERE_**

**Test 1:** Check that it is not possible to create an instance of the Example class with null values. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Exemplo instance = new Exemplo(null, null);
	}

*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)

*In this section, it is suggested to provide, if necessary, some evidence that the construction/implementation is in accordance with the previously carried out design. Furthermore, it is recommeded to mention/describe the existence of other relevant (e.g. configuration) files and highlight relevant commits.*

*It is also recommended to organize this content by subsections.* 

** Test class **

	public class Test{
		private String state;
		private Client client;
		private String nhsCode;
		private String description;
		private TestType type;
		private String code;
		private final List<Parameter> listParameters;
		private final List<ParameterCategory> listCategories;
		private Date dateRegistered;
		
		public Test (TestType type, String description,Client client) {
			checkTypeAttribute(type);
			checkDescriptionAttribute(description);
			checkClientAttribute(client);

			this.type = type;
			this.description = description.trim();
			this.client = client;

			this.listParameters = new ArrayList<>();
			this.listCategories = new ArrayList<>();
			this.listTestParameter = new ArrayList<>();
    	}
		
		private void checkTypeAttribute (TestType type) {
        	if(type == null) {
            	throw new IllegalArgumentException("Creating Test Error: Test type is null.");
        	}
   		}
    	private void checkDescriptionAttribute (String description) {
        	if(description.trim().length() == 0) {
        	    throw new IllegalArgumentException("Creating Test Error: Description is empty.");
       	 	}
    	}
		private void checkClientAttribute (Client client) {
			if(client == null) {
				throw new IllegalArgumentException("Creating Test Error: Client is null.");
			}
		}
		private void checkNhsCodeAttribute (String nhsCode) {
			int count = 0;
			for(int i = 0; i < nhsCode.length(); i++) {
				if(nhsCode.charAt(i) != ' ')
					count++;
			}
			if(count != 12) {
				throw new IllegalArgumentException("Adding NhsCode to Test Error: NhsCode needs 12 alphanumeric characters.");
			}
		}

		public void setNhsCode(String nhsCode) {
			checkNhsCodeAttribute(nhsCode);
			this.nhsCode = nhsCode;
			this.state = Constants.REGISTERED;
			this.dateRegistered = new Date(System.currentTimeMillis());
		}
		
	}
	
** TestStrore class **
	
	public class TestStore {

    private Company company;
    private Client client;
    private final List<Test> testList;
    private Test test;
    private long numRegisteredTest = 0;

    public TestStore(){
        testList = new ArrayList<>();
    }

    public void setCompany (Company company) {
        this.company = company;
    }

    public Company getCompany () {
        return company;
    }

    public boolean checkRegisteredClient(long tin) {
        ClientStore cStore = this.company.getClientStore();
        this.client = cStore.getClientByTIN(tin);
        return (client != null) ;
    }

    public List getListTestType() {
        TestTypeStore ttStore = this.company.getTestTypeStore();
        TestTypeMapper ttMapper = new TestTypeMapper();
        return ttMapper.toDto(ttStore.getTestTypeList());
    }

    public void newTest(String typeCode) {
        TestTypeStore ttStore = this.company.getTestTypeStore();
        TestType type = ttStore.getTestTypeByCode(typeCode);
        String description = type.getCollectingMethod();
        this.test = new Test(type,description,this.client);
        generateTestCode();
    }

    private void generateTestCode() {
        String testCode = new GenerateTestCode(numRegisteredTest).getCode();
        this.test.setCode(testCode);
    }

    public void addCategoryToTest (String categoryCode) {
        ParameterCategoryStore pcStore = this.company.getParameterCategoryStore();
        ParameterCategory category = pcStore.getParameterCategoryByCode(categoryCode);
        this.test.addCategory(category);
    }

    public List getListParameters(String categoryCode) {
        ParameterStore pStore = this.company.getParameterStore();
        ParameterMapper pMapper = new ParameterMapper();
        return pMapper.toDto(pStore.getParameterList(),categoryCode);
    }

    public boolean addParameterToTest(String parameterCode) {
        ParameterStore pStore = this.company.getParameterStore();
        Parameter parameter = pStore.getParameterByCode(parameterCode);
        return this.test.addParameter(parameter);
    }

    public void addNhsCodeToTest(String nhs) {
        this.test.setNhsCode(nhs);
    }

    public boolean validateTest() {
        for (Test t : testList) {
            if (t.getNhsCode().equals(this.test.getNhsCode())) {
                System.out.println("Error: Test was already registered with same Nhs code.");
            }
        }
        return true;
    }

    public void saveTest() {
        if(!testList.contains(this.test)) {
            testList.add(this.test);
            numRegisteredTest += 1;
        } else {
            throw new IllegalArgumentException("Test is already registered.");
        }
    }
	
** GenerateTestCode class **
	
	public class GenerateTestCode {
    private static final long MAXNUMTEST = 1000000000000L;

    private final String code;

    public GenerateTestCode(long numTests) {
        this.code = generateTestCode(numTests);
    }

    private String generateTestCode(long numTests) {
        long num = numTests;
        if(num + 1 == MAXNUMTEST) {
            throw new IllegalArgumentException("Reached maximum number of Tests.");
        }
        // acrescentar zeros entre as letras e o numero
        String fillZeros = "";
        for (int i=0;i< 12;i++) {

            if (num % 10 == 0) {
                fillZeros += "0";
            }
            num = num / 10;
        }
        return fillZeros + "" + (numTests + 1);
    }

    public String getCode() {
        return this.code;
    }

}

# 6. Integration and Demo 

*In this section, it is suggested to describe the efforts made to integrate this functionality with the other features of the system.*


# 7. Observations

*In this section, it is suggested to present a critical perspective on the developed work, pointing, for example, to other alternatives and or future related work.*





