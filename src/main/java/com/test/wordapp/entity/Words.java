package com.test.wordapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Words {
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
		
	public Words() {
		super();
	}
	
	
	public Words(Long id, String word) {
		super();
		this.id = id;
		this.word = word;
	}

	private String word;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
}
