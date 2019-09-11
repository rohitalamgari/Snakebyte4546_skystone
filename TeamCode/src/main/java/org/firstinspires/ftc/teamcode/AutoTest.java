package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


@Autonomous(name = "AutoTest", group = "LinearOpMode")
public class AutoTest extends LinearOpMode {

    RobotSkystone robot = new RobotSkystone();

    @Override
    public void runOpMode() throws InterruptedException{

        robot.init(hardwareMap, telemetry);

        waitForStart();
    }

}
