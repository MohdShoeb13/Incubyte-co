package com.test.wordapp.service;

import java.util.List;

import com.test.wordapp.entity.Words;

public interface WordsService {
   
	List<Words> getAllWords();
	public Words getWordById(Long id);
	public Words addWord(Words word);
	public void deleteWord(Long wordId);
	public void updateWord(Words word, Long wordId);
		
}
