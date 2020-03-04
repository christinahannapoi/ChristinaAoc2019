package a2019.aoc.christina.christinaaoc2019;

public class Goal {
    private Coupon c;
    private Shop s;
    private int activeSteps;

    public Goal (Coupon c, Shop s)
    {
        this.c=c;
        this.s=s;
        this.activeSteps=0;
    }

    public Goal() {
    }

    public Coupon getC() {
        return c;
    }

    public void setC(Coupon c) {
        this.c = c;
    }

    public Shop getS() {
        return s;
    }

    public void setS(Shop s) {
        this.s = s;
    }

    public int getActiveSteps() {
        return activeSteps;
    }

    public void setActiveSteps(int activeSteps) {
        this.activeSteps = activeSteps;
    }

    public boolean goalReached ()
    {
        if (this.activeSteps==this.c.getStepsRequired())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
