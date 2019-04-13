package paint.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;
import java.util.Map;

public class Circle extends AbstractShape
{
		private double radius;
	    private Point position;
	    private Color color;
	    private Color fillColor;
	    protected Map<String,Double>properties;
	    
	public Circle() {
		  properties = new HashMap<String,Double>();
          properties.put("X-axis" , 0.0);
          properties.put("Y-axis" , 0.0);
          properties.put("Radius" , 0.0);
          properties.put("isSelected", 0.0);
          color=Color.black;
          fillColor=null;
          position =new Point();
	}
    
	public boolean contains(Point p)
	{    Ellipse2D C=new Ellipse2D.Double(position.getX(), position.getY(), radius, radius);
	
		return C.contains(p);
	}
	
   public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public void setColor(Color color) {
		this.color = color;
	}

public void draw (Graphics g)
   {Graphics2D g2=(Graphics2D)g;
	g2.setStroke(new BasicStroke(5F));
	if (properties.get("isSelected").intValue()==1 )
	{
		final float dash1[] = {10.0f};
	    final BasicStroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
		g2.setStroke(dashed);
	}

 g.setColor(getColor());
 g.drawOval((int)position.getX(), (int) position.getY(), (int)this.radius, (int)this.radius);
    if(fillColor!=null) 
    {
	g.setColor(this.getFillColor());
	g.fillOval((int)position.getX(), (int) position.getY(), (int)this.radius, (int)this.radius);
	}
   }

public void setProperties(Map<String, Double> properties) {
    	this.properties=properties;
    	double x=properties.get("X-axis").intValue();
       double y=properties.get("Y-axis").intValue();
       this.radius=properties.get("Radius");
       Point a=new Point((int)x,(int)y); 
     
       this.setPosition(a);
}

public Map<String, Double> getProperties() {
	
	return properties;
}

public Point getPosition() {
	return position;
}

public Color getColor() {
	return color;
}

public Object clone() throws CloneNotSupportedException {
	Circle circle =new Circle();
	circle.color=this.color;
	circle.fillColor=this.fillColor;
	circle.position=this.position;
	circle.radius=this.radius;
	Map <String,Double> mp = new HashMap<>();
	mp.put("X-axis" ,this.properties.get("X-axis"));
	mp.put("Y-axis" , this.properties.get("Y-axis"));
	mp.put("Raduis" , this.properties.get("Radius"));
	mp.put("isSelected", 0.0);
	circle.properties=mp;
	return circle;
}
}
