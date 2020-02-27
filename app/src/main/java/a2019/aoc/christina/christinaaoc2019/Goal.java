package a2019.aoc.christina.christinaaoc2019;

public class Goal {
    private Coupon c;
    private Shop s;
    private int activeSteps;

    public Goal (Coupon c, Shop s, int activeSteps)
    {
        this.c=c;
        this.s=s;
        this.activeSteps=0;
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
