package draw;

import javafx.scene.shape.*;
import javafx.geometry.Point2D;

public class ellipse implements shape {
	
	private Point2D Center;
	private Point2D End;
	private Ellipse Ellipse;
	
	
	private ellipse (){}
	private ellipse (double x1, double y1, double x2 , double y2){
		Ellipse = new Ellipse();
		Center = new Point2D(x1,y1);
		End = new Point2D(x2,y2);
		Set();
	}
	private ellipse (Point2D Center, Point2D End)
	{
		Ellipse = new Ellipse();
		this.Center=Center;
		this.End=End;
		Set();
	}
	private ellipse(shape Shape){
		Ellipse = new Ellipse();
		 Ellipse.setFill(Shape.getShapeFx().getFill());
		 Ellipse.setStroke(Shape.getShapeFx().getStroke());
		 Ellipse.setRotate(Shape.getShapeFx().getRotate());
	      Ellipse.setStrokeWidth(Shape.getShapeFx().getStrokeWidth());
		double RadiusX=Math.abs(Shape.getEnd().getX()-Shape.getCenter().getX());
		double RadiusY=Math.abs(Shape.getEnd().getY()-Shape.getCenter().getY());
        Center=new Point2D(10+RadiusX,130+RadiusY);
        End= new Point2D(10+2*RadiusX,130+2*RadiusY);
		Set();
	}
	
	public static final shape getCopyEllipse(shape Shape){
		
		return new ellipse(Shape);
	}
	public static final ellipse getEllipse (double x1 , double y1 , double x2 , double y2)
	{
		return new ellipse (x1,y1,x2,y2);
	}
	
	public static final ellipse getEllipse (Point2D Start , Point2D End)
	{
		return new ellipse (Start,End);
	}
	
	
	public Point2D getCenter() {
        return Center;
       
    }

    public Point2D getEnd() {
        return End;
    }

    public Ellipse getShapeFx() {
        return Ellipse;
    }
	
	private void Set() {
		Ellipse.setCenterX(Center.getX());
		Ellipse.setCenterY(Center.getY());
		Ellipse.setRadiusX(Math.abs(End.getX()-Center.getX()));
		Ellipse.setRadiusY(Math.abs(End.getY()-Center.getY()));
	}
	@Override
	public void Delete() {
		Ellipse =null;
		
	}
	@Override
	public void Modify(double newx1, double newx2, double newy1, double newy2) {
		
		Center= new Point2D(newx1,newy1);
		End = new Point2D(newx2,newy2);
		Set();
	}
	@Override
	public void Modify(Point2D newCenter, Point2D newEnd) {
		Center=newCenter;
		End = newEnd;
		Set();
	}
	public String toString()
	{
		
		return "Center:"+"(" + Center.getX() +","+ Center.getY() +"),  Radius:"+ Math.abs(End.getX()-Center.getX()) + "," + Math.abs(End.getY()-Center.getY());
	}
	@Override
	public Point2D getStart() {
		return null;
	}
	@Override
	public void Move(double x, double y) {
		
		double RadiusX=Math.abs(End.getX()-Center.getX());
		double RadiusY=Math.abs(End.getY()-Center.getY());
        Center=new Point2D(x+RadiusX,y+RadiusY);
        End= new Point2D(x+2*RadiusX,y+2*RadiusY);
		Set();
	}
	@Override
	public void Rotate(double angle) {
		Ellipse.setRotate(angle);
		
	}
	

}

