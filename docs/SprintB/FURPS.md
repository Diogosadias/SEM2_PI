
# Supplementary Specification (FURPS+)

## Functionality

| **_Function_**   | Description                         |                                       
|:------------------------|:-----------------|
|**Auditing**|_"To validate the work done, the laboratory coordinator checks the chemical test/result and associated diagnosis made and confirms that everything was done correctly."_|
|**Authentication**|_"All those who wish to use the application must be authenticated with a password..."_|
|**Communication**|_"...the client receives a notification alerting that the results are already available in the central application..."_|
|**Persistence**|_"The application should use object serialization to ensure data persistence between two runs of the application." / [Client's Email](References.md) :  "Whenever the system fails, there should be no data loss."_|
|**Reporting**|_"...requires Many Labs to summarize and report Covid-19 data,..." / "The JaCoCo plugin should be used to generate the coverage report._|
|**Scheduling**|_"The company is also required to generate daily (automatic) reports..."_|
|**Security**|_"All those who wish to use the application must be authenticated with a password..."_ / _"Only the specialist doctor is allowed to access all client data."_|
|**Workflow**|_"After completing the chemical analysis, the results of all chemical analyses are analysed by a specialist doctor who makes a diagnosis and writes a report"_|


## Usability



| **_Function_**   | **_Description_** |                                 
|:------------------------|:-----------------|
|**Accessibility**|_"To facilitate the access to the results, the application must allow ordering the clients by TIF and by name."_|
|**Aesthetics**|_"The application graphical interface is to be developed in JavaFX 11" / "All the images/figures produced during the software development process should be recorded in SVG format" / [Client's Email](References.md) :"The user interface must be simple, intuitive and consistent."_|
|**Consistency**|_" Must be authenticated with a password holding seven alphanumeric characters, including three capital letters and two digits." / [Client's Email](References.md) : "The user interface must be simple, intuitive and consistent."_|
|**Performace**|

## Reliability
_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._

| **_Function_**   | Description                         |                                       
|:------------------------|:-----------------|
|**Accuracy**|_"The accuracy of the prediction models should be analysed and documented in the application user manual"_|
|**Availability**|[Client's Email](References.md) :_"The system should not fail more than 5 days in one year."_
|**Recoverability**|_"The application should use object serialization to ensure data persistence between two runs of the application."_ |


## Performance
_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._

| **_Function_**   | Description                         |                                       
|:------------------------|:-----------------|
|**Response time**|_"...both simple linear and multiple linear regression algorithms should be evaluated to select the best model" / [Client's Email](References.md) :"Any interface between a user and the system shall have a maximum response time of 3 seconds."_|
|**Start-up time**|_[Client's Email](References.md) :"The system should start up in less than 10 seconds."_|


## Supportability
_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, instability, scalability and more._

| **_Function_**   | Description                         |                                       
|:------------------------|:-----------------|
|**Configurability**|_"The ordering algorithm to be used by the application must be defined through a configuration file."_|
|**Localizability**|_"The application must support the English language only."_|
|**Testability**| _"The development team must implement unit tests for all methods except methods that implement Input/Output operations. The unit tests should be implemented using the JUnit 4 framework. "_|




***

## +


### Design Requirements
_Specifies or constraints the system design process. Examples may include: programming languages,
software process, mandatory standards/patterns, use of development tools, class library, etc._

| **_Function_**   | Description                         |                                       
|:------------------------|:-----------------|
|**Auditing**|_"Only the specialist doctor is allowed to access all client data."_|
|**Authentication**|_"All those who wish to use the application must be authenticated with a password holding seven alphanumeric characters, including three capital letters and two digits."_|
|**Communication**|_"...the client receives a notification alerting that the results are already available in the central application..."_ / Information given by the Client though Moodle - _"It will be a simple text message saying that the results are "already available in the central application and informing that he/she must access the application to view those results"."_|
|**Reporting**|_"The company is also required to generate daily (automatic) reports with all the information demanded by the NHS and should send them to the NHS using their API"_|




### Implementation Requirements

_Specifies or constraints the code or construction of a system such
such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._

| **_Function_**   | Description                         |                                       
|:------------------------|:-----------------|
|**Implementation languages**|_"The application must be developed in Java language using the IntelliJ IDE or Netbeans"_|
|**Standards-compliance**|_"(i) adopt best practices for identifying requirements and for OO software analysis and design; (ii) adopt recognized coding standards (e.g., CamelCase); (iii) use Javadoc to generate useful documentation for Java code."_
|**Platform support**|_[Client's Email](References.md) : "The application should run on all platforms for which there exists a Java Virtual Machine."_|



### Interface Requirements


| **_Function_**   | Description                         |                                       
|:------------------------|:-----------------|
|**External systems**|_"...the application uses an external module that is responsible for doing an automatic validation using test reference values." / "identifying each sample with a barcode that is automatically generated using an external API._ |
|**Interface formats**|_"The application graphical interface is to be developed in JavaFX 11."_|


### Physical Requirements

Our working group did not find any kind of physical requirements in the information provided by the Client.
