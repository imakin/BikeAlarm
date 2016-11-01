package in.izzulmak.bikealarm;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static int tvNumber;
    ArrayList<TextView> textViews;
    public SeekBarListener seekBarListener1;
    public SeekBarListener seekBarListener2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNumber = 0;
        textViews = new ArrayList<TextView>();
        SensorControl.create(this);

        seekBarListener1 = new SeekBarListener(this);
        ((SeekBar) findViewById(R.id.sb_main1)).setOnSeekBarChangeListener(seekBarListener1);
        seekBarListener2 = new SeekBarListener(this);
        ((SeekBar) findViewById(R.id.sb_main2)).setOnSeekBarChangeListener(seekBarListener2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void red() {
        LinearLayout container = (LinearLayout) findViewById(R.id.ll_main);
        container.setBackgroundColor(Color.RED);
    }
    public void white(){
        LinearLayout container = (LinearLayout) findViewById(R.id.ll_main);
        container.setBackgroundColor(Color.WHITE);
    }



    /**
     * set text view text
     * @param id the id of textview, if id is valued tvNumber+1, new textview will be created
     * @param text text for the textview
     */
    public void setTV(int id, String text) {
        LinearLayout container = (LinearLayout) findViewById(R.id.ll_main);
        if (id<0)
            throw new IllegalArgumentException();

        if (id<tvNumber) {
            textViews.get(id).setText(text);
        }
        else if (id==tvNumber) {
            TextView newtv = new TextView(container.getContext());
            newtv.setText(text);
            container.addView(newtv);
            container.setOrientation(LinearLayout.VERTICAL);
            textViews.add(newtv);
            tvNumber++;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
