package A3;

interface Graph {
	
	  public void Initial(int n);       											// Initialize to n vertices
	  public int N();                												// Number of vertices
	  public int E();																// Number of edges
	  
	  public int First(int v);       												// Get v's first neighbor
	  public int Next(int v, int w); 												// Get v's next neighbor
	  public int Weight(int i, int j); 												// weight
	  public void setEdge(int i, int j, int wght); 									// Set weight
	  public void deleteEdge(int i, int j);   											// Delete edge (i, j)
	  public boolean isEdge(int i, int j); 											// If (i,j) an edge?
	  public void setMark(int v, int val); 											// Set Mark for v
	  public int getMark(int v);           											// Get Mark for v
	  
	  public boolean isPrerequisite(String SourceCourse, String destinationCourse); // determines if the course is a prerequisite of the other
	  public String getPrerequisitePath(String CourseCode); 						//returns the path of prerequisites for a course 
	  public int getIndex(String coencourse); 										// getting the index
	  public String [] getPrerequisites(String CourseCode);
	  public String getCourse(int Index); 											//returns the course code based on index

}
