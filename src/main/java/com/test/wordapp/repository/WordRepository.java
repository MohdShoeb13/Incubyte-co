package com.test.wordapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.wordapp.entity.Words;

@Repository
public interface WordRepository extends JpaRepository<Words, Long> {
	public Optional<Words> findById(Long id);
}
