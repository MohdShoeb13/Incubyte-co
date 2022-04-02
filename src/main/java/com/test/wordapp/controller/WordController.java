package com.test.wordapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/words")
	public Words addWord(@RequestBody Words word) {
		return wordsService.createWord(word);
	}
	
	@DeleteMapping("/{wordId}")
	public String delete(@PathVariable("wordId") Long wordId) {
		System.out.println(wordId);
		this.wordsService.deleteWord(wordId);
		return "Word deleted sucessfully";
	}
}
