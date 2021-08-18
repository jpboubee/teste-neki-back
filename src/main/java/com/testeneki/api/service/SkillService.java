package com.testeneki.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testeneki.api.entities.Skill;
import com.testeneki.api.repositories.SkillRepository;
import com.testeneki.api.vo.SkillVO;

@Service
public class SkillService {

	@Autowired
	private SkillRepository skillRepository;
	
	public List<SkillVO> listar(){
		List<Skill> skills = skillRepository.findAll();
		List<SkillVO> skillsVO = new ArrayList<>();
		for (Skill skill : skills) {
			skillsVO.add(converterEntidade(skill));
		}
		return skillsVO;
	}
	
	public SkillVO inserir(SkillVO skillVO) {
		Skill skill = skillRepository.save(converterVO(skillVO));
		return converterEntidade(skill);
	}
	
	public SkillVO atualizar(SkillVO skillVO, Integer id) throws Exception {
		Optional<Skill> skill = skillRepository.findById(id);
		if(skill.isPresent()) {
			skill.get().setName(skillVO.getName());
			skill.get().setDescription(skillVO.getDescription());
			skill.get().setVersion(skillVO.getVersion());
			skill.get().setImageUrl(skillVO.getImageUrl());
			return converterEntidade(skillRepository.save(skill.get()));
		}
		throw new Exception("skill não encontrada");
	}
	
	public String deletar (Integer id) throws Exception {
		Optional<Skill> skill = skillRepository.findById(id);
		if(skill.isPresent()) {
			skillRepository.deleteById(id);
			return "deletado com sucesso";
		}
		throw new Exception("user não encontrado");
	}
	
	
	private Skill converterVO (SkillVO skillVO) {
		Skill skill = new Skill();
		skill.setName(skillVO.getName());
		skill.setDescription(skillVO.getDescription());
		skill.setVersion(skillVO.getVersion());
		skill.setImageUrl(skillVO.getImageUrl());
		return skill;
	}
	
	private SkillVO converterEntidade (Skill skill) {
		SkillVO skillVO = new SkillVO();
		skillVO.setId(skill.getId());
		skillVO.setName(skill.getName());
		skillVO.setDescription(skill.getDescription());
		skillVO.setVersion(skill.getVersion());
		skillVO.setImageUrl(skill.getImageUrl());
		return skillVO;
	}
}
