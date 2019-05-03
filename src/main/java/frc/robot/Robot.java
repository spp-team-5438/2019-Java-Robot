/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.Drivetrain;
import frc.robot.Pneumatics;
import frc.robot.Intake;
import frc.robot.Elevator;

public class Robot extends TimedRobot {

  //define all other classes
  Drivetrain mecanumDrivetrain = new Drivetrain();
  Pneumatics pneumatics = new Pneumatics();
  Intake intake = new Intake();
  Elevator elevator = new Elevator();
  //Autonomous auto = new Autonomous();
  //Vision vision = new Vision();

  //define controller
  public static XboxController controller = new XboxController(0);
  public static XboxController controller2 = new XboxController(1);
  double dPadXAxis = controller.getRawAxis(5);
  double dPadYAxis = controller.getRawAxis(6);

  //run when the robot is starting up; initialization code is placed here:
  @Override
  public void robotInit() {
  }

  //run when the robot enters operator control:
  @Override
  public void teleopInit() {
    mecanumDrivetrain.init();
    elevator.init();
	  intake.init();
  }

  //run periodically when the operator is in control:
  @Override
	public void teleopPeriodic() {
    mecanumDrivetrain.main();
    pneumatics.main();
    intake.main();
    elevator.main();
}

  //run when robot enters autonomous mode; initializtion for autonomous should be placed here:
  @Override
  public void autonomousInit() {
  }

  // run periodically when the robot is in autonomous mode:
  @Override
  public void autonomousPeriodic() {
    teleopPeriodic();
  }
}
