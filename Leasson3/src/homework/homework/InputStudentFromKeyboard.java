package homework;

import java.util.Scanner;

public class InputStudentFromKeyboard {

	public Student readStudent() {
		Scanner sc = new Scanner(System.in);

		Student newSt = new Student(null, null, null, 0, null);

		System.out.println("Write Name for student: ");
		newSt.setName(sc.nextLine());

		System.out.println("Write Last Name for student: ");
		newSt.setLastName(sc.nextLine());

		System.out.println("Write Gender of student(MALE/FEMALE): ");
		if (sc.nextLine().equals(Gender.MALE.name())) {
			newSt.setGender(Gender.MALE);
		} else {
			newSt.setGender(Gender.FEMALE);
		}

		System.out.println("Write Id for student: ");
		newSt.setId(sc.nextInt());

		System.out.println("Write Group name for student: ");
		sc.nextLine();
		newSt.setGroupName(sc.nextLine());

		return newSt;
	}

	public boolean addNewStudent(Group group) {
		try {
			group.addStudent(readStudent());
			return true;
		} catch (GroupOverflowException e) {
			System.out.println("Group over flow. Already full");
			return false;
		}

	}
}
