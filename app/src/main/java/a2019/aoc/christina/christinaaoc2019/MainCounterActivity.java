package a2019.aoc.christina.christinaaoc2019;

import android.content.DialogInterface;
import android.content.Intent;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainCounterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_counter);
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
                AlertDialog.Builder Builder;
                Builder = new AlertDialog.Builder(MainCounterActivity.this);
                Builder.setMessage("Are you sure you want to log out?");
                Builder.setCancelable(false);

                Builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainCounterActivity.this.finish();
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
                goToNextActivity = new Intent (getApplicationContext(), SetGoalActivity.class);
                AlertDialog.Builder Builder2;
                Builder2 = new AlertDialog.Builder(MainCounterActivity.this);
                Builder2.setMessage("Are you sure you want to change your goal?");
                Builder2.setCancelable(false);

                Builder2.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainCounterActivity.this.finish();
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

        }
        return true;
    }
}
