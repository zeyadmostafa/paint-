package paint.controller;

import java.util.ArrayList;

import paint.model.Shape;

import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class JsonFile implements Strategy {

	@Override
	public void save(ArrayList<Shape> shapes,String path) throws Exception {
		
	    int i;
	    JSONObject jBigObject = new JSONObject();
        jBigObject.put("noOfShapes", "" + shapes.size());
        JSONObject jShapes;
        
        for(i=0; i<shapes.size(); i++)
        {
        	    Shape s = shapes.get(i);
        	    jShapes=new JSONObject();
        	    if(s instanceof paint.model.Triangle)
        	    {
        	    	 jShapes.put("Name", s.getClass().getCanonicalName());
        	    	   jShapes.put("Color", s.getColor().getRGB());
        	    	 if (s.getFillColor()!=null)
        		            jShapes.put("FillColor", s.getFillColor().getRGB());
        		            else
        		            	jShapes.put("FillColor", null);
        		            jShapes.put("properties", s.getProperties());
        		            jBigObject.put("" + i, jShapes);
        	    }
        	    else {
	            
	            jShapes.put("Name", s.getClass().getCanonicalName());
	            jShapes.put("PositionX", s.getPosition().getX());
	            jShapes.put("PositionY", s.getPosition().getY());
	            jShapes.put("Color", s.getColor().getRGB());
	            if (s.getFillColor()!=null)
	            jShapes.put("FillColor", s.getFillColor().getRGB());
	            else
	            	jShapes.put("FillColor", null);
	            jShapes.put("properties", s.getProperties());
	            jBigObject.put("" + i, jShapes);
	        }}
	        try {
	            FileWriter file = new FileWriter(path);
	            file.write(jBigObject.toJSONString());
	            file.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
      
        }



		
	


	@Override
	public void load(ArrayList<Shape> shapes,String path) throws Exception {
			JSONParser jsonParser = new JSONParser();
				      
	        try { 
	        	shapes.clear();
	        	File file = new File(path);
	            Object object = jsonParser.parse(new FileReader(file));       
	            JSONObject jsonObject = (JSONObject) object;
	            int size = Integer.parseInt(((String) jsonObject.get("noOfShapes")));
	            
	            for (int i =0; i <size; i++) {
	            	
	            	JSONObject  jShapes = (JSONObject) jsonObject.get(i + "");
	            	Class o=null;
	            	try {
	            	  o= Class.forName((String)jShapes.get("Name"));}
	            	catch(Exception e) {}
	            	if (o!=null) {
	            		
	            		Shape s=(Shape) o.newInstance();
	                    if (s instanceof paint.model.Triangle)
	                    { s.setColor(new Color(((Number)jShapes.get("Color")).intValue()));
	                    	System.out.println("S IS TRIANGLE");
	                    	if (jShapes.get("FillColor")!=null)
			                    s.setFillColor(new Color(((Number)jShapes.get("FillColor")).intValue()));
			                    
	                    	s.setProperties((Map<String, Double>)jShapes.get("properties"));
	                    	
	                    	
		                    
		                    shapes.add(s);
	                    }
	                    else
	                    {
	                    s.setColor(new Color(((Number)jShapes.get("Color")).intValue()));
	                    if (jShapes.get("FillColor")!=null)
	                    s.setFillColor(new Color(((Number)jShapes.get("FillColor")).intValue()));
	                    s.setProperties((Map<String, Double>)jShapes.get("properties"));	                    
	                    s.setPosition(new Point( ((Number)jShapes.get("PositionX")).intValue(),((Number)jShapes.get("PositionY")).intValue()));
	                    shapes.add(s);
	                    }
	                  
	                    
	            	}
	            
	            }
	        }catch (Exception e) {
	            }
		
		}
		
	}


