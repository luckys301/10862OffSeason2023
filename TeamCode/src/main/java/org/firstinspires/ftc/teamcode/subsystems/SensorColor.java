package org.firstinspires.ftc.teamcode.subsystems;

import android.graphics.Color;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class SensorColor extends SubsystemBase implements HardwareDevice {

    private ColorSensor colorSensor;
    private Telemetry telemetry;

    public SensorColor(ColorSensor colorSensor) {
        this.colorSensor = colorSensor;
    }

    public SensorColor(HardwareMap hardwareMap , Telemetry tl) {
        this.colorSensor = hardwareMap.get(ColorSensor.class, "colorSensor");
        this.telemetry = tl;

        this.colorSensor.enableLed(true);
    }

    public void periodic() {
//        telemetry.addData("Distance (cm)",
//                String.format(Locale.US, "%.02f", colorSensor.getDistance(DistanceUnit.INCH)));
        telemetry.addData("\tAlpha:", colorSensor.alpha());
        telemetry.addData("\tRed:", colorSensor.red());
        telemetry.addData("\tGreen:", colorSensor.green());
        telemetry.addData("\tBlue:", colorSensor.blue());

        telemetry.update();
    }

    public int[] HSVtoARGB(int alpha, float[] hsv) {
        int color = Color.HSVToColor(alpha, hsv);
        return new int[]{Color.alpha(color), Color.red(color), Color.green(color), Color.blue(color)};
    }

    public float[] RGBtoHSV(int red, int green, int blue, float[] hsv) {
        Color.RGBToHSV(red, green, blue, hsv);
        return hsv;
    }

//    public int[] getARGB() {
//        return new int[]{alpha(), red(), green(), blue()};
//    }

//    public int alpha() {return colorSensor.alpha();}
//    public int red() {return colorSensor.red();}
//    public int green() {return colorSensor.green();}
//    public int blue() {return colorSensor.blue();}

    public boolean grabbedBlueCone() {
        //TODO:Change the color
//        telemetry.addLine("Got Blue Cone");
//        return (blue()>100);
        return (colorSensor.red() > 150) && (colorSensor.green() > 150);
    }
    public boolean grabbedRedCone() {
        //TODO:Change the color
//        telemetry.addLine("Got Red Cone");
//        return (red() > 150);
        return (colorSensor.red() > 150) && (colorSensor.green() > 150);
    }

    @Override
    public void disable() {colorSensor.close();}

    @Override
    public String getDeviceType() {return "Color Sensor";}

}