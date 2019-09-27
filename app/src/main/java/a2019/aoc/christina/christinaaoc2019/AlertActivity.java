package a2019.aoc.christina.christinaaoc2019;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlertActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnLOGOUT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
        btnLOGOUT = (Button)findViewById(R.id.btnLOGOUT);
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder Builder;
        Builder = new AlertDialog.Builder(AlertActivity.this);
        Builder.setMessage("Are you sure you want to log out?");
        Builder.setCancelable(false);
        Builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                AlertActivity.this.finish();
            }
        }).setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog Alert = Builder.create();
        Alert.show();

    }
}
