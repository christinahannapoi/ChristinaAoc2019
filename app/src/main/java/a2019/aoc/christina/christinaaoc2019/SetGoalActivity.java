package a2019.aoc.christina.christinaaoc2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;


public class SetGoalActivity extends AppCompatActivity implements View.OnClickListener {

    EditText textViewGoal;
    CheckBox goal1, goal2, goal3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_goal);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu)
    {
        getMenuInflater().inflate(R.menu.go_menu, menu);
        return true;
    }

    public boolean onOptionsItemsSelected (MenuItem item)
    {
        Intent goToNextActivity = new Intent (getApplicationContext(), LoginActivity.class);

        switch (item.getItemId())
        {
            case R.id.logOutItem:
                goToNextActivity = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(goToNextActivity);
                break;

            case R.id.settingsItem:
                goToNextActivity = new Intent (getApplicationContext(), SettingsActivity.class);
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

    }

    private void EventHandler()
    {
        btnGetOut()
    }
}
