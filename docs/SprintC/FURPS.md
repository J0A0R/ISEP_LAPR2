# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:_

- _are common across several US/UC;_
- _are not related to US/UC, namely: Audit, Reporting and Security._



(fill in here)
- The application should use object serialization to ensure data persistence between two runs of the application
- The application should send an SMS message when the vaccination event is scheduled ans registered in the system
- Ability of the system to respond if the SNS number is registered in the system,  show the user´s vaccination record and recommend the vaccine



### Security
- All those who wish to use the application must be authenticated with a password
- Only the nurses are allowed to access all user’s health data


## Usability

_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._


(fill in here )


### Help and Documentation
- The user manual of the application (in the annexes)


## Reliability
_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._


(fill in here )

### Possibility of prediction

- The implemented algorithm should be analyzed in
  terms of its worst-case time complexity, and it should be compared to a benchmark algorithm
  provided


## Performance
_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._


(fill in here )
### Response time
- The computational complexity analysis, must be accompanied by the observation of the
  execution time of the algorithms


## Supportability
_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and localizability._



(fill in here )
### Testability


### Compatibility
- The application must support, at least, the Portuguese and the English languages
- The software application should also be conceived having in mind that it can be further commercialized to other companies and/or organizations and/or healthcare systems besides DGS



### Design Constraints

_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._


(fill in here )
- The team must adopt recognized coding standards
- The JaCoCo plugin should be used to generate the coverage report


### Implementation Constraints

_Specifies or constraints the code or construction of a system such
such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._


(fill in here )
- The application must be developed in Java language using the IntelliJ IDE or NetBeans
- The application graphical interface is to be developed in JavaFX 11
- The unit tests should be implemented using the JUnit 5 framework
- The application graphical interface is to be developed in JavaFX 11
- The team must use Javadoc to generate useful documentation for Java code
- All the images/figures produced during the software development process should be recorded in
  SVG format
- The development team must implement unit tests for all methods
- The application should implement a brute force algorithm  to determine the contiguous subsequence with maximum sum
- For any time interval on one day, the difference between the number of new clients arrival and the number of clients leaving the center every five-minute period is computed.
- In the case of a working day, with a center open from 8 a.m. until 8 p.m., a list with
  144 integers is obtained, where a positive integer means that in such a five-minute slot more clients
  arrive at the center for vaccination than clients leave with the vaccination process completed. A
  negative integer means the opposite.



### Interface Constraints
_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._


(fill in here )

- The system should allow interaction and implementation with the DGS system for issuing the certificate

### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

(fill in here )