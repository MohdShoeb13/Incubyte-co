package com.test.wordapp.service;

import java.util.List;

import com.test.wordapp.entity.Words;

public interface WordsService {
   
	public Words createWord(Words word);
	
	public Words upadteWord(Words word);
	
	public List<Words> getWords();
	
	public Words deleteWord(Long wordId);
	
	
	
}
