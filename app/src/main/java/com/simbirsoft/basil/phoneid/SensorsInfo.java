package com.simbirsoft.basil.phoneid;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;

import java.util.List;

import static android.content.Context.SENSOR_SERVICE;

/**
 * Created by basil on 11/10/16.
 */

public class SensorsInfo {

    SensorManager sensorManager;

    SensorsInfo(Activity context) {
        sensorManager = (SensorManager)context.getSystemService(SENSOR_SERVICE);

    }

    public void getInfo(StringBuilder sb) {
        List<Sensor> list = sensorManager.getSensorList(Sensor.TYPE_ALL);
        if (list.isEmpty()) {
            sb.append("No sensors presents");
            return;
        }
        sb.append("List of available sensors:");
        for(Sensor sensor: list){
            sb.append("\n");
            sb.append("* ");
            sb.append(sensor.getName());
            sb.append("\n");
            sb.append("Manufactored by ");
            sb.append(sensor.getVendor());
            sb.append("\n");
            sb.append("Power consumption: ");
            sb.append(sensor.getPower());
            sb.append("\n");
            sb.append("Sensor type: ");
            sb.append(convertType(sensor.getType()));
        }
    }

    private String convertType(int type) {
        switch(type) {
            case Sensor.TYPE_ACCELEROMETER:
                return "Accelerometer";
            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                return "Ambient Temperature";
            case Sensor.TYPE_GRAVITY:
                return "Gravity";
            case Sensor.TYPE_GYROSCOPE:
            case Sensor.TYPE_GYROSCOPE_UNCALIBRATED:
                return "Gyroscope";
            case Sensor.TYPE_HEART_BEAT:
            case Sensor.TYPE_HEART_RATE:
                return "Hear Beat";
            case Sensor.TYPE_LIGHT:
                return "Light Sensor";
            case Sensor.TYPE_MAGNETIC_FIELD:
            case Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED:
                return "Magnetic Field";
            case Sensor.TYPE_MOTION_DETECT:
                return "Motion Detection";
            default: return "Common Sensor";
        }
    }

}
