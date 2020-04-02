package Assignment2;

/**
 * Write a description of class Warehouse here.
 * 
 * @author (David Proia) 
 * @version (10/01/2012)
 */

public class Shipment implements Comparable<Shipment>
{
    private Widget widgets;

    public Shipment()
    {
        widgets = new Widget();
    }
        
    public Shipment(int nTime, double nCost, int nQty)
    {
        widgets = new Widget(nTime, nCost, nQty);
    }
    
    public Widget getWidget()
    {
        return widgets;
    }
    
    public void setWidget(int nTime, double nCost, int nQty)
    {
        widgets = new Widget(nTime, nCost, nQty);
    }
        
    public String toString() 
    {

        return widgets.toString(); 
    }
    
    @Override
    public int compareTo(Shipment other)
    {
        if(this.getWidget().getTime() > other.getWidget().getTime())
        {
            return 1;
        }
        else if(this.getWidget().getTime() < other.getWidget().getTime())
        {
            return -1;
        }
        return 0;
    }
    
}