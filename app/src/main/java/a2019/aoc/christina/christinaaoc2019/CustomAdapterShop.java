package a2019.aoc.christina.christinaaoc2019;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterShop {


    /**
     * Created by Sarah on 9/20/2017.
     * this page contains the custom galley that extends
     */

    public class CustomAdapter2 extends ArrayAdapter<Shop> {

        private int resourceLayout;
        private Context mContext;

        public CustomAdapter2(Context context, int resource, List<Shop> shops) {
            super(context, resource, shops);
            this.resourceLayout = resource;
            this.mContext = context;
        }

    /*
    getView() method. This view is called when a listItem needs to be created and populated with the data.In this method first the View is inflated using the LayoutInflator.inflate() method. It is important that you check that if the view you are trying to inflate is new or reused


     */

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View v = convertView;
            if (v == null)
                v = LayoutInflater.from(mContext).inflate(resourceLayout, parent, false);


            Shop p = getItem(position);

            if (p != null) {
                TextView shopName = (TextView) v.findViewById(R.id.shopName);

                if (shopName != null) {
                    shopName.setText(p.getShopName());
                }
            }


                return v;
            }

        }

}
