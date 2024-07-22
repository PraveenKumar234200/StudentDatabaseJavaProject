package project;

public class Teacher {
private String name;
private String subject;

// constructor
public Teacher(String name, String subject) {
    this.name = name;
    this.subject = subject;
    
}
//Getter and setter are used to store teacher name and subject
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}

}
