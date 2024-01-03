package homework9afis;

import java.util.*;

public class Group {

	private String groupName;
	private List<Student> students = new ArrayList<>();

	public Group(String groupName) {
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudens(List<Student> studens) {
		this.students = studens;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Group group = (Group) o;
		return Objects.equals(groupName, group.groupName) && Objects.equals(students, group.students);
	}

	@Override
	public int hashCode() {
		return Objects.hash(groupName, students);
	}

	public boolean equivalentStudents() {
		for (int i = 0; i < students.size() - 1; i++) {
			for (int j = i + 1; j < students.size(); j++) {
				if (students.get(i) != null && students.get(i).equals(students.get(j))) {
					System.out.println("Students " + (i+1) + " and " + (j+1) + " are equivalent.");
					return true;
				}
			}
		}
		return false;
	}

	public void addStudent(Student student) throws GroupOverflowException {
			if (students.size() >= 10) {
				throw new GroupOverflowException("Group over flow. Already full");
			} else {
				students.add(student);
			}
	}

	public Student searchStudentByLastName(String lastName) throws StudentNotFoundException {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i) != null && students.get(i).getLastName().equals(lastName)){
				return students.get(i);
			}
		}
		throw new StudentNotFoundException("We are dont have this student in this group");
	}

	public boolean removeStudentByID(int id) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == id) {
				students.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public void sortStudentsByLastName(){
		Collections.sort(students, Comparator.nullsFirst(new SortStudensByName()));
	}

	@Override
	public String toString() {
		return "Group{" +
				"groupName='" + groupName + '\'' +
				", students=" + students +
				'}';
	}
}
