package draw;

import javafx.scene.shape.*;
import javafx.geometry.Point2D;

public class square implements shape{
	
	private Point2D Start;
	private Point2D End;
	private Rectangle Square;
	
	private square (){}
	
	private square(shape Shape){
		double side=Double.min(Math.abs(Shape.getEnd().getX()-Shape.getStart().getX()), Math.abs(Shape.getEnd().getY()-Shape.getStart().getY()));
		Square = new Rectangle();
		Square.setFill(Shape.getShapeFx().getFill());
		Square.setStroke(Shape.getShapeFx().getStroke());
		Square.setRotate(Shape.getShapeFx().getRotate());
		Square.setStrokeWidth(Shape.getShapeFx().getStrokeWidth());
		if((Shape.getStart().getX()<Shape.getEnd().getX())&&(Shape.getStart().getY()<Shape.getEnd().getY()))
		{
		Start=new Point2D(10,130);
		End=new Point2D(10+side,130+side);
		}
		else if ((Shape.getStart().getX()<Shape.getEnd().getX())&&(Shape.getStart().getY()>Shape.getEnd().getY()))
		{
			Start= new Point2D(10,130+side);
			End= new Point2D(10+side,130);
		}
		Set(); 
	}
	private square (double x1, double y1, double x2 , double y2){
		Square = new Rectangle();
		Start = new Point2D(x1,y1);
		End = new Point2D(x2,y2);
		Set();
	}
	private square (Point2D Start, Point2D End)
	{
		Square = new Rectangle();
		this.Start=Start;
		this.End=End;
		Set();
	}
	public static final square  getCopySquare(shape Shape){
		return new square (Shape);

	}
	public static final square getSquare (double x1 , double y1 , double x2 , double y2)
	{
		return new square (x1,y1,x2,y2);
	}
	
	public static final square getsquare (Point2D Start , Point2D End)
	{
		return new square (Start,End);
	}
	
	public Point2D getStart() {
        return Start;
    }

    public Point2D getEnd() {
        return End;
    }

    public Rectangle getShapeFx() {
        return Square;
    }
	
	private void Set() {
		double min=Double.min(Math.abs(End.getX()-Start.getX()), Math.abs(End.getY()-Start.getY()));
		
		if((Start.getX()<End.getX())&&(Start.getY()<End.getY()))
		{
			Square.setX(Start.getX());
			Square.setY(Start.getY());
			Square.setWidth(min);
			Square.setHeight(min);
		}
		
		
		else if ((Start.getX()<End.getX())&&(Start.getY()>End.getY()))
		{
			Square.setX(Start.getX());
			Square.setY(End.getY());
			Square.setWidth(min);
			Square.setHeight(min);
		}
		
		
			
	}
	@Override
	public void Delete() {
		Square =null;
		
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
		double min=Double.min(Math.abs(End.getX()-Start.getX()), Math.abs(End.getY()-Start.getY()));
		
		return "Start:(" + Start.getX() +","+ Start.getY() +"), Width: "+ min +"]";
	}
	@Override
	public Point2D getCenter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Move(double x, double y) {
		
		double side=Double.min(Math.abs(End.getX()-Start.getX()), Math.abs(End.getY()-Start.getY()));
		Square = new Rectangle();
		if((Start.getX()<End.getX())&&(Start.getY()<End.getY()))
		{
		Start=new Point2D(x,y);
		End=new Point2D(x+side,y+side);
		}
		else if ((Start.getX()<End.getX())&&(Start.getY()>End.getY()))
		{
			Start= new Point2D(x,y+side);
			End= new Point2D(x+side,y);
		}
		Set();
	}

	@Override
	public void Rotate(double angle) {
		Square.setRotate(angle);
		
	}
	
}


