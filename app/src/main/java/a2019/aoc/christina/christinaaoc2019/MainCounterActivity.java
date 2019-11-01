package a2019.aoc.christina.christinaaoc2019;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class MainCounterActivity extends AppCompatActivity implements SensorEventListener, View.OnClickListener {

    private SensorManager sensorManager;
    private TextView count;
    boolean activityRunning;
    Button resetButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_counter);

        count = (TextView) findViewById(R.id.count);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        resetButton = findViewById(R.id.resetButton);
        resetButton.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        activityRunning = true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if (countSensor!=null)
        {
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        }
        else
        {
            Toast.makeText(this, "Count sensor not available!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        activityRunning = false;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(activityRunning)
        {
            count.setText(String.valueOf(event.values[0]));
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    @Override
    public boolean onCreateOptionsMenu (Menu menu)
    {
        getMenuInflater().inflate(R.menu.go_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent goToNextActivity = new Intent (getApplicationContext(), LoginActivity.class);

        switch (item.getItemId()) {
            case R.id.logOutItem:
                goToNextActivity = new Intent(getApplicationContext(), LoginActivity.class);
                AlertDialog.Builder Builder;
                Builder = new AlertDialog.Builder(MainCounterActivity.this);
                Builder.setMessage("Are you sure you want to log out?");
                Builder.setCancelable(false);

                final Intent finalGoToNextActivity = goToNextActivity;
                Builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(finalGoToNextActivity);
                    }
                }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog Alert = Builder.create();
                Alert.show();
                break;

            case R.id.changeGoalItem:
                goToNextActivity = new Intent(getApplicationContext(), SetGoalActivity.class);
                AlertDialog.Builder Builder2;
                Builder2 = new AlertDialog.Builder(MainCounterActivity.this);
                Builder2.setMessage("Are you sure you want to change your goal?");
                Builder2.setCancelable(false);

                final Intent finalGoToNextActivity1 = goToNextActivity;
                Builder2.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(finalGoToNextActivity1);
                    }
                }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog Alert2 = Builder2.create();
                Alert2.show();
                break;

            case R.id.infoItem:
                goToNextActivity = new Intent(getApplicationContext(), InformationActivity.class);
                AlertDialog.Builder Builder3;
                Builder3 = new AlertDialog.Builder(MainCounterActivity.this);
                Builder3.setMessage("Are you sure you want to leave this page?");
                Builder3.setCancelable(false);

                final Intent finalGoToNextActivity2 = goToNextActivity;
                Builder3.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(finalGoToNextActivity2);
                    }
                }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog Alert3 = Builder3.create();
                Alert3.show();
                break;

        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if (v==resetButton)
        {
           count.setText(String.valueOf("0"));
        }
    }
}
