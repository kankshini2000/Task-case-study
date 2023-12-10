package com.casestudy.formservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.formservice.entity.Form;

public interface FormRepo extends JpaRepository<Form, Long>{

}
