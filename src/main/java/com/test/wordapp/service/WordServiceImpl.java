package com.test.wordapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.wordapp.entity.Words;
import com.test.wordapp.repository.WordRepository;

@Service
public class WordServiceImpl implements WordsService {
	
	@Autowired
	private WordRepository wordRepository;

	@Override
	public Words createWord(Words word) {
		return this.wordRepository.save(word);
	}

	@Override
	public Words upadteWord(Words word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Words> getWords() {
		return this.wordRepository.findAll();
	}

	@Override
	public void deleteWord(Long wordId) {
		// TODO Auto-generated method stub
		this.wordRepository.deleteById(wordId);;
	}

}
