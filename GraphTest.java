package A3;

import A3.ADTStack; 
import A3.AStack; 

/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/

import java.io.*;
import java.util.*;

public class GraphTest
   
{
	
	static final int UNVISITED = 0;
	static final int VISITED = 1;
	
	// Create a graph from file
	static Graph createGraph(BufferedReader file, Graph G) 
	throws IOException 
	{
			  String line = null;
			  StringTokenizer token;
			  boolean undirected = false;
			  int i, weight, v1_int, v2_int; 
			  String v1, v2; 
			
			  assert (line = file.readLine()) != null :
			         "Unable to read number of vertices";
			  while(line.charAt(0) == '#')
			  assert (line = file.readLine()) != null :
			         "Unable to read number of vertices";
			  token = new StringTokenizer(line);
			  
			  int n = Integer.parseInt(token.nextToken());
			  G.Initial(n);
			  
			  for (i=0; i<n; i++)
			    G.setMark(i, UNVISITED);
			  
			  assert (line = file.readLine()) != null :
			         "Unable to read graph type";
			  
			  if (line.charAt(0) == 'U')
			    undirected = true;
			  else if (line.charAt(0) == 'D')
			    undirected = false;
			  else assert false : "Bad graph type: " + line;
			
			  // Read in edges
			  while((line = file.readLine()) != null) {
				token = new StringTokenizer(line);
			    v1 = token.nextToken();
			    v2 = token.nextToken();
			    if (token.hasMoreTokens())
			      weight = Integer.parseInt(token.nextToken());
			    else // No weight given -- set at 1
			      weight = 1;
			    v1_int = G.getIndex(v1); 
			    v2_int = G.getIndex(v2); 
			    G.setEdge(v1_int, v2_int, weight);
			    if (undirected) // Put in edge in other direction
			      G.setEdge(v2_int, v1_int, weight);
			  }
			  return G;
	}
	
	
	static void Gprint(Graph G, StringBuffer out) {
		  int i, j;
		
		  for (i=0; i<G.N(); i++) {
		    for(j=0; j<G.N(); j++)
		      if (G.Weight(i, j) == Integer.MAX_VALUE)
		        out.append("0 ");
		      else
		        out.append(G.Weight(i, j) + " ");
		  }
	}
	
	
	/**
	 * output connected component;
	 * @param G
	 */
	static void concom(Graph G) {
		  int i;
		  for (i=0; i<G.N(); i++)  // For n vertices in graph
		    G.setMark(i, 0);       // Vertex i in no component
		  
		  int comp = 1;            // Current component
		  
		  for (i=0; i<G.N(); i++)
		    if (G.getMark(i) == 0) // Start a new component
		      DFS_component(G, i, comp++);
		  
		  for (i=0; i<G.N(); i++)
		    out.append(i + "[" + G.getMark(i) + "] ");
	}
	
	
	static void DFS_component(Graph G, int v, int comp) {
	  
	  G.setMark(v, comp);
	  
	  for (int w = G.First(v); w < G.N(); w = G.Next(v, w))
	    if (G.getMark(w) == 0)
	      DFS_component(G, w, comp);
	}
	
	
	static void DFS(Graph G, int v) { // Depth first search
		  PreVisit(G, v);                 // Take appropriate action
		  G.setMark(v, VISITED);
		  for (int w = G.First(v); w < G.N() ; w = G.Next(v, w))
		    if (G.getMark(w) == UNVISITED)
		      DFS(G, w);
		  PostVisit(G, v);                // Take appropriate action
		
 }
	
	/**
	 * depth first traversal
	 */
	   static void PreVisit(Graph G, int v) {
		  out.append(v + "pre "); //subject to the application
		}

		static void PostVisit(Graph G, int v) {
		  out.append(v + "pos "); // subject to the application 
		}
		
		 public boolean isCyclic(Graph G, int start) {
			
			 ADTStack<Integer> stack = new AStack<Integer>(G.N());
				stack.push(start);
				while(stack.length()>0) {	
					int v = stack.topValue();
					stack.pop();
					G.setMark(v, VISITED);
					if(((Graphm) G).incrCount(v)>1)
						return true;
					int temp = v; 
					for (int w = G.First(temp); w < G.N(); w = G.Next(temp,w)) {
					    if (G.getMark(w) == UNVISITED) { // Put next to stack   	
					    	stack.push(w);
					    	G.setMark(w, VISITED);  	
					    	int k = G.First(w); 
					    	while(k<G.N()) {
					    		 if (G.getMark(k) == UNVISITED) {
					    			 G.setMark(k, VISITED);
					    			 stack.push(k);
					    			 temp = k;
					    			 break;
					    		 }
					    		 k = G.Next(w, k);
					    	}
					    }
					    if(((Graphm) G).incrCount(w)>1)
							return true;
					 }
				}
			 return false;
		 }
		
	static StringBuffer out;
	

	  public void setUp()
	  {
	    out = new StringBuffer(100);
	  }
	
	 public void testisPrerequisite() throws IOException{
			BufferedReader f;
			f = new BufferedReader(new InputStreamReader(new FileInputStream("coen_course.gph")));
			Graph G = new Graphm();
			createGraph(f, G);
			
	}
	 
	  public void testGetPrerequisitePath() throws IOException{
		  
		  	BufferedReader f;
			f = new BufferedReader(new InputStreamReader(new FileInputStream("coen_course.gph")));
			Graph G = new Graphm();
			createGraph(f, G);

	  }
	  

}
