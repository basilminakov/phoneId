package com.simbirsoft.basil.phoneid;

import android.os.Build;

/**
 * Created by basil on 11/9/16.
 */

public class PhoneInfo {
    public void getInfo(StringBuilder sb) {
        sb.append("OS version: ");
        sb.append(Build.VERSION.RELEASE);
        sb.append("\n");
        sb.append("Manufacturer: ");
        sb.append(Build.BRAND.toUpperCase());
        sb.append("\n");
        sb.append("Device: ");
        sb.append(Build.DEVICE);
        sb.append("\n");
        sb.append("Phone model: ");
        sb.append(Build.MODEL);
        sb.append("\n");
        sb.append("Manufacturer serial: ");
        sb.append(Build.SERIAL);
        sb.append("\n");
        sb.append("Board ID: ");
        sb.append(Build.BOARD);
    }
}
