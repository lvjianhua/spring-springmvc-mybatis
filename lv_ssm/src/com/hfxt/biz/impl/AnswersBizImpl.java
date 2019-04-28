package com.hfxt.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hfxt.biz.AnswersBiz;
import com.hfxt.dao.AnswersDao;
import com.hfxt.entity.Answers;

@Service("AnswersBizImpl")
public class AnswersBizImpl implements AnswersBiz {

	@Autowired
	private AnswersDao aDao;

	public int addAnswers(Answers answers) {
		// TODO Auto-generated method stub
		return aDao.addAnswers(answers);
	}

	public List<Answers> getAnswersByQid(Integer qid) {
		// TODO Auto-generated method stub
		return aDao.getAnswersByQid(qid);
	}

	public int getAnsCountByQid(Integer qid) {
		// TODO Auto-generated method stub
		return aDao.getAnsCountByQid(qid);
	}
}
