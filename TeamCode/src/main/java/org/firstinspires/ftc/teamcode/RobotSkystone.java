package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class RobotSkystone {

    MecanumDrive driveTrain = new MecanumDrive();
    Sensors sensors = new Sensors();

    public void init(HardwareMap hwmap, Telemetry telemetry){
        //this is where we initialize all of our other things, like sensors, drivetrain, etc.
        driveTrain.init(hwmap, telemetry);
        sensors.init(hwmap, telemetry);
    }
}
