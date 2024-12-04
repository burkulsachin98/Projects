package Project1.Project1;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerator {
	@Test
	 void 	testGenerateDummyData(){
		
	 Faker fk = new Faker();
	 
	 String fullname = fk.name().fullName();
	 String firstName =fk.name().firstName();
	 
	 System.out.println(fullname);
	 System.out.println(firstName);
	}

}
