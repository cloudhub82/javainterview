package com.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercise {

	public static void main(String[] args) {

		List<Integer> ls = Arrays.asList(11, 12, 22, 33, 33, 55, 66);
	}

	private static void optionalTest() {
		Optional<Double> price = Optional.ofNullable(null);
		price.orElseThrow(() -> new RuntimeException("Bad Code1"));// java.lang.RuntimeException: Bad Code

		List<AnotherBook> books = Arrays.asList(new AnotherBook("Gone with the wind", "Fiction"),
				new AnotherBook("Bourne Ultimatum", "Thriller"), new AnotherBook("The Client", "Thriller"));
		List<String> genreList = new ArrayList<>();

		// genreList=books.stream().map(l->l.getGenre()).collect(Collectors.toList());
		// books.stream().map(l->l.getGenre()).forEach(genreList::add);
		books.stream().map(l -> l.getGenre()).forEach(b -> genreList.add(b));
		System.out.println(genreList);
	}

	private static void mapToDoubleTest() {
		List<Person> friends = Arrays.asList(new Person("Bob", "Kelly", 31), new Person("Paul", "Landers", 32),
				new Person("John", "Paters", 33));
		double averageAge = friends.stream().filter(f -> f.getAge() < 3).mapToInt(i -> i.getAge()).average()
				.orElse(0.0);
		System.out.println(averageAge);
	}

	private static void toMapTest() {
		List<Book> books = Arrays.asList(new Book("Atlas Shrugged", 10.0), new Book("Freedom at Midnight", 5.0),
				new Book("Gone with the wind", 5.0));

		Map<String, Double> bookMap = books.stream().collect(Collectors.toMap(p -> p.getTitle(), p -> p.getPrice()));
		bookMap.forEach((a, b) -> {
			if (a.startsWith("A")) {
				System.out.println(b);
			}
		});

		List<Book> books1 = Arrays.asList(new Book("Gone with the wind", 10.0), new Book("Gone with the wind", 20.0),
				new Book("Atlas Shrugged", 15.0));

		books1.stream()
				// .collect(Collectors.toMap((b->b.getTitle()), b->b.getPrice())) //
				// IllegalStateException
				.collect(Collectors.toMap((b -> b.getTitle()), b -> b.getPrice(), (v1, v2) -> v1 + v2)) // If duplicate
																										// found then
																										// value will be
																										// added for
																										// same key
				.forEach((a, b) -> System.out.println(a + " " + b));

	}

	private static void testOptional() {
		Optional<String> grade1 = getGrade(50);
		Optional<String> grade2 = getGrade(77);
		System.out.println(grade1.orElse("UNKNOWN"));

		// if (grade2.isPresent()) {
		grade2.ifPresentOrElse((value) -> {
			System.out.println("Found value:  " + value);
		}, () -> {
			System.out.println("Empty");
		});
		// }
	}

	public static Optional<String> getGrade(int marks) {

		Optional<String> grade = Optional.empty();
		if (marks > 50) {
			grade = Optional.of("PASS");
		} else {
			Optional.of("FAIL");
		}

		return grade;

	}

	private static void testFlatMap() {
		Stream<List<String>> lstStream1 = Stream.of(Arrays.asList("a", "b"), Arrays.asList("a", "c"));

		Stream<List<String>> lstStream2 = Stream.of(Arrays.asList("x", "y"), Arrays.asList("x", "y"));

		Stream<List<String>> lstStream3 = Stream.of(Arrays.asList("p", "q"), Arrays.asList("p", "q"));

		Stream.of(lstStream1, lstStream2, lstStream3).flatMap(ls -> ls.filter(v -> v.contains("c")))
				.forEach(System.out::println);
		;

		lstStream1.filter(lst -> lst.contains("c")).flatMap(l -> l.stream()).forEach(System.out::println);

		List<Book> lstBook = Arrays.asList(new Book("Thinking in Java", 30.0), new Book("Java in 24 hrs”", 20.0),
				new Book("Java Recipes", 10.0));
		List<Book> lstBook2 = Arrays.asList(new Book("Thinking in Java2", 300.0), new Book("Java in 24 hrs2”", 200.0),
				new Book("Java Recipes2", 100.0));
		Stream<List<Book>> lstStream = Stream.of(lstBook, lstBook2);

		System.out.println(
				lstStream.flatMapToDouble(lst -> lst.stream().mapToDouble(b -> b.getPrice())).average().orElse(0.0));

		System.out.println(lstBook.stream().filter(b -> b.getPrice() > 10.0)
				.flatMapToDouble(p -> DoubleStream.of(p.getPrice())).average().orElse(0.0));

		System.out.println(
				lstBook.stream().filter(b -> b.getPrice() > 10.0).mapToDouble(p -> p.getPrice()).average().orElse(0.0));
	}

	private static void getSorted() {
		/*
		 * Stream the list and sort it so that it outputs “BoltNailScrew” i.e.
		 * alphabetic name order. Use Stream’s forEach method to output the names
		 */
		List<Item> lstItem = new ArrayList<>();
		lstItem.add(new Item(1, "Screw"));
		lstItem.add(new Item(2, "Nail"));
		lstItem.add(new Item(3, "Bolt"));

		/*
		 * lstItem.stream().sorted((i1,i2)->i1.getName().compareTo(i2.getName())).
		 * forEach(System.out::print);
		 */

		lstItem.stream().sorted(Comparator.comparing(a -> a.getName())).forEach(System.out::print);
		List<Person> lstPerson = Arrays.asList(new Person("Alan", "Burke", 22), new Person("Zoe", "Peters", 60),
				new Person("Peter", "Castle", 29));
		// Oldest Person
		System.out.println(lstPerson.stream().max((p1, p2) -> p1.getAge() - p2.getAge()).get());
		System.out.println(lstPerson.stream().max(Comparator.comparing(Person::getAge)).get());

		IntStream iSTream1 = IntStream.of(10, 47, 33, 23);
		IntStream iSTream2 = IntStream.of(10, 47, 33, 23);
		IntStream iSTream3 = IntStream.of(10, 47, 33, 23);
		System.out.println(iSTream1.reduce((l1, l2) -> (l1 - l2) > -1 ? l1 : l2)); // OutPut OptionalInt[47]
		System.out.println(iSTream2.reduce((l1, l2) -> Integer.max(l1, l2)));// OutPut OptionalInt[47]
		System.out.println(iSTream3.reduce(Integer.MIN_VALUE, (l1, l2) -> Integer.max(l1, l2)));// OutPut 47

		IntStream iSTream5 = IntStream.of(10, 47, 33, 23);
		IntStream iSTream6 = IntStream.of(10, 47, 33, 23);
		System.out.println(iSTream5.reduce(Integer::sum)); // OutPut OptionalInt[113]
		System.out.println(iSTream6.reduce(Integer::max)); // OutPut OptionalInt[47]
	}

}
