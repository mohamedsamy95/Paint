package draw;

import java.io.IOException; 
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Callback;

public class Main extends Application {
	int historyFlag=0;
	
	
	int undoIndex=0;
	int redoIndex=0;
    int movedFlag;
	FillColor FillColor;
	BorderColor BorderColor;
	private static  Stage firstStage;
	@FXML
	private static AnchorPane mainLayout;
	@FXML
	private static AnchorPane mainLayout1;
	@FXML
	private  static AnchorPane tools;
	@FXML
	TextField stroke;
	@FXML
	TextField Dialog;
	@FXML
	TextField rotation;
	@FXML
	private  TableView<shape> history;
	commandMang manager= new commandMang();
	Group painting=new Group();
	private double pressedX;
	private double pressedY;
	@FXML
	Rectangle fill;
	@FXML
	Rectangle border;
	ShapeFactory s;
    String selected;
    int moveFlag=0;
    ArrayList<shape> shapes = new ArrayList<shape>();
    int lastShape=0;
    int currentIndex=0;
    int selectedIndex=0;
    int selectionFlag=0;
    shape currentShape;
    String tool;
	Canvas canvas;
	private double draggedX ;
    private double draggedY ;
    private double lastX ;
    private double lastY ;
    private double movedX ;
    private double movedY ;
    @FXML
    private static Color borderColor;
    @FXML
    private static Color fillColor;
    @FXML
    private  ColorPicker colorPicker;
    @FXML
    private  ColorPicker colorPicker2;

    int flag=0;
    
	@Override
	public void start(Stage primaryStage) throws IOException {
		firstStage = primaryStage;
		firstStage.setTitle("Paint");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("Main.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		firstStage.setScene(scene);
	    firstStage.show();
	    
	  }

	
	@FXML
	public void initialize(){
		 System.out.println(selected);
		 colorPicker2.setValue(Color.BLACK);
		 borderColor=colorPicker2.getValue();
		 fillColor=colorPicker.getValue();
		 border.setFill(colorPicker2.getValue());
		 stroke.setText("2");
		 rotation.setText("0");
	}
	
	public void delete(){
		if(selectedIndex>=0){
        	manager.addCommand(new commandLineContainer(shapes.get(selectedIndex)));
			mainLayout.getChildren().remove(shapes.get(selectedIndex).getShapeFx());
			shapes.remove(selectedIndex);
			currentIndex--;
			selectedIndex--;
			System.out.println(currentIndex);
		}
		
	}
	
	/*public void history(){
		
		if(historyFlag==0){
			history.setVisible(true);
			items= FXCollections.observableArrayList(shapes);
			history.setItems(items);
			historyFlag=1;
		}
		else{
			history.setVisible(false);
			historyFlag=0;
		}
		
		
	}*/
	
	public void rotate(){
		if(selected=="select"){
		mainLayout.getChildren().remove(shapes.get(selectedIndex).getShapeFx());
		shapes.get(selectedIndex).Rotate(Double.parseDouble(rotation.getText()));
		mainLayout.getChildren().add(shapes.get(selectedIndex).getShapeFx());
		shapes.get(selectedIndex).getShapeFx().toBack();
		manager.addCommand(new commandLineContainer(shapes.get(selectedIndex)));
		}
	}
	public void fillColor(){
		 fillColor=colorPicker.getValue();
		 fill.setFill(colorPicker.getValue());
		 if(selected=="select"){
			 FillColor.setColor(fillColor);
			 FillColor.setShape(shapes.get(selectedIndex).getShapeFx());
		    manager.addCommand(new commandLineContainer(shapes.get(selectedIndex)));

		 }
		 
	 }
	
   public void borderColor() {
		 borderColor=colorPicker2.getValue();
		 border.setFill(colorPicker2.getValue());
		 
		 if(selected=="select"){
			 BorderColor.setColor(borderColor);
			 BorderColor.setShape(shapes.get(selectedIndex).getShapeFx());
		 	manager.addCommand(new commandLineContainer(shapes.get(selectedIndex)));

			
		 }
	 }

	public void deleteButtonClicked(){
		
		selected="delete";
	}
	public void resizeButtonClicked(){
		
		tool="resize";
	}
	
	public void selectButtonClicked(){
		
		selected="select";
	}
	public void circleButtonClicked(){
		
		selected="circle";
	}
	
	public void penButtonClicked(){
		
		selected="pen";
	}
	public void moveButtonClicked(){
		
		selected="move";
		
		
	}
	
	public void rightTButtonClicked(){
		
		selected="righttriangle";
		
	}
	public void ellipseButtonClicked(){
		
		selected="ellipse";
	}
	
	public void rectangleButtonClicked(){
		
		selected="rectangle";
	}
	
	public void squareButtonClicked(){
		
		selected="square";
	}
	
	public void lineButtonClicked(){
		
		selected="line";
	}
	public void	triangleButtonClicked(){
		
		selected="triangle";
	}
	
	public void select(){
		
		System.out.println("nnnn");
		 selectionFlag=0;
		 for(int index=currentIndex-1;index>=0;index--){
			 if(shapes.get(index).getShapeFx().getBoundsInLocal().contains(pressedX,pressedY)){
				selectedIndex=index;
				selectionFlag=1;
				break;
				
			 }
	
		 }
		 if(selectionFlag==1){
			 System.out.println(shapes.get(selectedIndex));
		 }
	}
	
	public void handleMove(MouseEvent me){
		if(selected=="select"&&currentIndex>0){
			movedX=me.getX();
			movedY=me.getY();
			 for(int index=currentIndex-1;index>=0;index--){
				 if(shapes.get(index).getShapeFx().getBoundsInLocal().contains(movedX,movedY)){
					selectedIndex=index;
					selectionFlag=1;
					break;
					
				 }
		
			 }
			 if(selectionFlag==1){
				 try{
				 Dialog.setText(shapes.get(selectedIndex).toString());
				 }catch(Exception ex){
					 
				 }
			 }
		}
			 
				 
			 
		
	}
	
	public void drag(MouseEvent me){
		
		if(flag==1 ){
   		    mainLayout.getChildren().remove(shapes.get(currentIndex).getShapeFx());
   	   	 }

		 if((selected=="circle"||selected=="rectangle"||selected=="square"||selected=="righttriangle"||selected=="triangle"||selected=="ellipse"||selected=="line")&&shapes.get(currentIndex).getShapeFx()!=null){
			 
			 System.out.println(shapes.get(currentIndex));
			 shapes.get(currentIndex).Modify(pressedX, draggedX, pressedY, draggedY);
			 FillColor=FillColor.getFillColorObject();
			 FillColor.setShape(shapes.get(currentIndex).getShapeFx());
			 BorderColor=BorderColor.getBorderColorObject();
			 BorderColor.setColor(borderColor);
			 BorderColor.setBorderWidth(Integer.parseInt(stroke.getText()));
			 BorderColor.setShape(shapes.get(currentIndex).getShapeFx());
			 FillColor.setColor(fillColor);
			 FillColor.setShape(shapes.get(currentIndex).getShapeFx());
	         mainLayout.getChildren().add(shapes.get(currentIndex).getShapeFx());
	         shapes.get(currentIndex).getShapeFx().toBack();
	         flag=1;
		 }
	}
	
	
	 public void handlePress(MouseEvent me) {
		 pressedX = me.getX();
         pressedY = me.getY();
         historyFlag=1;
    	 if(selected=="circle"||selected=="line"||selected=="rectangle"||selected=="square"||selected=="righttriangle"||selected=="ellipse"){
           shapes.add(ShapeFactory.getShape(selected, pressedX,pressedY,pressedX,pressedY));
    	 }
    	  if(selected=="triangle"){
    		 shapes.add(ShapeFactory.getShape(selected, pressedX,pressedY,pressedX+50,pressedY+50));
    	  }
  
		 if(selected=="select"){
		     select();
		}
		 
     }

	 public void handleDrag(MouseEvent me) { 
		
		 draggedX =  me.getX();
		 draggedY =  me.getY();
		  if(selected!=null && selected!="select" && selected != "move"){

			 drag(me);
	     
		 }
		  
		  else if(selected=="select"&&tool!="resize"){
			  
			 move();

		  }
		  else if(selected=="select" &&tool=="resize"){
			  resize();
		  }
		  

	 }
	 
	 
	 
	 public void handleRelease(MouseEvent me){
		     tool=null;
	    	if(selected!=null){
		    	lastX = me.getX();
				lastY = me.getY();
		        
				if(selected=="circle"||selected=="rectangle"||selected=="square"||selected=="righttriangle"||selected=="triangle"||selected=="ellipse"||selected=="line")
		         {
		        	manager.addCommand(new commandLineContainer(shapes.get(currentIndex)));
		           currentIndex++;
		           
		           flag=0;
		           System.out.println(currentIndex);
		         }
				
				if(moveFlag==1){
		        	manager.addCommand(new commandLineContainer(shapes.get(selectedIndex)));
					moveFlag=0;
				}

	    	} 
	     }

	 	public void undo(){
	 		
	 	shape tmp=manager.undo();
	 	Command cmd=manager.checkExistance(tmp);
	 	if(cmd==null){
	
	 	if(mainLayout.getChildren().contains(tmp.getShapeFx())){
	 		mainLayout.getChildren().remove(tmp.getShapeFx());
	 		currentIndex--;
	 		selectedIndex--;
	 		shapes.remove(currentIndex);
	 	}
	 	}else{
	 		mainLayout.getChildren().remove(tmp.getShapeFx());
	 		mainLayout.getChildren().add(cmd.getShape().getShapeFx());
	 		cmd.getShape().getShapeFx().toBack();
	 		
	 	}
	 	}
	 	
	 	public void redo(){
	 		shape tmp=manager.redo();
	 		Command cmd=manager.checkExistance(tmp);
	 		
	 			System.out.println(cmd);
		 		mainLayout.getChildren().add(tmp.getShapeFx());
		 		shapes.add(tmp);
		        shapes.get(currentIndex).getShapeFx().toBack();
		 		currentIndex++;
		 		selectedIndex++;
	 		

	 	}
	 	
	 	
	 	public void resize(){
	 		if(shapes.get(selectedIndex) instanceof rectangle){
	   		 mainLayout.getChildren().remove(shapes.get(selectedIndex).getShapeFx());
			 shapes.get(selectedIndex).Modify(((shapes.get(selectedIndex).getStart().getX())),draggedX ,((Rectangle)(shapes.get(selectedIndex).getShapeFx())).getY(), draggedY);
	         mainLayout.getChildren().add(shapes.get(selectedIndex).getShapeFx());
	         shapes.get(selectedIndex).getShapeFx().toBack();
	 		}
	 		if(shapes.get(selectedIndex) instanceof square){
		   		 mainLayout.getChildren().remove(shapes.get(selectedIndex).getShapeFx());
				 shapes.get(selectedIndex).Modify(((shapes.get(selectedIndex).getStart().getX())),draggedX ,((shapes.get(selectedIndex).getStart().getY())), draggedY);
		         mainLayout.getChildren().add(shapes.get(selectedIndex).getShapeFx());
		         shapes.get(selectedIndex).getShapeFx().toBack();
		 		}
	 		
	 		if(shapes.get(selectedIndex) instanceof circle){
		   		 mainLayout.getChildren().remove(shapes.get(selectedIndex).getShapeFx());
				 shapes.get(selectedIndex).Modify(((Circle)(shapes.get(selectedIndex).getShapeFx())).getCenterX(),draggedX ,((Circle)(shapes.get(selectedIndex).getShapeFx())).getCenterY(), draggedY);
		         mainLayout.getChildren().add(shapes.get(selectedIndex).getShapeFx());
		         shapes.get(selectedIndex).getShapeFx().toBack();
		 		}
	 		if(shapes.get(selectedIndex) instanceof ellipse){
		   		 mainLayout.getChildren().remove(shapes.get(selectedIndex).getShapeFx());
				 shapes.get(selectedIndex).Modify(((Ellipse)(shapes.get(selectedIndex).getShapeFx())).getCenterX(),draggedX ,((Ellipse)(shapes.get(selectedIndex).getShapeFx())).getCenterY(), draggedY);
		         mainLayout.getChildren().add(shapes.get(selectedIndex).getShapeFx());
		         shapes.get(selectedIndex).getShapeFx().toBack();
		 		}
	 		if(shapes.get(selectedIndex) instanceof line){
		   		 mainLayout.getChildren().remove(shapes.get(selectedIndex).getShapeFx());
				 shapes.get(selectedIndex).Modify((shapes.get(selectedIndex).getStart().getX()),draggedX ,shapes.get(selectedIndex).getStart().getY(), draggedY);
		         mainLayout.getChildren().add(shapes.get(selectedIndex).getShapeFx());
		         shapes.get(selectedIndex).getShapeFx().toBack();
		 		}
	 		if(shapes.get(selectedIndex) instanceof triangle || shapes.get(selectedIndex) instanceof rightTriangle){
		   		 mainLayout.getChildren().remove(shapes.get(selectedIndex).getShapeFx());
				 shapes.get(selectedIndex).Modify(shapes.get(selectedIndex).getStart().getX(),draggedX ,shapes.get(selectedIndex).getStart().getY(), draggedY);
		         mainLayout.getChildren().add(shapes.get(selectedIndex).getShapeFx());
		         shapes.get(selectedIndex).getShapeFx().toBack();
		 		}
	 	}
	 	
	 	public void copy(){
	 		
	 	
	 		if(selectionFlag==1){
	 			shape copy=s.copyShaped(shapes.get(selectedIndex));
		 		mainLayout.getChildren().add(copy.getShapeFx());
		 		shapes.add(copy);
		 		shapes.get(currentIndex).getShapeFx().toBack();		 		
		 		
		 		System.out.println(shapes.get(currentIndex));
		 		manager.addCommand(new commandLineContainer(shapes.get(currentIndex)));
		 		currentIndex++;
		 		lastShape++;
		 		selectionFlag=0;
	 		}
	 	}
	 	
	 	
	 	public void move(){
	 		
	 	   if(selectedIndex>=0&&!shapes.isEmpty()){
		    	mainLayout.getChildren().remove(shapes.get(selectedIndex).getShapeFx());
			  	shapes.get(selectedIndex).Move(draggedX, draggedY);
			  	mainLayout.getChildren().add(shapes.get(selectedIndex).getShapeFx());
		 		shapes.get(selectedIndex).getShapeFx().toBack();
			  	System.out.println(shapes.get(selectedIndex));
			  	System.out.println(draggedX);
			  	moveFlag=1;
		    }
	 	}
	 	
	public static void main(String[] args) {
		launch(args);
		}
}
		

