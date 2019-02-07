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

public class Arm {

    //define Victor and set PWM channel
    VictorSP armMotor = new VictorSP(0);

    XboxController controller = new XboxController(0);
    public Hand leftHand = GenericHID.Hand.kLeft;
    public Hand rightHand = GenericHID.Hand.kRight;

    public void teleopPeriodic() {

        double leftTriggerValue = controller.getTriggerAxis(leftHand);
        double rightTriggerValue = controller.getTriggerAxis(rightHand);

        if (rightTriggerValue > 0) {
        armMotor.set(rightTriggerValue);
        }
        else if (leftTriggerValue < 0) {
        armMotor.set(-1 * leftTriggerValue);
        }
    }
}
