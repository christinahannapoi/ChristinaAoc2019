package a2019.aoc.christina.christinaaoc2019;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Sarah on 9/20/2017.
 * this page contains the custom galley that extends
 */

public class CustomAdapter2 extends ArrayAdapter<Coupon> {

    private int resourceLayout;
    private Context mContext;

    public CustomAdapter2(Context context, int resource, List<Coupon> coupons) {
        super(context, resource, coupons);
        this.resourceLayout = resource;
        this.mContext = context;
    }

    /*
    getView() method. This view is called when a listItem needs to be created and populated with the data.In this method first the View is inflated using the LayoutInflator.inflate() method. It is important that you check that if the view you are trying to inflate is new or reused


     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        if(v == null)
            v = LayoutInflater.from(mContext).inflate(resourceLayout,parent,false);


        Coupon p = getItem(position);

        if (p != null) {
            TextView couponMoney = (TextView) v.findViewById(R.id.couponMoney);
            TextView expirationDate = (TextView) v.findViewById(R.id.expirationDate);
            TextView stepsRequired = (TextView) v.findViewById(R.id.stepsRequired);


           if(couponMoney!=null)
           {
               couponMoney.setText((p.getCouponMoney()));
           }
           if(expirationDate!=null)
           {
               expirationDate.setText(p.getExpirationDate());
           }
           if (stepsRequired!=null)
           {
               stepsRequired.setText(p.getStepsRequired());
           }
        }

        return v;
    }

}
