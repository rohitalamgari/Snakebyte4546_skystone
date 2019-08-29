package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class TankTele extends OpMode {
    RobotSkystone robot = new RobotSkystone();
    @Override
    public void init() {
        robot.init(hardwareMap, telemetry);
    }

    @Override
    public void loop() {
        double leftStick = gamepad1.left_stick_x;
        double rightStick = gamepad1.right_stick_y;

        if (Math.abs(rightStick) > 0.1){
            robot.tankDrive.forward(rightStick);
        }

        if (Math.abs(leftStick) > 0.1){
            robot.tankDrive.turn(leftStick);
        }
    }
}
