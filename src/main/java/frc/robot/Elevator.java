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
  public static WPI_VictorSPX emotor1 = new WPI_VictorSPX(5);
  public static WPI_VictorSPX emotor2 = new WPI_VictorSPX(6);

  //define controller and hands
  public static XboxController controller = new XboxController(0);
  public Hand leftHand = GenericHID.Hand.kLeft;
  public Hand rightHand = GenericHID.Hand.kRight;

    public void teleopPeriodic() {
      //set the second motor to follow the first motor so they both perform the same action
      emotor2.follow(emotor1);
        
      //set motor safety
      emotor1.setSafetyEnabled(true);
      emotor2.setSafetyEnabled(true);
      emotor1.setExpiration(0.1);
      emotor2.setExpiration(0.1);

      //scan for bumpers being pressed to drive the motors
      if (controller.getBumperPressed(rightHand)) {
        emotor2.set(0.5);
      } 
      else if (controller.getBumper(leftHand)) {
        emotor2.set(-0.5);
      } 
      else {
        emotor2.set(0);
      }
    }
}
