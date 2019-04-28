package com.hfxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hfxt.entity.Answers;
import com.hfxt.entity.Questions;

public interface QuestionsDao {
	
	List<Questions> getPagerQuestions(@Param("questions")Questions questions,@Param("pageIndex")Integer pageIndex,@Param("pageSize")Integer pageSize);
	int getCount();
	Questions getQuestionsById(@Param("id")Integer id);
	int addQuestions(Questions questions);
}
