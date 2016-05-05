package draw;

import javafx.geometry.Point2D;
import javafx.scene.paint.Paint;

public class commandLineContainer implements Command {


    private final shape val;
    private  Paint fillColor;
    private Paint borderColor;
    private Point2D Start;
    private Point2D End;
    private Point2D Center;
    private Double angle;
    
    public commandLineContainer(shape v){
    	System.out.println(v+"OOOOOOOOOOOOOOOO");
        this.val = v;
        if(v instanceof circle){
       Center=v.getCenter();
       End=v.getEnd();
       fillColor =v.getShapeFx().getFill();
       borderColor=v.getShapeFx().getStroke();
       angle=v.getShapeFx().getRotate();
        }else{
        	  Start=v.getStart();
              End=v.getEnd();
              fillColor =v.getShapeFx().getFill();
              borderColor=v.getShapeFx().getStroke();
              angle=v.getShapeFx().getRotate();
              }
   
        }
        	
        
    
public shape getShape(){
	val.getShapeFx().setRotate(angle);
	val.getShapeFx().setFill(fillColor);
	val.getShapeFx().setStroke(borderColor);
	if(val instanceof circle)
	val.Modify(Center, End);	
	else
	
	val.Modify(Start,End);
    return val;
}


    public shape undo(){
    	System.out.println(val+"PPPPPPPPPPPPp");
        return val;

    }



    public shape redo(){

       return val;

    }
    public shape getval(){
       return val;
    }

}
