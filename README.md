### Assignment 3 Description

**Objective:**
Develop a program to manage and query the prerequisites of COEN courses using graph data structures and algorithms.

**Tasks:**
1. **Graph File Creation (5 marks):**
   - Create a file named `coen_course.gph` that represents COEN courses and their prerequisites. Each course is a node, and prerequisites are edges between nodes.

2. **Graph Class Implementation (30 marks):**
   - Implement a graph class that reads `coen_course.gph` and stores course relationships.
   - Implement two methods:
     1. **Get Prerequisite Path:**
        - Method: `public string getPrerequisistePath(string courseCode)`
        - Returns the sequence of prerequisite courses for a given course.
     2. **Check Prerequisite:**
        - Method: `public boolean isPrerequisite(string sourceCourse, string destinationCourse)`
        - Checks if one course is a prerequisite for another.

3. **Test Cases (20 marks):**
   - Develop test cases for the two methods:
     1. Test `getPrerequisistePath()`
     2. Test `isPrerequisite()`

**Submission Requirements:**
- Include all source code for tasks 1, 2, and 3.
- Include the graph file `coen_course.gph`.
- Provide screenshots of running the test cases as a PDF.
- Archive all files into a single `.z`, `.gz`, `.tar`, or `.zip` file following the naming convention `[SID_1]_[SID_2]_A3.zip`.
