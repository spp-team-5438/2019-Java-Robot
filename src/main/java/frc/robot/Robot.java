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
  private int frontLeftnum = 2;
  private int rearLeftnum = 1;
  private int frontRightnum = 4;
  private int rearRightnum = 3;

  //create speedcontroller entries for talons
  private SpeedController frontLeft = new WPI_TalonSRX(frontLeftnum);
  private SpeedController rearLeft = new WPI_TalonSRX(rearLeftnum);
  private SpeedController frontRight = new WPI_TalonSRX(frontRightnum);
  private SpeedController rearRight = new WPI_TalonSRX(rearRightnum);
  
  //create mecanum drive
  private MecanumDrive mDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
  
  //define xboxcontroller for use with mecanum drive
  private XboxController controller = new XboxController(0);
  Hand LeftHand = GenericHID.Hand.kLeft;
  Hand RightHand = GenericHID.Hand.kRight;

  //SAFETY
  public Robot() {
    mDrive.setExpiration(0.1);
    mDrive.setSafetyEnabled(true);
  }


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
    mDrive.driveCartesian((controller.getRawAxis(0) * -.5), (controller.getRawAxis(1) * .5), (controller.getRawAxis(4) * -.5));
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