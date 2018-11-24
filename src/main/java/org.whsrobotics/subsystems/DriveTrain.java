package org.whsrobotics.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import org.whsrobotics.commands.FlightStickDrive;
import org.whsrobotics.robot.RobotMap;
import org.whsrobotics.robot.Telemetry;
import org.whsrobotics.utils.BAPMController;

public class DriveTrain extends Subsystem {

    private static WPI_TalonSRX leftFront;
    private static WPI_TalonSRX leftBack;
    private static WPI_TalonSRX rightFront;
    private static WPI_TalonSRX rightBack;
    private static BAPMController bapmController;

    private static SpeedControllerGroup leftDrive;
    private static SpeedControllerGroup rightDrive;

    private static DifferentialDrive differentialDrive;

    private static DriveTrain instance;

    public DriveTrain() {

        bapmController = new BAPMController(0);

        // Regular DriveTrain

        leftFront = new WPI_TalonSRX(RobotMap.MotorControllers.DRIVE_LEFT_FRONT.tal);
        rightFront = new WPI_TalonSRX(RobotMap.MotorControllers.DRIVE_RIGHT_FRONT.tal);
        leftBack = new WPI_TalonSRX(RobotMap.MotorControllers.DRIVE_LEFT_BACK.tal);
        rightBack = new WPI_TalonSRX(RobotMap.MotorControllers.DRIVE_RIGHT_BACK.tal);

        setBrakeMode();

        leftDrive = new SpeedControllerGroup(leftFront, leftBack);
        rightDrive = new SpeedControllerGroup(rightFront, rightBack);

        differentialDrive = new DifferentialDrive(leftDrive, rightDrive);

    }

    private enum Modes {
        NONE, REGULAR, BAPM
    }

    private Modes determineMode() {
        String commandName = getCurrentCommandName();

        if (commandName.contains("BAPMDrive")) {
            return Modes.BAPM;
        } else if (commandName.contains("FlightStickDrive")) {
            return Modes.REGULAR;
        } else {
            return Modes.NONE;
        }

    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new FlightStickDrive());
    }

    @Override
    public void periodic() {

        // Current Mode
        Telemetry.recordTelemetry("Drive Mode", determineMode().toString());

        // Encoder values?

        // Motor currents
        Telemetry.recordTelemetry("MotorFL_Current", leftFront.getOutputCurrent());
        Telemetry.recordTelemetry("MotorBL_Current", leftBack.getOutputCurrent());
        Telemetry.recordTelemetry("MotorFR_Current", rightFront.getOutputCurrent());
        Telemetry.recordTelemetry("MotorBR_Current", rightBack.getOutputCurrent());
    }

    public static void drive(double speed, double rotation) {
        differentialDrive.arcadeDrive(speed, rotation);
    }

    /**
     *
     * @param speed
     * @param rotation
     */
    public static void BAPMdrive(double speed, double rotation) {

        // Only enable BAPM if speed is greater than 0.05 (positive) AND rotation is minimal (0.1?)!!!
        if (speed > 0.05 && rotation < 0.1) {
            bapmController.setPercentVoltage(speed);
        }

        drive(speed, rotation);

    }


    public static DriveTrain getInstance() {
        if (instance == null) {
            instance = new DriveTrain();
        }

        return instance;
    }

    public static void stopDrive() {
        differentialDrive.stopMotor();
        bapmController.stopMotor();
    }

    public static void setBrakeMode() {
        leftFront.setNeutralMode(NeutralMode.Brake);
        leftBack.setNeutralMode(NeutralMode.Brake);
        rightFront.setNeutralMode(NeutralMode.Brake);
        rightBack.setNeutralMode(NeutralMode.Brake);
    }

    public static void setCoastMode() {
        leftFront.setNeutralMode(NeutralMode.Coast);
        leftBack.setNeutralMode(NeutralMode.Coast);
        rightFront.setNeutralMode(NeutralMode.Coast);
        rightBack.setNeutralMode(NeutralMode.Coast);
    }

}