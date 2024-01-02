package homework;

import java.io.File;

public class Main {

	public static void main(String[] args) throws GroupOverflowException, StudentNotFoundException {
		Group group = new Group("First");

		Student st1 = new Student("Stanislav", "Kosto", Gender.MALE, 1, "First");
		Student st2 = new Student("Audrey", "Cross", Gender.MALE, 2, "Second");
		Student st3 = new Student("Nancy", "Brown", Gender.FEMALE, 3, "First");
		Student st4 = new Student("Nancy", "Brown", Gender.FEMALE, 3, "First");

		InputStudentFromKeyboard isfk = new InputStudentFromKeyboard();

		GroupFileStorage gfs = new GroupFileStorage();

		group.addStudent(st1);
		group.addStudent(st2);
		group.addStudent(st3);
		group.addStudent(st4);

//		System.out.println(group.searchStudentByLastName("Kosto"));

		System.out.println(group.equivalentStudents());



	}

}
