package A3;
/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/
import java.lang.String;

import java.util.Stack;

class Graphm implements Graph  			 // Graph: Adjacency matrix

{ 

  private int [][] matrix;               // The edge matrix
  private int numEdge;                   // Number of edges
  public int[] Mark;                     // The mark array
  public int[] Count;
  public boolean END = false;
  
  static final int UNVISITED = 0;
  static final int VISITED = 1;
  
  
  public Graphm() {}
  public Graphm(int n) {                  // Constructor
    Init(n);
  }

  public void Init(int n) {
    Mark = new int[n];
    Count = new int[n];
    matrix = new int [n][n];
    numEdge = 0;
  }
  
  // function to assign each course to an index 
  public int getIndex(String coencourse)
  {
	
		int index;
		switch (coencourse)
		{
			case "MATH204":
				index = 0;
				break;

			case "COEN243":
				index = 1;
				break;

			case "COEN212":
				index = 2;
				break;

			case "COEN231":
				index = 3;
				break;

			case "COEN311":
				index = 4;
				break;

			case "COEN313":
				index = 5;
				break;

			case "COEN346":
				index = 6;
				break;

			case "COEN352":
				index = 7;
				break;

			case "ENGR290":
				index = 8;
				break;

			case "ELEC311":
				index = 9;
				break;

			case "COEN317":
				index = 10;
				break;

			case "COEN320":
				index = 11;
				break;

			case "SOEN341":
				index = 12;
				break;

			case "ELEC372":
				index = 13;
				break;

			case "COEN244":
				index = 14;
				break;

			case "COEN366":
				index = 15;
				break;

			case "ENGR301":
				index = 16;
				break;

			case "ENGR371":
				index = 17;
				break;

			case "COEN390":
				index = 18;
				break;

			case "COEN466":
				index = 19;
				break;

			case "COEN451":
				index = 20;
				break;

			case "COEN316":
				index = 21;
				break;

			case "COEN413":
				index = 22;
				break;

			case "COEN424":
				index = 23;
				break;

			case "COEN432":
				index = 24;
				break;

			case "COEN434":
				index = 25;
				break;

			case "COEN415":
				index = 26;
				break;

			case "COEN433":
				index = 27;
				break;

			case "COEN421":
				index = 28;
				break;

			case "COEN447":
				index = 29;
				break;

			case "COEN422":
				index = 30;
				break;

			case "COEN448":
				index = 31;
				break;

			case "COEN490":
				index = 32;
				break;

			case "COEN446":
				index = 33;
				break;
				
			case "COEN498":
				index = 34;
				break;
				
			case "DEPTMNT":
				index = 35;
				break;

			default:
				index = -1; 
		}
		return index;
	}
  public String getCourse(int Index)
  {
	
		String Course;
		switch (Index)
		{
			case 0:
				Course = "MATH204";
				break;

			case 1:
				Course = "COEN243";
				break;

			case 2:
				Course = "COEN212";
				break;

			case 3:
				Course = "COEN231";
				break;

			case 4:
				Course = "COEN311";
				break;

			case 5:
				Course = "COEN313";
				break;

			case 6:
				Course = "COEN346";
				break;

			case 7:
				Course = "COEN352";
				break;

			case 8:
				Course = "ENGR290";
				break;

			case 9:
				Course = "ELEC311";
				break;

			case 10:
				Course = "COEN317";
				break;

			case 11:
				Course = "COEN320";
				break;

			case 12:
				Course = "SOEN341";
				break;

			case 13:
				Course = "ELEC372";
				break;

			case 14:
				Course = "COEN244";
				break;

			case 15:
				Course = "COEN366";
				break;

			case 16:
				Course = "ENGR301";
				break;

			case 17:
				Course = "ENGR371";
				break;

			case 18:
				Course = "COEN390";
				break;

			case 19:
				Course = "COEN466";
				break;

			case 20:
				Course = "COEN451";
				break;

			case 21:
				Course = "COEN316";
				break;

			case 22:
				Course = "COEN413";
				break;

			case 23:
				Course = "COEN424";
				break;

			case 24:
				Course = "COEN432";
				break;

			case 25:
				Course = "COEN434";
				break;

			case 26:
				Course = "COEN415";
				break;

			case 27:
				Course = "COEN433";
				break;

			case 28:
				Course = "COEN421";
				break;

			case 29:
				Course = "COEN447";
				break;

			case 30:
				Course = "COEN422";
				break;

			case 31:
				Course = "COEN448";
				break;

			case 32:
				Course = "COEN490";
				break;

			case 33:
				Course = "COEN446";
				break;
				
			case 34:
				Course = "COEN498";
				break;
				
			case 35:
				Course = "DEPTMNT";
				break;

			default:
				Course = null; 
		}
		return Course;
	}
  public int n() { return Mark.length; } // # of vertices

  public int e() { return numEdge; }     // # of edges

  public int first(int v) { // Get v's first neighbor
    for (int i=0; i<Mark.length; i++)
      if (matrix[v][i] != 0) return i;
    return Mark.length;  // No edge for this vertex
  }

  public int next(int v, int w) { // Get v's next edge
    for (int i=w+1; i<Mark.length; i++)
      if (matrix[v][i] != 0)
        return i;
    return Mark.length;  // No next edge;
  }

  public boolean isEdge(int i, int j) // Is (i, j) an edge?
    { return matrix[i][j] != 0; }
 
  
  // Set edge weight
  public void setEdge(int i, int j, int wt) {
    assert wt!= 0 : "Cannot set weight to 0";
    if (matrix[i][j] == 0) numEdge++;
    matrix[i][j] = wt;
  }

  public void delEdge(int i, int j) { // Delete edge (i, j)
    if (matrix[i][j] != 0) {
      matrix[i][j] = 0;
      numEdge--;
    }
  }
  
  public int weight(int i, int j) { // Return edge weight
	    if (i == j) return 0;
	    if (matrix[i][j] == 0) return Integer.MAX_VALUE;
	    return matrix[i][j];
	  }

  // Get and set marks
  public void setMark(int v, int val) { Mark[v] = val; }
  public int getMark(int v) { return Mark[v]; }
  
  public int incrCount(int w) {return ++Count[w];}
  
  public boolean isPrerequisite(String SourceCourse, String destinationCourse)
  {
	  int CourseSource = getIndex(SourceCourse); 
	  int CourseDestination = getIndex(destinationCourse);
 
	  if (CourseSource == -1)
	  {
		  System.out.println("invalid Course");
		  return false; 
	  }
	  
	  if (CourseDestination == -1)
	  {
		  System.out.println("invalid Course");
		  return false; 
	  }
	 return isEdge(CourseSource,CourseDestination); 
	  
  }
  
  public String []  getPrerequisites(String CourseCode) {
	  
	  String [] result = new String [this.n()];
	  
	  int counter =0;
	  int CourseIndex = getIndex(CourseCode);
	  int index = 0;
	  for(int j=0; j< n();j++)
	  {
		  if(this.isEdge(j, CourseIndex)) {
			  result[index] = getCourse(j);
			  index++;
			  
		  }
			
	  }
	  
	  for(int i =0; i<result.length ;i++) {
		  
		  if(result[i] != null) {
			  counter++;
		  }
		  
	  }
	  
	  String[] returned = new String[counter];
	  
	  for(int i=0; i<counter;i++) {
		  
		  returned[i] = result[i];
	  }
	  return returned; 
  }

  public String getPrerequisitePath(String CourseCode) {
	  
	  Stack <String> stack = new Stack<> ();
	  Stack<String>  path = new Stack<>();
	  
	  int counter =0;
	  
	  stack.push(CourseCode);
	  path.push(CourseCode);
	  
	  String ret_path = "";

	  while(!stack.empty()) {
		
		  
		  String visiting = stack.pop();
		  
		  String [] prereqs = getPrerequisites(visiting);
		  
		  for(String p: prereqs) {
			  if(getMark(getIndex(p)) == UNVISITED) {
				  getPrerequisitePath(p);
			  }
			  counter++;
			  if(counter == prereqs.length)
			  {
				  END = true;
			  }
		  }
		  if(prereqs != null) {
			  
			  for(int i=0; i<prereqs.length;i++) {
				  
			
				  
				  if(getMark(getIndex(prereqs[i])) == UNVISITED){
					  path.push(prereqs[i]);
					  stack.push(prereqs[i]);
					  setMark(getIndex(prereqs[i]),VISITED);
				 }
				 
				  
			  }
		  }
	  }
	  
	  String temp;
	  while(!path.empty()) {
		  
		  for(int i = 0; i< path.size();i++)
		  {
			  temp = path.pop();
			  if(!ret_path.contains(temp)) {
				  ret_path += temp;
				  ret_path += " ";
			  }
				  
		  }
	  }
	  
	  if(END) {
		  for(int i=0; i< n();i++)
		   {
			setMark(i,UNVISITED);
		   }
	  }

	  return ret_path; 
  }
@Override
public void Initial(int n) {
	// TODO Auto-generated method stub
	
}
@Override
public int N() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public int E() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public int First(int v) {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public int Next(int v, int w) {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public int Weight(int i, int j) {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public void deleteEdge(int i, int j) {
	// TODO Auto-generated method stub
	
}
}
