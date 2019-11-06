package a2019.aoc.christina.christinaaoc2019;

import java.util.ArrayList;

public class Shop {
    private int shopImage;
    private String shopName;
    private ArrayList<Coupon> coupons;

    public Shop (int shopImage, String shopName, ArrayList<Coupon>coupons)
    {
        this.shopImage=shopImage;
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

    public int getShopImage() {
        return shopImage;
    }

    public void setShopImage(int shopImage) {
        this.shopImage = shopImage;
    }


}
