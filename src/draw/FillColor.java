package draw;

import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class FillColor extends ShapeDecorator {
	private static FillColor FillColorObject;
	private Shape shape;
	private Color fillColor;

	private FillColor() {
	}
	
	public static final FillColor getFillColorObject()
	{
		if(FillColorObject==null)
		FillColorObject=new FillColor();
		
		return FillColorObject;
	} 

	private void Set() {
		shape.setFill(fillColor);
		
	}

	@Override
	public void setShape(Shape shape)
	{
		this.shape=shape;
		Set();
	}
	
    @Override
	public void setColor(Color fillColor) {
		this.fillColor=fillColor;
		
	}
}
