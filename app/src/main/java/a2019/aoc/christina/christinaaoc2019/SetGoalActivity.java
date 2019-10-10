package a2019.aoc.christina.christinaaoc2019;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class SetGoalActivity extends AppCompatActivity implements View.OnClickListener  {

    EditText textViewGoal;
    CheckBox goal1, goal2, goal3;
    Button okButton;
    int id = 0;

    RadioGroup radioGroupGoals;
    RadioButton r1, r2, r3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_goal);

        okButton = findViewById(R.id.okButton);
        okButton.setOnClickListener(this);
        r1 = findViewById(R.id.radioButtonG1);
        r2 = findViewById(R.id.radioButtonG2);
        r3 = findViewById(R.id.radioButtonG3);

        radioGroupGoals = findViewById(R.id.radioGroupGoals);
        radioGroupGoals.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                    id = checkedId;
            }
        });

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

        switch (item.getItemId())
        {
            case R.id.logOutItem:
                goToNextActivity = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(goToNextActivity);
                break;

            case R.id.changeGoalItem:
                goToNextActivity = new Intent (getApplicationContext(), SettingsActivity.class);
                AlertDialog.Builder Builder;
                Builder = new AlertDialog.Builder(SetGoalActivity.this);
                Builder.setMessage("Are you sure you want to change your goal?");
                Builder.setCancelable(false);

                Builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SetGoalActivity.this.finish();
                    }
                }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog Alert = Builder.create();
                Alert.show();
                startActivity(goToNextActivity);
                break;

            case R.id.backItem:
                goToNextActivity = new Intent (getApplicationContext(),SignUpActivity.class);
                startActivity(goToNextActivity);
                break;
        }
        return true;
    }


    @Override
    public void onClick(View v) {
        if (v==okButton)
        {
            Intent i = new Intent(this, SelectCouponActivity.class);
            startActivity(i);
        }
    }
}
