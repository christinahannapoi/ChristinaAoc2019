package a2019.aoc.christina.christinaaoc2019;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InformationActivity extends AppCompatActivity implements View.OnClickListener{
    TextView titleTextView, contentTextView;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        titleTextView = findViewById(R.id.titleTextView);
        contentTextView = findViewById(R.id.contentTextView);
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (backButton==v)
        {
            Intent i = new Intent(this, LoginActivity.class);
            startActivity(i)
            ;
        }

    }
}
