package com.example.persondog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class PersondogApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersondogApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(PersonRepository personRepository,
											   DogRepository dogRepository, CustodyRepository custodyRepository) {
		return args -> {
			Person person = Person.builder()
					.id("1pers")
					.name("Fra")
					.age(35)
					.build();

			personRepository.save(person);

			Person person2 = Person.builder()
					.id("2pers")
					.name("Lucia")
					.age(69)
					.build();

			personRepository.save(person2);

			Person person3 = Person.builder()
					.id("3pers")
					.name("LLuc")
					.age(38)
					.build();

			personRepository.save(person3);


			Dog dog = Dog.builder()
					.id("1dog")
					.name("Madu")
					.breed("Golden Retriever")
					.age(2)
					.build();

			dogRepository.save(dog);

			Dog dog2 = Dog.builder()
					.id("2dog")
					.name("Chan")
					.breed("Anatolian Shepherd Dog")
					.age(5)
					.build();

			dogRepository.save(dog2);

			Dog dog3 = Dog.builder()
					.id("3dog")
					.name("Luna")
					.breed("Mixed")
					.age(8)
					.build();

			dogRepository.save(dog3);

			Custody custody = Custody.builder()
					.id("1adopt")
					.date (LocalDate.of(2024, 12, 28))
					.contract("contract")
					.fee(0)
					.person(person)
					.dog(dog)
					.build();

			custodyRepository.save(custody);

			Custody custody2 = Custody.builder()
					.id("2adopt")
					.date (LocalDate.of(2020, 7, 1))
					.contract("contract")
					.fee(0)
					.person(person2)
					.dog(dog2)
					.build();

			custodyRepository.save(custody2);

			Custody custody3 = Custody.builder()
					.id("3adopt")
					.date (LocalDate.of(2018, 11, 14))
					.contract("contract")
					.fee(0)
					.person(person2)
					.dog(dog3)
					.build();

			custodyRepository.save(custody3);



			System.out.println("Person saved: " + personRepository.findById("1pers"));
			System.out.println("Dog saved: " + dogRepository.findById("1dog"));
		};
	}

}
