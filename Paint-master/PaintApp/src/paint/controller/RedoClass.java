package paint.controller;

import java.awt.Color;

import paint.model.Memento;
import paint.model.Shape;
import paint.view.MyPaintWindow;

public class RedoClass implements CommandInterface {

	@Override
	public void execute(Memento memento) {
		try {
			DrawingEngine.getDrawingEngine().setArraylist(memento.redoStack());
		} catch (Exception e) {
			System.out.println("stack is empty ");
			// TODO: handle exception
		}	
		
		if (MyPaintWindow.whiteBG==true) {
			for (Shape shape : DrawingEngine.getDrawingEngine().getShapes()) {
	           if (shape.getColor()== Color.black) {
				try {
					shape.setColor(Color.white);
				} catch (Exception ee) {
					ee.printStackTrace();
				}   
	           }}
		}
		else if (MyPaintWindow.whiteBG==false) {
			for (Shape shape : DrawingEngine.getDrawingEngine().getShapes()) {
	           if (shape.getColor()== Color.white) {
				try {
					shape.setColor(Color.black);
				} catch (Exception ee) {
					ee.printStackTrace();
				}   
	           } }
		}	
		// TODO Auto-generated method stub
		
	}

}
