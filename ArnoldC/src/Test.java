import java.util.ArrayList;


public class Test {







	public static void main (String args[]){



		TreeVisitor t = new TreeVisitor(new PrintVisitor());
		LValNode l = new LValNode("greatVariables");
		LValNode l2 = new LValNode("greatJavaProgram");
		//System.out.println(l.getCommand());
		ConstantNode c = new ConstantNode(5);
		ConstantNode c1 = new ConstantNode(10);
		//System.out.println(c.getCommand());
		OrNode o1 = new OrNode(l,l2);
		DeclareNode d = new DeclareNode(o1,c);
		//System.out.println(d.getCommand());
		//ConditionNode f = new ConditionNode(new LValNode("o zi urata"),"||",l2);
		//f.accept(t);

		OrNode o = new OrNode(c1,c);
		//ConditionNode e = new ConditionNode(f,"&&",o);
		ArrayList<String> linesFromFile = new ArrayList<String>();
		int i = 0, length;
		StringParser parser = new StringParser();
		String newString = StringParser.readFromFile("/home/mirceas/Projects/Workspace-Java/ArnoldC/src/someFile.ar");
		linesFromFile = StringParser.parseInput(newString);
		
		for( String s2: linesFromFile )
			System.out.println(s2);
		//System.out.println(s);
		//ArnoldInterpreter a = parser.returnCommandNode(linesFromFile);
		//a.accept(t);
		//e.accept(t);
		//d.accept(t);
	}
}
