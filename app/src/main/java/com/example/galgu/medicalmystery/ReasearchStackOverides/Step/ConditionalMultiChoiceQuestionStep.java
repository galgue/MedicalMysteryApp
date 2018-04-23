package com.example.galgu.medicalmystery.ReasearchStackOverides.Step;

import org.researchstack.backbone.answerformat.AnswerFormat;

/**
 * Created by galgu on 3/23/2018.
 */

public class ConditionalMultiChoiceQuestionStep extends ConditionalStep {


    public ConditionalMultiChoiceQuestionStep(String identifier, String title, AnswerFormat ans, int nextStep, int frevStep) {
        super(identifier, title, ans, nextStep, frevStep);
    }

    @Override
    public int getNextID(int ansID) {
        return nextStep;
    }
}
