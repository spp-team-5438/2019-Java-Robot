/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;

import frc.robot.Drivetrain;
import frc.robot.Pneumatics;
import frc.robot.Arm;
import frc.robot.Camera;
import frc.robot.Elevator;
import frc.robot.REVDigitBoard;
import frc.robot.Autonomous;

public class Robot extends TimedRobot {

  //define all other classes
  Drivetrain mecanumDrivetrain = new Drivetrain();
  Pneumatics pneumatics = new Pneumatics();
  Arm arm = new Arm();
  Camera camera = new Camera();
  Elevator elevator = new Elevator();
  REVDigitBoard display = new REVDigitBoard();
  Autonomous auto = new Autonomous();

  //define xbox controller
  public static XboxController controller = new XboxController(0);

  //run when the robot is starting up; initialization code is placed here:
  @Override
  public void robotInit() {
    display.display("5438");
    camera.main();
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
}

  //run when robot enters autonomous mode; initializtion for autonomous should be placed here:
  @Override
  public void autonomousInit() {
  }

  // run periodically when the robot is in autonomous mode:
  @Override
  public void autonomousPeriodic() {
    auto.init();
  }

 // run when the robot is put into disabled mode:
  @Override
	public void disabledInit() {
  }
}