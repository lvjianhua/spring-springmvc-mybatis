package com.hfxt.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.hfxt.biz.AnswersBiz;
import com.hfxt.biz.QuestionsBiz;
import com.hfxt.entity.Answers;
import com.hfxt.entity.Questions;
import com.hfxt.tool.Pager;

@Controller
public class ProblemContorller {

	@Autowired
	private QuestionsBiz qBiz;
	@Autowired
	private AnswersBiz aBiz;
	@RequestMapping(value="pagerindex.html")
	public ModelAndView pagerindex(Model model,Pager<Questions> pager,Questions questions) {
		int count=qBiz.getCount();
		pager.setTotal(count);
		List<Questions> qList=qBiz.getPagerQuestions(questions,(pager.getCurrentPage()-1)*pager.getPageSize(), pager.getPageSize());
		for (Questions questions2:qList) {
			int ansCount=aBiz.getAnsCountByQid(questions2.getId());
			questions2.setAnswerCount(ansCount);
		}
		
		pager.setPageRecords(qList);
		model.addAttribute("pager", pager);
		model.addAttribute("q", questions);
		ModelAndView view=new ModelAndView("index");
		return view;
	}
	
	@RequestMapping(value="getQuestionsById.html")
	public ModelAndView getQuestionsById(Model model,Integer id) {
		Questions questions=qBiz.getQuestionsById(id);
		List<Answers> aList=aBiz.getAnswersByQid(id);
		model.addAttribute("aList",aList);
		model.addAttribute("q", questions);
		ModelAndView view=new ModelAndView("addAnswers");
		return view;
	}
	@RequestMapping(value="toaddQuestion.html")
	public ModelAndView toaddQuestion(Model model) {
		ModelAndView view=new  ModelAndView("addQuestion");
		return view;
	}
	@RequestMapping(value="addQuestions")
	@ResponseBody
	public Map<String,Object> addQuestions(Model model,Questions questions){
		Map<String,Object> map=new HashMap<String, Object>();
		int result=qBiz.addQuestions(questions);
		
		  if (result==1) {
				map.put("recode",true);
				map.put("remsg","提问成功");
			}else{
				map.put("recode", false);
				map.put("remsg", "提问失败");
		
	}
	return map;
}

	@RequestMapping(value="addAnswers")
	@ResponseBody
	public Map<String, Object> addAnswers(Model model,Answers answers) {
		int result=aBiz.addAnswers(answers);
		Map<String,Object> map=new HashMap<String, Object>();
		  if (result==1) {
				map.put("recode",true);
				map.put("remsg","回答成功");
			}else{
				map.put("recode", false);
				map.put("remsg", "回答失败");
		
	}
		return map;
	}
}
