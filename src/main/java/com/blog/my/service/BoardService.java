package com.blog.my.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.my.dto.BoardSaveRequestDto;
import com.blog.my.model.Board;
import com.blog.my.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	@Transactional
	public void write(BoardSaveRequestDto dto) {
		Board boardEntity = BoardSaveRequestDto.toEntity(dto);
		boardRepository.save(boardEntity);
	}
	
	@Transactional
	public Page<Board> selectList(Pageable pageable){
		return boardRepository.findAll(pageable);
	}
	
	@Transactional
	public Board datail(int id) {
		Board board = boardRepository.findById(id).orElseThrow(() -> {
			return new RuntimeException("해당글은 삭제 되었습니다.");
		});
		board.setReadCount(board.getReadCount() + 1);
		
		return board;
	}
}
