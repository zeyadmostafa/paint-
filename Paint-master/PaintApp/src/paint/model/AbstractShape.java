package paint.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

public abstract class AbstractShape implements Shape 
{	 
	    public abstract void setPosition(Point position);
	    public abstract void setProperties(Map<String, Double> properties); 
	    public abstract Map<String, Double> getProperties() ;
	    public abstract void setColor(Color color) ; 
	    public abstract Color getColor();
	    public abstract void setFillColor(Color color) ;
	    public abstract Color getFillColor() ; 
	    public abstract void draw(Graphics g) ;
	    public abstract boolean contains(Point p);
	    public abstract Object clone() throws CloneNotSupportedException; 
}
