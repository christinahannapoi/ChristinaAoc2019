package a2019.aoc.christina.christinaaoc2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CouponListViewActivity extends AppCompatActivity {
    ListView lvCoupons;
    ArrayList<String> coupons=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon_list_view);

        lvCoupons = findViewById(R.id.couponListView);
        coupons.add("coupon 1");
        coupons.add("coupon 2");
        coupons.add("coupon 3");
        coupons.add("coupon 4");








    }


}
