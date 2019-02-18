/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import frc.robot.Drivetrain;

public class Vision {
    private NetworkTableEntry tapeDetected, tapeDistance;
    NetworkTableInstance instance = NetworkTableInstance.getDefault();
    NetworkTable vision = instance.getTable("Vision");
    Drivetrain mecanumDrivetrain = new Drivetrain();

    public void vision() {
        NetworkTableEntry tapeDetected = vision.getEntry("tapeDetected");
        NetworkTableEntry tapeDistance = vision.getEntry("tapeDistance");
        if(tapeDetected.getBoolean(true)) {
            if(tapeDistance.getDouble(0) < 5) {
              System.out.println("less than 5!");
            } else {
                System.out.println("more than 5!");
                // mecanumDrivetrain.driveStraight();
            }
          }
    }
    
   

}