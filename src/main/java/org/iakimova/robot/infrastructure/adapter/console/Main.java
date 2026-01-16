package org.iakimova.robot.infrastructure.adapter.console;

import org.iakimova.robot.application.service.VacuumCleanerService;
import org.iakimova.robot.domain.exception.DomainException;
import org.iakimova.robot.domain.model.Coordinate;
import org.iakimova.robot.domain.model.Grid;
import org.iakimova.robot.domain.model.Orientation;
import org.iakimova.robot.domain.model.Robot;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n== Vacuum Cleaner Navigation System ==");

        Grid grid = initializeGrid(scanner);
        runSimulation(scanner, grid);

        System.out.println("\nSimulation finished. Systems offline.");
        scanner.close();
    }

    private static Grid initializeGrid(Scanner scanner) {
        while (true) {
            try {
                System.out.println("\n --- Grid Configuration --- ");
                System.out.print("Enter upper-right coordinates (e.g., '5 5'): ");
                int maxX = scanner.nextInt();
                int maxY = scanner.nextInt();
                return new Grid(maxX, maxY);
            } catch (Exception e) {
                System.err.println("Error: Invalid input. Please enter two integers for grid dimensions.");
                scanner.nextLine();
            }
        }
    }

    private static void runSimulation(Scanner scanner, Grid grid) {
        boolean addingRobot = true;

        while (addingRobot) {
            Robot robot = null;

            while (robot == null) {
                try {
                    System.out.println("\n--- Robot Deployment ---");
                    System.out.print("Enter landing position and orientation (e.g., '1 2 N'): ");
                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    String inputLabel = scanner.next();

                    Orientation orientation = Orientation.fromLabel(inputLabel);
                    robot = new Robot(grid, new Coordinate(x, y), orientation);
                } catch (DomainException e) {
                    System.err.println("Logic Error: " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("Input Error: Please enter two numbers and a direction letter (N, S, E, W).");
                    scanner.nextLine();
                }
            }

            boolean instructionsExecuted = false;
            while (!instructionsExecuted) {
                try {
                    System.out.print("Enter movement instructions - L: Left, R: Right, M: Move, (e.g., 'LMLMLMLMM'): ");
                    String instructions = scanner.next();

                    VacuumCleanerService service = new VacuumCleanerService(robot);
                    service.execute(instructions);

                    System.out.println("\nSuccess! Final position: " +
                            robot.getCoordinate().x() + " " +
                            robot.getCoordinate().y() + " " +
                            robot.getOrientation().getLabel());

                    instructionsExecuted = true;
                } catch (DomainException e) {
                    System.err.println("Logic Error during movement: " + e.getMessage());
                    scanner.nextLine();
                    System.out.println("Please try again for the same robot.");
                }
            }

            System.out.print("\nDeploy another robot on this grid? (y/n): ");
            addingRobot = scanner.next().equalsIgnoreCase("y");
        }
    }
}