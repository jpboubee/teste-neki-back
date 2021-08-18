package com.testeneki.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testeneki.api.service.UserSkillService;
import com.testeneki.api.vo.UserSkillVO;

@RestController
@RequestMapping("/userSkill")
public class UserSkillController {
	
	@Autowired
	private UserSkillService userSkillService;
	
	@GetMapping
	private ResponseEntity<List<UserSkillVO>> listar (@RequestParam String username){
		return ResponseEntity.ok(userSkillService.listar(username));
	}
	
	@PostMapping
	private ResponseEntity<UserSkillVO> inserir (@RequestBody UserSkillVO userSkillVO){
		return ResponseEntity.ok(userSkillService.inserir(userSkillVO));
	}
	
	@PutMapping("{id}")
	private ResponseEntity<UserSkillVO> atualizar (@RequestBody UserSkillVO userSkillVO, @PathVariable Integer id) throws Exception{
		return ResponseEntity.ok(userSkillService.atualizar(userSkillVO, id));
	}
	
	@DeleteMapping("{id}")
	private ResponseEntity<String> deletar (@PathVariable Integer id) throws Exception{
		return ResponseEntity.ok(userSkillService.deletar(id));
	}
}
