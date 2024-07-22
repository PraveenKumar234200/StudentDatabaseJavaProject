package project;

public class Student {
private int rollNumber;
private int marks;

// constructor
public Student(int rollNumber, int marks) {
    this.rollNumber = rollNumber;
    this.marks = marks;
}
//Getter and setter are used to enter students roll number and marks
public int getRollNumber() {
	return rollNumber;
}
public void setRollNumber(int rollNumber) {
	this.rollNumber = rollNumber;
}
public int getMarks() {
	return marks;
}
public void setMarks(int marks) {
	this.marks = marks;
}
}
