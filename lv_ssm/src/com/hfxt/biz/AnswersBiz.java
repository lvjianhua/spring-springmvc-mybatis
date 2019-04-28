package com.hfxt.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hfxt.entity.Answers;

public interface AnswersBiz {
	int getAnsCountByQid(@Param("qid")Integer qid);
	List<Answers> getAnswersByQid(@Param("qid")Integer qid);
	int addAnswers(Answers answers);
}
