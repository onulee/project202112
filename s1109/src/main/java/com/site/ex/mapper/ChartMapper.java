package com.site.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.site.ex.dto.ChartDto;

@Mapper
public interface ChartMapper {
	//차트 전체데이터 가져오기
	List<ChartDto> selectChartIncome();
}
