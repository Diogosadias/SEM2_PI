
# Supplementary Specification (FURPS+)

## Functionality

| **_Function_**   | Description                         |                                       
|:------------------------|:-----------------|
|**Auditing**|_"To validate the work done, the laboratory coordinator checks the chemical test/result and associated diagnosis made and confirms that everything was done correctly."_|
|**Authentication**|_"All those who wish to use the application must be authenticated with a password..."_|
|**Communication**|_"...the client receives a notification alerting that the results are already available in the central application..."_|
|**Localisation**|_"The application must support the English language only."_|
|**Persistence**|_"The application should use object serialization to ensure data persistence between two runs of the application."_|
|**Printing**|_"...informing that he/she must access the application to view (test) those results..."_|
|**Reporting**|_"...requires Many Labs to summarize and report Covid-19 data,..." / "The JaCoCo plugin should be used to generate the coverage report._|
|**Scheduling**|_"The company is also required to generate daily (automatic) reports..."_|
|**Security**|_"All those who wish to use the application must be authenticated with a password..."_ / _"Only the specialist doctor is allowed to access all client data."_|
|**Transaction management**|(*) - Persistence??|
|**Workflow**|_"After completing the chemical analysis, the results of all chemical analyses are analysed by a specialist doctor who makes a diagnosis and writes a report"_|


## Usability



| **_Function_**   | **_Description_** |                                 
|:------------------------|:-----------------|
|**Accessibility**|_" All those who wish to use the application must be authenticated with a password" / "To facilitate the access to the results, the application must allow ordering the clients by TIF and by name."_|
|**Aesthetics**|_"The application graphical interface is to be developed in JavaFX 11" / "All the images/figures produced during the software development process should be recorded in SVG format"_|
|**Consistency**|_" Adopt recognized coding standards (e.g., CamelCase)..." / " Must be authenticated with a password holding seven alphanumeric characters, including three capital letters and two digits."_|


## Reliability
_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._

| **_Function_**   | Description                         |                                       
|:------------------------|:-----------------|
|**Accuracy**|_"The accuracy of the prediction models should be analysed and documented in the application user manual" / "...identifying each sample with a barcode that is automatically generated using an external API._|
|**Recoverability**|_"The application should use object serialization to ensure data persistence between two runs of the application."_|


## Performance
_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._

| **_Function_**   | Description                         |                                       
|:------------------------|:-----------------|

|**Response time**|_"...both simple linear and multiple linear regression algorithms should be evaluated to select the best model"_|
|**Throughput**|_"To facilitate the access to the results, the application must allow ordering the clients by TIF and by name. The ordering algorithm to be used by the application must be defined through a configuration file."_|



## Supportability
_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, instability, scalability and more._

| **_Function_**   | Description                         |                                       
|:------------------------|:-----------------|
|**Adaptability**|_"the application uses an external module that is responsible for doing an automatic validation using test reference values. " / " identifying each sample with a barcode that is automatically generated using an external API_|
|**Testability**| _"...the system should be developed having in mind the need to easily support other kinds of tests (e.g., urine)."_|





## +


### Design Requirements
_Specifies or constraints the system design process. Examples may include: programming languages,
software process, mandatory standards/patterns, use of development tools, class library, etc._

| **_Function_**   | Description                         |                                       
|:------------------------|:-----------------|
|**Auditing**|_"adopt recognized coding standards (e.g., CamelCase)"_|
|**Reporting**|_"use Javadoc to generate useful documentation for Java code."_|
|**Workflow**|_"...adopt best practices for identifying requirements and for OO software analysis and design"_|




***


### Implementation Requirements

_Specifies or constraints the code or construction of a system such
such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._

| **_Function_**   | Description                         |                                       
|:------------------------|:-----------------|
|**Implementation languages**|_"The application must be developed in Java language using the IntelliJ IDE or Netbeans"_|
|**Platform support**|_"All the images/figures produced during the software development process should be recorded in SVG format."_|




### Interface Requirements


| **_Function_**   | Description                         |                                       
|:------------------------|:-----------------|
|**External systems**|_"...the application uses an external module that is responsible for doing an automatic validation using test reference values." / "identifying each sample with a barcode that is automatically generated using an external API._ |
|**Interface formats**|_"The application graphical interface is to be developed in JavaFX 11."_|


### Physical Requirements

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

| **_Function_**   | Description                         |                                       
|:------------------------|:-----------------|
|**Shape**||
|**Size**||
|**Weight**||


