package paint.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import paint.controller.CommandInterface;
import paint.controller.DrawingEngine;
import paint.controller.FactoryClass;
import paint.controller.Moving;
import paint.controller.RedoClass;
import paint.controller.Strategy;
import paint.controller.undoClass;
import paint.controller.xmlFile;
import paint.controller.JsonFile;
import paint.model.Circle;
import paint.model.LineSegment;
import paint.model.Memento;
import paint.model.Shape;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;

public class MyPaintWindow extends JFrame {
private int action;
private String ShapeType;
private Point drawStart;
private Point drawEnd;
private JPanel contentPane;
private JPanel panel;
private JButton btnRedo;
private JButton btnCircle;
private JButton btnEllipse;
private JButton btnTriangle;
private JButton btnNewButton_1;
private JButton btnNewButton_2;
private JButton btnNewButton_3;
private JButton btnFillcolor;
private String Selectedbtn=null;
private JButton btnUndooooo;
private CommandInterface command;
private JButton btnNewButton_4;
private JButton btnSquare;
private Color prevColor ;
private JButton btnNewButton_5;
private JButton btnNewButton_6;
public static String url;
private Shape copy;
Strategy file ;
private JFileChooser SLfile;
public static boolean whiteBG=false;
private JButton btnWhiteBackground;
public Memento memento = new Memento();
ArrayList<Shape> selectedshapes = new ArrayList<Shape>(); 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPaintWindow frame = new MyPaintWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MyPaintWindow() {
		setTitle("Paint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 499);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setBounds(28, 65, 675, 286);
		contentPane.add(panel);
		handler handler=new handler();
		panel.addMouseListener(handler);
		panel.addMouseMotionListener(handler);
		contentPane.add(panel);
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setIcon(new ImageIcon(MyPaintWindow.class.getResource("/images/rect.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Selectedbtn="rectangle";
				System.out.println("rectangle selected"+Selectedbtn);
				ShapeType="rectangle";
				action=1;
			}
		});
		btnNewButton.setBounds(38, 362, 51, 25);
		contentPane.add(btnNewButton);	
		btnCircle = new JButton("");
		btnCircle.setIcon(new ImageIcon(MyPaintWindow.class.getResource("/images/circle.png")));
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Selectedbtn="circle";
				ShapeType="circle";
				action=3;
			}
		});
		btnCircle.setBounds(122, 362, 43, 25);
		contentPane.add(btnCircle);
		
		btnEllipse = new JButton("");
		btnEllipse.setIcon(new ImageIcon(MyPaintWindow.class.getResource("/images/ellipse.png")));
		btnEllipse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShapeType="ellipse";
				Selectedbtn="ellipse";
				action=2;
			}
		});
		btnEllipse.setBounds(193, 362, 51, 23);
		contentPane.add(btnEllipse);
		
		btnTriangle = new JButton("");
		btnTriangle.setIcon(new ImageIcon(MyPaintWindow.class.getResource("/images/tri.png")));
		btnTriangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Selectedbtn="triangle";
				action=4;
				ShapeType="triangle";
			}
		});
		btnTriangle.setBounds(271, 364, 51, 23);
		contentPane.add(btnTriangle);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(MyPaintWindow.class.getResource("/images/line.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Selectedbtn="line";
				action=5;
				ShapeType="line";
			}
		});
		btnNewButton_1.setBounds(351, 364, 51, 23);
		contentPane.add(btnNewButton_1);
		
		 btnNewButton_3 = new JButton("");
		 btnNewButton_3.setBackground(Color.WHITE);
		 btnNewButton_3.setIcon(new ImageIcon(MyPaintWindow.class.getResource("/images/move.png")));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Selectedbtn="move";
				System.out.println("selected btn is "+Selectedbtn);
			}
		});
		btnNewButton_3.setBounds(726, 92, 89, 36);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_2 = new JButton("Color");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBackground(new Color(0, 153, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Selectedbtn="color";
				Color color=JColorChooser.showDialog(null,"Select a color", Color.RED); 
				for(Shape selectedShape :selectedshapes) {
					if(selectedShape!=null)
					{
						selectedShape.setColor(color);
					}
				}
			memento.StackOfShapes();
			}
		});
		btnNewButton_2.setBounds(488, 362, 89, 23);
		contentPane.add(btnNewButton_2);
		
		btnFillcolor = new JButton("Fill Color");
		btnFillcolor.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFillcolor.setBackground(new Color(0, 153, 255));
		btnFillcolor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Selectedbtn="fillcolor";
				Color color=JColorChooser.showDialog(null,"Select a color", Color.RED); 
				for(Shape selectedShape :selectedshapes) {
					if(selectedShape!=null)
					{
						selectedShape.setFillColor(color);
					}
					else
						JOptionPane.showMessageDialog(null, "Select a shape to edit");
					if(selectedShape instanceof paint.model.LineSegment)
					{
						JOptionPane.showMessageDialog(null, "Line color is changed using color not fillcolor");
					}
				}
					DrawingEngine.getDrawingEngine().refresh(panel.getGraphics());
				memento.StackOfShapes();
			}
		});
		btnFillcolor.setBounds(601, 362, 89, 23);
		contentPane.add(btnFillcolor);
		
		btnNewButton_4 = new JButton("");
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setIcon(new ImageIcon(MyPaintWindow.class.getResource("/images/resize.jpg")));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Selectedbtn="resize";
			}
		});
		btnNewButton_4.setBounds(726, 139, 89, 37);
		contentPane.add(btnNewButton_4);
		JButton btnBlackBackground = new JButton("Black Mode");
		btnBlackBackground.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBlackBackground.setForeground(Color.WHITE);
		btnBlackBackground.setBackground(new Color(0, 0, 0));
		btnBlackBackground.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			panel.setBackground(Color.black);//***********************************************************************************************
			whiteBG=true;
			for (Shape shape : DrawingEngine.getDrawingEngine().getShapes()) {
	          if (shape.getColor()==Color.black) {
				try {
					shape.setColor(Color.white);
				} catch (Exception e) {
					e.printStackTrace();
				}   
			} }
		//	DrawingEngine.getDrawingEngine().refresh(getGraphics());

			}
		});
		btnBlackBackground.setBounds(438, 28, 109, 25);
		contentPane.add(btnBlackBackground);
		
		btnWhiteBackground = new JButton("White Mode");
		btnWhiteBackground.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnWhiteBackground.setBackground(Color.WHITE);
		btnWhiteBackground.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(Color.WHITE);
				// take care changes in redo and undo classes
				
			whiteBG=false;//***********************************************************************************************************
			for (Shape shape : DrawingEngine.getDrawingEngine().getShapes()) {//
	           if (shape.getColor()== Color.WHITE ) {
				try {
					shape.setColor(Color.black);
				} catch (Exception ee) {
					ee.printStackTrace();
				}   
			}}
		//	DrawingEngine.getDrawingEngine().refresh(getGraphics());

			}
		});
		btnWhiteBackground.setBounds(577, 29, 109, 25);
		contentPane.add(btnWhiteBackground);
			JButton btnSave = new JButton("Save XML");
			btnSave.setBackground(new Color(102, 255, 102));
			btnSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int retval = 0;
				FileChooserSave(retval);

file=new xmlFile();
				if (retval == JFileChooser.APPROVE_OPTION) {
					
					url = "" + SLfile.getSelectedFile();
				
					try {
						
						file.save(DrawingEngine.getDrawingEngine().getShapes(),url);
System.out.println("File Saved !");
					} catch (Exception e1) {
System.out.println("File Not Saved !");
					}
				}
			}
		});
		btnSave.setBounds(42, 417, 97, 25);
		contentPane.add(btnSave);
		
		btnSquare = new JButton("");
		btnSquare.setIcon(new ImageIcon(MyPaintWindow.class.getResource("/images/square.png")));
		btnSquare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Selectedbtn="square";
				System.out.println("square selected"+Selectedbtn);
				ShapeType="square";
				action=6;
			}
		});
		btnSquare.setBounds(422, 362, 35, 25);
		contentPane.add(btnSquare);
		 btnUndooooo = new JButton("Undo");
			
			btnUndooooo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnRedo.setEnabled(true);
				 command = new undoClass();
					command.execute(memento);
					try {
						DrawingEngine.getDrawingEngine().refresh(panel.getGraphics());
					} catch (Exception e) {
						System.out.println("stack is empty");
						// TODO: handle exception
					}
					    System.out.println("---->>>>"+DrawingEngine.getDrawingEngine().getArraylist());     
					    						DrawingEngine.getDrawingEngine().refresh(panel.getGraphics());
						 
				}
			});
			btnUndooooo.setBounds(155, 29, 89, 23);
			contentPane.add(btnUndooooo);
		btnNewButton_5 = new JButton("");
		btnNewButton_5.setIcon(new ImageIcon(MyPaintWindow.class.getResource("/images/delete.png")));
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				for(Shape selectedShape : selectedshapes) {
			if(selectedShape!=null) {
				try {	memento.undoStack();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			
				DrawingEngine.getDrawingEngine().removeShape(selectedShape);
			}	
				}
				DrawingEngine.getDrawingEngine().refresh(panel.getGraphics());
			}
		});
		btnNewButton_5.setBounds(726, 187, 89, 36);
		contentPane.add(btnNewButton_5);
		btnNewButton_6 = new JButton("");
		btnNewButton_6.setIcon(new ImageIcon(MyPaintWindow.class.getResource("/images/copy.png")));
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				Selectedbtn="Copy";
				try {
					for(Shape selectedShape : selectedshapes) {
						if(selectedShape!=null) 
						{ selectedShape.getProperties().put("isSelected", 0.0);
					try {
						 copy=(Shape) selectedShape.clone();
					} catch (CloneNotSupportedException e1) {
						e1.printStackTrace();
					}
					copy.setPosition(new Point(15,15));
					DrawingEngine.getDrawingEngine().addShape(copy);
					}}
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			selectedshapes.clear();
			memento.StackOfShapes();
			DrawingEngine.getDrawingEngine().refresh(panel.getGraphics());
				}
		});
		btnNewButton_6.setBounds(726, 240, 89, 35);
		contentPane.add(btnNewButton_6);
		btnRedo = new JButton("Redo");
		btnRedo.setEnabled(false);
		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(memento.redo.isEmpty())
				{
					btnRedo.setEnabled(false);
				}
				else {
					btnRedo.setEnabled(true);

			}	
			
			command=new RedoClass();
				command.execute(memento);
				try {
					DrawingEngine.getDrawingEngine().refresh(panel.getGraphics());
				} catch (Exception e) {
					System.out.println("stack is empty ");
					// TODO: handle exception
				}
            memento.StackOfShapes();
				
				}
			
		});
		btnRedo.setBounds(37, 27, 89, 23);
		contentPane.add(btnRedo);
		
		JButton btnDeselect = new JButton("Deselect");
		btnDeselect.setBackground(new Color(255, 102, 0));
		btnDeselect.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeselect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent Deselect) {
				Selectedbtn="Deselect";
				for (Shape s : selectedshapes) {
					s.getProperties().put("isSelected", 0.0);
				}
				selectedshapes.clear();
				DrawingEngine.getDrawingEngine().refresh(panel.getGraphics());
			}
		});
		btnDeselect.setBounds(726, 286, 89, 36);
		contentPane.add(btnDeselect);
		
		JButton btnSaveJson = new JButton("Load XML");
		btnSaveJson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int retval = 0;
				OpenFile(retval);
				file=new xmlFile();
				if (retval == JFileChooser.APPROVE_OPTION) {
					url = "" + SLfile.getSelectedFile();
					try {
						
						file.load(DrawingEngine.getDrawingEngine().getShapes(),"");
					
					} catch (Exception e1) {
					}
				}
				DrawingEngine.getDrawingEngine().refresh(panel.getGraphics());
			}
		});
		btnSaveJson.setBackground(new Color(102, 255, 102));
		btnSaveJson.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSaveJson.setBounds(168, 417, 97, 25);
		contentPane.add(btnSaveJson);
		
		JButton btnLoadJson = new JButton("Load JSON");
		btnLoadJson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int retval = 0;
				OpenFile(retval);
				file=new JsonFile();
				if (retval == JFileChooser.APPROVE_OPTION) {
					url = "" + SLfile.getSelectedFile();
					try {
						
						file.load(DrawingEngine.getDrawingEngine().getShapes(),url);
					
					} catch (Exception e1) {
					}
				}
				DrawingEngine.getDrawingEngine().refresh(panel.getGraphics());
			}
		});
		btnLoadJson.setBackground(new Color(255, 204, 153));
		btnLoadJson.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLoadJson.setBounds(601, 417, 102, 25);
		contentPane.add(btnLoadJson);
		
		JButton btnLoadXml = new JButton("Save JSON");
		btnLoadXml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int retval = 0;
				FileChooserSave(retval);
				
                file=new JsonFile();
				if (retval == JFileChooser.APPROVE_OPTION) {
					url = "" + SLfile.getSelectedFile();
					try {
						file.save(DrawingEngine.getDrawingEngine().getShapes(),url);
						 System.out.println("File   saved!");
					} catch (Exception e1) {
       System.out.println("File Not  saved!");
					}
				}
			}
		});

		btnLoadXml.setBackground(new Color(255, 204, 153));
		btnLoadXml.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLoadXml.setBounds(488, 417, 97, 25);
		contentPane.add(btnLoadXml);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DrawingEngine.getDrawingEngine().getShapes().clear();
				memento.StackOfShapes();
				DrawingEngine.getDrawingEngine().refresh(panel.getGraphics());
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClear.setBackground(Color.CYAN);
		btnClear.setBounds(726, 28, 89, 25);
		contentPane.add(btnClear);
	}
	
	private class handler implements MouseListener,MouseMotionListener{
		public void mouseDragged(MouseEvent e) {
			drawEnd=e.getPoint();
			repaint();
		}

		public void mouseMoved(MouseEvent e) {
		}
		public void mouseClicked(MouseEvent e) {
			
		
			
		}
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
			System.out.println("MOUSE");
			drawStart=new Point(e.getX(),e.getY());
			for(Shape s :DrawingEngine.getDrawingEngine().getShapes())
			{	  		if (s.getProperties().get("isSelected") == 1.0	)	{
				System.out.println("<-----"+s);
			}

				if(s.contains(e.getPoint())) {
					System.out.println("mouse contains"+s);
					s.getProperties().put("isSelected",  1.0);
					selectedshapes.add(s);
					System.out.println("---->"+s);

					//selectedShape.setColor(Color.RED);
				}
				else
				{  if(Selectedbtn!="resize") {
					//s.getProperties().put("isSelected", 0.0);
					System.out.println(s.contains(e.getPoint()));}
				}
				//DrawingEngine.getDrawingEngine().refresh(panel.getGraphics());
			}
		//	DrawingEngine.getDrawingEngine().refresh(panel.getGraphics());
			repaint();
		}

		public void mouseReleased(MouseEvent e) {
			if(ShapeType!=null)	{
			FactoryClass factory=new FactoryClass();
			Shape a = factory.getShape(ShapeType);
			double x=Math.min(drawStart.getX(), e.getX());
			double y=Math.min(drawStart.getY(), e.getY());
			Map<String, Double> m =new HashMap<String,Double>();
			if (whiteBG==true) {//***************************************************************************************************
				a.setColor(Color.white );
				
			}
			else {//*************************************************************************************************************************
				a.setColor(Color.BLACK);
			}
				if(action==1)
				{	
				double width=Math.abs(drawStart.getX()-e.getX());
				double length=Math.abs(drawStart.getY()-e.getY());
				m.put("X-axis", x);
				m.put("Y-axis", y);
				m.put("length", length);
				m.put("width", width);
				m.put("isSelected", 0.0);
				a.setProperties(m);
				}
				else if(action==2)
				{
					double width=Math.abs(drawStart.getX()-e.getX());
					double length=Math.abs(drawStart.getY()-e.getY());
					m.put("X-axis", x);
					m.put("Y-axis", y);
					m.put("Radius2", length);
					m.put("Radius1", width);
					m.put("isSelected", 0.0);
					a.setProperties(m);
				}
				else if (action==3) {
					double width=Math.abs(drawStart.getX()-e.getX());
					m.put("X-axis", x);
					m.put("Y-axis", y);
					m.put("Radius", width);
					m.put("isSelected", 0.0);
					a.setProperties(m);
				}
				else if (action==4) {
					m.put("X1", drawStart.getX());
					m.put("Y1", drawStart.getY());
					m.put("X2",drawStart.getX()*2-e.getX());
					System.out.println("start point is"+drawStart);
					System.out.println("endpoint is"+(e.getX()-drawStart.getX()));
					m.put("Y2", (double)e.getY());
					m.put("X3", (double) e.getX());
					m.put("Y3", (double) e.getY());
					m.put("isSelected", 0.0);
					a.setProperties(m);
				}
				else if (action==5){
					m.put("X1", drawStart.getX());
					m.put("Y1", drawStart.getY());
					m.put("X2", (double) e.getX());
					m.put("Y2", (double) e.getY());
					m.put("isSelected", 0.0);
					a.setProperties(m);
				}
				else if(action==6)
				{
				//double width=Math.abs(drawStart.getX()-e.getX());
				double length=Math.abs(drawStart.getY()-e.getY());
				m.put("X-axis", x);
				m.put("Y-axis", y);
				m.put("length", length);
				m.put("isSelected", 0.0);
				a.setProperties(m);
				}
				DrawingEngine.getDrawingEngine().addShape(a);
				memento.StackOfShapes();
				//engine.refresh(panel.getGraphics());
				action=0;
				ShapeType=null;
			}
			
		try { 
			if(Selectedbtn.equals("move")) {
				for(Shape selectedShape : selectedshapes) {
				if(selectedShape!=null)
			{   System.out.println("move is selected");
			Moving command =new Moving();
				int x=(int) Math.min(drawStart.getX(), e.getX());
				int y=(int) Math.min(drawStart.getY(), e.getY());
				double xDiff= (drawEnd.getX()-drawStart.getX());
				double yDiff= (drawEnd.getY()-drawStart.getY());
				Point p =command.Move(x, y, xDiff, yDiff);
			
				selectedShape.setPosition(p);
			}
				}
			}
			if(Selectedbtn.equals("resize"))
			{  Map<String, Double> mp =new HashMap<String,Double>();
				mp.put("isSelected", 1.0);
				
				int x=(int) Math.min(drawStart.getX(), e.getX());
				int y=(int) Math.min(drawStart.getY(), e.getY());
				double xDiff= (drawEnd.getX()-drawStart.getX());
				double yDiff= (drawEnd.getY()-drawStart.getY());
				x += xDiff;
		        y += yDiff;
		        for(Shape selectedShape : selectedshapes) {
		        	if(selectedShape!=null) {
				if(selectedShape instanceof paint.model.LineSegment)
				{     mp.put("X1", selectedShape.getProperties().get("X1"));
				mp.put("Y1", selectedShape.getProperties().get("Y1"));
				mp.put("X2", (double) x);
				mp.put("Y2", (double) y);
				selectedShape.setProperties(mp);
				}
				else if (selectedShape instanceof paint.model.Circle)
				{ 
					double NewRadius=drawStart.distance(e.getPoint());
					if(selectedShape.contains(e.getPoint()))
					{
						NewRadius=NewRadius*-1;
					}
					mp.put("X-axis",selectedShape.getProperties().get("X-axis"));
					mp.put("Y-axis", selectedShape.getProperties().get("Y-axis"));
					mp.put("Radius",selectedShape.getProperties().get("Radius")+NewRadius);
					selectedShape.setProperties(mp);
				}
				else if (selectedShape instanceof paint.model.Ellipse)
				{
					double NewRadius=drawStart.distance(e.getPoint());
					if(selectedShape.contains(e.getPoint()))
					{
						NewRadius=NewRadius*-1;
					}			
					mp.put("X-axis",selectedShape.getProperties().get("X-axis"));
					mp.put("Y-axis", selectedShape.getProperties().get("Y-axis"));
					mp.put("Radius1",selectedShape.getProperties().get("Radius1")+NewRadius);
					mp.put("Radius2",selectedShape.getProperties().get("Radius2")+NewRadius);
					selectedShape.setProperties(mp);
				//	command.ResizeEllipse(selectedShape,mp,NewRadius);
				}
				else if (selectedShape instanceof paint.model.Triangle)
				{System.out.println("X1"+selectedShape.getProperties().get("X2"));
					mp.put("X1", selectedShape.getProperties().get("X1"));
					mp.put("Y1", selectedShape.getProperties().get("Y1"));
					mp.put("X2",selectedShape.getProperties().get("X1")*2-e.getX());
					System.out.println("start point is"+drawStart);
					System.out.println("endpoint is"+(e.getX()-drawStart.getX()));
					mp.put("Y2", (double)e.getY());
					mp.put("X3", (double) e.getX());
					mp.put("Y3", (double) e.getY());
					selectedShape.setProperties(mp);
				}
				else if (selectedShape instanceof paint.model.Rectangle)
					
				{	double Newlength=drawStart.distance(e.getPoint());
					if(selectedShape.contains(e.getPoint()))
				{
					Newlength=Newlength*-1;
				}
					mp.put("X-axis", selectedShape.getProperties().get("X-axis"));
					mp.put("Y-axis", selectedShape.getProperties().get("Y-axis"));
					mp.put("length", selectedShape.getProperties().get("length")+Newlength);
					mp.put("width", selectedShape.getProperties().get("width")+Newlength);
					selectedShape.setProperties(mp);
				}
				else if (selectedShape instanceof paint.model.Square)
					
				{	double Newlength=drawStart.distance(e.getPoint());
					if(selectedShape.contains(e.getPoint()))
				{
					Newlength=Newlength*-1;
				}
					mp.put("X-axis", selectedShape.getProperties().get("X-axis"));
					mp.put("Y-axis", selectedShape.getProperties().get("Y-axis"));
					mp.put("length", selectedShape.getProperties().get("length")+Newlength);
					selectedShape.setProperties(mp);
				}
		        }
		        }
			}
			DrawingEngine.getDrawingEngine().refresh(panel.getGraphics());
		} catch (Exception e2) {
			// TODO: handle exception
		}	
		//	repaint();	
		}
	}
	private void OpenFile(int retval) {
		SLfile = new JFileChooser();
		retval = SLfile.showOpenDialog(null);
		SLfile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		SLfile.setBackground(Color.white);
	}
	private void FileChooserSave(int retval) {
	SLfile = new JFileChooser();
	retval = SLfile.showSaveDialog(null);
	SLfile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
	SLfile.setBackground(Color.white);
}
}
