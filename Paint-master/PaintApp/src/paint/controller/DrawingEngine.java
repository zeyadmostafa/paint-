package paint.controller;

import java.awt.Graphics;
import java.util.ArrayList;

import paint.model.Shape;

public class DrawingEngine implements DrawingEngineInterface{
	ArrayList<Shape> shapes = new ArrayList<Shape>(); 
	
	 private DrawingEngine() {
	}
		private static  DrawingEngine drawingEngine = new DrawingEngine();	
		public static DrawingEngine getDrawingEngine() {
			return drawingEngine ;
		}

		 public void setArraylist (ArrayList<Shape> temp) {
			 shapes.clear();
			 for (Shape shape :temp) {
		            try {
						shapes.add((Shape)shape.clone());
					} catch (CloneNotSupportedException e) {
		e.printStackTrace();
					} 
		        }
		//	 shapes=temp;
		 }
		 public ArrayList<Shape> getArraylist(){
			
			 return shapes;
			 
		 }
		 
	public void refresh(Graphics canvas)
	{
		for (Shape s : shapes) 
		{
			s.draw(canvas);
		}
	}

	public void addShape(Shape shape) 
	{
		shapes.add(shape);
	}

	public void removeShape(Shape shape) {
		shapes.remove(shape);
	}

	public void updateShape(Shape oldShape, Shape newShape) {
		shapes.remove(oldShape);
		shapes.add(newShape);
	}
	
	public ArrayList<Shape> getShapes() {		
		return shapes;
	}
	
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	
	public void redo() {
		// TODO Auto-generated method stub
		
	}

	public void save(String path) {
		// TODO Auto-generated method stub
		
	}

	
	public void load(String path) {
		// TODO Auto-generated method stub
		
	}

}
