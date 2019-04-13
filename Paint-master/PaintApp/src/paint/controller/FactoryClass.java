package paint.controller;



public class FactoryClass {
	
	    public paint.model.Shape getShape(String shape){
	        //if(shape.equalsIgnoreCase("triangle"))  return new Triangle();
	        if(shape.equals("rectangle")) return new paint.model.Rectangle();
	        if(shape.equals("square"))    return new paint.model.Square();
	        if(shape.equals("circle"))    return new paint.model.Circle();
	        if(shape.equals("ellipse"))   return new paint.model.Ellipse();
	        if(shape.equals("line"))      return new paint.model.LineSegment();
	        if(shape.equals("triangle"))  return new paint.model.Triangle();
	        return null;
	}
}
