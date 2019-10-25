package a2019.aoc.christina.christinaaoc2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CouponListViewActivity extends AppCompatActivity {
    ListView lvCoupons;
    ArrayList <Coupon>  coupons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon_list_view);

        lvCoupons = findViewById(R.id.couponListView);
        coupons = new ArrayList<Coupon>();

        coupons.add(new Coupon("shop1","$15","12.2020","7000 steps"));
        coupons.add(new Coupon ("shop2", "$20", "12.2020", "80000 steps"));


    }


}
