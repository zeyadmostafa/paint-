package paint.controller;
import paint.view.*;

import java.awt.Color;

import paint.model.Memento;
import paint.model.Shape;

public class undoClass implements CommandInterface {

	@Override
	public void execute(Memento memento) {
		System.out.println(DrawingEngine.getDrawingEngine().getArraylist());      
		
		DrawingEngine.getDrawingEngine().getArraylist().clear();
		System.out.println("new arraylist after delete "+DrawingEngine.getDrawingEngine().getArraylist());

	//panel.removeAll();
		//paintComponents(getGraphics());
		try {
			DrawingEngine.getDrawingEngine().setArraylist(memento.undoStack());
			System.out.println("new arraylist "+DrawingEngine.getDrawingEngine().getArraylist());
		} catch (Exception e) {
			System.out.println("stack is empty");
			// TODO: handle exception
		}

		if (MyPaintWindow.whiteBG==true) {
			for (Shape shape : DrawingEngine.getDrawingEngine().getShapes()) {
	            try {
					shape.setColor(Color.white);
				} catch (Exception ee) {
					ee.printStackTrace();
				}   
	        }
		}
		else if (MyPaintWindow.whiteBG==false) {
			for (Shape shape : DrawingEngine.getDrawingEngine().getShapes()) {
	            try {
					shape.setColor(Color.black);
				} catch (Exception ee) {
					ee.printStackTrace();
				}   
	        }
		}

		
		    System.out.println("---->>>>"+DrawingEngine.getDrawingEngine().getArraylist());   
		
	}

	

}
