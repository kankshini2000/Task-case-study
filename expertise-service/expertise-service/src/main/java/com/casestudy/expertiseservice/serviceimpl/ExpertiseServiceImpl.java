package com.casestudy.expertiseservice.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.casestudy.expertiseservice.dto.ExpertiseDto;
import com.casestudy.expertiseservice.entity.Expertise;
import com.casestudy.expertiseservice.repo.ExpertiseRepo;
import com.casestudy.expertiseservice.service.ExpertiseService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ExpertiseServiceImpl implements ExpertiseService{

	private ExpertiseRepo exptRepo;
	
	private ModelMapper modelMapper;

//	Create expertise
	@Override
	public ExpertiseDto createExpertise(ExpertiseDto exptDto) {
		Expertise expt = modelMapper.map(exptDto, Expertise.class);
		Expertise savedExpt = exptRepo.save(expt);
		ExpertiseDto savedExptDto = modelMapper.map(savedExpt, ExpertiseDto.class);
		return savedExptDto;
	}

//	Get expertise by id
	@Override
	public ExpertiseDto getExpertiseById(Long exptId) {
		Optional<Expertise> foundId = exptRepo.findById(exptId);
		return modelMapper.map(foundId, ExpertiseDto.class);
	}

//	Get all expertise 
	@Override
	public List<ExpertiseDto> getAllExpertise() {
		List<Expertise> listOfExpt = exptRepo.findAll();
		List<ExpertiseDto> listOfAllExpt = new ArrayList<>();
		for (Expertise expt : listOfExpt) {
			listOfAllExpt.add(modelMapper.map(expt, ExpertiseDto.class));
		}
		return listOfAllExpt;
	}

//	Update expertise by id
	@Override
	public ExpertiseDto updateExpertise(ExpertiseDto exptDto) {
		Expertise foundExpt =  exptRepo.findById(exptDto.getExptId()).get();
		foundExpt.setExptId(exptDto.getExptId());
		foundExpt.setExptName(exptDto.getExptName());
		foundExpt.setExptDesc(exptDto.getExptDesc());
		ExpertiseDto updatedExpt = modelMapper.map(foundExpt, ExpertiseDto.class);
		return updatedExpt;
	}

//	Delete expertise by id
	@Override
	public void deleteExpertise(Long exptDto) {
		exptRepo.deleteById(exptDto);
		
	}
}
