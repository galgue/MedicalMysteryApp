package com.example.galgu.medicalmystery.ReasearchStackOverides.Step;


import org.researchstack.backbone.answerformat.AnswerFormat;

import java.util.Map;

/**
 * Created by galgu on 3/22/2018.
 */

public class ConditionalSingleChoiceQuestionStep extends ConditionalStep {

    public ConditionalSingleChoiceQuestionStep(String identifier, String title, AnswerFormat ans, Map<Integer, Integer> answerToQuestion, int frevStep) {
        super(identifier, title, ans, answerToQuestion,frevStep);
    }


    @Override
    public int getNextID(int ansID) {
        return answerToQuestion.get(ansID);
    }
}
