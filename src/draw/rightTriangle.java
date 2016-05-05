package draw;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;

import com.sun.javafx.scene.BoundsAccessor;

import javafx.geometry.Point2D;

public class rightTriangle implements shape {

	private Point2D Start;
	private Point2D End;
	private Point2D Point3;
	private Polygon RightTriangle;
	private Paint fill,border;
	private Double angle,width;
	
	
	
	private rightTriangle (){}
	private rightTriangle(shape Shape){
		RightTriangle = new Polygon();
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
			Start= new Point2D(10,130+height);
			End= new Point2D(10+width,130);
		}
		else if((Shape.getStart().getX()>Shape.getEnd().getX())&&(Shape.getStart().getY()>Shape.getEnd().getY()))
		{
			Start =new Point2D(10+width,130+height);
			End =new Point2D(10,130);
		}
		Set(); 
		RightTriangle.setFill(Shape.getShapeFx().getFill());
		RightTriangle.setStroke(Shape.getShapeFx().getStroke());
		RightTriangle.setRotate(Shape.getShapeFx().getRotate());
		RightTriangle.setStrokeWidth(Shape.getShapeFx().getStrokeWidth());
		fill=Shape.getShapeFx().getFill();
		border=Shape.getShapeFx().getStroke();
		angle=Shape.getShapeFx().getRotate();
		width=Shape.getShapeFx().getStrokeWidth();
	}
	private rightTriangle (double x1, double y1, double x2 , double y2){
		
		Start = new Point2D(x1,y1);
		End = new Point2D(x2,y2);
		Set();
		fill=RightTriangle.getFill();
		 border=RightTriangle.getStroke();
		 angle=RightTriangle.getRotate();
		 width=RightTriangle.getStrokeWidth();
	}
	
	private rightTriangle (Point2D Start, Point2D End)
	{
		this.Start=Start;
		this.End=End;
		Set();
	}
	public static final rightTriangle getCopyRightTriangle (shape Shape)
	{
		return new rightTriangle (Shape);
	}
	
	
	public static final rightTriangle getRightTriangle (double x1, double y1, double x2 , double y2)
	{
		return new rightTriangle (x1,y1,x2,y2);
	}
	
	public static final rightTriangle getRightTriangle (Point2D Start , Point2D End)
	{
		return new rightTriangle (Start,End);
	}
	
	public Polygon getShapeFx(){
		return RightTriangle;
	}
	
	
	
	private void Set() {
		Point3= new Point2D(Start.getX(),End.getY());
		RightTriangle=new Polygon(Start.getX(),Start.getY(),End.getX(),End.getY(),Point3.getX(),Point3.getY());
	}

	@Override
	public void Delete() {
		RightTriangle=null;
		
	}

	@Override
	public void Modify(double newx1, double newx2, double newy1, double newy2){
		
		Start = new Point2D(newx1,newy1);
		End = new Point2D(newx2,newy2);
		Set();
	}
	
	@Override
	public void Modify(Point2D newStart, Point2D newEnd) {
		Start= newStart;
		End=newEnd;
		Set();
		
	}
	
	
	public String toString(){
		
		
		return "[(" + "(" + Start.getX() + "," + Start.getY() + ")" + "(" + End.getX() + "," + End.getY() + ")" + "(" + Point3.getX() + "," + Point3.getY() + ")" + "]";
	}
	@Override
	public Point2D getStart() {
        return Start;
    }

    public Point2D getEnd() {
        return End;
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
		RightTriangle.setFill(Color.WHITE);
		RightTriangle.setStroke(Color.BLACK);
		RightTriangle.setStrokeWidth(2);
		RightTriangle.setRotate(angle);
		
	}
	@Override
	public void Rotate(double angle) {
		RightTriangle.setRotate(angle);
		
	}

}
