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
import frc.robot.Elevator;

import edu.wpi.first.wpilibj.XboxController;

public class Vision {

    Elevator elevator = new Elevator();

    private NetworkTableEntry tapeDetected, tapeDistance, tapeYaw;
    NetworkTableInstance instance = NetworkTableInstance.getDefault();
    NetworkTable vision = instance.getTable("Vision");
    Drivetrain mecanumDrivetrain = new Drivetrain();
    XboxController controller = new XboxController(0);

    public void auto_vision() {
        NetworkTableEntry tapeDetected = vision.getEntry("tapeDetected");
        NetworkTableEntry tapeDistance = vision.getEntry("tapeDistance");
        NetworkTableEntry tapeYaw = vision.getEntry("tapeYaw");
        if(tapeDetected.getBoolean(true)) {
            if(tapeDistance.getDouble(0) < 50) {
                if(tapeYaw.getDouble(0) < -2) {
                    mecanumDrivetrain.driveRight();
                } else if (tapeYaw.getDouble(0) > 2) {
                    mecanumDrivetrain.driveLeft();
                }
            } else {
                mecanumDrivetrain.driveStraight();
            }
          }
    }

    public void assist_vision() {
        NetworkTableEntry tapeDetected = vision.getEntry("tapeDetected");
        NetworkTableEntry tapeYaw = vision.getEntry("tapeYaw");
        NetworkTableEntry tapePitch = vision.getEntry("tapePitch");

        if((tapeDetected.getBoolean(true)) && (controller.getBButton())) {
            if(tapeYaw.getDouble(0) < -2) {
                mecanumDrivetrain.driveRight();
            } 
            else if (tapeYaw.getDouble(0) > 2) {
                mecanumDrivetrain.driveLeft();
            }

            // elevator
            if(tapePitch.getDouble(0) < -1) {
                elevator.up();
            } 
            else if (tapePitch.getDouble(0) > 1) {
                elevator.down();
            }

        }
       
    }
    }



