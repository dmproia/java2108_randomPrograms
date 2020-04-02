
import javax.swing.*;


import java.awt.Polygon;
import java.io.*;
import java.util.*;
public class MyVertexRunner extends JFrame
{
	private static  Scanner scan;
	private static Polygon form1 = new Polygon();
	private static Polygon form2= new Polygon();
	private static LinkedList<Integer> xCord = new LinkedList<Integer>();
	private static LinkedList<Integer> yCord = new LinkedList<Integer>();
	private static LinkedList<Integer> y2Cord = new LinkedList<Integer>();

	
	public static void main(String[] args) throws FileNotFoundException
	{
		
		JFileChooser chooser = new JFileChooser();
		if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			File selectedFile = chooser.getSelectedFile();
			scan = new Scanner(selectedFile);
			addNodePoint();
			Iterator itr = xCord.iterator();
			while(itr.hasNext())
			{
				int f = (int) itr.next();
				int g = (int) itr.next();
				yCord.add(f);
				y2Cord.add(g);
				form1.addPoint(f, g);
			}
			//distance between points calculated
			
			//Taking new points and adding them to form1
			for(int i =0;i<yCord.size() && i<y2Cord.size();i+=2)
			{
				int u = yCord.get(i);
				int v = y2Cord.get(i);
				form2.addPoint(u, v);
			}
		}
		
		JFrame frame = new JFrame();
		frame.setTitle("Original Picture shown As nice note");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Reform er = new Reform(form1);
		frame.add(er);
		frame.setVisible(true);
		
		JFrame frame2 = new JFrame();
		frame2.setTitle("Note after Vertexes have been removed");
		frame2.setSize(400, 400);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Reform er2 = new Reform(form2);
		frame2.add(er2);
		frame2.setVisible(true);
		
		
	}
	
	//scans for node's and add's them to the xCord for Vertex
	public static void addNodePoint()
	{
		while(scan.hasNext())
		{
			int f = scan.nextInt();
			xCord.add(f);
		}
	}
	
	
}
