package genericsClassExample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.teksystems.coffee.MenuItem;

public class Generics {

	public static void main(String[] args) {

		List<String> list1 = new ArrayList<String>();
		list1.add("String 1");
		list1.add("String 2");
		list1.add("String 3");
		printList(list1);

		List<String> list2 = new ArrayList<>();
		list2.add("String 4");
		list2.add("String 5");
		list2.add("String 6");
		printList(list2);

		list1.addAll(list2);
		printList(list1);

		list1.remove(4);
		printList(list1);

		String a = list1.get(3);
		System.out.println("\na = " + a);

		if (list1.contains("String 1")) {
			System.out.println("\nList 1 contains String 1");
		}

		list1.add(1, "Inserted String");
		printList(list1);

		String[] arr = new String[5];
		arr[0] = "Java";
		arr[1] = "Python";
		arr[2] = "JavaScript";
		arr[3] = "ReactJs";

		List<String> listObj = Arrays.asList(arr);
		printList(listObj);

		// -------------------------------------------------
		List<String> list = new ArrayList<>();
		list.add("position 0");
		list.add("position 1");
		list.add("position 0");
		list.add("position 0");
		list.add("position 0");
		list.add("position 0");
		printList(list);

		// a set is unordered and will not allow duplicates
		Set<String> set = new HashSet<>();
		set.add("position 0");
		set.add("position 1");
		set.add("position 0");
		set.add("position 0");
		printList(list);

		// a hashmap is a key value pair
		HashMap<String, String> map = new HashMap<>();
		map.put("eric", "Eric Heilig");
		map.put("londen", "Londen Haskins");

		System.out.println(map.get("eric"));
		System.out.println(map.get("londen"));
		// someone does not exist in map as key so it returns null;
		System.out.println(map.get("someone"));

		System.out.println("############################");
		HashMap<String, Integer> grades = new HashMap<>();
		grades.put("eric", 100);
		grades.put("joe", 90);
		System.out.println(grades.get("eric"));
		System.out.println(grades.get("joe"));

		// map of menu items
		HashMap<String, MenuItem> menuItems = new HashMap<>();
		menuItems.put("lemonade", new MenuItem("lemonade", "drink", 0.85));
		menuItems.put("juice", new MenuItem("cranberry juice", "drink", 3.36));
		// at this point the juice will be cranberry
		System.out.println("1) Item name is " + menuItems.get("juice").getItem());

		// now we add another menu item with the same key .. which overwrites cranberry
		// with apple
		menuItems.put("juice", new MenuItem("apple juice", "drink", 2.36));

		MenuItem item1 = menuItems.get("juice");
		System.out.println("2) Item name is " + item1.getItem());

		MenuItem item = menuItems.get("lemonade");
		System.out.println("3) Item name is " + item.getItem());

	}

	public static void printList(List<String> list) {
		System.out.println("-----------");
		for (String s : list) {
			System.out.println(s);
		}

	}

}
