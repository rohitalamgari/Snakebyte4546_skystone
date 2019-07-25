package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public abstract class robotPart {
    protected Telemetry privateTelemetry;

    public void init(HardwareMap hwmap, Telemetry myTelemetry){
        privateTelemetry = myTelemetry;
        privateTelemetry.update();
    }
}
