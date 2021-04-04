
# Supplementary Specification (FURPS+)

## Functionality

| **_Function_**   | Description                         |                                       
|:------------------------|:-----------------|
| **Email** |  Existence of email services to inform the client.
| **SMS** | Existence of SMS services to inform the client. |
|**Authentication**| Ensures that only certain people are able to get into the system |
|**Ordering**|Orders the clients by name and TIF|
|**Registering**| Registers a new client into the system
|**Validation**| Validates analysis and reports|
|**Record** | Records the samples tests results and reports|
|**Associating**|Connecting the samples with the client/test |
|**Identifying Sample**|Give sample an identifying barcode provide by an external API|
|**Tracking**|Allows workers to know where a sample is located or if it is in travel|
|**Notify**|Sending notification via Email or SMS to client to inform results are available|
|**Generate Daily Reports**|Generate reports to be send to the NHS|

## Usability

_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards.

| **_Function_**   | **_Description_** |                                 
|:------------------------|:-----------------|
| **JavaFX 11** |  Graphical Interface
|**JavaDoc**| Generates a documentation for the Java code|
| **Accessibility**| Some users have more permissions than others to manipulate the system data|
|**CamelCase**| Adopts recognized coding standards
|**Alphanumeric Confirmation** | Makes sure the inputted alphanumerics  follow the requirements to be accepted|
| **JaCoCo** | Generates the coverage report|
| **SVG format** | Records all images/figures produced in SVG format.|
|**Search client**|Allows lab workers to find results and access them easier|


## Reliability
_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._

| **_Function_**   | Description                         |                                       
|:------------------------|:-----------------|
| **User Manual** |  Analyzes the accuracy of the prediction models| 
| **Object Serialization**|  Ensures data persistence between two runs of the application |
|**Barcode Uniqueness**|One sample must have an unique barcode|

## Performance
_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._

| **_Function_**   | Description                         |                                       
|:------------------------|:-----------------|
| **Configuration File** |  Configures the parameters and initial settings of the algorithms|
|**Daily tests algorithm**|Adaptive software that allows program to run faster Algorithm |


## Supportability
_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, instability, scalability and more._

| **_Function_**   | Description                         |                                       
|:------------------------|:-----------------|
| **Test Flexiblity** |  Ensures that the system easily supports other kind of tests|
|**External Code Compatability**| Detects and analyzes external codes into the system|
|**External Software**| Lets the System cooperate with external systems



## +


### Design Constraints
_Specifies or constraints the system design process. Examples may include: programming languages,
software process, mandatory standards/patterns, use of development tools, class library, etc._

- **Development of a graphical interface using JavaFX 11**

- **Adopt good practices when identifying requirements and for OO software analysis and design**

- **Adopt recognized coding standards**

- **Usage of Javadoc to generate useful documentation for Java code**

***


### Implementation Constraints

_Specifies or constraints the code or construction of a system such
such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._

- **Develop the project in Java programming language**

- **Adopt recognized coding standards**



### Interface Constraints

- **Development of a graphical interface using JavaFX 11**


### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

- **Application must run on the hardware and software available in the current facilities of the Many Labs Company**