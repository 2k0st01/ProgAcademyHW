package homework9afis;

import java.util.Comparator;

public class SortStudensByName implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Student st1 = (Student) o1;
		Student st2 = (Student) o2;
		
		String name1 = st1.getLastName();
		String name2 = st2.getLastName();
		
		if(name1.compareTo(name2) > 0) {
			return 1;
		}
		if(name1.compareTo(name2) < 0) {
			return -1;
		} 
		return 0;
	}

}
