package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Message;

@Repository
public interface MessageRepo extends JpaRepository<Message, Integer> {

	List<Message> findByParentID(Integer parentID);

}
