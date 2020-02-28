package a2019.aoc.christina.christinaaoc2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static a2019.aoc.christina.christinaaoc2019.R.raw.goals;

public class GoalActivity extends AppCompatActivity {

    ListView lvGoals;
    ArrayList<String> goals=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

        lvGoals = findViewById(R.id.goalListView);

        CouponFileReader couponFileReader = new CouponFileReader(this);



        goals = couponFileReader.readLine(R.raw.goals);
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, goals);
        lvGoals.setAdapter(arrayAdapter);
        lvGoals.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent (GoalActivity.this, ShopListViewActivity.class);
                i.putExtra("goal",goals);
                startActivity(i);
            }
        });

    }
}
