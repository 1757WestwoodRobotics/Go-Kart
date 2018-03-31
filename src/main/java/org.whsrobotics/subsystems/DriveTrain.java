package org.whsrobotics.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Encoder;
import org.whsrobotics.robot.OI;
import org.whsrobotics.robot.RobotMap;

public class DriveTrain extends Subsystem {

    private static WPI_TalonSRX leftFront;
    private static WPI_TalonSRX leftBack;
    private static WPI_TalonSRX rightFront;
    private static WPI_TalonSRX rightBack;
    private static WPI_TalonSRX rightMiddle;
    private static WPI_TalonSRX leftMiddle;

    private static SpeedControllerGroup leftDrive;
    private static SpeedControllerGroup rightDrive;

    private static DifferentialDrive differentialDrive;

    private static DriveTrain instance;

    public DriveTrain() {

            leftFront = new WPI_TalonSRX(RobotMap.MotorControllers.DRIVE_LEFT_FRONT.tal);
            rightFront = new WPI_TalonSRX(RobotMap.MotorControllers.DRIVE_RIGHT_FRONT.tal);
            leftBack = new WPI_TalonSRX(RobotMap.MotorControllers.DRIVE_LEFT_BACK.tal);
            rightBack = new WPI_TalonSRX(RobotMap.MotorControllers.DRIVE_RIGHT_BACK.tal);
            leftMiddle = new WPI_TalonSRX(RobotMap.MotorControllers.DRIVE_LEFT_MIDDLE.tal);
            rightMiddle = new WPI_TalonSRX(RobotMap.MotorControllers.DRIVE_RIGHT_MIDDLE.tal);
    }


    @Override
    protected void initDefaultCommand() {
    }

    @Override
    public void periodic() {
    }

    private static void drive(double speed, double rotation, boolean squaredInputs) {
            differentialDrive.arcadeDrive(speed, rotation, squaredInputs);
    }

    public static void flightStickDrive(double speed, double rotation) {
        drive(OI.flightstickCurve(speed),OI.flightstickCurve(rotation),true);
    }

    public static DriveTrain getInstance() {
        if (instance == null) {
            instance = new DriveTrain();
        }

        return instance;
    }

    public static void stopDrive() {
        differentialDrive.stopMotor();
    }

}