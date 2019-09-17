package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "VuforiaBitmapTest", group = "4546")
public class VuforiaBitmapTest extends LinearOpMode {

    private VuforiaBitmap sample;

    @Override
    public void runOpMode() throws InterruptedException{

        waitForStart();
        sample = new VuforiaBitmap(this);

        telemetry.addData("avgX: ", sample.avgX());
        telemetry.update();
    }
}
