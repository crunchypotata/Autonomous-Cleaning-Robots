package org.iakimova.robot.application.service;

import org.iakimova.robot.domain.exception.DomainException;
import org.iakimova.robot.domain.model.Instruction;
import org.iakimova.robot.domain.model.Robot;

import java.util.List;

public class VacuumCleanerService {
    private final Robot robot;

    public VacuumCleanerService(Robot robot) {
        this.robot=robot;
    }
    public void execute(String instructions) throws DomainException {
        List<Instruction> commands = Instruction.parse(instructions);

        for (Instruction command : commands) {
            switch (command) {
                case L -> robot.turnLeft();
                case R -> robot.turnRight();
                case M -> robot.move();
            }
        }
    }
}
