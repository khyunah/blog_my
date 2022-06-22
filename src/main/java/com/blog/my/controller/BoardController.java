package com.blog.my.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.my.dto.BoardSaveRequestDto;
import com.blog.my.model.Board;
import com.blog.my.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@GetMapping({"", "/"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/list")
	public String list(@PageableDefault(size = 2, sort = "id", direction = Direction.DESC) Pageable pageable, Model model) {
		Page<Board> boards = boardService.selectList(pageable);
		model.addAttribute("boards", boards);
		return "list";
	}
	
	@GetMapping("/listPage")
	@ResponseBody
	public Page<Board> listPage(@PageableDefault(size = 2, sort = "id", direction = Direction.DESC) Pageable pageable, Model model) {
		Page<Board> boards = boardService.selectList(pageable);
		model.addAttribute("boards", boards);
		return boards;
	}
	
	@GetMapping("/write")
	public String write() {
		return "write_form";
	}
	
	@PostMapping("/save")
	@ResponseBody
	public String save(@RequestBody BoardSaveRequestDto dto) {
		boardService.write(dto);
		return "ok";
	}
	
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable int id, Model model) {
		Board board = boardService.datail(id);
		model.addAttribute("board", board);
		return "detail";
	}
	
}
