
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class removePackage {

	public static void main(String[] args) {
		File old_file = new File(args[0]);
		
		
		try {
			Scanner sc = new Scanner(old_file);
			
			
			
			String next;
			String file="";
			int count=0;
			boolean package_found = false;

			while(sc.hasNextLine()) {
				
				next = sc.nextLine();
				count++;

				if (count > 20 && !package_found){
					System.exit(0);
				}
				
				if (next.contains("package ")) {
					package_found = true;
					continue;
				}

				file+=next+"\n";


			}

			FileWriter fw = new FileWriter(old_file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(file);
			bw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
