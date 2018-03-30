package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = null;
		if (args.length == 0) {
			scanner = new Scanner(System.in);
		} else {
			try {
				scanner = new Scanner(new File(args[0]));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		while (scanner.hasNext()) {
			System.out.println(scanner.nextLine());
		}
	}
	
}
