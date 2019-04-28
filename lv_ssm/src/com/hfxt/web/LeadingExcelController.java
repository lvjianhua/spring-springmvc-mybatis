package com.hfxt.web;

import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.hfxt.biz.QuestionsBiz;
import com.hfxt.entity.Questions;
import com.hfxt.tool.ImportExcelUtil;

/**
 * �ļ�����
 * 
 * @author lv
 *
 */
@Controller
public class LeadingExcelController {
	@Autowired
	private QuestionsBiz qBiz;
	
@RequestMapping("/form")    
public ModelAndView form(HttpServletRequest request,Model model)throws Exception{
    MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;     
    InputStream in =null;  
    List<List<Object>> listob = null;  
    MultipartFile file = multipartRequest.getFile("upfile");  
    if(file.isEmpty()){  
        throw new Exception("�ļ������ڣ�");  
    }  
    in = file.getInputStream();  
    listob = new ImportExcelUtil().getBankListByExcel(in,file.getOriginalFilename());  
      
    // �ô��ɵ���service��Ӧ�����������ݱ��浽���ݿ��У���ֻ���������  
    for (int i = 0; i < listob.size(); i++) {  
        List<Object> lo = listob.get(i);  
        Questions question = new Questions();
        question.setTitle(String.valueOf(lo.get(0)));
        question.setEtailDesc(String.valueOf(lo.get(1)));
        question.setAnswerCount(Integer.parseInt((String)lo.get(2)));
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
        question.setLastModified(sdf.parse(String.valueOf(lo.get(3))));
        System.out.println("��ӡ��Ϣ-->"+question.toString());  
        qBiz.addQuestions(question);
    }  
	ModelAndView view=new ModelAndView("redirect:/pagerindex.html");
	return view;
}

@RequestMapping(value="/ajax")  
public  void  ajaxUploadExcel(HttpServletRequest request,HttpServletResponse response) throws Exception {  
    MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;    
    InputStream in =null;  
    List<List<Object>> listob = null;  
    MultipartFile file = multipartRequest.getFile("upfile");  
    if(file.isEmpty()){  
        throw new Exception("�ļ������ڣ�");  
    }  
      
    in = file.getInputStream();  
    listob = new ImportExcelUtil().getBankListByExcel(in,file.getOriginalFilename());  
      
  //�ô��ɵ���service��Ӧ�����������ݱ��浽���ݿ��У���ֻ���������  
    for (int i = 0; i < listob.size(); i++) {  
        List<Object> lo = listob.get(i);  
        Questions question = new Questions();
        question.setTitle(String.valueOf(lo.get(0)));
        question.setEtailDesc(String.valueOf(lo.get(1)));
        question.setAnswerCount(Integer.parseInt((String)lo.get(2)));
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
        question.setLastModified(sdf.parse(String.valueOf(lo.get(3))));
        System.out.println("��ӡ��Ϣ-->"+question.toString());  
        qBiz.addQuestions(question);
    }  
      
    PrintWriter out = null;  
    response.setCharacterEncoding("utf-8");  //��ֹajax���ܵ���������Ϣ����  
    out = response.getWriter();  
    out.print("�ļ�����ɹ���");  
    out.flush();  
    out.close();  
} 


@RequestMapping(value="leadingexcel.html")
public ModelAndView getQuestionsById(Model model,Integer id) {
	ModelAndView view=new ModelAndView("leadingexcel");
	return view;
}


}