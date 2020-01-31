package com.sj.boot.mycontact.repository;

import com.sj.boot.mycontact.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByName(String name);

    // native 쿼리
    //@Query(value = "select * from person where month_of_birthday = ?1 and day_of_birthday = ?2", nativeQuery = true)
    // entity 기반 쿼리 실행
    @Query(value = "select person from Person person where person.birthday.monthOfBirthday = ?1")
    List<Person> findByMonthOfBirthday(int monthOfBirthday);

    // 삭제된 유저만 검색
    @Query(value = "select * from Person person where person.deleted = true", nativeQuery = true)
    List<Person> findPeopleDeleted();

}
