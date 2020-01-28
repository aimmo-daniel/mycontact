package com.sj.boot.mycontact.repository;

import com.sj.boot.mycontact.domain.Person;
import com.sj.boot.mycontact.domain.dto.Birthday;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud() {
        Person person = Person.builder().name("john").age(10).bloodType("A").build();

        personRepository.save(person);

        List<Person> people = personRepository.findByName("john");

        assertThat(people.size()).isEqualTo(1);
        assertThat(people.get(0).getName()).isEqualTo("john");
        assertThat(people.get(0).getAge()).isEqualTo(10);
        assertThat(people.get(0).getBloodType()).isEqualTo("A");
    }

    @Test
    void findByBloodType() {
        List<Person> people = personRepository.findByBloodType("A");

        assertThat(people.size()).isEqualTo(2);
        assertThat(people.get(0).getName()).isEqualTo("martin");
        assertThat(people.get(1).getName()).isEqualTo("benny");
    }

    @Test
    void findByBirthdayBetween() {
        List<Person> people = personRepository.findByMonthOfBirthday(8);

        assertThat(people.size()).isEqualTo(2);
        assertThat(people.get(0).getName()).isEqualTo("martin");
        assertThat(people.get(1).getName()).isEqualTo("benny");
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