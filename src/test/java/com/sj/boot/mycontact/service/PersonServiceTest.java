package com.sj.boot.mycontact.service;

import com.sj.boot.mycontact.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PersonServiceTest {

    private PersonService personService;

    @Autowired
    public PersonServiceTest(PersonService personService) {
        this.personService = personService;
    }

    @Test
    void getPeopleExcludeBlocks() {
        List<Person> people = personService.getPeopleExcludeBlocks();

        assertThat(people.size()).isEqualTo(3);
        assertThat(people.get(0).getName()).isEqualTo("martin");
        assertThat(people.get(1).getName()).isEqualTo("david");
        assertThat(people.get(2).getName()).isEqualTo("benny");
    }

    @Test
    void getPeopleByName() {
        List<Person> person = personService.getPeopleByName("martin");

        assertThat(person.get(0).getName()).isEqualTo("martin");
    }

    @Test
    void getPerson() {
        Person person = personService.getPerson(3L);

        assertThat(person.getName()).isEqualTo("dennis");
    }


}