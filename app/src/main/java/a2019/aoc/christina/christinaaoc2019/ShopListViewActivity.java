package a2019.aoc.christina.christinaaoc2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShopListViewActivity extends AppCompatActivity  {
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

        lvShops.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView arg0, View arg1,
                                    int position, long arg3) {
                // call new layout with intent
                Intent intent = new Intent(ShopListViewActivity.this, MainCounterActivity.class);
                startActivity(intent);

            }
        });

    }




}
