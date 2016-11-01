package in.izzulmak.bikealarm;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

/**
 * Created by Izzulmakin on 01/11/16.
 */
public class SensorControl {
    private static SensorListener assignedListener;
    public static void create(MainActivity mref) {
        assignedListener= new SensorListener(mref);
        SensorManager sm = (SensorManager) mref.getSystemService(Context.SENSOR_SERVICE);
        sm.registerListener(assignedListener, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }
    public static SensorListener getListener() {
        return assignedListener;
    }
}
