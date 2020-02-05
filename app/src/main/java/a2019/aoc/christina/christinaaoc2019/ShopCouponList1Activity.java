package a2019.aoc.christina.christinaaoc2019;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShopCouponList1Activity extends AppCompatActivity {
        ListView lvCoupons;
        ArrayList<String> coupons=new ArrayList<>();


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_coupon_list_view);

            lvCoupons = findViewById(R.id.coupon1ListView);

            final CouponFileReader couponFileReader = new CouponFileReader(this);

            coupons = couponFileReader.readLine(R.raw.coupons1);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, coupons);
            lvCoupons.setAdapter(arrayAdapter);
            lvCoupons.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(ShopCouponList1Activity.this, coupons.get(position), Toast.LENGTH_SHORT).show();
                }
            });

        }

}
