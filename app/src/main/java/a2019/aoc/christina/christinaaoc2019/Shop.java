package a2019.aoc.christina.christinaaoc2019;

import android.graphics.Bitmap;

import java.util.ArrayList;

public class Shop {
    private String shopName;
    private ArrayList<Coupon> coupons;




    public Shop (String shopName, ArrayList<Coupon>coupons)
    {

        this.shopName=shopName;
        this.coupons=coupons;
    }

    public Shop()
    {

    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setCoupons(ArrayList<Coupon> coupons) {
        this.coupons = coupons;
    }

    public ArrayList<Coupon> getCoupons() {
        return coupons;
    }



}
