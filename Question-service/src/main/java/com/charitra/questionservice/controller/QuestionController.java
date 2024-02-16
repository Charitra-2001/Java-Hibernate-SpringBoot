package com.charitra.questionservice.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.charitra.questionservice.model.Question;
import com.charitra.questionservice.model.QuestionWrapper;
import com.charitra.questionservice.model.Response;
import com.charitra.questionservice.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return  questionService.addQuestion(question);
    }
    
    @GetMapping("generate")
    public ResponseEntity<List<Integer>> GenerateQuestionForQuiz(@RequestParam("category") String category, @RequestParam("Limit") int limit)
    {
    	return questionService.getQuestionsForQuiz(category,limit);
    }
    
    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsById(@RequestBody List<Integer> Id)
    {
    	return questionService.getQuestionsById(Id);
    }
    
    @PostMapping("getScore")
    public ResponseEntity<Integer> getScores(@RequestParam List<Response> response)
    {
    	return questionService.getScores(response);
    }
}
