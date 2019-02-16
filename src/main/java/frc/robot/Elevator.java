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

public class Elevator {
  //define speedcontrollers for victors
  public static WPI_VictorSPX eMotor = new WPI_VictorSPX(5);

  //define controller and hands
  public static XboxController controller = new XboxController(0);
  public Hand leftHand = GenericHID.Hand.kLeft;
  public Hand rightHand = GenericHID.Hand.kRight;

    public void main() {
      //set the second motor to follow the first motor so they both perform the same action

      //set motor safety
      eMotor.setSafetyEnabled(false);
      eMotor.setExpiration(0.05);

      //scan for bumpers being pressed to drive the motors
      if (controller.getBumperPressed(rightHand)) {
        eMotor.set(1);
      } 
      else if (controller.getBumperPressed(leftHand)) {
        eMotor.set(-1);
      } 
      else if (controller.getBumperReleased(rightHand)) {
        eMotor.set(0);
      }
      else if (controller.getBumperReleased(leftHand)) {
        eMotor.set(0);
      }
      else {
        eMotor.set(0);
      }
    }
}
