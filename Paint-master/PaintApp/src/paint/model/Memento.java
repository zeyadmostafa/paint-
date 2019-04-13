package paint.model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Stack;

import paint.controller.DrawingEngine;

public class Memento  {  
	
	int count=0;
	public static Stack<ArrayList<Shape>> undo	= new Stack<ArrayList<Shape>>();
	public static Stack<ArrayList<Shape>> redo	= new Stack<ArrayList<Shape>>();


	public void  StackOfShapes(){	 
		
      
		 ArrayList<Shape> state = new ArrayList<Shape>();
		 
        for (Shape shape : DrawingEngine.getDrawingEngine().getShapes()) {
            try {
				state.add((Shape)shape.clone());
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}   
        }
		 
		// state = DrawingEngine.getDrawingEngine().getArraylist();
        if (count==20) {
        	undo.remove(0);
        	count--;
            undo.push(state);

        }else {
        	count++;
         undo.push(state);
        }
        
        System.out.println("stack of shapes");
	}
	
	
	public  ArrayList<Shape> undoStack (){
	if (undo.isEmpty()) {
	//	System.out.println("el null ahooooo");	
		return null;
	}
	ArrayList<Shape> temp =  new ArrayList<Shape>();
	for (Shape shape : undo.pop() ) {
        try {
			temp.add((Shape)shape.clone());
		} catch (CloneNotSupportedException e) {
e.printStackTrace();
		}  
    }
	// temp =  undo.pop();
	
	   redo.push(temp);

		return undo.peek();
	}
	
	public  ArrayList<Shape> redoStack (){
		
		if (redo.isEmpty()) {
			return null ;
		}
		
		return redo.pop();
		
	}

	public void refresh(Graphics canvas) {
        if (undo.isEmpty()) {
        	return;
        }
     
        ArrayList<Shape> temp =  new ArrayList<Shape>();
   temp = undo.peek();
		
		for (Shape s : temp ) {
			s.draw(canvas);
		}
	}
    
}