package com.testeneki.api.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.testeneki.api.entities.User;
import com.testeneki.api.repositories.UserRepository;
import com.testeneki.api.vo.UserVO;

@Service
public class UserService {
	
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public List<UserVO> listar() {
		List<User> usuarios = userRepository.findAll();
		List<UserVO>usuariosVO = new ArrayList<>(); 
		for (User user : usuarios) {
			usuariosVO.add(converteEntidade(user));
		}
		return usuariosVO;
	}
	
	public UserVO cadastrar (UserVO userVO) {
		User user = userRepository.save(converteVO(userVO));
		return converteEntidade(user);
	}
	
	public UserVO atualizar (UserVO userVO, Integer id) throws Exception {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			user.get().setLogin(userVO.getLogin());
			user.get().setPassword(encoder.encode(userVO.getPassword()));
			return converteEntidade(userRepository.save(user.get()));
		}
		throw new Exception("user não encontrado");
	}
	
	public String deletar (Integer id) throws Exception {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			userRepository.deleteById(id);
			return "deletado com sucesso";
		}
		throw new Exception("user não encontrado");
	}
	
	public String login (UserVO userVO) {
		Optional<User> user = userRepository.findByLogin(userVO.getLogin());
		if(encoder.matches(userVO.getPassword(), user.get().getPassword())) {
			
			user.get().setLastLoginDate(LocalDate.now());
			return "acesso permitido";
		}
		return "acesso negado";
	}
	
	private User converteVO (UserVO userVO) {
		User user = new User();
		user.setLogin(userVO.getLogin());
		user.setPassword(encoder.encode(userVO.getPassword()));
		user.setLastLoginDate(LocalDate.now());
		return user;
	}
	private UserVO converteEntidade (User user) {
		UserVO userVO = new UserVO();
		userVO.setId(user.getId());
		userVO.setLogin(user.getLogin());
		userVO.setPassword(user.getPassword());
		userVO.setLastLoginDate(user.getLastLoginDate());
		return userVO;
	}
	
}
