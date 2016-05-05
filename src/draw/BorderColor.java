package draw;

import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class BorderColor extends ShapeDecorator {
	private static BorderColor BorderColorObject;
	private Shape shape;
	private Color borderColor;
	private double borderWidth;

	private BorderColor() {}
	
	public static final BorderColor getBorderColorObject()
	{
		if(BorderColorObject==null)
		BorderColorObject=new BorderColor();
		
		return BorderColorObject;
	} 

	private void Set() {
		if(shape!=null)
		{
		shape.setStroke(borderColor);
		shape.setStrokeWidth(borderWidth);
		}
		
	}

	
	@Override
	public void setShape(Shape shape)
	{
		this.shape=shape;
		Set();
	}

	@Override
	public void setColor(Color borderColor) {
		this.borderColor=borderColor;
		
	}
	public void setBorderWidth (double borderWidth)
	{
		this.borderWidth=borderWidth;
	}

}
