package my.project.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

// @Component("fileFortuneService")
@Component //default name - its fileFortuneService
public class FileFortuneService implements FortuneService {
	File file;
	List<String> motivators;
	
	public FileFortuneService() {
		System.out.println(this.getClass().getSimpleName() + ": running default constructor");
//		file = new File("src/FileFortuneServiceMotivators.txt");
//		if (file.exists()) {
//			motivators = new ArrayList<String>();
//			try(BufferedReader br = new BufferedReader(new FileReader(file))) {
//			    String line = br.readLine();
//			    while (line != null) {
//			    	motivators.add(line);
//			        line = br.readLine();
//			    }
//			}
//		}
	}
	
	@PostConstruct
	public void readFortunesFromFile() throws FileNotFoundException, IOException {
		System.out.println(this.getClass().getSimpleName() + " - inside method readFortunesFromFile() invoked by @PostConstruct annotation");
		file = new File("src/FileFortuneServiceMotivators.txt");
		if (file.exists()) {
			motivators = new ArrayList<String>();
			try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			    String line = br.readLine();
			    while (line != null) {
			    	motivators.add(line);
			        line = br.readLine();
			    }
			}
		}

	}
	@Override
	public String getFortune() {
		Random rand = new Random();
		
		return this.getClass().getSimpleName() + " says: " + motivators.get(rand.nextInt(motivators.size())) + " cheers from file fortune service!";
	}

}
