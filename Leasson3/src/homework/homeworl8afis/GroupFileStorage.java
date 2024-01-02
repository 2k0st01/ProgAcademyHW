package homeworl8afis;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GroupFileStorage {
	public void saveGroupToCSV(Group gr) {

		try (PrintWriter pw = new PrintWriter(new File(gr.getGroupName() + ".csv"))) {
			for (int i = 0; i < gr.getStudens().length; i++) {
				if (gr.getStudens()[i] != null) {
					pw.println(gr.getStudens()[i].getName() + ";" + gr.getStudens()[i].getLastName() + ";"
							+ gr.getStudens()[i].getGender() + ";" + gr.getStudens()[i].getId() + ";"
							+ gr.getStudens()[i].getGroupName());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Group loadGroupFromCSV(File file) {
		Group gr = new Group(file.getName().substring(0, file.getName().lastIndexOf(".")));
		String tempText = "";
		try (Scanner sc = new Scanner(file)) {
			for (; sc.hasNextLine();) {
				tempText += sc.nextLine() + System.lineSeparator();
			}
		} catch (IOException e) {
			System.out.println(e);
		}

		String[] allStudents = tempText.split(System.lineSeparator());

		for (int i = 0; i < allStudents.length; i++) {
			String oneSt = allStudents[i];
			String[] student = oneSt.split("[;]");
			try {
				Student stud = new Student(student[0], student[1], Gender.valueOf(student[2]), Integer.valueOf(student[3]), student[4]);
				stud.setGroupName(student[4]);
				gr.addStudent(stud);
			} catch (GroupOverflowException e) {
				e.printStackTrace();
			}
		}
		return gr;
	}

	public File findFileByGroupName(String groupName, File workFolder) {
		File[] files = workFolder.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile() && files[i].getName().equals(groupName + ".csv")) {
				System.out.println("File " + groupName + ".csv was found in " + workFolder);
				return files[i];
			}
		}
		System.out.println("File " + groupName + ".csv was not found in " + workFolder);
		return null;
	}
}
