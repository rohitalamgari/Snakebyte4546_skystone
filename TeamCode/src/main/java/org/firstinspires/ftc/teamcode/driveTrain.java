package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class driveTrain extends robotPart {
    public DcMotor mtrFL = null;
    public DcMotor mtrFR = null;
    public DcMotor mtrBL = null;
    public DcMotor mtrBR = null;

    public void init(HardwareMap hwmap, Telemetry myTelemetry){
        super.init(hwmap, myTelemetry);
        mtrFL = hwmap.dcMotor.get("mtrFL");
        mtrFR = hwmap.dcMotor.get("mtrFR");
        mtrBL = hwmap.dcMotor.get("mtrBL");
        mtrBR = hwmap.dcMotor.get("mtrBR");
    }
}
