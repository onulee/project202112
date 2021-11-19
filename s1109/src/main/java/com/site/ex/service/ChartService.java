package com.site.ex.service;

import java.util.List;

import com.site.ex.dto.ChartDto;

public interface ChartService {
	//차트 전체데이터 가져오기
	List<ChartDto> selectChartIncome();
}
