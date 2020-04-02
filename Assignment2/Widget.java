package Assignment2;

/**
 * Write a description of class Warehouse here.
 * 
 * @author (David Proia) 
 * @version (10/01/2012)
 */
public class Widget
{
    private int time;
    private double cost;
    private int qty;

    public Widget()
    {
        time = 0;
        cost = 0;
        qty = 0;
    }

    public Widget(int nTime, double nCost, int nQty)
    {
        time = nTime;
        cost = nCost;
        qty = nQty;
    }

    public Widget(Widget newWidget)
    {
        time = newWidget.getTime();
        cost = newWidget.getCost();
        qty = newWidget.getQty();
    }

    public int getTime()
    {
        return time;
    }

    public double getCost()
    {
        return cost;
    }

    public int getQty()
    {
        return qty;
    }

    public void setQty(int nQty)
    {
        qty = nQty;
    }

    public void setTime(int nTime)
    {
        time = nTime;
    }

    public void setCost(double nCost)
    {
        cost = nCost;
    }

    public String toString() 
    {

        return "\ttime: " + time + "  \tcost: " + cost + "\tqty: " + qty;
    }
}