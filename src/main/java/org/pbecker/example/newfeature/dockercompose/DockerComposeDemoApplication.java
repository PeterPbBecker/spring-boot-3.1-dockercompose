package org.pbecker.example.newfeature.dockercompose;

import org.pbecker.example.newfeature.dockercompose.domain.Person;
import org.pbecker.example.newfeature.dockercompose.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class DockerComposeDemoApplication implements ApplicationListener<ApplicationReadyEvent> {

	public static void main(String[] args) {
		SpringApplication.run(DockerComposeDemoApplication.class, args);
	}

	@Autowired
	PersonRepository personRepository;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		if (personRepository.count() == 0) {
			personRepository.save(new Person(null, "Max", "Mustermann", 24));
			personRepository.save(new Person(null, "Adam", "Riese", 34));
			personRepository.save(new Person(null, "Eva", "Klein", 55));
			personRepository.save(new Person(null, "John", "Doe", 30));
		}
	}
}
