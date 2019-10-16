package a2019.aoc.christina.christinaaoc2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SelectCouponActivity extends AppCompatActivity implements View.OnClickListener{

    RadioGroup radioGroupCoupons;
    RadioButton radioButton1,radioButton2,radioButton3;
    Button submitButton;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_coupon);

        radioButton1 = findViewById(R.id.coupon1);
        radioButton2 = findViewById(R.id.coupon2);
        radioButton3 = findViewById(R.id.coupon3);
        submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(this);
        radioGroupCoupons = findViewById(R.id.radioGroupCoupons);
        radioGroupCoupons.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                id = checkedId;
            }
        });


    }

    @Override
    public void onClick(View v) {
        if (v==submitButton)
        {
            Intent i = new Intent (this, MainCounterActivity.class);
            startActivity(i);
        }
    }
}
