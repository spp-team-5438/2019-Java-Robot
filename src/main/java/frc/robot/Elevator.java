/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Elevator {
  //define speedcontrollers for victors
  public static WPI_VictorSPX eMotor = new WPI_VictorSPX(5);

  //define controller and hands
  public static XboxController controller = new XboxController(0);
  public Hand leftHand = GenericHID.Hand.kLeft;
  public Hand rightHand = GenericHID.Hand.kRight;

  public void main() {
    //set motor safety
    eMotor.setSafetyEnabled(true);
    eMotor.setExpiration(0.02);

    //send data to smartdashboard
    double eMotorspeed = eMotor.getMotorOutputPercent();
    SmartDashboard.putNumber("Elevator Speed", eMotorspeed);

    //print statements
    if (controller.getBumperPressed(rightHand)) {
      System.out.println("RIGHT BUMPER PRESSED - ELEVATOR GOING UP!");
    }
    else if (controller.getBumperPressed(leftHand)) {
      System.out.println("LEFT BUMPER PRESSED - ELEVATOR GOING DOWN!");
    }

    //scan for bumpers being pressed to drive the motors
    if (controller.getBumper(rightHand)) {
      eMotor.set(1);
    } 
    else if (controller.getBumper(leftHand)) {
      eMotor.set(-1);
    } 
    else if (controller.getBumperReleased(rightHand)) {
      System.out.println("RIGHT BUMPER RELEASED!");
      eMotor.set(0);
    }
    else if (controller.getBumperReleased(leftHand)) {
      System.out.println("LEFT BUMPER RELEASED!");
      eMotor.set(0);
    }
    else {
      eMotor.set(0);
    }
  }
}
