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
import org.springframework.web.bind.annotation.RestController;

import com.testeneki.api.service.SkillService;
import com.testeneki.api.vo.SkillVO;

@RestController
@RequestMapping("/skill")
public class SkillController {

	@Autowired
	private SkillService skillService;
	
	@GetMapping
	private ResponseEntity<List<SkillVO>> listar (){
		return ResponseEntity.ok(skillService.listar());
	}
	
	@PostMapping
	private ResponseEntity<SkillVO> inserir (@RequestBody SkillVO skillVO){
		return ResponseEntity.ok(skillService.inserir(skillVO));
	}
	
	@PutMapping("{id}")
	private ResponseEntity<SkillVO> atualizar (@RequestBody SkillVO skillVO, @PathVariable Integer id) throws Exception{
		return ResponseEntity.ok(skillService.atualizar(skillVO, id));
	}
	
	@DeleteMapping("{id}")
	private ResponseEntity<String> deletar (@PathVariable Integer id) throws Exception{
		return ResponseEntity.ok(skillService.deletar(id));
	}
}
