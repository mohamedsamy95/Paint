package draw;

import javafx.geometry.Point2D;

public class ShapeFactory {
	private ShapeFactory(){}
	
	public static shape copyShaped(shape Shape) //Shape to copy
	{ 

		if(Shape instanceof rectangle)
			return rectangle.getCopyRectangle(Shape);
		else if(Shape instanceof circle)
			return circle.getCopyCircle(Shape);
		else if(Shape instanceof ellipse)
			return ellipse.getCopyEllipse(Shape); 
		else if(Shape instanceof square)
			return square.getCopySquare(Shape);
		else if(Shape instanceof triangle)
			return triangle.getCopyTriangle(Shape);
		else if(Shape instanceof rightTriangle )
			return rightTriangle.getCopyRightTriangle(Shape);
		else if(Shape instanceof line)
			return line.getCopyLine(Shape);
		else
			return null;

			}
	
	
	public final static shape getShape (String shapeName,double x1 , double y1 , double x2 , double y2)
	{
		if(shapeName.equalsIgnoreCase("rectangle"))
			return rectangle.getRectangle(x1,y1,x2,y2); //Coordinates of start and end point
		else if(shapeName.equalsIgnoreCase("ellipse"))
			return ellipse.getEllipse(x1,y1,x2,y2);    //Coordinates of center and end point
		else if(shapeName.equalsIgnoreCase("line"))
			return line.getLine(x1,y1,x2,y2);         //Coordinates of start and end point
		else if(shapeName.equalsIgnoreCase("triangle"))
			return triangle.getTriangle(x1,y1,x2,y2); //Coordinates of start and end point
		else if(shapeName.equalsIgnoreCase("circle"))
			return circle.getCircle(x1,y1,x2,y2);    //Coordinates of center and end point
		else if(shapeName.equalsIgnoreCase("square"))
			return square.getSquare(x1,y1,x2,y2);   //Coordinates of start and end point
		else if(shapeName.equalsIgnoreCase("rightTriangle"))
			return rightTriangle.getRightTriangle(x1, y1, x2, y2);  //Coordinates of start and end point
		else
			return null;
	}
	
	public static shape getShape (String shapeName,Point2D Start , Point2D End)
	{
		if(shapeName.equalsIgnoreCase("rectangle"))
			return rectangle.getRectangle(Start,End);  //Point objects of start and end point
		else if(shapeName.equalsIgnoreCase("Ellipse"))
			return ellipse.getEllipse(Start,End);      //Point objects of center and end point
		else if(shapeName.equalsIgnoreCase("line"))
			return line.getLine(Start,End);           //Point objects of start and end point
		else if(shapeName.equals("Triangle"))
			return triangle.getTriangle(Start,End);   //Point objects of start and end point
		else if(shapeName.equalsIgnoreCase("circle"))
			return circle.getCircle(Start,End);    //Point objects of center and end point
		else if(shapeName.equalsIgnoreCase("square"))
			return square.getsquare(Start,End);   //Point objects of start and end point
		else if(shapeName.equalsIgnoreCase("rightTriangle"))
			return rightTriangle.getRightTriangle(Start, End); //Point objects of start and end point
		else
			return null;
	}

}