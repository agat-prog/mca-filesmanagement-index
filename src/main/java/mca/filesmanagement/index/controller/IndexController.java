package mca.filesmanagement.index.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mca.filesmanagement.index.commons.IndexFileDto;
import mca.filesmanagement.index.service.IndexService;

@RestController
@RequestMapping("/api/index")
public class IndexController {

	private static Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private IndexService indexService;
	
	public IndexController() {
		super();
	}
	
	@GetMapping
	public List<IndexFileDto> search(Pageable pageable) {
		LOGGER.info("search --> " + pageable);
		return this.indexService.search(pageable).toList();
	}
}
