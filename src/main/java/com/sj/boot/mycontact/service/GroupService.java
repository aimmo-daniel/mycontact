package com.sj.boot.mycontact.service;

import com.sj.boot.mycontact.domain.Group;
import com.sj.boot.mycontact.repository.GroupRepository;
import com.sj.boot.mycontact.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Group get(Long id) {
        return groupRepository.findById(id).orElse(null);
    }

/*    @Transactional
    public void put(GroupDto groupDto) {
        Group group = new Group();
        group.set(groupDto);

        groupRepository.save(group);
    }

    @Transactional
    public void modify(Long id, String description) {
        Group group = groupRepository.findById(id).orElseThrow(GroupNotFoundException::new);

        group.setDescription(description);

        groupRepository.save(group);
    }*/

/*    @Transactional
    public List<Person> getPersons(Long id) {
        return personRepository.findByGroup
    }*/

  /*  @Transactional
    public void putPerson(Long id, Long personId) {

    }*/

}
