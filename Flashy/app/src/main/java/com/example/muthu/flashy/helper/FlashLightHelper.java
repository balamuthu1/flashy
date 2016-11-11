package com.example.muthu.flashy.helper;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.util.Log;

/**
 * Created by Muthu on 11/11/2016.
 */
public class FlashLightHelper {

    public static void handleActionTurnOnFlashLight(Context context){
        try{

            CameraManager manager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
            String[] list = manager.getCameraIdList();
            manager.setTorchMode(list[0], true);
        }
        catch (CameraAccessException cae){
            Log.e("camera exception", cae.getMessage());
            cae.printStackTrace();
        }
    }

    public static void handleActionTurnOffFlashLight(Context context){
        try{
            CameraManager manager = (CameraManager) context.getSystemService(Context.CAMERA_SERVICE);
            manager.setTorchMode(manager.getCameraIdList()[0], false);
        }
        catch (CameraAccessException cae){
            Log.e("camera exception", cae.getMessage());
            cae.printStackTrace();
        }
    }
}
