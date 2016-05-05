package draw;

import javafx.geometry.Point2D;
import javafx.scene.shape.Shape;

public interface shape {
	
	void Delete();
	void Modify(double newx1,double newx2,double newy1,double newy2);
	void Modify(Point2D newStart , Point2D newEnd);
	public Point2D getStart();
	public Point2D getEnd();
	public Point2D getCenter();
	public void Move (double x,double y);
	public void Rotate (double angle);
	String toString();
	Shape getShapeFx();

}
