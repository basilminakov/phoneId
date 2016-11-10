package com.simbirsoft.basil.phoneid;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;

import java.util.Iterator;
import java.util.List;

/**
 * Created by basil on 11/9/16.
 */

public class CameraInfo {


    @TargetApi(21)
    public CameraCharacteristics getCameraInstance(Activity context){
        CameraManager manager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
        String[] ids;
        CameraCharacteristics features = null;
        try {
            ids = manager.getCameraIdList();
            features = manager.getCameraCharacteristics(ids[0]);
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return features;
    }

    @TargetApi(21)
    public void getInfo(Activity context, StringBuilder sb) {
        CameraCharacteristics features = getCameraInstance(context);
        if (features != null) {
            List keys = features.getKeys();
            Iterator iter = keys.iterator();
            CameraCharacteristics.Key currentKey = null;
            while(iter.hasNext()) {
                currentKey = (CameraCharacteristics.Key)iter.next();
                sb.append(currentKey.toString());
                sb.append(": ");
                sb.append(features.get(currentKey).toString());
                sb.append("/n");
            }
        } else {
            sb.append("Camera: unable to detect features");
        }
    }
}
