package LockedMe.com;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class MainProject {
	// To get the filenames in ascending order
	public static List<String> getFileNames() throws IOException{
		File folderName = new File("C:\\Users\\prava\\Desktop\\java\\MainProjectPhase_1\\ProjectFiles");
		File[] list1 = folderName.listFiles();
		List<String> l1 = new ArrayList<String>();
		for(File i : list1) {
			if(i.isFile()) {
				String s= i.getName();
				int lengthofS = s.length();
				s= s.substring(0,lengthofS-4);
				l1.add(s);
			}
		}
		return l1;
	}
	
	//To create files
	public static void createFile() throws IOException {
        Scanner sc = new Scanner(System.in);
		String filename = sc.next();
		String filename1 = MessageFormat.format("C:\\Users\\prava\\Desktop\\java\\MainProjectPhase_1\\ProjectFiles\\{0}.txt",filename);
		File file1 = new File(filename1);
		if(file1.createNewFile()) {
			System.out.println("File is Created");
		}
		else {
			System.out.println("File is Already Exist");
		}
		FileWriter writer= new FileWriter(filename1,false);
		System.out.println("If you want to add something to this file.");
		System.out.println("1.Yes --->  enter y ");
		System.out.println("2.No  --->  enter n");
		Scanner sc2 = new Scanner(System.in);
		char select = sc2.next().charAt(0);
		if(select == 'y' || select == 'Y') {
		System.out.println("Enter the content you want to write");
		Scanner sc1 = new Scanner(System.in);
		String content = sc1.nextLine();
		writer.write(content);
		writer.close();
		System.out.println("content written in the file succesfully");
		}
		else {
			System.out.println("return to MENU");
		}
	}
	
	//To delete files
	public static void deleteFile() throws IOException {
		Scanner sc = new Scanner(System.in);
		String filename = sc.next();
		String filename1 = MessageFormat.format("C:\\Users\\prava\\Desktop\\java\\MainProjectPhase_1\\ProjectFiles\\{0}.txt",filename);
        Path path = Paths.get(filename1);
			if(Files.deleteIfExists(path))
					System.out.println(filename+"got deleted succesfully....!!!");
			else 
				System.out.println("File not detected");
	}
	
	//To search for a file
	public static void searchFile() throws IOException{
		boolean flag = false;
		System.out.println("Please enter the filename that you want to add: ");
		Scanner sc = new Scanner(System.in);
		String filename = sc.next();
		List l1 = getFileNames();
		for(Object obj  : l1) {
			if(obj.toString().equalsIgnoreCase(filename)) {
				flag = true;
		        System.out.println(obj);
			}
		}
		if(flag) {
			System.out.println("File found");
		}
		else {
			System.out.println("File not found");
		}
		
		
	}
	public static void main(String[] args) {
		boolean exit = true;
		boolean exit1 = true;
		while(exit) {
		System.out.println("Enter Your choice option number from the below list: ");
		System.out.println("          1.Retrive current filenames in ascending order");
		System.out.println("          2.Business-level operation menu");
		System.out.println("          3.Exit from the application");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		switch(option) {
		case 1:
			try {
				System.out.println("List of files are :");
				int i=1;
				List l1 = getFileNames();
				Collections.sort(l1);
				for(Object obj  : l1) {
				    System.out.println(i+". " +obj);
				   i++;
				}
				}
				catch(IOException e) {
				e.printStackTrace();
			    }
			break;
		case 2:
			while(exit1) {
			System.out.println("Enter your choice for business from the below list:");
			System.out.println("          1. Add a file and its content to a directory");
			System.out.println("          2. Delete a file from a directory");
			System.out.println("          3. Searching a file and showing its content");
			System.out.println("          4. Exit from the Business level operation");
			int option1 = sc.nextInt();
			switch(option1) {
			case 1:
				System.out.println("Enter the file you want to add");
				try {
				createFile();
				}
				catch(IOException e) {
				e.printStackTrace();
			    }
				break;
			case 2:
				System.out.println("Enter the file you want to delete");
				try {
					deleteFile();
					}
				catch(NoSuchFileException e) {
					System.out.println("No such file found"+e);
				}
					catch(IOException e) {
					e.printStackTrace();
				    }
				break;
			case 3:
				System.out.println("Enter the file name you want to search");
				try {
					searchFile();
				}
				catch(IOException e) {
					e.printStackTrace();
				    }
				
				break;
				
			case 4:
				System.out.println("Exiting from the business level application........\nReturning to the MENU");
				exit1 = false;
				break;
	       default:
	    	   System.out.println("INVALID OPTION.....\n     PLEASE CHOOSE THE CORRECT OPTION");
			}
			}
			break;
			
			
		case 3:
			System.out.println("Exiting from the application");
			exit = false;
			break;
		default:
	    	   System.out.println("INVALID OPTION.....\n     PLEASE CHOOSE THE CORRECT OPTION");
			
		}
			
	}
	}
}
