package com.pionieerlabs.app.messages;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface MessageRepository extends JpaRepository<Message, Long>{
}
