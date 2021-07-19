package api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
// @SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ApplicationStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  SpringApplication.run(ApplicationStart.class, args);
	}

}
