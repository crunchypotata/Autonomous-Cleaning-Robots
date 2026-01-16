# Autonomous Cleaning Robot

### **Author:** Aleksandra Iakimova

## Overview

This project is a Java-based navigation system for autonomous cleaning robots operating within a defined rectangular grid. The solution focuses on reliability, strict boundary control, and a clear separation of concerns.

## Architecture & Design

The application is built using **Clean Architecture** and **Hexagonal (Ports & Adapters)** principles to ensure the core logic remains independent of external interfaces.

### Key Architectural Decisions:

- **Hexagonal Architecture:** Decouples core logic from infrastructure. The domain remains pure, while the application layer orchestrates use cases.
- **Rich Domain Model (DDD):** Business rules and validations are encapsulated within domain entities to ensure state consistency.
- **TDD Approach:** Developed with a test-first mindset, resulting in high coverage and a reliable, verifiable codebase.
- **SOLID:** Adheres to clean code standards, specifically leveraging Dependency Inversion for flexible adapter management.
## Assumptions & Logic

- **Boundary Safety:** To protect the hardware, the robot will not execute a movement command if it leads outside the grid. In such cases, a DomainException is raised, and the current command sequence is terminated.
- **Sequential Processing:** Each robot finishes its entire instruction set before the user is prompted to deploy a new one.
- **Collision Management:** The current version focuses on single-robot navigation safety. Multi-robot collision avoidance is identified as a candidate for future development.

## Navigation Commands
The robot processes a sequence of instructions. Any invalid characters or movements that would result in a boundary violation are caught and reported.

- L: Rotate 90° Left
- R: Rotate 90° Right
- M: Move forward one point in the current orientation

**Note: Commands are case-insensitive.**

## Technical Stack

- **Java 23**: Core SDK
- **JUnit 5**: unit and integration testing
- **Gradle 8.x**: for build management

## How to run

1. Clone the repository. 
2. Ensure you have Java 17+ installed. 
3. Run the application using Gradle:

   ``` bash 
    ./gradlew build
    ```
   or
   ``` bash 
   ./gradlew run --console=plain
   ```
4. Run the test:
   ``` bash 
   ./gradlew test
   ```
### Future Improvements
- **Stateful Grid:** Multi-robot coordination.
- **Obstacle Mapping:** Support for non-passable cells
