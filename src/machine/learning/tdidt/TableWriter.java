package machine.learning.tdidt;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.nio.charset.*;

class TableWriter {
	
	private static Charset UTF8 = Charset.forName("UTF-8");
	
	public void write(Node root) throws IOException {
		Writer writer = new OutputStreamWriter(new FileOutputStream("./Output.txt"), UTF8);
		Queue<Node> q = new LinkedList<>();
        
        q.add(root);
		
		
		try {
	        while(!q.isEmpty()){ 
	            writer.write((String)q.peek().print());
	            writer.write("\r\n");
	            if (q.peek().child_left!=null)
	                q.add(q.peek().child_left);
	            if (q.peek().child_right!=null)
	                q.add(q.peek().child_right);
	            q.poll();
	        }

		}finally {
            writer.close();
        }


		


	}
}
