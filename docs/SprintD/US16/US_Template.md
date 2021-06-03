# US 16 - Overview and Analyze performed Tests

## 1. Requirements Engineering



### 1.1. User Story Description

**As a laboratory coordinator, I want to have an overview of all the tests performed  by Many Labs and analyse the overall performance of the company (for instance, check  the sub-intervals in which there were more samples waiting for the result). To facilitate  overall analysis, the application should also display statistics and graphs.**

### 1.2. Customer Specifications and Clarifications 

**Q1:** Should the interval of time considered for the evaluation be asked to the Laboratory Coordinator?

**A1:** Yes.

**Q2:**  How should we ask him the interval of time to be considered? Should we ask him to type a number of days? A number of weeks? Should we give general options like: last week, last month..., for him to select from? In case the Laboratory Coordinator chooses, for example, one week, should we consider the last 7 days, or should we consider, for example, the data from monday to sunday?

**A2:** The laboratory coordinator should introduce two dates that define an interval, the beginning date and the end date. This interval will be used to find the contiguous subsequence with maximum sum.

**Q3:** What is the meaning of "overview" here? Should the laboratory coordinator see the number of tests waiting for samples, the number of tests waiting for results, the number of tests waiting for diagnoses... Or should he see the information available for each one of the tests in the application?

**A3:** The laboratory coordinator should be able to check the number of clients, the number of tests waiting for results, the number of tests waiting for diagnosis and the total number of tests processed in the laboratory in each day, week, month and year. Moreover, the laboratory coordinator should be able to check the contiguous subsequence with maximum sum.


### 1.3. Acceptance Criteria

**AC1:** While evaluating the performance the laboratory
coordinator should have the ability to dynamically select the algorithm to be
applied from the ones available on the system

**AC2:** Support for easily
adding other similar algorithms is required.

**AC3:** the application should also display statistics and graphs.

### 1.4. Found out Dependencies

**US7, US3**

### 1.5 Input and Output Data

**Input Data:**

* Request the check the ManyLabs Test data; 
* The algorithm to be applied.

**Output Data:**

* Overview of the tests performed;
* The performed tests statistics and graphs;



### 1.6. System Sequence Diagram (SSD)

*Insert here a SSD depicting the envisioned Actor-System interactions and throughout which data is inputted and outputted to fulfill the requirement. All interactions must be numbered.*

![US16-SSD](US16-SSD.svg)


### 1.7 Other Relevant Remarks

*Use this section to capture other relevant information that is related with this US such as (i) special requirements ; (ii) data and/or technology variations; (iii) how often this US is held.* 


## 2. OO Analysis

### 2.1. Relevant Domain Model Excerpt 
*In this section, it is suggested to present an excerpt of the domain model that is seen as relevant to fulfill this requirement.* 

![US16-MD](US16-MD.svg)

### 2.2. Other Remarks

*Use this section to capture some aditional notes/remarks that must be taken into consideration into the design activity. In some case, it might be usefull to add other analysis artifacts (e.g. activity or state diagrams).* 



## 3. Design - User Story Realization 

### 3.1. Rationale

**The rationale grounds on the SSD interactions and the identified input/output data.**

| Interaction ID | Question: Which class is responsible for... | Answer  | Justification (with patterns)  |
|:-------------  |:--------------------- |:------------|:---------------------------- |
    | Step 1: requests an analysis of the performed tests 		 |	...having the performed tests stored?|   Company         | IE: Has it's own data.                            |
| Step 2: asks which algorithm should be used  		 |		...asking the user information?					 |    UI         |      UI: it's the frontier between the user and the system making it able to both interact.                        |
| Step 3: select the algorithm  		 |		...transforming the data?					 |     BenchmarkAlgorithm        |     Creator: Converts and calculates the data.                          |
| | ...sending the stored tests? | TestDTO | IE: Knows it's own data.
| Step 4: shows the data  		 |	n/a					 |         |                   |
| Step 5: confirms the data 		 |	...confirming the converted data?						 |  BenchmarkAlgorithm           |       Creator: Converts and calculates the data.                        |
| Step 6: informs operation success  		 |	...converting the converted data into a file?						 |  BenchmarkAlgorithm           |      IE: Has it's own data                        |              

### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * BenchmarkAlgorithm

Other software classes (i.e. Pure Fabrication) identified: 
 * AnalyzeTestsUI  
 * AnalyzeTestsController

## 3.2. Sequence Diagram (SD)

*In this section, it is suggested to present an UML dynamic view stating the sequence of domain related software objects' interactions that allows to fulfill the requirement.* 

![US16-SD](US16-SD.svg)


ref:

![US16-SD](Sequence Diagram1.svg)
## 3.3. Class Diagram (CD)

*In this section, it is suggested to present an UML static view representing the main domain related software classes that are involved in fulfilling the requirement as well as and their relations, attributes and methods.*

![US16-CD](US16-CD.svg)

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

# 6. Integration and Demo 

*In this section, it is suggested to describe the efforts made to integrate this functionality with the other features of the system.*


# 7. Observations

*In this section, it is suggested to present a critical perspective on the developed work, pointing, for example, to other alternatives and or future related work.*





