package a2019.aoc.christina.christinaaoc2019;

public class Coupon {
    private String couponMoney;
    private String expirationDate;
    private String stepsRequired;

    public Coupon ( String couponMoney, String expirationDate, String stepsRequired)
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

    public String getStepsRequired() {
        return stepsRequired;
    }

    public void setStepsRequired(String stepsRequired) {
        this.stepsRequired = stepsRequired;
    }


}

