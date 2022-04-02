package com.test.wordapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.wordapp.entity.Words;
import com.test.wordapp.service.WordsService;

@RestController
public class WordController {
  
	@Autowired
	private WordsService wordsService;
	
	@GetMapping("/words")
	public ResponseEntity<List<Words>> getBooks(){
		List<Words> list = wordsService.getAllWords();
		if(list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
//	@GetMapping("/words/{id}")
//	public ResponseEntity<Words> getBook(@PathVariable("id") Long id){
//		Optional<Words> word = wordsService.getWordById(id);
//		if(word.isEmpty()) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
//		return ResponseEntity.ok(word.get());
//	}
	
	
	@PostMapping("/words")
	public ResponseEntity<Words> addBook(@RequestBody Words word){
		Words theWord = null;
		try {
			theWord = this.wordsService.addWord(word);
			return ResponseEntity.of(Optional.of(theWord));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@DeleteMapping("/words/{wordId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("wordId") Long wordId){
		try {
			this.wordsService.deleteWord(wordId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/words/{wordId}")
	public ResponseEntity<Words> updateBook(@RequestBody Words word,
			@PathVariable("wordId") Long wordId){
		try {
			this.wordsService.updateWord(word, wordId);
			return ResponseEntity.ok().body(word);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
