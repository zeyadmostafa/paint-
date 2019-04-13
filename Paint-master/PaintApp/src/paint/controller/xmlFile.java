package paint.controller;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import org.w3c.dom.DocumentType;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


import java.awt.*;
import paint.model.Circle;
import paint.model.Ellipse;
import paint.model.LineSegment;
import paint.model.Shape;
import paint.model.Square;
import paint.model.Triangle;
import paint.view.MyPaintWindow;

public class xmlFile implements Strategy {

	public void save(ArrayList<Shape> shapes,String path) throws Exception {
		Ellipse c;
		Triangle t;
		Rectangle r;
		Square s;
		Circle cir;
		LineSegment l;
		Color co;
		DocumentBuilderFactory docFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("shapes");
		doc.appendChild(rootElement);
		for (Shape S : shapes) {
			if (S instanceof paint.model.Circle) {
				System.out.println("IN CIRLCEEE");
				Element circle = doc.createElement("circle");
				rootElement.appendChild(circle);
				// xpoint elements
				Element xc = doc.createElement("x");
				xc.appendChild(doc.createTextNode("" + S.getPosition().getX()));
				circle.appendChild(xc);
				// ypoint elements
				Element yc = doc.createElement("y");
				yc.appendChild(doc.createTextNode(""
						+S.getPosition().getY()));
				circle.appendChild(yc);
				// Width elements
				Element Raduis = doc.createElement("Radius");
				Raduis.appendChild(doc.createTextNode(""
						 + S.getProperties().get("Radius")));
				circle.appendChild(Raduis);
				Element ccolor = doc.createElement("color");
				ccolor.appendChild(doc.createTextNode(Integer
						.toString(S.getColor().getRGB())));
				circle.appendChild(ccolor);
				
				if(S.getFillColor()!=null) {
					Element cfilled = doc.createElement("filledred");
					cfilled.appendChild(doc.createTextNode(""+ S.getFillColor().getRed()));
					circle.appendChild(cfilled);
					
					Element cfilled2= doc.createElement("filledblue");
					
					cfilled2.appendChild(doc.createTextNode(""+ S.getFillColor().getBlue()));
					
					circle.appendChild(cfilled2);
					
					Element cfilled3= doc.createElement("filledgreen");
					
					cfilled3.appendChild(doc.createTextNode(""+ S.getFillColor().getGreen()));
					
				circle.appendChild(cfilled3);}
					else if ( S.getFillColor()==null){
						System.out.println("NOFILLED COLOR");
						Element cfilled = doc.createElement("filledred");
					cfilled.appendChild(doc.createTextNode(""+ 255));
				circle.appendChild(cfilled);
					
					Element cfilled2= doc.createElement("filledblue");
					
					cfilled2.appendChild(doc.createTextNode(""+ 255));
					
					circle.appendChild(cfilled2);
					
					Element cfilled3= doc.createElement("filledgreen");
					
					cfilled3.appendChild(doc.createTextNode(""+ 255));
					
				circle.appendChild(cfilled3);
						
				}
			}
			else if (S instanceof paint.model.Ellipse) {
				Element ellipse = doc.createElement("ellipse");
				rootElement.appendChild(ellipse);
				// xpoint elements
				Element xellp = doc.createElement("x");
				xellp.appendChild(doc.createTextNode("" + S.getPosition().getX()));
				ellipse.appendChild(xellp);
				// ypoint elements
				Element yellp = doc.createElement("y");
				yellp.appendChild(doc.createTextNode(""
						+S.getPosition().getY()));
				ellipse.appendChild(yellp);
				// Width elements
				Element Raduis1 = doc.createElement("Radius1");
				Raduis1.appendChild(doc.createTextNode(""
						 + S.getProperties().get("Radius1")));
				ellipse.appendChild(Raduis1);
				Element Raduis2 = doc.createElement("Radius2");
				Raduis2.appendChild(doc.createTextNode(""
						 + S.getProperties().get("Radius2")));
				ellipse.appendChild(Raduis2);
             //  Element isSelected = doc.createElement("isSelected");
             //  isSelected.appendChild(doc.createTextNode(""+S.getProperties().get("isSelected")));
               //circle.appendChild(isSelected);
				// color elements
				Element ccolor = doc.createElement("color");
				ccolor.appendChild(doc.createTextNode(Integer
						.toString(S.getColor().getRGB())));
				ellipse.appendChild(ccolor);
			/*	Element cfilled = doc.createElement("filled");
				cfilled.appendChild(doc.createTextNode(""+ S.getFillColor()));
				ellipse.appendChild(cfilled);*/
			
				if(S.getFillColor()!=null) {
					Element cfilled = doc.createElement("filledred");
					cfilled.appendChild(doc.createTextNode(""+ S.getFillColor().getRed()));
				ellipse.appendChild(cfilled);
					
					Element cfilled2= doc.createElement("filledblue");
					
					cfilled2.appendChild(doc.createTextNode(""+ S.getFillColor().getBlue()));
					
				ellipse.appendChild(cfilled2);
					
					Element cfilled3= doc.createElement("filledgreen");
					
					cfilled3.appendChild(doc.createTextNode(""+ S.getFillColor().getGreen()));
					
					ellipse.appendChild(cfilled3);}
					else if ( S.getFillColor()==null){
						System.out.println("NOFILLED COLOR");
						Element cfilled = doc.createElement("filledred");
					cfilled.appendChild(doc.createTextNode(""+ 255));
				ellipse.appendChild(cfilled);
					Element cfilled2= doc.createElement("filledblue");
					
					cfilled2.appendChild(doc.createTextNode(""+ 255));
					
					ellipse.appendChild(cfilled2);
					
					Element cfilled3= doc.createElement("filledgreen");
					
					cfilled3.appendChild(doc.createTextNode(""+ 255));
					
					ellipse.appendChild(cfilled3);
						
				}
			}
			else if (S instanceof paint.model.Rectangle)
			{
				Element rectangle = doc.createElement("rectangle");
				rootElement.appendChild(rectangle);
				// xpoint elements
				Element xr = doc.createElement("x");
					xr.appendChild(doc.createTextNode("" + S.getPosition().getX()));

				rectangle.appendChild(xr);
				// ypoint elements
				Element yr = doc.createElement("y");
				yr.appendChild(doc.createTextNode(""
						+S.getPosition().getY()));
				rectangle.appendChild(yr);
				// Width elements
				Element length = doc.createElement("length");
				length.appendChild(doc.createTextNode(""+ S.getProperties().get("length")));				
				rectangle.appendChild(length);				
				Element width = doc.createElement("width");				
				width.appendChild(doc.createTextNode(""+ S.getProperties().get("width")));			
				rectangle.appendChild(width);			
				Element ccolor = doc.createElement("color");
				ccolor.appendChild(doc.createTextNode(Integer
						.toString(S.getColor().getRGB())));
				rectangle.appendChild(ccolor);
				if(S.getFillColor()!=null) {
					Element cfilled = doc.createElement("filledred");
					cfilled.appendChild(doc.createTextNode(""+ S.getFillColor().getRed()));
				rectangle.appendChild(cfilled);
					
					Element cfilled2= doc.createElement("filledblue");
					
					cfilled2.appendChild(doc.createTextNode(""+ S.getFillColor().getBlue()));
					
					rectangle.appendChild(cfilled2);
					
					Element cfilled3= doc.createElement("filledgreen");
					
					cfilled3.appendChild(doc.createTextNode(""+ S.getFillColor().getGreen()));
					
					rectangle.appendChild(cfilled3);}
					else if ( S.getFillColor()==null){
						System.out.println("NOFILLED COLOR");
						Element cfilled = doc.createElement("filledred");
					cfilled.appendChild(doc.createTextNode(""+ 255));
					rectangle.appendChild(cfilled);
					
					Element cfilled2= doc.createElement("filledblue");
					
					cfilled2.appendChild(doc.createTextNode(""+ 255));
					
					rectangle.appendChild(cfilled2);
					
					Element cfilled3= doc.createElement("filledgreen");
					
					cfilled3.appendChild(doc.createTextNode(""+ 255));
					
					rectangle.appendChild(cfilled3);
						
				}
			}
			else if (S instanceof paint.model.LineSegment)
			{
				Element line = doc.createElement("line");
				rootElement.appendChild(line);
				// xpoint elements
				Element xl = doc.createElement("x");
				xl.appendChild(doc.createTextNode("" + S.getPosition().getX()));
				line.appendChild(xl);
				// ypoint elements

				Element yl = doc.createElement("y");

				yl.appendChild(doc.createTextNode(""

						+S.getPosition().getY()));

			line.appendChild(yl);
				// Width elements
				Element x1= doc.createElement("X1");

				x1.appendChild(doc.createTextNode(""
				
						+ S.getProperties().get("X1")));
				line.appendChild(x1);
				
				Element x2 = doc.createElement("X2");
				x2.appendChild(doc.createTextNode(""+ S.getProperties().get("X2")));
				line.appendChild(x2);
				
				Element y1= doc.createElement("Y1");
				y1.appendChild(doc.createTextNode(""+ S.getProperties().get("Y1")));
				line.appendChild(y1);
				
				Element y2 = doc.createElement("Y2");
				y2.appendChild(doc.createTextNode(""+ S.getProperties().get("Y2")));
				
				line.appendChild(y2);
				Element ccolor = doc.createElement("color");

				ccolor.appendChild(doc.createTextNode(Integer
						.toString(S.getColor().getRGB())));
				line.appendChild(ccolor);
				// filled elements
				Element cfilled = doc.createElement("filled");
				cfilled.appendChild(doc.createTextNode(Integer
						.toString(S.getFillColor().getRGB())));

				line.appendChild(cfilled);
			}
			else if (S instanceof paint.model.Square)
			{ 
				Element square = doc.createElement("square");
				rootElement.appendChild(square);
				// xpoint elements
				Element xs = doc.createElement("x");
				xs.appendChild(doc.createTextNode("" + S.getPosition().getX()));

				square.appendChild(xs);
				
				// ypoint elements

				Element yl = doc.createElement("y");

				yl.appendChild(doc.createTextNode(""

						+S.getPosition().getY()));

			square.appendChild(yl);
		
				// Width elements
				Element length= doc.createElement("length");
				
				length.appendChild(doc.createTextNode(""+ S.getProperties().get("length")));
				square.appendChild(length);
				
				Element ccolor = doc.createElement("color");

				ccolor.appendChild(doc.createTextNode(Integer
						.toString(S.getColor().getRGB())));
				square.appendChild(ccolor);
				
				/*Element cfilled = doc.createElement("filled");
				cfilled.appendChild(doc.createTextNode(""+ S.getFillColor()));
				square.appendChild(cfilled);*/
				
				if(S.getFillColor()!=null) {
					Element cfilled = doc.createElement("filledred");
					cfilled.appendChild(doc.createTextNode(""+ S.getFillColor().getRed()));
				square.appendChild(cfilled);
					
					Element cfilled2= doc.createElement("filledblue");
					
					cfilled2.appendChild(doc.createTextNode(""+ S.getFillColor().getBlue()));
					
					square.appendChild(cfilled2);
					
					Element cfilled3= doc.createElement("filledgreen");
					
					cfilled3.appendChild(doc.createTextNode(""+ S.getFillColor().getGreen()));
					
					square.appendChild(cfilled3);}
					else if ( S.getFillColor()==null){
						System.out.println("NOFILLED COLOR");
						Element cfilled = doc.createElement("filledred");
					cfilled.appendChild(doc.createTextNode(""+ 255));
					square.appendChild(cfilled);
					
					Element cfilled2= doc.createElement("filledblue");
					
					cfilled2.appendChild(doc.createTextNode(""+ 255));
					
					square.appendChild(cfilled2);
					
					Element cfilled3= doc.createElement("filledgreen");
					
					cfilled3.appendChild(doc.createTextNode(""+ 255));
					
					square.appendChild(cfilled3);
						
				}
			}
			else if (S instanceof paint.model.Triangle)
			{ 
				Element triangle = doc.createElement("triangle");
				rootElement.appendChild(triangle);
				// xpoint elements
				Element xtr = doc.createElement("x");
				
				xtr.appendChild(doc.createTextNode("" + S.getProperties().get("X1")));
				
				triangle.appendChild(xtr);



				// ypoint elements

				Element ytr = doc.createElement("y");

				ytr.appendChild(doc.createTextNode(""

						+S.getProperties().get("Y1")));

			triangle.appendChild(ytr);
			
			
				// Width elements
				Element x1= doc.createElement("X2");
				x1.appendChild(doc.createTextNode(""+ S.getProperties().get("X2")));
				triangle.appendChild(x1);
				
				Element y1= doc.createElement("Y2");
				
				y1.appendChild(doc.createTextNode(""+ S.getProperties().get("Y2")));
				triangle.appendChild(y1);
				
				Element x2= doc.createElement("X3");
				x2.appendChild(doc.createTextNode(""+ S.getProperties().get("X3")));
				triangle.appendChild(x2);
				
				Element y2= doc.createElement("Y3");
				y2.appendChild(doc.createTextNode(""+ S.getProperties().get("Y3")));
				triangle.appendChild(y2);
				
				Element x3= doc.createElement("X4");
				x3.appendChild(doc.createTextNode(""+ S.getProperties().get("X3")));
				triangle.appendChild(x3);
				
				Element y3= doc.createElement("Y4");
				y3.appendChild(doc.createTextNode(""+S.getProperties().get("Y3")));
				triangle.appendChild(y3);
				
				Element ccolor = doc.createElement("color");

				ccolor.appendChild(doc.createTextNode(Integer

						.toString(S.getColor().getRGB())));
				triangle.appendChild(ccolor);
				
				// filled elements
		/*		Element cfilled = doc.createElement("filled");
				cfilled.appendChild(doc.createTextNode(""+ S.getFillColor()));
				triangle.appendChild(cfilled);*/
			
				if(S.getFillColor()!=null) {
				Element cfilled = doc.createElement("filledred");
				cfilled.appendChild(doc.createTextNode(""+ S.getFillColor().getRed()));
				triangle.appendChild(cfilled);
				
				Element cfilled2= doc.createElement("filledblue");
				
				cfilled2.appendChild(doc.createTextNode(""+ S.getFillColor().getBlue()));
				
				triangle.appendChild(cfilled2);
				
				Element cfilled3= doc.createElement("filledgreen");
				
				cfilled3.appendChild(doc.createTextNode(""+ S.getFillColor().getGreen()));
				
				triangle.appendChild(cfilled3);}
				else if ( S.getFillColor()==null){
					System.out.println("NOFILLED COLOR");
					Element cfilled = doc.createElement("filledred");
				cfilled.appendChild(doc.createTextNode(""+ 255));
				triangle.appendChild(cfilled);
				
				Element cfilled2= doc.createElement("filledblue");
				
				cfilled2.appendChild(doc.createTextNode(""+ 255));
				
				triangle.appendChild(cfilled2);
				
				Element cfilled3= doc.createElement("filledgreen");
				
				cfilled3.appendChild(doc.createTextNode(""+ 255));
				
				triangle.appendChild(cfilled3);
					
			}
			
			}
			
			
		}



		// write the content into xml file

		TransformerFactory transformerFactory = TransformerFactory

				.newInstance();

		Transformer transformer = transformerFactory.newTransformer();

		DOMSource source = new DOMSource(doc);

		StreamResult result = new StreamResult(new File(MyPaintWindow.url + ".xml"));

		transformer.transform(source, result);

		System.out.println("File saved!");

	}
	
	public void load(ArrayList<Shape> shapes, String path) throws Exception{
		
		int shapeindex = 0;
		shapes.clear();
		//Currentshapes.clear();
		File Xml = new File(MyPaintWindow.url);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(Xml);
		doc.getDocumentElement().normalize();
		Map<String, Double> mp =new HashMap<String,Double>();
		
		NodeList sList = doc.getElementsByTagName("square");
		
		for (int i = 0; i < sList.getLength(); i++)
		{

			Node sNode = sList.item(i);
			if (sNode != null) {
				if (sNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) sNode;
		
					Square s = new Square();
						
					Map<String, Double> ms =new HashMap<String,Double>();
			//		System.out.println("tag value "+ getTagValue("x",eElement));
					double x =Double.parseDouble(getTagValue("x",eElement));
		
				
					double y =Double.parseDouble(getTagValue("y",eElement));
					
					double l=Double.parseDouble(getTagValue("length", eElement));
					System.out.println(""+l);
					ms.put("X-axis", x);
					ms.put("Y-axis", y);
					ms.put("length",l);
					ms.put("isSelected", 0.0);
				
					  
					  s.setProperties(ms);
					  
					
					 Color co = new Color(Integer.parseInt(getTagValue("color",eElement)));

				s.setColor(co);
				
				int r =Integer.parseInt(getTagValue("filledred",eElement));
				
				//System.out.println("r"+r);
				int b =Integer.parseInt(getTagValue("filledblue",eElement));
	
				int g=Integer.parseInt(getTagValue("filledgreen", eElement));
	
				Color c=new Color(r, g, b);
		
						s.setFillColor(c);
						
						shapes.add(s);
					
				}
			
			}}
		
		NodeList rList = doc.getElementsByTagName("rectangle");
		for (int i = 0; i < rList.getLength(); i++) {

			Node rNode = rList.item(i);
			if (rNode != null) {
				if (rNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) rNode;
					
		
					paint.model.Rectangle r = new paint.model.Rectangle();
						
					Map<String, Double> mr =new HashMap<String,Double>();
					
				
					double x =Double.parseDouble(getTagValue("x",eElement));
					
				
					double y =Double.parseDouble(getTagValue("y",eElement));
					
					double l=Double.parseDouble(getTagValue("length", eElement));
				
					double w =Double.parseDouble(getTagValue("width",eElement));
					
					
					
		
					mr.put("X-axis", x);
					mr.put("Y-axis", y);
					mr.put("length",l);
					mr.put("width", w);
					mr.put("isSelected", 0.0);
					r.setProperties(mr);
					  
					
					 Color co1 = new Color(Integer.parseInt(getTagValue("color",eElement)));

				r.setColor(co1);
				
				int red =Integer.parseInt(getTagValue("filledred",eElement));
				
				//System.out.println("r"+r);
				int b =Integer.parseInt(getTagValue("filledblue",eElement));
	
				int g=Integer.parseInt(getTagValue("filledgreen", eElement));
	
				Color c=new Color(red, g, b);
		
						r.setFillColor(c);
				
						shapes.add(r);
				}
			} } 
		
		NodeList circList = doc.getElementsByTagName("circle");
		for (int i = 0; i < circList.getLength(); i++) {

			Node cNode = circList.item(i);
			if (cNode != null) {
				if (cNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) cNode;
					
		
					paint.model.Circle c = new paint.model.Circle();
						
					Map<String, Double> mc =new HashMap<String,Double>();
					
					
					double x =Double.parseDouble(getTagValue("x",eElement));
					System.out.println("hello" +x);
				
					double y =Double.parseDouble(getTagValue("y",eElement));
					
					System.out.println("hello" +y);
					
					//double s =Double.parseDouble(getTagValue("isSelected",eElement));
					
					double R=Double.parseDouble(getTagValue("Radius", eElement));
					System.out.println(""+R);

					mc.put("X-axis", x);
					mc.put("Y-axis", y);
					mc.put("Radius",R);
					
					mc.put("isSelected", 0.0);
					
					
					  
					c.setProperties(mc);
					  
					
					 Color co2 = new Color(Integer.parseInt(getTagValue("color",eElement)));

				c.setColor(co2);
				
				int r =Integer.parseInt(getTagValue("filledred",eElement));
				
				//System.out.println("r"+r);
				int b =Integer.parseInt(getTagValue("filledblue",eElement));
	
				int g=Integer.parseInt(getTagValue("filledgreen", eElement));
	
				Color col=new Color(r, g, b);
		
						c.setFillColor(col);
				
						shapes.add(c);
		
		}}}
		NodeList ellpList = doc.getElementsByTagName("ellipse");
		for (int i = 0; i < ellpList.getLength(); i++) {

			Node ellpNode = ellpList.item(i);
			if (ellpNode != null) {
				if (ellpNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) ellpNode;
					
		
					paint.model.Ellipse ellp = new paint.model.Ellipse();
						
					Map<String, Double> mellp =new HashMap<String,Double>();
					
					
					double x =Double.parseDouble(getTagValue("x",eElement));
				
				
					double y =Double.parseDouble(getTagValue("y",eElement));
					
					
					
					double R1=Double.parseDouble(getTagValue("Radius1", eElement));
					
					double R2 = Double.parseDouble(getTagValue("Radius2",eElement));
					

					mellp.put("X-axis", x);
					mellp.put("Y-axis", y);
					mellp.put("Radius1",R1);
					mellp.put("Radius2", R2);
					mellp.put("isSelected", 0.0);
					
					
					  
					ellp.setProperties(mellp);
					  
					
					 Color co2 = new Color(Integer.parseInt(getTagValue("color",eElement)));

				ellp.setColor(co2);
				
int r =Integer.parseInt(getTagValue("filledred",eElement));
				
				//System.out.println("r"+r);
				int b =Integer.parseInt(getTagValue("filledblue",eElement));
	
				int g=Integer.parseInt(getTagValue("filledgreen", eElement));
	
				Color c=new Color(r, g, b);
		
						ellp.setFillColor(c);
				
						shapes.add(ellp);
		
		}}}

	
		NodeList lList = doc.getElementsByTagName("line");
		for (int i = 0; i < lList.getLength(); i++) {

			Node lNode = lList.item(i);
			if (lNode != null) {
				if (lNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) lNode;
					
		
					paint.model.LineSegment l = new paint.model.LineSegment();
						
					Map<String, Double> ml =new HashMap<String,Double>();
					
				
					double x =Double.parseDouble(getTagValue("x",eElement));
					double y =Double.parseDouble(getTagValue("y",eElement));
					
					double x1=Double.parseDouble(getTagValue("X1", eElement));
					
					
					double x2=Double.parseDouble(getTagValue("X2", eElement));
					double y1=Double.parseDouble(getTagValue("Y1", eElement));
					
					double y2 =Double.parseDouble(getTagValue("Y2",eElement));
					
					
					
		
					ml.put("X1", x1);
					ml.put("Y1", y1);
					ml.put("X2",x2);
					ml.put("Y2", y2);
					ml.put("isSelected", 0.0);
					  
					l.setProperties(ml);
					
					  
					
					 Color co1 = new Color(Integer.parseInt(getTagValue("color",eElement)));

				l.setColor(co1);
				
			/*	int fr =Integer.parseInt(getTagValue("filledred",eElement));
				
				//System.out.println("r"+fr);
				int b1 =Integer.parseInt(getTagValue("filledblue",eElement));
	
				int g1=Integer.parseInt(getTagValue("filledgreen", eElement));
	
				Color r1=new Color(fr, g1, b1);
		
						r.setFillColor(r1);*/
				
						shapes.add(l);
	}}}
		
		NodeList trList = doc.getElementsByTagName("triangle");
		for (int i = 0; i < trList.getLength(); i++) {

			Node trNode = trList.item(i);
			if (trNode != null) {
				if (trNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) trNode;
					
		
					paint.model.Triangle tr = new paint.model.Triangle();
						
					Map<String, Double> mtr =new HashMap<String,Double>();
					
				
					double x =Double.parseDouble(getTagValue("x",eElement));
					double y =Double.parseDouble(getTagValue("y",eElement));
					
					double x2 =Double.parseDouble(getTagValue("X2",eElement));
					double y2 =Double.parseDouble(getTagValue("Y2",eElement));
					
					double x3 =Double.parseDouble(getTagValue("X3",eElement));
					double y3 =Double.parseDouble(getTagValue("Y3",eElement));
					
					double x4 =Double.parseDouble(getTagValue("X4",eElement));
					double y4 =Double.parseDouble(getTagValue("Y4",eElement));
					
					
					mtr.put("X1", x);
					mtr.put("Y1", y);
					mtr.put("X2",x2);
					mtr.put("Y2", y2);
					mtr.put("X3", x3);
					mtr.put("Y3", y3);
					
					mtr.put("isSelected", 0.0);
					tr.setProperties(mtr);
					 Color co1 = new Color(Integer.parseInt(getTagValue("color",eElement)));tr.setColor(co1);
						
				int r =Integer.parseInt(getTagValue("filledred",eElement));
	
				int b =Integer.parseInt(getTagValue("filledblue",eElement));
				int g=Integer.parseInt(getTagValue("filledgreen", eElement));
				Color c=new Color(r, g, b);
				
				tr.setFillColor(c);
				shapes.add(tr);
		}}}}
	

	private int[] convert(String a) {

		String[] s = a.split(",");
		int[] array = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			array[i] = Integer.parseInt(s[i]);
		}
		return array;
	}

	// method return the value of the taag

	private String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0)
				.getChildNodes();

		Node nValue = (Node) nlList.item(0);

		return nValue.getNodeValue();

	}

}
