
public interface Visitor {
	public void visit (ArnoldInterpreter a);
	public void visit (DeclareNode d);
	public void visit (IfBodyNode i);
	public void visit (LValNode n);
	public void visit (ConstantNode c);
	public void visit (OrNode o);
}

class TreeVisitor implements Visitor{
	
	private Visitor baseVisitor;
	
	public TreeVisitor(){}
	
	public TreeVisitor(Visitor v){
		this.setVisitor(v);
	}
	
	public void setVisitor( Visitor v){
		this.baseVisitor = v;
	}
	public Visitor getVisitor(){
		return this.baseVisitor;
	}
	@Override
	public void visit(DeclareNode d) {
		int cnt = 0;
		for( Node someNode : d.getChildren()){
			if(someNode instanceof ConditionNode){
				System.out.print("(");
				someNode.accept(new TreeVisitor(baseVisitor));
				System.out.print(")");
			}
			else
				someNode.accept(baseVisitor);
			if(cnt == 0)
				d.accept(baseVisitor);
			
			cnt++;
		}
		System.out.println(";");
	}
	public void visit(LValNode l){
		l.accept(baseVisitor);
	}
	public void visit(ConstantNode c){
		c.accept(baseVisitor);
	}
	@Override
	public void visit(OrNode o) {
		int cnt = 0;
		for( Node someNode : o.getChildren()){
			
			if(someNode instanceof ConditionNode){
			System.out.print("(");
			someNode.accept(new TreeVisitor(baseVisitor));
			System.out.print(")");
			}
			else
				someNode.accept(baseVisitor);
			if(cnt == 0 )
				o.accept(baseVisitor);
			cnt++;
		}
		
	}
	@Override
	public void visit(IfBodyNode i) {
		// TODO Auto-generated method stub
	}
	@Override
	public void visit(ArnoldInterpreter a) {
		// TODO Auto-generated method stub
		
	}

	

	
}
class PrintVisitor implements Visitor{
	
	public PrintVisitor(){}
	@Override
	public void visit(DeclareNode d) {
		System.out.print(d);
		
	}
	@Override
	public void visit(IfBodyNode i) {
		System.out.print(i);
		
	}

	@Override
	public void visit(LValNode n) {
		System.out.print(n);
		
	}

	@Override
	public void visit(ConstantNode c) {
		System.out.print(c);
	}

	@Override
	public void visit(ArnoldInterpreter a) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void visit(OrNode o) {
		System.out.print(o);
		
	}
	
	
}
	
	
	



