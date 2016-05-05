package draw;
public interface Command {
    public shape undo();
    public  shape redo();
    public shape getval();
    public shape getShape();
}
