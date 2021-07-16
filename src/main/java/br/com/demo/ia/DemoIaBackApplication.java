package br.com.demo.ia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(
	scanBasePackages = {
		"br.com.demo.ia.repository", 
		"br.com.demo.ia.domain"
})
@EnableTransactionManagement
public class DemoIaBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoIaBackApplication.class, args);
	}

}
