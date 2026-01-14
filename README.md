# Autonomous Cleaning Robot

### **Author:** Aleksandra Iakimova

## Overview

This project is a Java-based solution for controlling autonomous cleaning robots. The application manages robots' movement on a rectangular grid based on sequential instructions .

## Technical Decisions
### Rich Domain Model

I implemented a **Rich Domain Model** to ensure that business logic is encapsulated directly within domain objects (Robot, Orientation, Coordinate). <br>

**Benefits of this approach:**

- **Encapsulation:** Logic for movement and rotation is placed where the data lives, preventing "Anemic Domain Model" issues
- **Consistency:** Domain rules (for example, not moving out of bounds) are enforced by the objects themselves, making the system less error-prone
- **Maintainability:** The code is easier to reason about and extend without breaking existing behavior

### Architecture

The project follows a **Hexagonal Architecture (Ports & Adapters)** to separate the core logic from external dependencies:

- **Domain**: Pure Java logic, independent of any frameworks
- **Application**: Contains use cases and defines Input/Output ports
- **Infrastructure** : Implements adapters for console I/O.

## Assumptions

- **Grid Boundaries:** If a robot receives a move command that would take it outside the grid, it ignores that specific movement command to prevent damage (or throws a domain exception, depending on your final choice).
- **Input Format:** Input follows the exact specification provided in the challenge
- **Sequential Execution:** Each robot completes its entire instruction set before the next one starts

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
## Technologies

- **Java 23**: no framework
- **JUnit 5**: unit and integration testing
- **Gradle**: for build management
