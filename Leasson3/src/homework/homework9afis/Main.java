package homework9afis;

public class Main {

	public static void main(String[] args) throws GroupOverflowException, StudentNotFoundException {
		Group group = new Group("First");

		Student st1 = new Student("Stanislav", "Kosto", Gender.MALE, 1, "First");
		Student st2 = new Student("Anastasia", "Berdak", Gender.FEMALE, 2, "First");
		Student st3 = new Student("Vladyslav", "Mendoza", Gender.MALE, 3, "First");
		Student st4 = new Student("Handing", "Nahari", Gender.MALE, 4, "First");

		InputStudentFromKeyboard isfk = new InputStudentFromKeyboard();

		GroupFileStorage gfs = new GroupFileStorage();

		group.addStudent(st1);
		group.addStudent(st2);
		group.addStudent(st3);
		group.addStudent(st4);

		isfk.addNewStudent(group);

		gfs.saveGroupToCSV(group);

		System.out.println(group.searchStudentByLastName("Berdak"));

		System.out.println(group.getStudents());
		group.sortStudentsByLastName();
		System.out.println();
		System.out.println(group.getStudents());




	}

}
