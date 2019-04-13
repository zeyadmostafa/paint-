package paint.controller;

import java.awt.Point;
import paint.model.*;
import java.util.Map;

public class Moving
{
	public Point Move(double x, double y,double xDiff,double yDiff)
	{
		System.out.println("old x and y " + x + " " + y);
        x += xDiff;
        y += yDiff;
        System.out.println("new x and y " + x + " " + y);
        return new Point((int)x,(int) y);
	}


	
}
