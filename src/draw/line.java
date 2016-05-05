package draw;

import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.geometry.Point2D;

public class line implements shape{
	
	private Point2D Start;
	private Point2D End;
	private Line Line;
	private Paint fill,border;
	private Double width,angle;

	private line (){}
	
	private line (double x1, double y1, double x2 , double y2){
		Start = new Point2D(x1,y1);
		End= new Point2D(x2,y2);
		Set();
		fill=Line.getFill();
		 border=Line.getStroke();
		 angle=Line.getRotate();
		 width=Line.getStrokeWidth();
		
	}
	
	private line (Point2D Start, Point2D End)
	{
		this.Start=Start;
		this.End=End;
		Set();
		
	}
	
	private line(shape Shape)
	{
		Line=new Line();
		 Line.setFill(Shape.getShapeFx().getFill());
		 Line.setStroke(Shape.getShapeFx().getStroke());
		 Line.setRotate(Shape.getShapeFx().getRotate());
		 Line.setStrokeWidth(Shape.getShapeFx().getStrokeWidth());
		 fill=Shape.getShapeFx().getFill();
		 border=Shape.getShapeFx().getStroke();
		 angle=Shape.getShapeFx().getRotate();
		 width=Shape.getShapeFx().getStrokeWidth();
		 System.out.println(angle+"noooooooo");
		 System.out.println(border);
		 System.out.println(fill);
		 
		 
		double width=Math.abs(Shape.getEnd().getX()-Shape.getStart().getX());
		double height=Math.abs(Shape.getEnd().getY()-Shape.getStart().getY());
		if((Shape.getStart().getX()<=Shape.getEnd().getX())&&(Shape.getStart().getY()<=Shape.getEnd().getY()))
		{
		Start=new Point2D(10,100);
		End=new Point2D(10+width,130+height);
		}
		else if((Shape.getStart().getX()>=Shape.getEnd().getX())&&(Shape.getStart().getY()<=Shape.getEnd().getY()))
		{
		Start = new Point2D(10+width,130);
		End= new Point2D(10,130+height);
		}
		else if ((Shape.getStart().getX()<=Shape.getEnd().getX())&&(Shape.getStart().getY()>=Shape.getEnd().getY()))
		{
			Start= new Point2D(10,130+height);
			End= new Point2D(10+width,130);
		}
		else if((Shape.getStart().getX()>=Shape.getEnd().getX())&&(Shape.getStart().getY()>=Shape.getEnd().getY()))
		{
			Start =new Point2D(10+width,130+height);
			End =new Point2D(10,130);
		}
		Set(); 
		
	}
	public static final line getLine (double x1 , double y1 , double x2 , double y2)
	{
		return new line(x1,y1,x2,y2);
	}
	
	public static final line getLine (Point2D Start , Point2D End)
	{
		return new line(Start,End);
	}
	
    public Point2D getStart() {
        return Start;
    }

    public Point2D getEnd() {
        return End;
    }
    public Line getShapeFx(){
    	return Line;}
    
    
	private void Set() {
    	Line = new Line(Start.getX(),Start.getY(),End.getX(),End.getY());
    
	}
    
    
	@Override
	public void Delete() {
		Line =null;
		
	}
	
	@Override
	public void Modify(double newx1, double newx2, double newy1, double newy2) {
		Line=null;
		Start= new Point2D(newx1,newy1);
		End= new Point2D(newx2,newy2);
		Set();
		
	}
	public void Modify(Point2D newStart , Point2D newEnd)
	{
		Start=newStart;
		End=newEnd;
		Set();
	}

	public String toString()
	{
		
		return "Start:"+"(" + Start.getX() +","+ Start.getY() +"),"+ "End:"+"(" + End.getX() +","+ End.getY() +")" ;
	}

	@Override
	public Point2D getCenter() {
		return null;
	}

	public static shape getCopyLine(shape Shape) {
		
		return new line (Shape);
	}

	@Override
	public void Move(double x, double y) {
	
		double width=Math.abs(this.getEnd().getX()-this.getStart().getX());
		double height=Math.abs(this.getEnd().getY()-this.getStart().getY());
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
		Line.setFill(fill);
		Line.setStroke(border);
		Line.setStrokeWidth(2);
		Line.setRotate(angle);
	
		
	}

	@Override
	public void Rotate(double angle) {
		Line.setRotate(angle);
		
	}
	
}

