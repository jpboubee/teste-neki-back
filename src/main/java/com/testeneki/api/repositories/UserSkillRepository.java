package com.testeneki.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testeneki.api.entities.User;
import com.testeneki.api.entities.UserSkill;

@Repository
public interface UserSkillRepository extends JpaRepository<UserSkill,Integer>{
	List<UserSkill> findAllByUser (User user);
}
