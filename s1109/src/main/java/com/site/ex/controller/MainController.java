package com.site.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.site.ex.service.DataService;
import com.site.ex.service.DataServiceImpl;

@Controller
public class MainController {
	
	@Autowired
	DataService dataService;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/data")
	public String data() {
		return "data";
	}
	@RequestMapping("/list")
	public String list() {
		return "list";
	}
	
	@RequestMapping("/dataApi") //공공데이터 연결
	@ResponseBody
	public String dataApi(@RequestParam(defaultValue = "1") String searchData,@RequestParam String category) throws Exception {
		System.out.println("searchData : "+searchData);
		String data="";
		switch (category) {
			case "pageNo":
				//공공데이터List 가져오기
				data = dataService.selectData(searchData);
			break;
			case "keyword":
				//공공데이터 검색으로 가져오기
				data = dataService.selectSearchData(category,searchData);
			break;
		}
		return data;
	}

}
