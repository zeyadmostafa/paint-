package paint.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.util.HashMap;
import java.util.Map;

public class Ellipse extends AbstractShape {
    private double length,width;
    private Point position;
    private Color color;
    private Color fillColor;
    protected Map<String,Double>properties;

	public Ellipse() {
		  properties = new HashMap<String,Double>();
          properties.put("X-axis" , 0.0);
          properties.put("Y-axis" , 0.0);
          properties.put("Radius1" , 0.0);
          properties.put("Radius2" , 0.0);
          properties.put("isSelcted", 0.0);
          color=Color.black;
          fillColor=null;
          position =new Point();
	}
	
	public Point getPosition() {
		return position;
	}

	public void setProperties(Map<String, Double> properties) {
		this.properties=properties;
		double x=properties.get("X-axis").intValue();
		double y=properties.get("Y-axis").intValue();
	    this.length=properties.get("Radius1");
	    this.width=properties.get("Radius2");
	    Point a=new Point((int)x,(int)y); 
	    this.setPosition(a);
		
	}
	
	public Map<String, Double> getProperties() {

		return properties;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void draw(Graphics g) {
		Graphics2D g2=(Graphics2D)g;
		g2.setStroke(new BasicStroke(5F));

		if (properties.get("isSelected").intValue()==1 )
		{
			final float dash1[] = {10.0f};
		    final BasicStroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
			g2.setStroke(dashed);
		}
	
			g.setColor(this.getColor());
			g.drawOval((int)position.getX(),(int) position.getY(), (int)this.length, (int)this.width);
	        if(fillColor!=null) {
	        g.setColor(this.getFillColor());
	        g.fillOval((int)position.getX(), (int) position.getY(), (int)this.length, (int)this.width);}
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	
	public Color getFillColor() {
		return fillColor;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Ellipse ellipse=new Ellipse();
	    ellipse.length=this.length;
	    ellipse.width =this.width;
	    ellipse.position=this.position;
	    
	    ellipse.color=this.color;
	    ellipse.fillColor=this.fillColor;
	    Map <String,Double> mp = new HashMap<>();
		mp.put("X-axis" ,this.properties.get("X-axis"));
		mp.put("Y-axis" , this.properties.get("Y-axis"));
		mp.put("Raduis1" , this.properties.get("Radius1"));
		mp.put("Raduis2" , this.properties.get("Radius2"));
		mp.put("isSelected", 0.0);
		ellipse.properties=mp;
	    return ellipse;
	}

	@Override
	public boolean contains(Point p) 
	{  Ellipse2D C=new Ellipse2D.Double(position.getX(), position.getY(), length, width);
	
	
    /*if (Math.pow(this.position.getX()-p.getX(), 2)+Math.pow(this.position.getY()-p.getY(), 2) < Math.pow(radius, 2))
        return true; 
    	return false;*/
	return C.contains(p);
		    }


}
