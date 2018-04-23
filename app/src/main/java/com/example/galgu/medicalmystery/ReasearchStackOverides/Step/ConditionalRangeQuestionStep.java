package com.example.galgu.medicalmystery.ReasearchStackOverides.Step;

import org.researchstack.backbone.answerformat.AnswerFormat;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by galgu on 3/24/2018.
 */

public class ConditionalRangeQuestionStep extends ConditionalStep {

    public ConditionalRangeQuestionStep(String identifier, String title, AnswerFormat ans, Map<Integer, Integer> answerToQuestion, int frevStep) {
        super(identifier, title, ans, answerToQuestion, frevStep);
    }

    @Override
    public int getNextID(int ansID) {

        List<Integer> keys = new LinkedList<>(answerToQuestion.keySet());
        Collections.sort(keys);

        for(int i = 1; i < keys.size(); i++)
        {
            if(keys.get(i)>ansID){
                return answerToQuestion.get(keys.get(i-1));
            }
        }

        return answerToQuestion.get(keys.get(keys.size()-1));
    }
}
