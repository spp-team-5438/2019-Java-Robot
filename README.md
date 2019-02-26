# 2019-Java-Robot
Saint Peter's Prep Team 5438
FRC 2019 Deep Space

# Basic To-Do
- [x] Write Drivetrain Code
- [x] Test and Finalize Drivetrain
- [x] Write Elevator Code
- [x] Test and Finalize Elevator
- [x] Write Arm Code
- [x] Write Pneumatics Code
- [x] Test and Finalize Pneumatics
- [x] Write Camera Code (display camera on SmartDashboard)

# Complex To-Do
- [ ] Integrate encoder in elevator for preset heights
- [x] Integrate a vision recognition system
- [x] Vision following (similar to limelight)
- [x] Vision driver assistance when a button is pressed
- [ ] Tune vision system for camera YAW offset
- [ ] autonomous? (see below; WIP)

# Auto Plan
- Drive forward x feet
- Turn 90 degrees by rotating left and right sides a quarter turn moving opposite sides
- Drive forward x feet
- Use .set(.5) for intake; timer.delay; then .set(0) to make intake motor spin for a certain amount of time

# To-do (non-programming)
- [ ] mount camera
- [ ] swap front motor controllers to Victor SPX for ability to use .follow()
- [ ] finish intake and mount to robot
- [ ] connect elevator encoder to talon
