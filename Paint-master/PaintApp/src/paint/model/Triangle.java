package paint.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.util.HashMap;
import java.util.Map;

public class Triangle extends AbstractShape{
		private int[] x,y;
	    private Map<String,Double>properties; 
	    private Color color,fillColor;
	    private Point Position;
		public Triangle(){
	            properties = new HashMap<String,Double>();
	            properties.put("X1" , 0.0);
	            properties.put("Y1" , 0.0);
	            properties.put("X2" , 0.0);
	            properties.put("Y2" , 0.0);
	            properties.put("Y3" , 0.0);
	            properties.put("X3" , 0.0);
	            properties.put("isSelected", 0.0);
	            this.color=Color.black;
	           this.fillColor=null;
	            x=new int[3];
	            y=new int[3];
	        }

	
	public Point getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void setPosition(Point position) {
		  int a=(x[0]+x[1])/2;
	       int b=(y[0]+y[1])/2;
	       Point m=new Point(a,b);
	       int u=((x[2]-m.x)/3)+m.x;
	       int v=((y[2]-m.y)/3)+m.y;
	       Point cc=new Point(u,v);
	       int mx=position.x-cc.x;
	       int my=position.y-cc.y;
	       x[0]=x[0]+mx;
	       x[1]=x[1]+mx;
	       x[2]=x[2]+mx;
	       y[0]=y[0]+my;
	       y[1]=y[1]+my;
	       y[2]=y[2]+my;
		
	}

	
	public void setProperties(Map<String, Double> properties) {
	
		  this.properties=properties;
          this.x[0]=properties.get("X1").intValue();
          this.y[0]=properties.get("Y1").intValue();
          this.x[1]=properties.get("X2").intValue();
          this.y[1]=properties.get("Y2").intValue();
          this.x[2]=properties.get("X3").intValue();
          this.y[2]=properties.get("Y3").intValue();  
	}

	
	public Map<String, Double> getProperties() {
		// TODO Auto-generated method stub
		return properties;
	}

	
	public void setColor(Color color) {
	this .color=color;
		
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

		if (properties.get("isSelected").intValue()==1 )
		{
			final float dash1[] = {10.0f};
		    final BasicStroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
			g2.setStroke(dashed);
		}
		g.setColor(this.getColor());
        g.drawPolygon(this.x, this.y, 3);
        if(fillColor!=null) {
        g.setColor(this.getFillColor());
        g.fillPolygon(this.x, this.y, 3);
        }
	}


	@Override
	public Object clone() throws CloneNotSupportedException {
		Triangle t=new Triangle();
	    t.Position=this.Position;
	    for(int i =0;i<3;i++){
	        t.x[i]= this.x[i];
	       t.y[i]= this.y[i];
	    }
	    t.color = this.color;
	    t.fillColor=this.fillColor;
	    Map <String,Double> mp = new HashMap<>();
		mp.put("X1" ,this.properties.get("X1"));
		mp.put("Y1" , this.properties.get("Y1"));
		mp.put("X2" , this.properties.get("X2"));
		mp.put("Y2" , this.properties.get("Y2"));
		mp.put("Y3" , this.properties.get("Y3"));
		mp.put("X3" , this.properties.get("X3"));
		mp.put("isSelected", 0.0);
		t.setProperties(mp);		    return t;
	}


	@Override
	public boolean contains(Point p) {
		return new Polygon(x,y,3).contains(p.getX(),p.getY())?true:false;
	}
}
