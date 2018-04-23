package com.example.galgu.medicalmystery.ReasearchStackOverides.AnswerFormat;

import com.example.galgu.medicalmystery.ReasearchStackOverides.Step.Body.SeekBarQuestionBody;

import org.researchstack.backbone.answerformat.AnswerFormat;

/**
 * Created by galgu on 3/26/2018.
 */

/**
 * this class define the attributes for SeekBar answer format
 *
 */
public class SeekBarAnswerFormat extends AnswerFormat implements AnswerFormat.QuestionType {

    private int min;
    private int length;

    /**
     * create an answer format for SeekBar
     *
     * @param min is the minimal number that you can select
     * @param max is the maximal number that you can select
     */
    public SeekBarAnswerFormat(int min, int max){
        this.min=min;
        this.length=max-min;
    }

    @Override
    public QuestionType getQuestionType() {
        return this;
    }

    /**
     * Returns the min value
     *
     * @return returns the min value
     */
    public int getMinValue() {
        return min;
    }

    /**
     * Returns the max value, or 0f for no maximum
     *
     * @return returns the max value, or 0f for no maximum
     */
    public int getLengthValue() {
        return length;
    }


    @Override
    public Class<?> getStepBodyClass() {
        return SeekBarQuestionBody.class;
    }
}
