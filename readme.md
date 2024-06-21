# Access Control System (ACS) Project - Server Side
<img src="./project%20images/main.png" alt="Descripción de la imagen" width="500"/>

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
1. Clone the repository to your local machine.
2. Open the project with your Java IDE
3. Execute `src/basenostates/usergroups/Main.java`. Ensure the run configuration is set with enabled assertions (`-ea` flag).
4. Launch the src/simulator/building.html file in any browser to start using the ACS server side
---

For more detailed information, please see the project documentation (https://github.com/lucas12avl/access_control_system_server_side/blob/master/access_control_system-Documentation.pdf).
