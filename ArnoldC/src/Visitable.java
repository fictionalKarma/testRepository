import java.util.ArrayList;


public interface Visitable {
	public  void accept(Visitor v);
};

abstract class Node implements Visitable{
	private String command;
	protected ArrayList<Node> children ;
	public void accept(Visitor v) {
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
}
class ArnoldInterpreter  extends Node{
		
	public ArnoldInterpreter(){
		children = new ArrayList<Node>();
	}
	public void addNode( Node n){
		this.children.add(n);
	}
	public ArrayList<Node> getChildren(){
		return this.children;
}
	@Override
	public void accept(Visitor v) {
		v.visit(this);  
	}
};
