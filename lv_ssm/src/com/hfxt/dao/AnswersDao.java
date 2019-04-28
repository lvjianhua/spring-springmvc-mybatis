package com.hfxt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hfxt.entity.Answers;

public interface AnswersDao {

	List<Answers> getAnswersByQid(@Param("qid")Integer qid);
	int addAnswers(Answers answers);
	int getAnsCountByQid(@Param("qid")Integer qid);
}
