package com.sj.boot.mycontact.service;

import com.sj.boot.mycontact.domain.Block;
import com.sj.boot.mycontact.domain.Person;
import com.sj.boot.mycontact.repository.BlockRepository;
import com.sj.boot.mycontact.repository.PersonRepository;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {

    private PersonService personService;
    private PersonRepository personRepository;
    private BlockRepository blockRepository;

    @Autowired
    public PersonServiceTest(PersonService personService, PersonRepository personRepository, BlockRepository blockRepository) {
        this.personService = personService;
        this.personRepository = personRepository;
        this.blockRepository = blockRepository;
    }

    @Test
    void getPeopleExcludeBlocks() {
        givenPeople();

        List<Person> result = personService.getPeopleExcludeBlocks();

        result.forEach(System.out::println);
    }

    @Test
    void getPeopleByName() {
        givenPeople();

        List<Person> result = personService.getPeopleByName("martin");

        result.forEach(System.out::println);
    }

    @Test
    void cascadeTest() {
        givenPeople();

        List<Person> result = personRepository.findAll();
        result.forEach(System.out::println);

        Person person = result.get(3);
        person.getBlock().setStartDate(LocalDate.now());
        person.getBlock().setEndDate(LocalDate.now());

        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);

        //personRepository.delete(person);
        //personRepository.findAll().forEach(System.out::println);
        //blockRepository.findAll().forEach(System.out::println);

        person.setBlock(null);
        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);
        blockRepository.findAll().forEach(System.out::println);
    }

    @Test
    void getPerson() {
        givenPeople();

        Person person = personService.getPerson(3L);

        System.out.println(person);
    }

    private void givenPeople() {
        givenPerson("martin", 10, "A");
        givenPerson("david", 12, "O");
        givenBlockPerson("dennis", 13, "B");
        givenBlockPerson("marco", 14, "AB");
    }

    private void givenPerson(String name, int age, String bloodType) {
        personRepository.save(new Person(name, age, bloodType));
    }

    private void givenBlockPerson(String name, int age, String bloodType) {
        Person blockPerson = Person.builder()
                .name(name)
                .age(age)
                .bloodType(bloodType)
                .block(new Block(name))
                .build();


        personRepository.save(blockPerson);
    }

}