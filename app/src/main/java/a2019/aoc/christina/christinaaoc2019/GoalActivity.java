package a2019.aoc.christina.christinaaoc2019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class GoalActivity extends AppCompatActivity {

    ListView lvGoals;
    ArrayAdapter <String> goals = new ArrayAdapter<String >();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);


        lvGoals = findViewById(R.id.goalListView);

        GoalFileReader goalFileReader = new GoalFileReader(this);



        goals = goalFileReader.readLine(R.raw.goals);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, goals);
        lvGoals.setAdapter(arrayAdapter);

    }
}
