/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Elevator {
    //define speedcontrollers for victors
    public static SpeedController emotor1 = new WPI_VictorSPX(5);
    public static SpeedController emotor2 = new WPI_VictorSPX(6);

    //define drive as variable
    public static DifferentialDrive elevatorDrive;

    public void teleopPeriodic() {
    }
}