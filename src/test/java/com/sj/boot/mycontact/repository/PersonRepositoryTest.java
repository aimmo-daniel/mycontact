package com.sj.boot.mycontact.repository;

import com.sj.boot.mycontact.domain.Person;
import com.sj.boot.mycontact.domain.dto.Birthday;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud() {
        Person person = Person.builder().name("martin").age(10).bloodType("A").build();

        personRepository.save(person);

        //System.out.println(personRepository.findAll());

        List<Person> people = personRepository.findAll();

        assertThat(people.size()).isEqualTo(1);
        assertThat(people.get(0).getName()).isEqualTo("martin");
        assertThat(people.get(0).getAge()).isEqualTo(10);
        assertThat(people.get(0).getBloodType()).isEqualTo("A");
    }

    @Test
    void findByBloodType() {
        givenPerson("martin", 10, "A");
        givenPerson("david", 15, "B");
        givenPerson("denis", 8, "O");
        givenPerson("sophia", 7, "AB");
        givenPerson("benny", 10, "A");
        givenPerson("john", 10, "A");

        List<Person> result = personRepository.findByBloodType("A");

        result.forEach(System.out::println);
    }

    @Test
    void findByBirthdayBetween() {
        givenPerson("martin", 10, "A", LocalDate.of(1991,2,19));
        givenPerson("david", 15, "B", LocalDate.of(1992,7,10));
        givenPerson("denis", 8, "O", LocalDate.of(1993,1,15));
        givenPerson("sophia", 7, "AB", LocalDate.of(1991,8,10));
        givenPerson("benny", 10, "A", LocalDate.of(1991,8,7));

        List<Person> result = personRepository.findByMonthOfBirthday(8);

        result.forEach(System.out::println);
    }

    private void givenPerson(String name, int age, String bloodType) {
        givenPerson(name, age, bloodType, null);
    }

    private void givenPerson(String name, int age, String bloodType, LocalDate birthday) {
        Person person = new Person(name, age, bloodType);
        person.setBirthday(new Birthday(birthday));

        personRepository.save(person);
    }

}