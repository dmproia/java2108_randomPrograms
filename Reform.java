
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;
import javax.swing.JPanel;

import java.awt.Font;

public class Reform extends Canvas
{
	public Polygon v;
	public Reform(Polygon h)
	{
		v = h;
	}
	
	public void paint(Graphics g)
	   {  
	     g.setColor(Color.red);
	     g.drawPolygon(v);
	   }
}
