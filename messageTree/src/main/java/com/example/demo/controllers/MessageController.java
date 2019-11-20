package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Message;
import com.example.demo.services.MessageService;

// Configures the app to accept all traffic from 4200 because
// Angular runs on a separate server (port 4200)
@CrossOrigin({ "*", "http://localhost:8080" })
@RestController
@RequestMapping("api")
public class MessageController {

	@Autowired
	private MessageService messageService;

	@RequestMapping(path = "messages", method = RequestMethod.GET)
	@ResponseBody
	public List<Message> index(HttpServletRequest req, HttpServletResponse res) {
		return messageService.index();
	}

	@RequestMapping(path = "message", method = RequestMethod.POST)
	@ResponseBody
	public Message create(HttpServletRequest req, HttpServletResponse res, @RequestBody Message message) {
		return messageService.create(message);
	}

	// PUT users/{id} WORKS
	@RequestMapping(path = "message", method = RequestMethod.PUT)
	@ResponseBody
	public Message update(HttpServletRequest req, HttpServletResponse res, @RequestBody Message message) {
		return messageService.update(message);
	}

	// DELETE users/{id}
	@RequestMapping(path = "message/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void destroy(HttpServletRequest req, HttpServletResponse res, @PathVariable int id) {
		messageService.destroy(id);

	}

}
