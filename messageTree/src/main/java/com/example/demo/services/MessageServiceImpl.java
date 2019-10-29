package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Message;
import com.example.demo.repos.MessageRepo;

@Service
public class MessageServiceImpl implements MessageService {


	@Autowired
	private MessageRepo messageRepo;
	
	@Override
	public List<Message> index() {
		return messageRepo.findAll();
	}

	@Override
	public Message create(Message message) {
		// TODO Auto-generated method stub
		return messageRepo.saveAndFlush(message);
	}

	@Override
	public Message update(Message message) {
		// TODO Auto-generated method stub
		return messageRepo.saveAndFlush(message);
	}

	@Override
	public void destroy(int id) {
		messageRepo.deleteById(id);
	}



}
