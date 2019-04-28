package com.hfxt.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hfxt.biz.QuestionsBiz;
import com.hfxt.dao.QuestionsDao;
import com.hfxt.entity.Answers;
import com.hfxt.entity.Questions;

@Service("QuestionsBizImpl")
public class QuestionsBizImpl  implements QuestionsBiz{

	@Autowired
	private QuestionsDao qDao;

	public List<Questions> getPagerQuestions(Questions questions,
			Integer pageIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		return qDao.getPagerQuestions(questions, pageIndex, pageSize);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return qDao.getCount();
	}

	public Questions getQuestionsById(Integer id) {
		// TODO Auto-generated method stub
		return qDao.getQuestionsById(id);
	}

	public int addQuestions(Questions questions) {
		// TODO Auto-generated method stub
		return qDao.addQuestions(questions);
	}
}
