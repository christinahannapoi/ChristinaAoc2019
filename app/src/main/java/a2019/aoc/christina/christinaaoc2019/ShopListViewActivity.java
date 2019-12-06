package a2019.aoc.christina.christinaaoc2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShopListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lvShops;
    ArrayList<String> shops=new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list_view);

        lvShops = findViewById(R.id.shopListView);
        shops.add("Shop 1");
        shops.add("Shop 2");
        shops.add("Shop 3");
        shops.add("Shop 4");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, shops);
        lvShops.setAdapter(adapter);
        lvShops.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getItemAtPosition(position).equals("Shop 1"))
        {
            Intent i1 = new Intent(this, ShopCouponList1Activity.class);
            i1.putExtra("Shop",position);
            startActivity(i1);
        }
        if (parent.getItemAtPosition(position).equals("Shop 2"))
        {
            Intent i2 = new Intent (this, ShopCouponList2Activity.class);
            i2.putExtra("Shop", position);
            startActivity(i2);
        }
        if (parent.getItemAtPosition(position).equals("Shop 3"))
        {
            Intent i3 = new Intent (this, ShopCouponList3Activity.class);
            i3.putExtra("Shop", position);
            startActivity(i3);
        }
        if (parent.getItemAtPosition(position).equals("Shop 4"))
        {
            Intent i4 = new Intent (this, ShopCouponList4Activity.class);
            i4.putExtra("Shop",position);
            startActivity(i4);
        }

    }


}
