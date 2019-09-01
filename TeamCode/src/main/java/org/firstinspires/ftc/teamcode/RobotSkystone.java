package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class RobotSkystone {
    tankDrive tankDrive = new tankDrive();
    Sensors sensors = new Sensors();

    public void init(HardwareMap hwmap, Telemetry telemetry){
        tankDrive.init(hwmap, telemetry);
        sensors.init(hwmap, telemetry);
    }
}
