# OO Analysis #

The construction process of the domain model is based on the client specifications, especially the nouns (for _concepts_) and verbs (for _relations_) used. 

## Rationale to identify domain conceptual classes ##
To identify domain conceptual classes, start by making a list of candidate conceptual classes inspired by the list of categories suggested in the book "Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design and Iterative Development". 


### _Conceptual Class Category List_ ###

| **Category** 		|  **Candidate Classes** |
|------------  				|---------      |
| **Business Transactions** 	| Test|
|**Transaction Line Items**| Sample|
|**Product/Service related to a Transaction or Transaction Line Item**| Parameter  |
|**Transaction Records**|  Reports|
|**Roles of People or Organizations**|External Doctor, Client, Receptionist, Medical Lab Technicians, Chemistry Technologist, Courier, Specialist Doctor, Laboratory Coordinator, Adminstrator|
|**Places**|Clinical Analysis Laboratory, Chemical Laboratory, Company's Headquarters|
|**Noteworthy Events**|Chemical Analysis, Diagnosis, Automatic Validation, Notification|
|**Physical Objects**| Lab Order|
|**Descriptions of Things**| Type of Test, Category|
|**Catalogs**||
|**Containers**|Client's Information, Test's Information|
|**Elements of Containers**||
|**Organizations**|Company, NHS|
|**Other External/Collaborating Systems**| External Module,  SVG|
|**Records of finance, work, contracts, legal matters**|Chemical Analysis, Diagnosis, Reports, barcode|
|**Financial Instruments**||
|**Documents mentioned/used to perform some work**| Lab Order, Reports|
|**etc.**|Password|



###**Rationale to identify associations between conceptual classes**###

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
| Company 	| performs| Tests|
|Company | conducts | TestType|
|Company | owns | Chemical Laboratory|
|Company| owns | Clinical Analysis Laboratory|
|Company| owns | Company's Headquarters|
| Parameter 	| presented under  | Category  |
| Category | created by | Adminstrator
| Test | requested by | Client
| Test | is of | TestType
|Test | resquests analysis of | Parameter|
| Recepcionist | receives | Lab Order
| Recepcionist | registers | Client
| Recepcionist | works for | Company
| Specialist Doctor | writes | Diagnosis|
| Specialist Doctor | works for| Company|
| MLT | records | Sample|
|MLT | works for | Company
| Chemistry Technologist | performs | Chemical Analyzes
| Chemistry Technologist | receives | Sample
|Chemistry Technologist | works for| Company
| Clinical Analysis Laboratory 	| collects | Sample|
| Chemical Laboratory 	| receives | Sample|
| Laboratory Coordinator 	| validates | Diagnosis|
| Laboratory Coordinator | works for | Company





## Domain Model

**Do NOT forget to identify concepts atributes too.**

**Insert below the Domain Model Diagram in a SVG format**

![DM.svg](DM.svg)



