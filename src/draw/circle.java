package draw;

import javafx.scene.shape.*;

import java.awt.Paint;

import javafx.geometry.Point2D;

public class circle implements shape {
	
	private Point2D Center;
	private Point2D End;
	private Circle Circle;
	
	
	private circle (){}
	private circle (double x1, double y1, double x2 , double y2){
		Circle = new Circle();
		Center = new Point2D(x1,y1);
		End = new Point2D(x2,y2);
		Set();
	}
	private circle (Point2D Start, Point2D End)
	{
		Circle = new Circle();
		this.Center=Start;
		this.End=End;
		
		Set();
	}
	
	private circle(shape Shape){
		Circle = new Circle();
        double radius =Math.sqrt(Math.pow(Shape.getEnd().getX()-Shape.getCenter().getX(),2 )+Math.pow(Shape.getEnd().getY()- Shape.getCenter().getY(),2));
        Circle.setFill(Shape.getShapeFx().getFill());
        Circle.setStroke(Shape.getShapeFx().getStroke());
        Circle.setRotate(Shape.getShapeFx().getRotate());
        Circle.setStrokeWidth(Shape.getShapeFx().getStrokeWidth());
		Center=new Point2D(10+radius,130+radius);
		End=new Point2D(10+2*radius,130+radius);
		Set();
	}
	public static final shape getCopyCircle(shape Shape){
		
		return new circle(Shape);
	}
	
	public static final circle getCircle (double x1 , double y1 , double x2 , double y2)
	{
		return new circle (x1,y1,x2,y2);
	}
	
	public static final circle getCircle (Point2D Start , Point2D End)
	{
		return new circle (Start,End);
	}
	
	
	public Point2D getCenter() {
        return Center;
       
    }

    public Point2D getEnd() {
        return End;
    }

    public Circle getShapeFx() {
        return Circle;
    }
	

	private void Set() {
		Circle.setCenterX(Center.getX());
		Circle.setCenterY(Center.getY());
		Circle.setRadius(Math.sqrt(Math.pow(End.getX()-Center.getX(),2 )+Math.pow(End.getY()- Center.getY(),2)));
	}
	@Override
	public void Delete() {
		Circle=null;
		
	}
	@Override
	public void Modify(double newx1, double newx2, double newy1, double newy2) {
		
		Center= new Point2D(newx1,newy1);
		End = new Point2D(newx2,newy2);
		Set();
	}
	
	public void Modify(Point2D newCenter , Point2D newEnd)
	{
		Center=newCenter;
		End=newEnd;
		Set();
	}
	public String toString()
	{
		
		return  "Width:"+"("+Center.getX() +","+ Center.getY() +")"+ " " +"Radius:("+ Math.abs(End.getX()-Center.getX()) + "," + Math.abs(End.getY()-Center.getY())+")" ;
	}
	@Override
	public Point2D getStart() {
		return null;
	}
	@Override
	public void Move(double x, double y) {
        double radius =Math.sqrt(Math.pow(this.getEnd().getX()-this.getCenter().getX(),2 )+Math.pow(this.getEnd().getY()- this.getCenter().getY(),2));
		Center=new Point2D(x+radius,y+radius);
		End=new Point2D(x+2*radius,y+radius);
		Set();
	}
	@Override
	public void Rotate(double angle) {
		Circle.setRotate(angle);
		
	}

}


	
	


