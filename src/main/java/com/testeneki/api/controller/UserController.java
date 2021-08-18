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

import com.testeneki.api.service.UserService;
import com.testeneki.api.vo.UserVO;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	private ResponseEntity<List<UserVO>> listar (){
		return ResponseEntity.ok(userService.listar());
	}
	
	@PostMapping
	private ResponseEntity<UserVO> inserir (@RequestBody UserVO userVO){
		return ResponseEntity.ok(userService.cadastrar(userVO));
	}
	@PostMapping("/login")
	private ResponseEntity<String> login (@RequestBody UserVO userVO){
		return ResponseEntity.ok(userService.login(userVO));
	}
	
	@PutMapping("{id}")
	private ResponseEntity<UserVO> atualizar (@RequestBody UserVO userVO, @PathVariable Integer id) throws Exception{
		return ResponseEntity.ok(userService.atualizar(userVO, id));
	}
	
	@DeleteMapping("{id}")
	private ResponseEntity<String> deletar (@PathVariable Integer id) throws Exception{
		return ResponseEntity.ok(userService.deletar(id));
	}
}
