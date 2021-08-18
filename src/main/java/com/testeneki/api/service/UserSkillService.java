package com.testeneki.api.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testeneki.api.entities.UserSkill;
import com.testeneki.api.repositories.SkillRepository;
import com.testeneki.api.repositories.UserRepository;
import com.testeneki.api.repositories.UserSkillRepository;
import com.testeneki.api.vo.UserSkillVO;

@Service
public class UserSkillService {
	
	@Autowired
	private UserSkillRepository userSkillRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SkillRepository skillRepository;
	
	public List<UserSkillVO> listar(String username){
		List<UserSkill> sks = userSkillRepository.findAllByUser(userRepository.findByLogin(username).get());
		List<UserSkillVO>skVOs = new ArrayList<>();
		for(UserSkill sk : sks) {
			skVOs.add(converterEntidade(sk));
		}
		return skVOs;
	}
	
	public UserSkillVO inserir (UserSkillVO skVO) {
		UserSkill sk = userSkillRepository.save(converterVO(skVO));
		return converterEntidade(sk);
	}
	
	public UserSkillVO atualizar (UserSkillVO skVO, Integer id) throws Exception {
		Optional<UserSkill> sk = userSkillRepository.findById(id);
		if(sk.isPresent()) {
			sk.get().setSkill(skillRepository.getById(skVO.getSkill_id()));
			sk.get().setKnowledgeLevel(skVO.getKnowledgeLevel());
			sk.get().setUpdatedAt(skVO.getUpdatedAt());
			return converterEntidade(userSkillRepository.save(sk.get()));
		}
		throw new Exception("user não encontrado");
	}
	
	public String deletar (Integer id) throws Exception {
		Optional<UserSkill> sk = userSkillRepository.findById(id);
		if(sk.isPresent()) {
			userSkillRepository.deleteById(id);
			return "deletado com sucesso";
		}
		throw new Exception("user não encontrado");
	}
	
	private UserSkillVO converterEntidade(UserSkill sk) {
		UserSkillVO skVO = new UserSkillVO();
		skVO.setId(sk.getId());
		skVO.setUser(sk.getUser());
		skVO.setSkill(sk.getSkill());
		skVO.setKnowledgeLevel(sk.getKnowledgeLevel());
		skVO.setCreatedAt(sk.getCreatedAt());
		skVO.setUpdatedAt(sk.getUpdatedAt());
		return skVO;
	}
	
	private UserSkill converterVO (UserSkillVO skVO) {
		UserSkill sk = new UserSkill();
		sk.setId(skVO.getId());
		sk.setUser(userRepository.getById(skVO.getUser_id()));
		sk.setSkill(skillRepository.getById(skVO.getSkill_id()));
		sk.setKnowledgeLevel(skVO.getKnowledgeLevel());
		sk.setCreatedAt(LocalDate.now());
		sk.setUpdatedAt(skVO.getUpdatedAt());
		return sk;
	}
}
