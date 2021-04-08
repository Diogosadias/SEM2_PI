
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
|**Reporting**|_"...requires Many Labs to summarize and report Covid-19 data,..."_|
|**Scheduling**|_"The company is also required to generate daily (automatic) reports..."_|
|**Security**|_"All those who wish to use the application must be authenticated with a password..."_ / _"Only the specialist doctor is allowed to access all client data."_|
|**Transaction management**|(*) - Persistence??|
|**Workflow**|_"After completing the chemical analysis, the results of all chemical analyses are analysed by a specialist doctor who makes a diagnosis and writes a report"_|


## Usability

_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards.

| **_Function_**   | **_Description_** |                                 
|:------------------------|:-----------------|
|**Accessibility**||
|**Aesthetics**||
|**Consistency**|(*) Not a specific requirement|



| **JavaFX 11** |  Graphical Interface
| **Accessibility**| Some users have more permissions than others to manipulate the system data|
|**CamelCase**| Adopts recognized coding standards
|**Alphanumeric Confirmation** | Makes sure the inputted alphanumerics  follow the requirements to be accepted|
| **SVG format** | Records all images/figures produced in SVG format.|
|**Search client**|Allows lab workers to find results and access them easier|


## Reliability
_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._

| **_Function_**   | Description                         |                                       
|:------------------------|:-----------------|
|**Accuracy**||
|**Availability**||
|**Recoverability**||


| **User Manual** |  Analyzes the accuracy of the prediction models| 
| **Object Serialization**|  Ensures data persistence between two runs of the application |
|**Barcode Uniqueness**|One sample must have an unique barcode|

## Performance
_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._

| **_Function_**   | Description                         |                                       
|:------------------------|:-----------------|
|**Recovery time**||
|**Response time**||
|**Shutdown time**||
|**Start-up time**||
|**Throughput**||

| **Configuration File** |  Configures the parameters and initial settings of the algorithms|
|**Daily tests algorithm**|Adaptive software that allows program to run faster Algorithm |


## Supportability
_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, instability, scalability and more._

| **_Function_**   | Description                         |                                       
|:------------------------|:-----------------|
|**Adaptability**||
|**Auditing**||
|**Compatibility**||
|**Configurability**||
|**Instability**||
|**Maintainability**||
|**Localisation**||
|**Scalability**||
|**Testability**||


| **Test Flexiblity** |  Ensures that the system easily supports other kind of tests|
|**External Code Compatability**| Detects and analyzes external codes into the system|
|**External Software**| Lets the System cooperate with external systems
| **JaCoCo** | Generates the coverage report|



## +


### Design Requirements
_Specifies or constraints the system design process. Examples may include: programming languages,
software process, mandatory standards/patterns, use of development tools, class library, etc._

| **_Function_**   | Description                         |                                       
|:------------------------|:-----------------|
|**Auditing**||
|**Authentication**||
|**Communication**||
|**Error management**||
|**Event management**||
|**Licensing**||
|**Localisation**||
|**Online help**||
|**Persistence**||
|**Printing**||
|**Reporting**||
|**Scheduling**||
|**Security**||
|**Transaction management**||
|**Workflow**||

- **Adopt good practices when identifying requirements and for OO software analysis and design**

- **Adopt recognized coding standards**

- **Usage of Javadoc to generate useful documentation for Java code**

- **JavaDoc Generates a documentation for the Java code**
***


### Implementation Requirements

_Specifies or constraints the code or construction of a system such
such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._

| **_Function_**   | Description                         |                                       
|:------------------------|:-----------------|
|**3rd party components**||
|**Implementation languages**||
|**Platform support**||
|**Resource limits**||
|**Standards-compliance**||

- **Develop the project in Java programming language**

- **Adopt recognized coding standards**



### Interface Requirements


| **_Function_**   | Description                         |                                       
|:------------------------|:-----------------|
|**External systems**||
|**Interface formats**||

- **Development of a graphical interface using JavaFX 11**


### Physical Requirements

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

| **_Function_**   | Description                         |                                       
|:------------------------|:-----------------|
|**Shape**||
|**Size**||
|**Weight**||


- **Application must run on the hardware and software available in the current facilities of the Many Labs Company**