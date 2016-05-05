package draw;

import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import java.awt.Paint;

import javafx.geometry.Point2D;

public class triangle implements shape {

	private Point2D Start;
	private Point2D End;
	private Point2D Point3;
	private Polygon Triangle;
	private javafx.scene.paint.Paint fill;
	private javafx.scene.paint.Paint border;
	private Double angle,width;
	private triangle (){}
	private triangle(shape Shape) //Copy constructor
	{
	fill=	Shape.getShapeFx().getFill();
	border=Shape.getShapeFx().getStroke();
	angle=Shape.getShapeFx().getRotate();
	double width=Math.abs(Shape.getEnd().getX()-Shape.getStart().getX());
	double height =Math.abs(Shape.getEnd().getY()-Shape.getStart().getY());
if((Shape.getStart().getX()<Shape.getEnd().getX())&&(Shape.getStart().getY()<Shape.getEnd().getY()))
  {
	Start=new Point2D(10+width,130);
	End=new Point2D(Start.getX()+width,Start.getY()+height);
  }
else if((Shape.getStart().getX()>Shape.getEnd().getX())&&(Shape.getStart().getY()<Shape.getEnd().getY()))
{
	Start=new Point2D(10+width,130);
	End=new Point2D(Start.getX()-width,Start.getY()+height);
}
else if((Shape.getStart().getX()<Shape.getEnd().getX())&&(Shape.getStart().getY()>Shape.getEnd().getY()))
{
	Start=new Point2D(10+width,130+height);
	End=new Point2D(Start.getX()+width,Start.getY()-height);
}
else if((Shape.getStart().getX()>Shape.getEnd().getX())&&(Shape.getStart().getY()>Shape.getEnd().getY()))
{
	Start=new Point2D(10+width,130+height);
	End=new Point2D(10,100);
}
	

Set();
		Triangle.setFill(fill);
		Triangle.setStroke(border);
		Triangle.setRotate(angle);
		Triangle.setStrokeWidth(Shape.getShapeFx().getStrokeWidth());
	}
	
	
	private triangle (double x1, double y1, double x2 , double y2){
		
		Start = new Point2D(x1,y1);
		End = new Point2D(x2,y2);
		Set();
		
	}
	private triangle (Point2D Start, Point2D End)
	{
		this.Start=Start;
		this.End=End;
		Set();
		fill=Triangle.getFill();
		 border=Triangle.getStroke();
		 angle=Triangle.getRotate();
		 width=Triangle.getStrokeWidth();
	}
	public static final triangle getCopyTriangle(shape Shape){
			
			return new triangle(Shape);
			
	}
	public static final triangle getTriangle (double x1, double y1, double x2 , double y2)
	{
		return new triangle (x1,y1,x2,y2);
	}
	
	public static final triangle getTriangle (Point2D Start , Point2D End)
	{
		return new triangle (Start,End);
	}
	
	public Polygon getShapeFx(){
		return Triangle;
	}
	
	
	private void Set() {
		//double Length=Math.sqrt(Math.pow(Math.abs(End.getX()-Start.getX()),2)+Math.pow(Math.abs(End.getY()-Start.getY()),2));
		//if(((Start.getX()<End.getX())&&(Start.getY()<End.getY())) || ((Start.getX()<End.getX())&&(Start.getY()>End.getY())))
		//{
			//Point3= new Point2D(End.getX()-Length,End.getY());
			//Triangle=new Polygon(Start.getX(),Start.getY(),End.getX(),End.getY(),Point3.getX(),Point3.getY());
		//}
		//else if (((Start.getX()>End.getX())&&(Start.getY()<End.getY())) || ((Start.getX()>End.getX())&&(Start.getY()>End.getY())))
		//{
			//Point3= new Point2D(End.getX()+Length,End.getY());
			//Triangle=new Polygon(Start.getX(),Start.getY(),End.getX(),End.getY(),Point3.getX(),Point3.getY());
		//}
		//Circle c1=new Circle(Start.getX(),Start.getY(),Length);
		//Circle c2=new Circle(End.getX(),End.getY(),Length);
		//Shape intersection=Shape.intersect(c1, c2);
		//if(((Start.getX()<End.getX())&&(Start.getY()<End.getY())) || ((Start.getX()>End.getX())&&(Start.getY()>End.getY())))
		//Point3 = new Point2D (intersection.getBoundsInLocal().getMinX(),intersection.getBoundsInLocal().getMaxY());
		//else if (((Start.getX()>End.getX())&&(Start.getY()<End.getY())) || ((Start.getX()<End.getX())&&(Start.getY()>End.getY())))
			//Point3 = new Point2D (intersection.getBoundsInLocal().getMaxX(),intersection.getBoundsInLocal().getMaxY());
		//Triangle=new Polygon(Start.getX(),Start.getY(),End.getX(),End.getY(),Point3.getX(),Point3.getY());
		double width=Math.abs(End.getX()-Start.getX());
		if(((Start.getX()<End.getX())&&(Start.getY()<End.getY())) || ((Start.getX()<End.getX())&&(Start.getY()>End.getY())))
		Point3 = new Point2D (Start.getX()-width,End.getY());
		else if (((Start.getX()>End.getX())&&(Start.getY()<End.getY())) || ((Start.getX()>End.getX())&&(Start.getY()>End.getY())))
		Point3= new Point2D (Start.getX()+width,End.getY());
		
		Triangle=new Polygon(Start.getX(),Start.getY(),End.getX(),End.getY(),Point3.getX(),Point3.getY());
			
	}

	@Override
	public void Delete() {
		Triangle=null;
		
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
	@Override
    public Point2D getEnd() {
        return End;
    }
	@Override
	public Point2D getCenter() {
		return null;
	}
	@Override
	public void Move(double x, double y) {
		double width=Math.abs(End.getX()-Start.getX());
		double height =Math.abs(End.getY()-Start.getY());
	if((Start.getX()<End.getX())&&(Start.getY()<End.getY()))
      {
		Start=new Point2D(x+width,y);
		End=new Point2D(Start.getX()+width,Start.getY()+height);
      }
	else if((Start.getX()>End.getX())&&(Start.getY()<End.getY()))
	{
		Start=new Point2D(x+width,y);
		End=new Point2D(Start.getX()-width,Start.getY()+height);
	}
	else if((Start.getX()<End.getX())&&(Start.getY()>End.getY()))
	{
		Start=new Point2D(x+width,y+height);
		End=new Point2D(Start.getX()+width,Start.getY()-height);
	}
	else if((Start.getX()>End.getX())&&(Start.getY()>End.getY()))
	{
		Start=new Point2D(x+width,y+height);
		End=new Point2D(x,y);
	}
	
	Set();
	Triangle.setFill(Color.WHITE);	
	Triangle.setStroke(Color.BLACK);	
	Triangle.setStrokeWidth(2);
	}
	@Override
	public void Rotate(double angle) {
		Triangle.setRotate(angle);
		
	}

}
