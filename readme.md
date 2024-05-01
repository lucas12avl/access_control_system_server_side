# Access Control System (ACS) Project

## Introduction
This project aims to design and implement a prototype of an Access Control System (ACS) as part of the software design course. The ACS manages physical security by controlling who has access to an area at any given time of any building map.

## First Milestone: Functionality
- **Locked and Unlocked States**: Introduced the basic door states of Locked and Unlocked, allowing doors to be locked or unlocked by any system user-
- **Unlock shortly and Propped State:**: Introduced some more complex states using Behavioural Patterns like Observer, visitor, State and others.
- **Door States Diagram**: Implemented a UML state diagram to represent the transitions between door states.
- **User Interface Simulator**: Developed a simulator in the form of a web page to test the ACU server and later the mobile app.

## Second Milestone: Enhanced Features and Refactoring
- **Comments and Naming**: Ensured the code is well-documented with meaningful comments and sensible naming conventions.
- **Checkstyle Compliance**: Adopted a coding style enforced by Checkstyle, except for Javadoc rules.
- **Logging**: Converted print statements into proper logging messages at various levels (DEBUG, INFO, WARNING).
- **Singleton Design Pattern**: Applied the Singleton design pattern to classes that should only have one instance during execution.
- **Refactoring**: Moved traversal methods out of partition and space classes to make the design more extensible.

## Development Tools
- **IntelliJ IDEA**: The chosen IDE for the project development.
- **PlantUML**: Used for creating UML class and state diagrams.
- **Checkstyle-IDEA**: A plugin to help adopt a coding style.
- **SLF4J and Logback**: Libraries used for logging.

## Running the Project
To run the project, load the ACU project in IntelliJ IDEA and execute `Main.java`. Ensure the run configuration is set with enabled assertions (`-ea` flag).

## Testing
Prepare a list of test cases to demonstrate the functionality of the implemented features. Use the simulator to interact with the ACU server.

## Contributions
Please list the contributions of each team member in the `autors.txt` file, detailing who did what. This is important for grading and authorship verification.

---

This README provides an overview of the first and second milestones of the ACS project. For more detailed information, please see the project documentation.
