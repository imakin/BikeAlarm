package in.izzulmak.bikealarm;

import android.widget.SeekBar;

/**
 * Created by Izzulmakin on 01/11/16.
 */
public class SeekBarListener implements SeekBar.OnSeekBarChangeListener {
    public double value;
    private MainActivity mref;
    public SeekBarListener(MainActivity mref) {
        this.mref = mref;
        value = 0.9;

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        value = (float)i/(float)seekBar.getMax();
        mref.setTV(3, String.valueOf(value));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
