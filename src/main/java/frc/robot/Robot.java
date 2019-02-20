/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.Drivetrain;
import frc.robot.Pneumatics;
import frc.robot.Arm;
import frc.robot.Elevator;
//import frc.robot.Autonomous;
//import frc.robot.Vision;
import frc.robot.NavX;


public class Robot extends TimedRobot {

  //define all other classes
  Drivetrain mecanumDrivetrain = new Drivetrain();
  Pneumatics pneumatics = new Pneumatics();
  Arm arm = new Arm();
  Elevator elevator = new Elevator();
  //Autonomous auto = new Autonomous();
  NavX gyro = new NavX();
  //Vision vision = new Vision();


  //run when the robot is starting up; initialization code is placed here:
  @Override
  public void robotInit() {
    mecanumDrivetrain.init();
    gyro.init();
  }

  //run when the robot enters operator control:
  @Override
  public void teleopInit() {
  }

  //run periodically when the operator is in control:
  @Override
	public void teleopPeriodic() {

    //call other classes
    mecanumDrivetrain.main();
    pneumatics.main();
    arm.main();
    elevator.main();
    // vision.vision();
}

  //run when robot enters autonomous mode; initializtion for autonomous should be placed here:
  @Override
  public void autonomousInit() {
  }

  // run periodically when the robot is in autonomous mode:
  @Override
  public void autonomousPeriodic() {
    //auto.init();
  }

 // run when the robot is put into disabled mode:
  @Override
	public void disabledInit() {
  }
}