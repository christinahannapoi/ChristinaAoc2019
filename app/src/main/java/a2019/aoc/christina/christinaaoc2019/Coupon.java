package a2019.aoc.christina.christinaaoc2019;

public class Coupon {
    private String couponMoney;
    private String expirationDate;
    private int stepsRequired;

    public Coupon ( String couponMoney, String expirationDate, int stepsRequired)
    {

        this.couponMoney= couponMoney;
        this.expirationDate= expirationDate;
        this.stepsRequired= stepsRequired;
    }

    public Coupon ()
    {

    }


    public String getCouponMoney() {
        return couponMoney;
    }

    public void setCouponMoney(String couponMoney) {
        this.couponMoney = couponMoney;
    }

     public String getExpirationDate () {
         return expirationDate;
     }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getStepsRequired() {
        return stepsRequired;
    }

    public void setStepsRequired(int stepsRequired) {
        this.stepsRequired = stepsRequired;
    }


}

