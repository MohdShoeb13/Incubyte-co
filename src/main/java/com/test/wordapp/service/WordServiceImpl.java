package com.test.wordapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.wordapp.entity.Words;
import com.test.wordapp.repository.WordRepository;

@Service
public class WordServiceImpl implements WordsService {
	
	@Autowired
	private WordRepository wordRepository;
	 
	public List<Words> getAllWords(){
		return (List<Words>)this.wordRepository.findAll();
	}
	
	public Optional<Words> getWordById(Long id) {
		Optional<Words> word = null;
		
		try {
			word = this.wordRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return word;
	}
	
	public Words addWord(Words word) {
		Words result = wordRepository.save(word);
		return result;
	}
	
	public void deleteWord(Long wordId) {
		wordRepository.deleteById(wordId);
	}
	
	public void updateWord(Words word, Long wordId) {
		word.setId(wordId);
		wordRepository.save(word);
	}

}
