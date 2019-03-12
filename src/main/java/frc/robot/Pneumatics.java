/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.XboxController;

 public class Pneumatics {

    //define solenoids and compressor
    DoubleSolenoid solenoidPush = new DoubleSolenoid(3, 0);
    //DoubleSolenoid solenoidPush = new DoubleSolenoid(0, 1);
    DoubleSolenoid solenoidHook = new DoubleSolenoid(2, 3);
    Compressor compressor = new Compressor();

    //define controller
    XboxController controller = new XboxController(0);

    public void main() {
        //set the compressor mode to turn on when pressure low and vice-versa
        compressor.setClosedLoopControl(true);

        //set the solenoid to extend when A is pressed and retract when X is pressed
        if (controller.getAButtonPressed()) {
            solenoidPush.set(Value.kForward);  
            System.out.println("Extending Solenoid!");
        }
        else if (controller.getXButtonPressed()) {
            solenoidPush.set(Value.kReverse);
            System.out.println("Retracting Solenoid!");
        }
        else {
            solenoidPush.set(Value.kOff);
        }

        //set the hook to flip up/down using controller button B as a toggle
        int count = 0;
        boolean isEven = (count % 2 == 0);
        
        if ((controller.getBButtonPressed() && (isEven == true))) {
            solenoidHook.set(Value.kForward);
            System.out.println("Hook down!");
            count++;
        }
        else if ((controller.getBButtonPressed() && (isEven == false))) {
            solenoidHook.set(Value.kReverse);
            System.out.println("Hook up!");
            count++;
        }
        else {
            solenoidHook.set(Value.kOff);
        }
    }
}