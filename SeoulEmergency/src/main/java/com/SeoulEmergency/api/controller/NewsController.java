package com.SeoulEmergency.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SeoulEmergency.api.service.NewsService;
import com.SeoulEmergency.core.domain.news.NewsList;
import com.SeoulEmergency.core.repository.NewsListRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/news")
@CrossOrigin(origins="*", allowedHeaders="*")
@Api(value = "���� ���� API", tags="News")
public class NewsController {

	@Autowired
	private NewsService newsService;
//	private final NewsListRepository newsListRepository;
//
//	@Autowired
//	public NewsController(NewsListRepository newsListRepository) {
//		this.newsListRepository = newsListRepository;
//	}

	@GetMapping("/list")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST"),
			@ApiResponse(responseCode = "404", description = "ã�� �� ���� ������"),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
	})
	@ApiOperation(value = "���� ����Ʈ ��������", notes="������ ���� ������ �� �� ���� ����Ʈ�� ������ �������� ���� ������ ����Ʈ�� �ҷ��´�.")
	public ResponseEntity<List<NewsList>> showNewsList(
			@RequestParam(value="page", defaultValue = "1") int page,
			@RequestParam(value="limit", defaultValue = "1") int limit
	) {
		// ���� �����ؾ� ��. ���� ��� ���� �� ��������
		List<NewsList> responseDto = newsService.getNewsList(page, limit);
		return ResponseEntity.status(200).body(responseDto);
	}
}
