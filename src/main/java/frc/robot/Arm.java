/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
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

public class Arm {

    //define motor controller
    WPI_TalonSRX armMotor = new WPI_TalonSRX(2);

    //define controller and hands
    XboxController controller = new XboxController(0);
    public Hand leftHand = GenericHID.Hand.kLeft;
    public Hand rightHand = GenericHID.Hand.kRight;

    public void main() {

        //get values of triggers for use
        double leftTriggerValue = controller.getTriggerAxis(leftHand);
        double rightTriggerValue = controller.getTriggerAxis(rightHand);
        double correct_rightTriggerValue = (-1*rightTriggerValue);
        
        //set motors safety
        armMotor.setSafetyEnabled(true);
        armMotor.setExpiration(0.5);

        //send values to smartdashbaord
        double armMotorSpeed = armMotor.getMotorOutputPercent();
        SmartDashboard.putNumber("Arm Speed", armMotorSpeed);

        //conditionals for operating the intake motor with bumpers
        if (controller.getBumper(rightHand)) {
            armMotor.set(-0.5);
            System.out.println("Intaking...");
          }
          else if (controller.getBumper(leftHand)) {
            armMotor.set(0.5);
            System.out.println("Expelling...");
          }
          else if (controller.getBumperReleased(rightHand)) {
            armMotor.set(0);
          }
          else if (controller.getBumperReleased(leftHand)) {
            armMotor.set(0);
          }
          else {
            armMotor.set(0);
          }
        
        //if right trigger is pressed spin one way, if left is pressed spin other way
        // if (rightTriggerValue > 0) {
        //     armMotor.set(correct_rightTriggerValue);
        //     System.out.println("ARM - INTAKE " + armMotorSpeed);
            
        //     //cap speed at -0.5
        //     if (correct_rightTriggerValue < -0.5) {
        //         armMotor.set(-0.5); 
        //     }
        //     else {
        //         armMotor.set(correct_rightTriggerValue);
        //     }
        // }
        // else if (leftTriggerValue > 0) {
        //     armMotor.set(leftTriggerValue);
        //     System.out.println("ARM - EXPEL " + armMotorSpeed);
            
        //     //cap speed at 0.5
        //     if (leftTriggerValue > 0.5) {
        //         armMotor.set(0.5);
        //     }
        //     else {
        //         armMotor.set(leftTriggerValue);
        //     }
        // }
        // else {
        //     armMotor.set(0);
        // }
    }
}
