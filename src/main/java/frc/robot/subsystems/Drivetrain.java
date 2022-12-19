// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  //change speed controller types as necessary
  
  PWMVictorSPX leftFrontMotor;
  PWMVictorSPX leftRearMotor;
  PWMVictorSPX rightFrontMotor;
  PWMVictorSPX rightRearMotor;

  SpeedControllerGroup driveMotorsLeft;
  SpeedControllerGroup driveMotorsRight;

  DifferentialDrive drive;
  

  /** Creates a new Drivetrain. */
  public Drivetrain() {
    leftFrontMotor = new PWMVictorSPX(Constants.LEFT_FRONT_MOTOR);
    leftFrontMotor.setInverted(false);
    leftRearMotor = new PWMVictorSPX(Constants.LEFT_REAR_MOTOR);
    leftRearMotor.setInverted(false);
    rightFrontMotor = new PWMVictorSPX(Constants.RIGHT_FRONT_MOTOR);
    rightFrontMotor.setInverted(false);
    rightRearMotor = new PWMVictorSPX(Constants.RIGHT_REAR_MOTOR);
    rightRearMotor.setInverted(false);

    driveMotorsLeft = new SpeedControllerGroup(leftFrontMotor, leftRearMotor);
    driveMotorsRight = new SpeedControllerGroup(rightFrontMotor, rightRearMotor);

    drive = new DifferentialDrive(driveMotorsLeft, driveMotorsRight);
    



  }

  public void driveWithJoysticks(XboxController controller, double speed)
  {
    drive.tankDrive((controller.getRawAxis(Constants.DRIVER_JOYSTICK_LEFT_Y_AXIS)*speed),(controller.getRawAxis(Constants.DRIVER_JOYSTICK_RIGHT_Y_AXIS)*speed));

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void stop() {
    drive.stopMotor();
  }
}
