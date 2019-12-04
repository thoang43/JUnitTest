import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Runner {

	public static void main(String[] args) {
		File draft_file = new File(args[0]);
		File result_file = new File(args[1]);
		
		try {
			Scanner sc = new Scanner(draft_file);
			FileWriter fw = new FileWriter(result_file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			String last=sc.nextLine();
			String current=sc.nextLine();
			
			bw.write(last + "\n");
			
			bw.write(current + "\n");
			
			String next="";
			while(sc.hasNextLine()) {
				
				next = sc.nextLine();

				
				if(!next.trim().startsWith("at")
					&& !next.trim().startsWith("Started")
					&& !next.trim().startsWith("Finished")
					&& !next.trim().contains("Exception:")) {
					bw.write(next + "\n");
				}
				if(next.contains("Exception")){
					bw.write(last + "\n");
					bw.write(current + "\n");
					bw.write(next + "\n");
				}

				last = current;
				current = next;

			}
			bw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
