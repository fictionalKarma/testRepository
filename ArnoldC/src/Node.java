import java.util.ArrayList;



class DeclareNode extends ArnoldInterpreter{
	
	public DeclareNode(Node l,Node c){
		super();
		this.addNode(l);
		this.addNode(c);
		this.setCommand(" = ");
	}
	public String toString(){
		return this.getCommand();
	}
	public void accept(Visitor v){
		v.visit(this);
	}
}

class IfBodyNode  extends ArnoldInterpreter{
	public IfBodyNode(){
		super();
	}
	public void accept(Visitor v){
		v.visit(this);
	}
	
}
class RValNode extends ArnoldInterpreter{
	public RValNode(Node n1 , Node n2){
		super();
		this.addNode(n1);
		this.addNode(n2);
		this.setCommand(" || ");
	}
	public String toString(){
		return this.getCommand();
	}
	public void accept(Visitor v){
		v.visit(this);
	}
}
class OrNode extends ConditionNode{
	
	public OrNode(Node n1 , Node n2){
		super(n1,n2);
		this.setCommand("||");
	}
	public String toString(){
		return " "+this.getCommand()+" ";
	}
	public void accept(Visitor v){
		v.visit(this);
	}
}
class ConditionNode extends ArnoldInterpreter{
	public ConditionNode(Node n1, Node n2){
		this.addNode(n1);
		this.addNode(n2);
	} 
	public String toString(){
		return this.getCommand();
	}
	public void accept(Visitor v){
		v.visit(this);
	}
}
class LValNode extends ArnoldInterpreter{
	
	public LValNode(String value){
		super();
		this.setCommand(value);
	}
	public String toString(){
		return this.getCommand();
	}
	public void accept(Visitor v){
		v.visit(this);
	}
}
class ConstantNode extends ArnoldInterpreter{
	
	public ConstantNode( int value){
		super();
		String valueString = "" + value;
		this.setCommand(valueString);
	}
	
	public String toString(){
		return this.getCommand();
	}
	public void accept(Visitor v){
		v.visit(this);
	}
}