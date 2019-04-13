package paint.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.Position;

public class LineSegment extends AbstractShape{
	private int[] x,y;
    private Map<String,Double>properties; 
    private Color color,fillColor;
    private Point center;
	
    
    public LineSegment(){
	
	            properties = new HashMap<String,Double>();
	            properties.put("X1" , 0.0);
	            properties.put("Y1" , 0.0);
	            properties.put("X2" , 0.0);
	            properties.put("Y2" , 0.0);
	            properties.put("isSelcted", 0.0);
	            color=Color.black;
	            fillColor=Color.black;
	            x=new int[2];
	            y=new int[2];
	}
	
	public Point getPosition() {
		Point P=new Point((x[0]+x[1])/2,(y[0]+y[1])/2);
		return P;
	}

	
	public void setProperties(Map<String, Double> properties) {
		this.properties=properties;
        this.x[0]=properties.get("X1").intValue();
        this.y[0]=properties.get("Y1").intValue();
        this.x[1]=properties.get("X2").intValue();
        this.y[1]=properties.get("Y2").intValue(); 
		
	}

	
	public Map<String, Double> getProperties() {
	
		return properties;
	}

	
	public void setColor(Color color) {
		this.color=color;
		
	}

	
	public Color getColor() {
		return color;
		
	}

	
	public void setFillColor(Color color) {
		this.fillColor=color;
		
	}

	
	public Color getFillColor() {
		return fillColor;
	}

	
	public void draw(Graphics g) {
		Graphics2D g2=(Graphics2D)g;
		g2.setStroke(new BasicStroke(5F));

		if (properties.get("isSelected").intValue()== 1 )
		{
			final float dash1[] = {10.0f};
		    final BasicStroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
			g2.setStroke(dashed);
		}
	
		 g.setColor(this.getColor());
         g.drawLine(x[0], y[0], x[1], y[1]);
          g.setColor(this.getFillColor());
	}
	
	public void setPosition(Point position) {
	       int a=(x[0]+x[1])/2;
	       int b=(y[0]+y[1])/2;
	       Point m=new Point(a,b);
	       int mx=position.x-m.x;
	       int my=position.y-m.y;
	       x[0]=x[0]+mx;
	       x[1]=x[1]+mx;
	       y[0]=y[0]+my;
	       y[1]=y[1]+my;	
	}
	
	public Object clone() throws CloneNotSupportedException {
		  Shape line =new LineSegment();
	      line.setColor(this.getColor());
	      line.setFillColor(this.getFillColor());
	      Map <String,Double> mp = new HashMap<>();
			mp.put("X1" ,this.properties.get("X1"));
			mp.put("Y1" , this.properties.get("Y1"));
			mp.put("X2" , this.properties.get("X2"));
			mp.put("Y2" , this.properties.get("Y2"));
			mp.put("isSelected", 0.0);
			line.setProperties(mp);
	      return line;
	}

	public boolean contains(Point p) {	
	     Line2D line = new Line2D.Double(x[0], y[0], x[1], y[1]);
	        int selectX = Math.min(x[0], x[1]) - 5;
	        int  selectY = Math.min(y[0], y[1]) - 5;
	        double selectWidth = Math.abs(x[0] - x[1]) + 10;
	        double   selectHeight = Math.abs(y[0] - y[1]) + 10;
	        Rectangle2D rect = new Rectangle2D.Double(selectX, selectY, selectWidth, selectHeight);
	 		
		return rect.contains(p);
	}
}
