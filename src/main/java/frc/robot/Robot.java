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
import frc.robot.Arm;
import frc.robot.Elevator;
import frc.robot.Autonomous;
import frc.robot.Vision;


public class Robot extends TimedRobot {

  //define all other classes
  Drivetrain mecanumDrivetrain = new Drivetrain();
  Pneumatics pneumatics = new Pneumatics();
  Arm arm = new Arm();
  Elevator elevator = new Elevator();
  Autonomous auto = new Autonomous();
  Vision vision = new Vision();

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
  }

  //run periodically when the operator is in control:
  @Override
	public void teleopPeriodic() {
    mecanumDrivetrain.main();
    pneumatics.main();
    arm.main();
    elevator.main();
    
    //target alignment using vision tracking triggered by the driver
    vision.assist_vision();

    if (controller2.getAButton()) {
      elevator.bottom_position();
    }
    else if (controller2.getXButton()) {
      elevator.middle_position();
    }
    else if (controller2.getYButton()) {
      elevator.top_position();
    }

    //elevator presets with dpad
    // if (dPadYAxis == -1.0) {
    //   elevator.bottom_position();
    // }
    // else if (dPadXAxis == 1.0) {
    //   elevator.middle_position();
    // }
    // else if (dPadYAxis == 1.0) {
    //   elevator.top_position();
    // }
}

  //run when robot enters autonomous mode; initializtion for autonomous should be placed here:
  @Override
  public void autonomousInit() {
    auto.init();
    auto.drive_forward(2);
  }

  // run periodically when the robot is in autonomous mode:
  @Override
  public void autonomousPeriodic() {
    //fully auto following based on vision targeting (ghetto limelight)
    //auto.vision_based();
  }
}
