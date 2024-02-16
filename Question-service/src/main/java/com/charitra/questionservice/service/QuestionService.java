package com.charitra.questionservice.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.charitra.questionservice.dao.QuestionDao;
import com.charitra.questionservice.model.Question;
import com.charitra.questionservice.model.QuestionWrapper;
import com.charitra.questionservice.model.Response;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String category, int limit) {
		List<Integer> ans = questionDao.findAllByCategory(category,limit);
		return new ResponseEntity<>(ans,HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionsById(List<Integer> Id) {
		
		List<QuestionWrapper> wrapper = new ArrayList<>();
		List<Question> ques = new ArrayList<Question>();
		
		for(Integer id:Id)
		{
			Question q = (questionDao.findById(id).get());
			ques.add(q);
		}
		for(Question q:ques)
		{
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			wrapper.add(qw);
		}
		return new ResponseEntity<>(wrapper,HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScores(List<Response> response) {
		int right = 0;
		List<Question> ques = new ArrayList<>();
		for(Response res:response)
		{
			Question q = (questionDao.findById(res.getId()).get());
			if(q.getRightAnswer().equals(res.getResponse()))
			{
				right++;
			}
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}
}
