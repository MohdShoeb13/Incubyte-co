package com.test.wordapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.wordapp.entity.Words;
import com.test.wordapp.service.WordsService;

@RestController
@RequestMapping("/api")
public class WordController {
  
	@Autowired
	private WordsService wordsService;
	
	@GetMapping("/words")
	public List<Words> getWords() {
	   return wordsService.getWords();
	}
}
