/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;

public class Elevator {
    //define speedcontrollers for victors
    public static WPI_VictorSPX emotor1 = new WPI_VictorSPX(5);
    public static WPI_VictorSPX emotor2 = new WPI_VictorSPX(6);

    public void teleopPeriodic() {
        //set the second motor to follow the first motor so they both perform the same action
        emotor2.follow(emotor1);

        //get and set the boolean values for if the bumpers are pressed or not
        public boolean rightBumperPressed = getBumperPressed(rightHand);
        public boolean leftBumperPressed = getBumperPressed(leftHand);

        //scan for bumpers being pressed to drive the motors
        //scan for bumpers not being pressed to stop the motors
        if (rightBumperPressed = true) {
          emotor2.set(0.5);
        } else if (rightBumperPressed = false) {
          emotor2.set(0);
        } else if (leftBumperPressed = true) {
          emotor2.set(-0.5);
        } else if (leftBumperPressed = false) {
          emotor2.set(0);
        }
    }
}
