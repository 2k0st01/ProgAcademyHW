package homework;

import java.util.Arrays;
import java.util.Comparator;

public class Group {

	private String groupName;
	private Student[] studens = new Student[10];

	public Group(String groupName) {
		super();
		this.groupName = groupName;
	}

	public Group() {
		super();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public Student[] getStudens() {
		return studens;
	}

	public void setStudens(Student[] studens) {
		this.studens = studens;
	}

	public void addStudent(Student student) throws GroupOverflowException {
		for (int i = 0; i < studens.length + 1; i++) {
			if (i >= studens.length) {
				throw new GroupOverflowException("Group over flow. Alread full");
			} else if (studens[i] == null) {
				studens[i] = student;
				return;
			}
		}
	}

	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		for (int i = 0; i < studens.length; i++) {
			if (studens[i] != null && studens[i].getLastName().equals(lastName)){
				return studens[i];
			}
		}
		throw new StudentNotFoundException("We are dont have this student in this group");
	}

	public boolean removeStudentByID(int id) {
		for (int i = 0; i < studens.length; i++) {
			if (studens[i].getId() == id) {
				studens[i] = null;
				return true;
			}
		}
		return false;
	}
	public void showAllStudents() {
		for(Student st : studens) {
			System.out.println(st);
		}
	}
	
	public void sortStudentsByLastName(){
		Arrays.sort(studens, Comparator.nullsFirst(new SortStudensByName()));
	}
	
	@Override
	public String toString() {
		return "Group [groupName=" + groupName + ", studens=" + Arrays.toString(studens) + "]";
	}
	
	
}
