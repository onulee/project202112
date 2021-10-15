package com.site.ex.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.site.ex.dao.EventDao;
import com.site.ex.dto.EventDto;

public class EventServiceWrite implements EventService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		EventDao eventDao = new EventDao();
		//String uploadPath=request.getRealPath("upload"); <-jsp
		//파일저장위치
		String uploadPath=request.getSession().getServletContext().getRealPath("upload");
		//파일크기
		int size=10*1024*1024;
		try {
			//파일업로드
			MultipartRequest multi = new MultipartRequest(request,uploadPath,size,"utf-8",new DefaultFileRenamePolicy());
			String estate=multi.getParameter("estate");
			Timestamp startdate=Timestamp.valueOf(multi.getParameter("startdate"));
			Timestamp enddate=Timestamp.valueOf(multi.getParameter("enddate"));
			String etitle=multi.getParameter("etitle");
			String econtent=multi.getParameter("econtent");
			String id="aaa";
			String efileName="";
			String efileName2="";
			//업로드된 파일이름 가져오기 
			Enumeration files = multi.getFileNames();
			String[] fileName = new String[2];
			int i=0;
			while(files.hasMoreElements()) {
				fileName[i] = (String) files.nextElement();
				i++;
			}
			//파일이름을 변수에 저장
			for(i=0;i<fileName.length;i++) {
				if(i==0) {
					efileName = fileName[i];
				}else {
					efileName2 = fileName[i];
				}
			}
			//입력받은 데이터 객체저장
			EventDto eDto = new EventDto(id, etitle, econtent, startdate,enddate, estate, efileName, efileName2);
			//db파일저장메소드 호출
			eventDao.insertEventWrite(eDto);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//execute

}
