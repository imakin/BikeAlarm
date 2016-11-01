package in.izzulmak.bikealarm;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/**
 * Created by Izzulmakin on 01/11/16.
 */
public class SensorListener implements SensorEventListener {
    private double [] gravity;
    private static MainActivity mref;
    public SensorListener(MainActivity mref) {
        this.mref = mref;
        gravity = new double[3];
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        switch (sensorEvent.sensor.getType()) {
            case Sensor.TYPE_GYROSCOPE:

                break;
            case Sensor.TYPE_ACCELEROMETER:
                // alpha is calculated as t / (t + dT),
                // where t is the low-pass filter's time-constant, latency the filter ads to the sensor event
                // dT is the event delivery rate.

                double alpha = mref.seekBarListener1.value;

                // Isolate the force of gravity with the low-pass filter.
                gravity[0] = alpha * gravity[0] + (1 - alpha) * sensorEvent.values[0];
                gravity[1] = alpha * gravity[1] + (1 - alpha) * sensorEvent.values[1];
                gravity[2] = alpha * gravity[2] + (1 - alpha) * sensorEvent.values[2];

                // Remove the gravity contribution with the high-pass filter.
                double l0 = sensorEvent.values[0] - gravity[0];
                double l1 = sensorEvent.values[1] - gravity[1];
                double l2 = sensorEvent.values[2] - gravity[2];

                mref.setTV(0, String.valueOf(l0));
                mref.setTV(1, String.valueOf(l1));
                mref.setTV(2, String.valueOf(l2));

                int x = (int)(mref.seekBarListener2.value*10);
                if (
                          l0>x
                        ||l0<-x
                        ||l1>x
                        ||l1<-x
                        ||l2>x
                        ||l2<-x
                        ) {
                    mref.red();
                }
                else{
                    mref.white();
                }
                break;
            default:break;
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
