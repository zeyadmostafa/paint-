package paint.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.awt.geom.*;

public class Rectangle extends AbstractShape {
  
	private Point Position;
	private double width;
	private double length;
	private Color color,fillcolor;

	
	public  Map<String, Double> properties;
	  public Rectangle() {		  
		  properties =new HashMap<String,Double>();
		  properties.put("X-axis", 0.0);
		  properties.put("Y-axis", 0.0);
		  properties.put("length", 0.0);
		  properties.put("width", 0.0);
		  properties.put("isSelected", 0.0);
		
		  color=Color.black;
		  fillcolor=null;
		  Position=new Point();
		}
	
	 public Point getPosition() {
		return Position;
	}

	public void setPosition(Point position) {
		Position = position;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getFillcolor() {
		return fillcolor;
	}

	public void setFillcolor(Color fillcolor) {
		this.fillcolor = fillcolor;
	}


	public void draw(Graphics g) {
		//Graphics2D g2=(Graphics2D)g;
		 //BasicStroke bs = new BasicStroke();
	       // g2.setStroke(new BasicStroke(5F));
		Graphics2D g2=(Graphics2D)g;
		g2.setStroke(new BasicStroke(5F));

		if (properties.get("isSelected").intValue()==1 )
		{
			final float dash1[] = {10.0f};
		    final BasicStroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
			g2.setStroke(dashed);
		}
	
		g.setColor(color);
		g.drawRect((int)Position.getX(), (int)Position.getY(), (int)this.width, (int)this.length);
		if(fillcolor!=null) {
		g.setColor(this.getFillcolor());
		g.fillRect((int)Position.getX(), (int)Position.getY(), (int)this.width, (int)this.length);}
	}

	
	public void setProperties(Map<String, Double> properties) {
		this.properties=properties;
		double x=properties.get("X-axis").intValue();
		double y=properties.get("Y-axis").intValue();
		this.width=properties.get("width");
		this.length=properties.get("length");
		Point a=new Point((int)x,(int)y);
		this.setPosition(a);
	}

	
	public Map<String, Double> getProperties() {
		return properties;
	}

	public Color getFillColor() {
		return fillcolor;
	}

	
	public void setFillColor(Color color) {
		this.fillcolor = color;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Rectangle r=new Rectangle();
	    r.Position=this.Position;
	    r.width=this.width;
	    r.length=this.length;
	    r.color=this.color;
	    r.fillcolor=this.fillcolor;
	    Map <String,Double> mp = new HashMap<>();
		mp.put("X-axis" ,this.properties.get("X-axis"));
		mp.put("Y-axis" , this.properties.get("Y-axis"));
		mp.put("width" , this.properties.get("width"));
		mp.put("length" , this.properties.get("length"));
		mp.put("isSelected", 0.0);
		r.setProperties(mp);	
	    return r;
	}

	@Override
	public boolean contains(Point p) {
		    double w=width;
		    double l=length;
		        if(w<0.0||l<0.0){
		         // At least one of the dimensions is negative...
		              return false;
		          }
		            // Note: if either dimension is zero, tests below must return false...
		         if (p.getX() < Position.getX() || p.getY() < Position.getY()) {
		               return false;
		           }
		         w += Position.getX();
		           l += Position.getY();
		          //    overflow || intersect
		          return ((w < Position.getX() || w > p.getX()) &&
		                   (l < Position.getY() || l> p.getY()));
	}
}
