package com.sj.boot.mycontact.controller;

import com.sj.boot.mycontact.domain.Group;
import com.sj.boot.mycontact.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/api/group")
@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping
    public List<Group> getAll() {
        return groupService.getAll();
    }

    @GetMapping("/{id}")
    public Group getGroup(@PathVariable Long id) {
        return groupService.get(id);
    }

   /* @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postGroup(@RequestBody GroupDto groupDto) { //그룹DTO 구현필요
        groupService.put(groupDto);
    }

    @PatchMapping("/{id}")
    public void modifyGroup(@PathVariable Long id, String description) {
        // 그룹 정보 수정하기
        groupService.modify(id, description);
    }

    @GetMapping("/{id}/people")
    public List<Person> getPeopleInGroup(@PathVariable Long id) {
        return groupService.getPersons(id); // 특정 그룹의 Person 리스트 가져오기
    }

    @PutMapping("/${id}/person/{personId}")
    public void putPersonInGroup(@PathVariable Long id, @PathVariable Long personId) {
        // Person 정보를 Group 정보에 매핑하기
        groupService.putPerson(id, personId);
    }
*/
}
