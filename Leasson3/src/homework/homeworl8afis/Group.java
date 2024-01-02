package homeworl8afis;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Group {

	private String groupName;
	private Student[] students = new Student[10];

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
		return students;
	}

	public void setStudens(Student[] studens) {
		this.students = studens;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Group group = (Group) o;
		return Objects.equals(groupName, group.groupName) && Arrays.equals(students, group.students);
	}

	@Override
	public int hashCode() {
		int result = Objects.hash(groupName);
		result = 31 * result + Arrays.hashCode(students);
		return result;
	}

	public boolean equivalentStudents() {
		for (int i = 0; i < students.length - 1; i++) {
			for (int j = i + 1; j < students.length; j++) {
				if (students[i] != null && students[i].equals(students[j])) {
					System.out.println("Students " + (i+1) + " and " + (j+1) + " are equivalent.");
					return true;
				}
			}
		}
		return false;
	}

	public void addStudent(Student student) throws GroupOverflowException {
		for (int i = 0; i < students.length + 1; i++) {
			if (i >= students.length) {
				throw new GroupOverflowException("Group over flow. Alread full");
			} else if (students[i] == null) {
				students[i] = student;
				return;
			}
		}
	}

	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getLastName().equals(lastName)){
				return students[i];
			}
		}
		throw new StudentNotFoundException("We are dont have this student in this group");
	}

	public boolean removeStudentByID(int id) {
		for (int i = 0; i < students.length; i++) {
			if (students[i].getId() == id) {
				students[i] = null;
				return true;
			}
		}
		return false;
	}
	public void showAllStudents() {
		for(Student st : students) {
			System.out.println(st);
		}
	}
	
	public void sortStudentsByLastName(){
		Arrays.sort(students, Comparator.nullsFirst(new SortStudensByName()));
	}
	
	@Override
	public String toString() {
		return "Group [groupName=" + groupName + ", studens=" + Arrays.toString(students) + "]";
	}
	
	
}
