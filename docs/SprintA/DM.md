# OO Analysis #

The construction process of the domain model is based on the client specifications, especially the nouns (for _concepts_) and verbs (for _relations_) used. 

## Rationale to identify domain conceptual classes ##
To identify domain conceptual classes, start by making a list of candidate conceptual classes inspired by the list of categories suggested in the book "Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design and Iterative Development". 


### _Conceptual Class Category List_ ###

| **Category** 		|  **Candidate Classes** |
|------------  				|---------      |
| **Business Transactions** 	| Test, Blood Tests, Covid Tests|
|**Transaction Line Items**| Sample|
|**Product/Service related to a Transaction or Transaction Line Item**| Parameter  |
|**Transaction Records**|  Report|
|**Roles of People or Organizations**|External Doctor, Client, Receptionist, Medical Lab Technicians, Chemistry Technologist, Specialist Doctor, Laboratory Coordinator, Adminstrator|
|**Places**|Clinical Analysis Laboratory, Chemical Laboratory (Company's Headquarters)|
|**Noteworthy Events**|Chemical Analysis, Diagnosis, Automatic Validation, Notification|
|**Physical Objects**| Lab Order|
|**Descriptions of Things**| Type of Test, Category|
|**Catalogs**||
|**Containers**||
|**Elements of Containers**| |
|**Organizations**|Company, NHS|
|**Other External/Collaborating Systems**| External Module,External API|
|**Records of finance, work, contracts, legal matters**|Chemical Analysis, Diagnosis, Covid-19 Report, Report, barcode|
|**Financial Instruments**||
|**Documents mentioned/used to perform some work**| Lab Order, Reports|




### **Rationale to identify associations between conceptual classes**

An association is a relationship between instances of objects that indicates a relevant connection and that is worth of remembering, or it is derivable from the List of Common Associations: 

+ **_A_** is physically or logically part of **_B_**
+ **_A_** is physically or logically contained in/on **_B_**
+ **_A_** is a description for **_B_**
+ **_A_** known/logged/recorded/reported/captured in **_B_**
+ **_A_** uses or manages or owns **_B_**
+ **_A_** is related with a transaction (item) of **_B_**
+ etc.



| Concept (A) 		|  Association   	|  Concept (B) |
|----------	   		|:-------------:		|------:       |
|Administrator|Creates|Category|
|Automatic Validation|done by |External Module|
|Barcode|associated with|Client
|Barcode|associated with|Sample
|Barcode|associated with|Test
|Barcode|given by|External API
|Blood Test| is of| Test
|Category | created by | Administrator
|Chemical Analysis|performed at|Chemical Laboratory|
|Chemical Analysis|performed by|Chemistry Technologist|
|Chemical Analysis|results in|Results|
|Chemical Laboratory	| belongs | Company|
|Chemical Laboratory	| has | Chemistry Technologist|
|Chemical Laboratory 	| receives | Sample|
|Chemistry Technologist | performs | Chemical Analyzes
|Chemistry Technologist | receives | Sample
|Chemistry Technologist | records| results
|Chemistry Technologist | works at | Chemical Laboratory
|Chemistry Technologist | works for| Company
|Client|accesses |results|
|Client|is associated with|Sample|
|Client|owns|Lab Order|
|Client|performs |Test|
|Client|receives|Notification|
|Clinical Analysis Laboratory 	| belongs | Company|
|Clinical Analysis Laboratory 	| collects | Sample|
|Clinical Analysis Laboratory 	| has | MLT|
|Clinical Analysis Laboratory 	| has | Receptionist|
|Clinical Analysis Laboratory 	| performs | Test|
|Company 	| performs| Tests|
|Company | conducts | TestType|
|Company | owns | Chemical Laboratory|
|Company| has| Administrator
|Company| has| Lab Coordinator
|Company| has| Specialist Doctor
|Company| owns | Clinical Analysis Laboratory|
|Company| owns | Company's Headquarters|
|Company| sends| Report
|Covid-19 Test| is of | Test
|Covid-19 Test| must be| Reported
|Covid-19 Test| results in| Sample(Swab)
|Diagnosis|Validated by |External Module|
|Diagnosis|written by |Specialist Doctor|
|External Doctor|gives|Lab Order|
|External Module|Validates|Diagnosis
|Lab Order|owned by|Client|
|Lab Order|prescribed by|External Doctor|
|Lab Order|required by|Test|
|Laboratory Coordinator 	| validates | Diagnosis|
|Laboratory Coordinator 	| validates | Report|
|Laboratory Coordinator 	| validates | Results|
|Laboratory Coordinator | works for | Company
|MLT | identifies | Sample
|MLT | records | Sample|
|MLT | works at | Clinical Analysis Laboratory|
|MLT | works for | Company
|NHS | receives| Report
|Notification|sent to |Client|
|Parameter 	| measured by | Test  |
|Parameter 	| presented under  | Category  |
|Receptionist | receives | Lab Order
|Receptionist | registers | Client
|Receptionist | works at | Clinical Analysis Laboratory|
|Receptionist | works for | Company
|Report|Validated|Lab Coordinator|
|Report|delivered to|Client|
|Report|made by|Specialist Doctor|
|Report|owned by|Diagnosis|
|Report|result of|Chemical Analysis|
|Sample|Collected in |Clinical Analysis Laboratory|
|Sample|associates with|Client|
|Sample|associates with|Test|
|Sample|identify with|Barcode|
|Sample|results in |results|
|Sample|results of |Test|
|Specialist Doctor | analyzes | results|
|Specialist Doctor | works for| Company|
|Specialist Doctor | writes | Diagnosis|
|Specialist Doctor | writes | Report|
|Test | is of | TestType
|Test | requested by | Client
|Test | requests analysis of | Parameter|
|Test|associates with|Sample|
|Test|needs|Lab Order|
|Test|performed at|Clinical Analysis Laboratory|
|Test|results in|Sample|



## Domain Model

**Do NOT forget to identify concepts atributes too.**

**Insert below the Domain Model Diagram in a SVG format**

![DM.svg](MD.svg)



