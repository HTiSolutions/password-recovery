package com.htisolutions.entities;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface SecurityQuestionDao extends CrudRepository<SecurityQuestion, Long> {

}
