/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Arm {

    //define Victor and set PWM channel
    VictorSP armMotor = new VictorSP(0);

    //define controller and hands
    XboxController controller = new XboxController(0);
    public Hand leftHand = GenericHID.Hand.kLeft;
    public Hand rightHand = GenericHID.Hand.kRight;

    public void main() {

        //get values of triggers for use
        double leftTriggerValue = controller.getTriggerAxis(leftHand);
        double rightTriggerValue = controller.getTriggerAxis(rightHand);
        
        //set motors safety
        armMotor.setSafetyEnabled(true);
        armMotor.setExpiration(0.020);

        //send values to smartdashbaord
        double armMotorSpeed = armMotor.getSpeed();
        SmartDashboard.putNumber("Arm Speed", armMotorSpeed);

        //if right trigger is pressed spin one way, if left is pressed spin other way
        if (rightTriggerValue > 0) {
            armMotor.setInverted(true);
            armMotor.set(rightTriggerValue);
            System.out.println("ARM - INTAKE " + armMotorSpeed);
            if (rightTriggerValue > 0.5) {
                armMotor.set(0.5);
            }
        }
        else if (leftTriggerValue > 0) {
            armMotor.setInverted(false);
            armMotor.set(leftTriggerValue);
            System.out.println("ARM - EXPEL " + armMotorSpeed);
            if (leftTriggerValue > 0.5) {
                armMotor.set(0.5);
            }
        else {
            armMotor.set(0);
        }
    }
    }
}
