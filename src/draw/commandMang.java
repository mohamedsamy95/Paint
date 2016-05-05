package draw;

import java.util.Iterator;
import java.util.List;

import java.util.ArrayList;
import java.util.ListIterator;


import javax.swing.event.ChangeEvent;


public class commandMang {
    private Node currentIndex = null;
    private Node parentNode = new Node();
    private List<Node>historyContainer=new ArrayList<Node>();
    private List<String> shapeToString =null;
    private List<Command> shapeObjects=null;

    public commandMang(){

        currentIndex = parentNode;

    }
    public commandMang(commandMang manager){

        this();

        currentIndex = manager.currentIndex;

    }
    public void clear(){

        currentIndex = parentNode;

    }
    public void addCommand(Command command){

        Node node = new Node(command);
        historyContainer.add(node);
        currentIndex.right = node;

        node.left = currentIndex;

        currentIndex = node;


    }
    public boolean canUndo(){

        return currentIndex != parentNode;

    }


    public boolean canRedo(){

        return currentIndex.right != null;

    }
    public shape undo(){

        //validate

        if ( !canUndo() ){

            throw new IllegalStateException("Cannot undo. Index is out of range.");

        }

        //undo

      shape temp=  currentIndex.changeable.undo();

        //set index

        moveLeft();
        return temp;

    }
    private void moveLeft(){

        if ( currentIndex.left == null ){

            throw new IllegalStateException("Internal index set to null.");

        }
        historyContainer.add(currentIndex);
        currentIndex = currentIndex.left;

    }

    private void moveRight(){

        if ( currentIndex.right == null ){

            throw new IllegalStateException("Internal index set to null.");

        }

        currentIndex = currentIndex.right;

    }
 

    public shape redo() {

        //validate

        if (!canRedo()) {

            throw new IllegalStateException("Cannot redo. Index is out of range.");

        }

        //reset index

        moveRight();

        //redo
     return   currentIndex.changeable.redo();

    }
    public Command checkExistance(shape sh){
        Node node=currentIndex;
        
        while(node.left!=null){
            if(node.changeable.getval()==sh){
              return node.changeable;

            }
            node=node.left;
        }
        return null;
    }
    public Command checkExistanceRedo(shape sh){
    	 Node node=currentIndex.left;     
        while(node.left!=null){
            if(node.changeable.getval()==sh){
              return node.changeable;

            }
            node=node.left;
        }
        return null;
    }
    public void historyInfo(){
        Iterator<Node>it=historyContainer.iterator();
        while (it.hasNext()){
            it.next().changeable.getval();
        }
    }
   /* public void tranport (int index){
      int  ind=0,size=historyContainer.size();
        List<Command> removed =new  ArrayList();
       ListIterator<Node>it=historyContainer.listIterator();
        while(ind!=index){
            historyContainer.get(size-ind).changeable.getval();
            System.out.println(index+"");
          //  removed.add(it.previous().changeable);
            index--;
        }
       // return removed;
    }*/

    private class Node {

        private Node left = null;

        private Node right = null;


        private final Command changeable;


        public Node(Command c) {

            changeable = c;

        }


        public Node() {

            changeable = null;

        }


    }}