package a2019.aoc.christina.christinaaoc2019;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShopCouponList1Activity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView lvCoupons;
    ArrayList<String> coupons=new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list_view);

        lvCoupons = findViewById(R.id.coupon1ListView);
        coupons.add("Shop 1");
        coupons.add("Shop 2");
        coupons.add("Shop 3");
        coupons.add("Shop 4");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, coupons);
        lvCoupons.setAdapter(adapter);
        lvCoupons.setOnItemClickListener((AdapterView.OnItemClickListener)this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
