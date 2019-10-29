package com.example.controllers;

//USER CONTROLLER WORKS DO NOT TOUCH UNTIL NEEDED FOR SECURITY
//ADDED SECURITY gc on 6/4

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Message;
import com.example.services.MessageService;

// Configures the app to accept all traffic from 4200 because
// Angular runs on a separate server (port 4200)
@CrossOrigin({ "*", "http://localhost:9000" })
@RestController
@RequestMapping("api")
public class MessageController {

	@Autowired
	private MessageService messageService;

	@RequestMapping(path = "messages", method = RequestMethod.GET)
	public List<Message> index(HttpServletRequest req, HttpServletResponse res, Principal principal) {
		return messageService.index();
	}

	@RequestMapping(path = "message", method = RequestMethod.POST)
	public Message create(HttpServletRequest req, HttpServletResponse res, @RequestBody Message message,
			Principal principal) {
		return messageService.create(message);
	}

	// PUT users/{id} WORKS
	@RequestMapping(path = "message", method = RequestMethod.PUT)
	public Message update(HttpServletRequest req, HttpServletResponse res, @RequestBody Message message,
			Principal principal) {
		return messageService.update(message);
	}

	// DELETE users/{id}
	@RequestMapping(path = "message/{id}", method = RequestMethod.DELETE)
	public void destroy(HttpServletRequest req, HttpServletResponse res, @PathVariable int id, Principal principal) {
		messageService.destroy(id);

	}

}
