package paint.controller;
import java.awt.Graphics;
import java.util.ArrayList;

import paint.model.Shape;

public interface DrawingEngineInterface {
		public void refresh(Graphics canvas); 
		public void addShape(Shape shape);  
		public void removeShape(Shape shape); 
		public void updateShape(Shape oldShape, Shape newShape); 
		public ArrayList<Shape> getShapes();    /* limited to 20 steps. You consider these actions in   * undo & redo: addShape, removeShape, updateShape */ 
		public void undo();
		public void redo(); 
		 
		 /* use the file extension to determine the type,    * or throw runtime exception when unexpected extension */ 
		public void save(String path);  
		public void load(String path);
}
