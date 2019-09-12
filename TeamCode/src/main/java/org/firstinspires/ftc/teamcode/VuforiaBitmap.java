package org.firstinspires.ftc.teamcode;

import android.graphics.Bitmap;

import static android.graphics.Color.red;
import static android.graphics.Color.green;
import static android.graphics.Color.blue;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.vuforia.Frame;
import com.vuforia.Image;
import com.vuforia.PIXEL_FORMAT;
import com.vuforia.Vuforia;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.Parameters;

public class VuforiaBitmap {

    private LinearOpMode opMode;

    VuforiaLocalizer vuforia;
    private VuforiaLocalizer.Parameters parameters;
    private VuforiaLocalizer.CameraDirection CAMERA_CHOICE = VuforiaLocalizer.CameraDirection.BACK;
    private static final String VUFORIA_KEY = "Acwi41P/////AAABmXAF5Uahj0aglVwEx0GLTotkFwuYvGa385NRnC3GmFdHiha7BKdStHJwB6nj4zrSBLOJ0jGEICqTReR3LiErc63MaNJf8NR/J8TUk6MOaF8xM5fa5uDU3J/7/tys+Hu1G5nlncWy3gGsHrU8lwG/rL+G0R/caVfNp0GfRtpcH7LMLDZOslSc+URv9+IF8+C0jA4JzTfM4lRkOEcIqIyTs20EZC+W3QYI7o7n700hOwq+WpoG7qMgqcrgk3+B1/hTLICE3fodM/34CQjbEONYKpGbj8IOG714CeY9qyI6WhainXidKda/QAslXEvYCDvBCZoGW/4I3TaZAJUWAeD1l5SeL/m4nuJxV9Jmai/0/9Qn";


    private final int RED_THRESHOLD = 0;
    private final int GREEN_THRESHOLD = 0;
    private final int BLUE_THRESHOLD = 0;





}
