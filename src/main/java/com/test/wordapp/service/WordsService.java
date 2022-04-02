package com.test.wordapp.service;

import java.util.List;
import java.util.Optional;

import com.test.wordapp.entity.Words;

public interface WordsService {
   
	List<Words> getAllWords();
	public Optional<Words> getWordById(Long id);
	public Words addWord(Words word);
	public void deleteWord(Long wordId);
	public void updateWord(Words word, Long wordId);
		
}
