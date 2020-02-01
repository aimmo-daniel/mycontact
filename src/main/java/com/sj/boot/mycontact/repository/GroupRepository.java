package com.sj.boot.mycontact.repository;

import com.sj.boot.mycontact.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {

}
