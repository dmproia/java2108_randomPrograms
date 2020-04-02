package Assignment2;

/**
 * Write a description of class Warehouse here.
 * 
 * @author (David Proia) 
 * @version (10/01/2012)
 */

import java.util.*;
import java.io.*;
import javax.swing.*;

public class Warehouse
{
    public static ArrayList<Shipment> shipments = new ArrayList<Shipment>();
    public static ArrayList<Order> orders = new ArrayList<Order>();
    public static Stack<Widget> OtoBeFilled = new Stack<Widget>();
    public static Stack<Widget> WidgetsInHand = new Stack<Widget>();

    public static void main(String[] args)
    {
        loadFile("shipments.txt");
        loadFile("orders.txt");
        
        Collections.sort(shipments);
        Collections.sort(orders);

        ListIterator shipmentIterator = shipments.listIterator();   
        ListIterator orderIterator = orders.listIterator();       
               
        while(shipmentIterator.hasNext() || orderIterator.hasNext())
        {
        	if (shipments.isEmpty())
            {
        		System.out.println("Order processed is: " + orders.get(0).toString());
            	OtoBeFilled.push(orders.get(0).getWidget());
		    	orders.remove(0);
		    	System.out.println("\tThere are no shipments or widgets-on-hand to fill this order at this time.");
		    	System.out.println("\t" + OtoBeFilled.get(0).getQty() + " widgets were pushed onto the orders-to-be-filled stack");
            }
            else if(orders.isEmpty())
            {
        		System.out.println("Shipment processed is: " + shipments.get(0).toString());
        		WidgetsInHand.push(shipments.get(0).getWidget());
            	shipments.remove(0);
            	System.out.println("\tThere are no orders to be filled at this time.");
            	System.out.println("\t" + WidgetsInHand.get(0).getQty() + " widgets were pushed onto the widgets-on-hand stack");
            }            
            else if(shipments.get(0).getWidget().getTime() < orders.get(0).getWidget().getTime())
            {
            	System.out.println("Shipment processed is: " + shipments.get(0).toString());
            	processShipment();
            }
            else if (shipments.get(0).getWidget().getTime() > orders.get(0).getWidget().getTime())
            {
            	System.out.println("Order processed is: " + orders.get(0).toString());
            	processOrder();
            }
            else if (shipments.get(0).getWidget().getTime() == orders.get(0).getWidget().getTime())
            {
            	System.out.println("Shipment processed is: " + shipments.get(0).toString());
            	processShipment();
            	System.out.println("Order processed is: " + orders.get(0).toString());
            	processOrder();
            	shipments.remove(0);
            	orders.remove(0);
            }
            else
        		System.out.println("I DON'T KNOW");
        }
    }       

    private static Shipment parseShipment(String line) 
    {  
        Scanner lineScanner = new Scanner(line);
        lineScanner.useDelimiter(",");                   
        int time = Integer.parseInt(lineScanner.next());
        double price = Double.parseDouble(lineScanner.next());        
        int qty = Integer.parseInt(lineScanner.next());        
        Shipment newShipment = new Shipment(time, price, qty);
        return newShipment;
    }    

    private static Order parseOrder(String line) 
    {  
        Scanner lineScanner = new Scanner(line);
        lineScanner.useDelimiter(",");                   
        int time = Integer.parseInt(lineScanner.next());
        double price = 0.0;        
        int qty = Integer.parseInt(lineScanner.next());        
        Order newOrder = new Order(time, price, qty);                
        return newOrder;
    }   

    public static void loadFile(String fileName)
    {
        try
        {                
            File dataFile = new File(fileName);
            Scanner scan = new Scanner(dataFile);

            String line;

            while (scan.hasNextLine())
            {
                line = scan.nextLine();
                if (fileName.equals("shipments.txt"))
                {
                    shipments.add(parseShipment(line));
                }
                else if(fileName.equals("orders.txt"))
                {
                    orders.add(parseOrder(line));
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "file not loaded");
                }
            }          
        }
        catch (IOException exception)
        {
            JOptionPane.showMessageDialog(null, "file not opened");
        }
    }

    public static void processShipment()
    {       	
    	if (!OtoBeFilled.empty())
    	{
    		if(shipments.get(0).getWidget().getQty() > OtoBeFilled.peek().getQty())
    		{
	    		WidgetsInHand.push(shipments.get(0).getWidget());    		
	    		shipments.remove(0);
	    		WidgetsInHand.get(0).setQty(WidgetsInHand.peek().getQty() - OtoBeFilled.peek().getQty());
	    		OtoBeFilled.pop();
	    		System.out.println("\tWidgets on hand: " + WidgetsInHand.get(0).toString());     		
    		}
    		else if(shipments.get(0).getWidget().getQty() < OtoBeFilled.peek().getQty())
    		{     		
	    		OtoBeFilled.push(shipments.get(0).getWidget());    		
	    		shipments.remove(0);
	    		WidgetsInHand.get(0).setQty(WidgetsInHand.peek().getQty() - OtoBeFilled.peek().getQty());
	    		OtoBeFilled.pop();
	    		System.out.println("\tOrders to be filled: " + OtoBeFilled.get(0).toString());
    		}
    		else if(shipments.get(0).getWidget().getQty() == OtoBeFilled.peek().getQty())
    		{
	    		shipments.remove(0);
	    		OtoBeFilled.pop();
	    		System.out.println("\tShipment and Order were the same.");
    		}
    		else
        		System.out.println("I DON'T KNOW");
    	}
    	else if (OtoBeFilled.empty())
    	{
    		WidgetsInHand.push(shipments.get(0).getWidget());
        	shipments.remove(0);
        	System.out.println("\tThere are no orders to be filled at this time.");
        	System.out.println("\t" + WidgetsInHand.get(0).getQty() + " widgets were pushed onto the widgets-on-hand stack");
    	}
    	else
    		System.out.println("I DON'T KNOW");
    }

    public static void processOrder()
    {      
    	if (!WidgetsInHand.empty())
    	{
	    	if(orders.get(0).getWidget().getQty() > WidgetsInHand.peek().getQty())
	    	{
	    		OtoBeFilled.push(orders.get(0).getWidget());    		
	    		orders.remove(0);
	    		OtoBeFilled.get(0).setQty(OtoBeFilled.peek().getQty() - WidgetsInHand.peek().getQty());
	    		WidgetsInHand.pop();
	    		System.out.println("\tOrders to be filled: " + OtoBeFilled.get(0).toString());
	    	}
	    	else if(orders.get(0).getWidget().getQty() < WidgetsInHand.peek().getQty())
	    	{     		
	    		WidgetsInHand.push(shipments.get(0).getWidget());    		
	    		shipments.remove(0);
	    		WidgetsInHand.get(0).setQty(WidgetsInHand.peek().getQty() - orders.get(0).getWidget().getQty());
	    		orders.remove(0);
	    		System.out.println("\tWidgets on hand: " + WidgetsInHand.get(0).toString());
	    	}    	
	    	else if(orders.get(0).getWidget().getQty() == WidgetsInHand.peek().getQty())
	    	{
	    		orders.remove(0);
	    		WidgetsInHand.pop();
	    		System.out.println("\tOrder and Shipment were the same.");
	    	}
	    	else
	    		System.out.println("I DON'T KNOW");
    	}
    	else if (WidgetsInHand.empty())
    	{
    		OtoBeFilled.push(orders.get(0).getWidget());
	    	orders.remove(0);
	    	System.out.println("\tThere are no shipments or widgets-on-hand to fill this order at this time.");
	    	System.out.println("\t " + OtoBeFilled.get(0).getQty() + " widgets were pushed onto the orders-to-be-filled stack");
    	}
    	else
    		System.out.println("I DON'T KNOW");
    }
}