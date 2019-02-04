/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.TimedRobot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class Robot extends TimedRobot {

  //define numbers of talons
  public static int frontLeftnum = 2;
  public static int rearLeftnum = 1;
  public static int frontRightnum = 4;
  public static int rearRightnum = 3;

  //create speedcontroller entries for talons
  public static SpeedController frontLeft = new WPI_TalonSRX(frontLeftnum);
  public static SpeedController rearLeft = new WPI_TalonSRX(rearLeftnum);
  public static SpeedController frontRight = new WPI_TalonSRX(frontRightnum);
  public static SpeedController rearRight = new WPI_TalonSRX(rearRightnum);

  //create mecanum drive
  public static MecanumDrive mDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);

  //define xbox controller for use with mecanum drive
  public static XboxController controller = new XboxController(0);
  public Hand leftHand = GenericHID.Hand.kLeft;
  public Hand rightHand = GenericHID.Hand.kRight;

  //run when the robot is starting up; initialization code is placed here:
  @Override
  public void robotInit() {
  }

  //run when the robot enters operator control:
  @Override
  public void teleopInit() {
  }

  //run periodically when the operator is in control:
  @Override
	public void teleopPeriodic() {

    //create drivetrain with controller inputs and set safety
    mDrive.driveCartesian((controller.getRawAxis(0)), (controller.getRawAxis(1)), (controller.getRawAxis(4)));
    mDrive.setMaxOutput(0.5);
    mDrive.setExpiration(0.1);
    mDrive.setSafetyEnabled(true);

    // TEST ROBOT OFF GROUND TO TEST INVERTED OR not
    // TO INVERT: motor.setInverted(true)

    //alt method:
    //mDrive.driveCartesian((controller.getRawAxis(0) * -.5), (controller.getRawAxis(1) * .5), (controller.getRawAxis(4) * -.5));
  }

  //run when robot enters autonomous mode; initializtion for autonomous should be placed here:
  @Override
  public void autonomousInit() {
  }

  // run periodically when the robot is in autonomous mode:
  @Override
  public void autonomousPeriodic() {
  }

  // run when the robot enters test mode:
  @Override
  public void testInit() {
  }

  // run periodically when the robot is in test mode:
  @Override
  public void testPeriodic() {
  }

 // run when the robot is put into disabled mode:
  @Override
	public void disabledInit() {
  }

}
