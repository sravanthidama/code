package dictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class FileDictionary {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.print("Enter File Path:"); // Existing File Path
												// "config\\data.txt"
		Scanner scanner = new Scanner(System.in);
		String filePath = scanner.next();
		if (doesFileExist(filePath)) {
			readAndPrintTheFileData(filePath);
		}
	}

	private static boolean doesFileExist(String filePath) {
		try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
			System.out.println("File Found");
			return true;
		} catch (IOException e) {
			System.out.println("File Not Found. Please Enter the correct path");
			return false;
		}

	}

	private static void readAndPrintTheFileData(String path) {
		try (Stream<String> stream = Files.lines(Paths.get(path))) {
			stream.forEach(FileDictionary::printData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void printData(String line) {
		if (line != null) {
			String[] array = line.split("-");
			String word = array[0];
			String meaning = array[1];
			String[] meanings = meaning.split(",");
			System.out.println(word);
			for (int i = 0; i < meanings.length; i++) {
				System.out.println(meanings[i].trim());
			}
		}
	}

}
