package a2019.aoc.christina.christinaaoc2019;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GoalFileReader {
    private Context mContext;

    public GoalFileReader(Context context) {
        this.mContext = context;
    }

    public ArrayList<String> readLine(int id) {
        ArrayList<String> mLines = new ArrayList<>();

        //    AssetManager am = mContext.getAssets();

        try {
            //getResources().openRawResource(R.raw.myfilename)
            InputStream is = mContext.getResources().openRawResource(id); //am.open(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;

            while ((line = reader.readLine()) != null)
                mLines.add(line);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mLines;
    }

}
