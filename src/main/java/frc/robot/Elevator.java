/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

public class Elevator {
  //define motor controller
  public static WPI_TalonSRX eMotor = new WPI_TalonSRX(4);

  //define controller and hands
  public static XboxController controller = new XboxController(0);
  public Hand leftHand = GenericHID.Hand.kLeft;
  public Hand rightHand = GenericHID.Hand.kRight;

  public void init() {
    eMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    eMotor.setSelectedSensorPosition(0);
  }
  
  
  public void main() {
    //set motor safety
    eMotor.setSafetyEnabled(true);
    eMotor.setExpiration(0.5);
    int actual_position = eMotor.getSelectedSensorPosition();

    //send data to smartdashboard
    double eMotorspeed = eMotor.getMotorOutputPercent();
    SmartDashboard.putNumber("Elevator Speed", eMotorspeed);
    SmartDashboard.putNumber("Elevator Encoder", actual_position);

    //print statements
    if (controller.getBumperPressed(rightHand)) {
      System.out.println("RIGHT BUMPER PRESSED - ELEVATOR GOING UP!");
    }
    else if (controller.getBumperPressed(leftHand)) {
      System.out.println("LEFT BUMPER PRESSED - ELEVATOR GOING DOWN!");
    }

    //scan for bumpers being pressed to drive the motors
    if (controller.getBumper(rightHand)) {
      eMotor.set(-1);
    }
    else if (controller.getBumper(leftHand)) {
      eMotor.set(1);
    }
    else if (controller.getBumperReleased(rightHand)) {
      System.out.println("RIGHT BUMPER RELEASED!");
      eMotor.set(-0.07);
    }
    else if (controller.getBumperReleased(leftHand)) {
      System.out.println("LEFT BUMPER RELEASED!");
      eMotor.set(-0.07);
    }
    else {
      eMotor.set(-0.07);
    }
  }

  //Encoder present positions
  int encoderBottomPosition = 0;
  int encoderMiddlePosition = 200;
  int encoderTopPosition = 400;

  public void up(){
    eMotor.set(-1);
  }
  
  public void down(){
    eMotor.set(1);
  }

  public void bottom_position() {
    int actual_position = eMotor.getSelectedSensorPosition();
    int gotoBottomPos = (encoderBottomPosition + (-1*actual_position));
    eMotor.set(ControlMode.Position, gotoBottomPos);
  }

  public void middle_position() {
    int actual_position = eMotor.getSelectedSensorPosition();
    int gotoMiddlePos = (encoderMiddlePosition + (-1*actual_position));
    eMotor.set(ControlMode.Position, gotoMiddlePos);
  }

  public void top_position() {
      int actual_position = eMotor.getSelectedSensorPosition();
      int gotoTopPos = (encoderTopPosition + (-1*actual_position));
      eMotor.set(ControlMode.Position, gotoTopPos);
  }
}