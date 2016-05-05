package draw;

import javafx.scene.shape.*;
import javafx.geometry.Point2D;

public class rectangle implements shape{
	
	private Point2D Start;
	private Point2D End;
	private Rectangle Rectangle;
	private Rectangle tempRectangle;
	
	private rectangle(shape Shape){
		Rectangle = new Rectangle();
		 Rectangle.setFill(Shape.getShapeFx().getFill());
		 Rectangle.setStroke(Shape.getShapeFx().getStroke());
		 Rectangle.setRotate(Shape.getShapeFx().getRotate());
		 Rectangle.setStrokeWidth(Shape.getShapeFx().getStrokeWidth());
		double width=Math.abs(Shape.getEnd().getX()-Shape.getStart().getX());
		double height=Math.abs(Shape.getEnd().getY()-Shape.getStart().getY());
		if((Shape.getStart().getX()<Shape.getEnd().getX())&&(Shape.getStart().getY()<Shape.getEnd().getY()))
		{
		Start=new Point2D(10,130);
		End=new Point2D(10+width,130+height);
		}
		else if((Shape.getStart().getX()>Shape.getEnd().getX())&&(Shape.getStart().getY()<Shape.getEnd().getY()))
		{
		Start = new Point2D(10+width,130);
		End= new Point2D(10,130+height);
		}
		else if ((Shape.getStart().getX()<Shape.getEnd().getX())&&(Shape.getStart().getY()>Shape.getEnd().getY()))
		{
			Start= new Point2D(10,100+height);
			End= new Point2D(10+width,130);
		}
		else if((Shape.getStart().getX()>Shape.getEnd().getX())&&(Shape.getStart().getY()>Shape.getEnd().getY()))
		{
			Start =new Point2D(10+width,100+height);
			End =new Point2D(10,130);
		}
		Set(); 
	}
	
	private rectangle (){}
	private rectangle (double x1, double y1, double x2 , double y2){
		Rectangle = new Rectangle();
		Start = new Point2D(x1,y1);
		End = new Point2D(x2,y2);
		Set();
	}
	private rectangle (Point2D Start, Point2D End)
	{
		Rectangle = new Rectangle();
		this.Start=Start;
		this.End=End;
		Set();
	}
	
	public static final rectangle  getCopyRectangle(shape Shape){
		return new rectangle (Shape);

	}
	
	public static final rectangle getRectangle (double x1 , double y1 , double x2 , double y2)
	{
		return new rectangle(x1,y1,x2,y2);
	}
	
	public static final rectangle getRectangle (Point2D Start , Point2D End)
	{
		return new rectangle (Start,End);
	}
	
	public Point2D getStart() {
        return Start;
    }

    public Point2D getEnd() {
        return End;
    }

    public Rectangle getShapeFx() {
        return Rectangle;
    }
	
	private void Set() {
		if((Start.getX()<End.getX())&&(Start.getY()<End.getY()))
		{	
			Rectangle.setX(Start.getX());
			Rectangle.setY(Start.getY());
			Rectangle.setWidth(End.getX()-Start.getX());
			Rectangle.setHeight(End.getY()-Start.getY());
			
		}
		
		else if ((Start.getX()>End.getX())&&(Start.getY()<End.getY()))
		{
			Rectangle.setX(End.getX());
			Rectangle.setY(Start.getY());
			Rectangle.setWidth(Start.getX()-End.getX());
			Rectangle.setHeight(End.getY()-Start.getY());
		}
		
		else if ((Start.getX()<End.getX())&&(Start.getY()>End.getY()))
		{
			Rectangle.setX(Start.getX());
			Rectangle.setY(End.getY());
			Rectangle.setWidth(End.getX()-Start.getX());
			Rectangle.setHeight(Start.getY()-End.getY());
		}
		
		else if ((Start.getX()>End.getX())&&(Start.getY()>End.getY()))
		{
			Rectangle.setX(End.getX());
			Rectangle.setY(End.getY());
			Rectangle.setWidth(Start.getX()-End.getX());
			Rectangle.setHeight(Start.getY()-End.getY());
		}
			
	}
	@Override
	public void Delete() {
		tempRectangle = Rectangle;
		Rectangle =null;
		
	}
	@Override
	public void Modify(double newx1, double newx2, double newy1, double newy2) {
		Start= new Point2D(newx1,newy1);
		End = new Point2D(newx2,newy2);
		Set();
	}
	public void Modify (Point2D newStart, Point2D newEnd)
	{
		Start = newStart;
		End = newEnd;
		Set();
	}
	
	public String toString()
	{
		
		return "Start point"+"(" + Start.getX() +","+ Start.getY() +"), End point: ("+ Math.abs(End.getX()-Start.getX()) + "," + Math.abs(End.getY()-Start.getY())+")";
	}

	@Override
	public Point2D getCenter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Move(double x, double y) {
		double width=Math.abs(End.getX()-Start.getX());
		double height=Math.abs(End.getY()-Start.getY());
		if((Start.getX()<End.getX())&&(Start.getY()<End.getY()))
		{
		Start=new Point2D(x,y);
		End=new Point2D(x+width,y+height);
		}
		else if((Start.getX()>End.getX())&&(Start.getY()<End.getY()))
		{
		Start = new Point2D(x+width,y);
		End= new Point2D(x,y+height);
		}
		else if ((Start.getX()<End.getX())&&(Start.getY()>End.getY()))
		{
			Start= new Point2D(x,y+height);
			End= new Point2D(x+width,y);
		}
		else if((Start.getX()>End.getX())&&(Start.getY()>End.getY()))
		{
			Start =new Point2D(x+width,y+height);
			End =new Point2D(x,y);
		}
		Set();
		
	}

	@Override
	public void Rotate(double angle) {
		Rectangle.setRotate(angle);
		
	}
	
}

