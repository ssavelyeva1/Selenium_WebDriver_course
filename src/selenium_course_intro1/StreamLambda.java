package selenium_course_intro1;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class StreamLambda {

	@Test
	public static void main(String[] args) {

		// counting the number of names starting with A in the list
		ArrayList<String> names = new ArrayList<String>();
		names.add("Anna");
		names.add("Arnold");
		names.add("Don");
		names.add("Aliaksandra");
		names.add("Mark");
		names.add("Clint");

		int count = 0;
		for (int i = 0; i < names.size(); i++) {
			// checking if the name in the list starts with letter 'A'
			String name = names.get(i);
			if (name.startsWith("A")) {
				count++;
			}
		}

		System.out.println(count);

	}

	@Test
	public void streamFilter() {

		ArrayList<String> names = new ArrayList<String>();
		names.add("Anna");
		names.add("Arnold");
		names.add("Don");
		names.add("Aliaksandra");
		names.add("Mark");
		names.add("Clint");

		// counting names starting with A
		Long c = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(c);

		// doing the same
		Stream<String> d = Stream.of("Anna", "Arnold", "Don", "Aliaksandra", "Mark", "Clint").filter(s -> {
			s.startsWith("A");
			return true;
		});
		System.out.println(d);

		// printing all the names of ArrayList
		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println());

	}

}
