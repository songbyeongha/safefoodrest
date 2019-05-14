package com.ssafy.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.elasticsearch.rest.RestClientProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ssafy.dto.Board;
import com.ssafy.service.HrmService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="SSAFY")
@CrossOrigin(origins="*")	// SOP 위반에 대한 처리
public class BoardRestController {

	@Autowired
	HrmService service;
	
	@GetMapping("/boards")
	@ApiOperation(value="모든 보드 값 리턴", response=Map.class)
	public ResponseEntity<Map<String, Object>> selectAll(){
		List<Board> list = service.selectAll(); 
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", "OK");
		resultMap.put("data", list);
		
		// 상태값 전달
		ResponseEntity<Map<String, Object>> ent = null;
		if(list.size()>0) {
			ent = new ResponseEntity<Map<String, Object>>(resultMap,HttpStatus.OK);			//200
		}else {
			ent = new ResponseEntity<Map<String, Object>>(resultMap,HttpStatus.NO_CONTENT);	//204
		}
		return ent;
	}
	
	@GetMapping("/boards/{id}")
	@ApiOperation(value="지정 id 보드 값 리턴", response=Map.class)
	public ResponseEntity<Map<String, Object>> select(@PathVariable Integer id){
		Board board = service.select(id);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", "OK");
		resultMap.put("data", board);
		
		// 상태값 전달
		ResponseEntity<Map<String, Object>> ent = null;
		if(board!=null) {
			ent = new ResponseEntity<Map<String, Object>>(resultMap,HttpStatus.OK);			//200
		}else {
			ent = new ResponseEntity<Map<String, Object>>(resultMap,HttpStatus.NO_CONTENT);	//204
		}
		return ent;
	}
	
	@GetMapping("/boards/page/{page}")
	@ApiOperation(value="지정 page 보드 값 리턴", response=Map.class)
	public ResponseEntity<Map<String, Object>> pageSelect(@PathVariable Integer page){
		List<Board> list = service.pagingPageSelect((page-1)*10);
		List<Board> max = service.selectAll();
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", "OK");
		resultMap.put("data", list);
		resultMap.put("maxpage", (max.size()/10)+1);
		// 상태값 전달
		ResponseEntity<Map<String, Object>> ent = null;
		if(list.size()>0) {
			ent = new ResponseEntity<Map<String, Object>>(resultMap,HttpStatus.OK);			//200
		}else {
			ent = new ResponseEntity<Map<String, Object>>(resultMap,HttpStatus.NO_CONTENT);	//204
		}
		return ent;
	}
	
	@GetMapping("/boards/title/{title}")
	@ApiOperation(value="지정 title 보드 정보 리턴", response=Map.class)
	public ResponseEntity<Map<String, Object>> selectByTitle(@PathVariable String title){
		List<Board> list = service.selectByTitle("%"+title+"%");
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", "OK");
		resultMap.put("data", list);
		
		// 상태값 전달
		ResponseEntity<Map<String, Object>> ent = null;
		if(list.size()>0) {
			ent = new ResponseEntity<Map<String, Object>>(resultMap,HttpStatus.OK);			//200
		}else {
			ent = new ResponseEntity<Map<String, Object>>(resultMap,HttpStatus.NO_CONTENT);	//204
		}
		return ent;
	}
	
	@GetMapping("/boards/content/{content}")
	@ApiOperation(value="지정 content 보드 정보 리턴", response=Map.class)
	public ResponseEntity<Map<String, Object>> selectByContent(@PathVariable String content){
		List<Board> list = service.selectByContent("%"+content+"%");
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", "OK");
		resultMap.put("data", list);
		
		// 상태값 전달
		ResponseEntity<Map<String, Object>> ent = null;
		if(list.size()>0) {
			ent = new ResponseEntity<Map<String, Object>>(resultMap,HttpStatus.OK);			//200
		}else {
			ent = new ResponseEntity<Map<String, Object>>(resultMap,HttpStatus.NO_CONTENT);	//204
		}
		return ent;
	}
	
	@GetMapping("/boards/writer/{writer}")
	@ApiOperation(value="지정 writer 보드 정보 리턴", response=Map.class)
	public ResponseEntity<Map<String, Object>> selectByWriter(@PathVariable String writer){
		List<Board> list = service.selectByWriter("%"+writer+"%");
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", "OK");
		resultMap.put("data", list);
		
		// 상태값 전달
		ResponseEntity<Map<String, Object>> ent = null;
		if(list.size()>0) {
			ent = new ResponseEntity<Map<String, Object>>(resultMap,HttpStatus.OK);			//200
		}else {
			ent = new ResponseEntity<Map<String, Object>>(resultMap,HttpStatus.NO_CONTENT);	//204
		}
		return ent;
	}
	
	@PostMapping("/boards")
	@ApiOperation(value="보드 정보 저장", response=Map.class)
	public ResponseEntity<Map<String, Object>> insert(@RequestBody Board emp){
		Integer result = service.insertBoard(emp);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", "OK");
		resultMap.put("data", emp);
		
		// 상태값 전달
		ResponseEntity<Map<String, Object>> ent = null;
		if(result>0) {
			ent = new ResponseEntity<Map<String, Object>>(resultMap,HttpStatus.OK);			//200
		}else {
			ent = new ResponseEntity<Map<String, Object>>(resultMap,HttpStatus.NO_CONTENT);	//204
		}
		return ent;
	}
	
	@DeleteMapping("/boards/{id}")
	@ApiOperation(value="보드 정보 삭제", response=Integer.class)
	public ResponseEntity<Map<String, Object>> delete(@PathVariable Integer id){
		Integer result = service.deleteBoard(id);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", "OK");
		resultMap.put("data", id);
		
		// 상태값 전달
		ResponseEntity<Map<String, Object>> ent = null;
		if(result>0) {
			ent = new ResponseEntity<Map<String, Object>>(resultMap,HttpStatus.OK);			//200
		}else {
			ent = new ResponseEntity<Map<String, Object>>(resultMap,HttpStatus.NO_CONTENT);	//204
		}
		return ent;
	}
	
	@PutMapping("/boards/{id}")
	@ApiOperation(value="보드 정보 수정", response=Map.class)
	public ResponseEntity<Map<String, Object>> update(@PathVariable Integer id,@RequestBody Board board){
		Board board1 = service.select(id);
		board.setQno(id);
		board.setInDate(board1.getInDate());
		board.setHit(board1.getHit());
		Integer result = service.updateBoard(board);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", "OK");
		resultMap.put("data", board);
		
		// 상태값 전달
		ResponseEntity<Map<String, Object>> ent = null;
		if(result>0) {
			ent = new ResponseEntity<Map<String, Object>>(resultMap,HttpStatus.OK);			//200
		}else {
			ent = new ResponseEntity<Map<String, Object>>(resultMap,HttpStatus.NO_CONTENT);	//204
		}
		return ent;
	}
	
	@PutMapping("/boards/hit/{id}")
	@ApiOperation(value="보드 정보 수정", response=Map.class)
	public ResponseEntity<Map<String, Object>> hitUp(@PathVariable Integer id){
		Board board = service.select(id);
		board.setHit(board.getHit()+1);
		Integer result = service.hitUp(board);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", "OK");
		resultMap.put("data", board);
		
		// 상태값 전달
		ResponseEntity<Map<String, Object>> ent = null;
		if(result>0) {
			ent = new ResponseEntity<Map<String, Object>>(resultMap,HttpStatus.OK);			//200
		}else {
			ent = new ResponseEntity<Map<String, Object>>(resultMap,HttpStatus.NO_CONTENT);	//204
		}
		return ent;
	}
}
