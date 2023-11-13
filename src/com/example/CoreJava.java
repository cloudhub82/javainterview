package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CoreJava {

	public static void main(String[] args) {

		IntStream is3 = IntStream.range(0, 5); // 0,1,2,3,4 = 5 numbers
		double avg2 = is3.average().orElse(0); // 0+1+2+3+4 = 10/5 = 2.0
		System.out.println(avg2);

	}

	private static List<Organization> getOrgData(List<Organization> lstOrg) {
		try (Stream<String> stream = Files.lines(Paths.get("org.txt"))) {
			stream.filter(line -> !line.split("\\|")[0].equals("Index")).limit(10000).forEach(line -> {
				String[] org = line.split("\\|");
				lstOrg.add(new Organization(Integer.parseInt(org[0]), org[1], org[2], org[3], org[4], org[5],
						Integer.parseInt(org[6]), org[7], Long.parseLong(org[8])));
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

		return lstOrg;
	}

	private static void getEmpData() {
		try (Stream<String> stream = Files.lines(Paths.get("HRA-50000.txt"))) {
			stream.filter(line -> line.split("\\`")[0].equals("Emp ID")).limit(2).forEach(line -> {
				String[] org = line.split("\\`");

				Arrays.stream(org).forEach(s -> System.out.println(s));

			});

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void m1() {
		/*
		 * Object obj = new String("Durga"); StringBuffer sb = (StringBuffer)obj;
		 * System.out.println(sb);
		 */

		Map<String, String> map = new HashMap<>();

		map.put("java", "Head First");
		map.put("sql", "Learning SQL");
		map.put("c++", "Yeswant Kanitkar");
		map.put("python", "Hard Way");

		map.entrySet().forEach(e -> System.out.println(e.getValue()));

		/*
		 * for(Entry<String, String> s :map.entrySet()) {
		 * 
		 * }
		 */
	}

}
