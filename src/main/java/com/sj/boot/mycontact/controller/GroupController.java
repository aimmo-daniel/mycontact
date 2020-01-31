package com.sj.boot.mycontact.controller;

import com.sj.boot.mycontact.controller.dto.GroupDto;
import com.sj.boot.mycontact.domain.Group;
import com.sj.boot.mycontact.domain.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/group")
@RestController
public class GroupController {

    @GetMapping
    public List<Group> getAll() {
        return null; // 그룹 전체 정보 가져오기
    }

    @GetMapping("/{id}")
    public Group getGroup(@PathVariable Long id) {
        return null; // 특정 그룹정보 가져오기
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postGroup(@RequestBody GroupDto groupDto) { //그룹DTO 구현필요
        // Group 생성하기
    }

    @PatchMapping("/{id}")
    public void modifyGroup(@PathVariable Long id, String description) {
        // 그룹 정보 수정하기
    }

    @GetMapping("/{id}/people")
    public List<Person> getPeopleInGroup(@PathVariable Long id) {
        return null; // 특정 그룹의 Person 리스트 가져오기
    }

    @PutMapping("/${id}/person/{personId}")
    public void putPersonInGroup(@PathVariable Long id, @PathVariable Long personId) {
        // Person 정보를 Group 정보에 매핑하기
    }

}
