package paint.controller;

import java.util.ArrayList;

import paint.model.Shape;

public interface Strategy 
{
	public void save(ArrayList<Shape> shapes,String path) throws Exception;
	public void load(ArrayList<Shape> shapes,String path) throws Exception;
}
