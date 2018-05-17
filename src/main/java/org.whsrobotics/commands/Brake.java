package org.whsrobotics.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import org.whsrobotics.robot.OI;
import org.whsrobotics.subsystems.DriveTrain;

import static org.whsrobotics.robot.RobotMap.FLIGHTSTICK;

/**
 * Created by Billy on 5/16/18.
 * This is the first thing I've ever made in Java other than a program that prints prime numbers so don't judge me
 */

public class Brake extends Command {
    
    private static Joystick flightStick;
    flightStick = new Joystick(FLIGHTSTICK);
    
    public Brake() {
        requires(DriveTrain.getInstance());
    }

    @Override
    protected void initialize() {
        System.out.println("Billy's Brake Command Initialized");
    }

    @Override
    protected void execute() {
        if (flightStick.getTrigger()){
            DriveTrain.stopDrive();
        }
    }

    @Override
    protected void end() {
        System.out.println("Stopped braking");
    }

    @Override
    protected void interrupted() {
        System.out.println("Billy's Brake Command was rudely interrupted");
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
    
    public static Brake getInstance() {
        if (instance == null) {
            instance = new Brake();
        }

        return instance;
    }
}
