package com.example.galgu.medicalmystery.ReasearchStackOverides.Step;

import org.researchstack.backbone.answerformat.AnswerFormat;
import org.researchstack.backbone.step.QuestionStep;

import java.util.Map;


/**
 * Created by galgu on 3/22/2018.
 */

public abstract class ConditionalStep extends QuestionStep implements ConditionalNext {

    protected Map<Integer,Integer> answerToQuestion;
    protected int nextStep;

    protected int frevStep;


    public ConditionalStep(String identifier, String title, AnswerFormat ans, int nextStep, int frevStep) {
        super(identifier, title,ans);
        this.nextStep=nextStep;
        this.frevStep=frevStep;
    }


    public ConditionalStep(String identifier, String title, AnswerFormat ans, Map<Integer,Integer> answerToQuestion, int frevStep) {
        super(identifier, title,ans);
        this.answerToQuestion=answerToQuestion;
        this.frevStep=frevStep;
    }

    public int getPrevID(){
        return frevStep;
    }

}
