package a2019.aoc.christina.christinaaoc2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CouponListViewActivity extends AppCompatActivity {
    ListView lvCoupons;
    ArrayList<String> coupons=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon_list_view);

        lvCoupons = findViewById(R.id.couponListView);

        CouponFileReader couponFileReader = new CouponFileReader(this);



        coupons = couponFileReader.readLine(R.raw.coupons1);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, coupons);
        lvCoupons.setAdapter(arrayAdapter);

    }
}
