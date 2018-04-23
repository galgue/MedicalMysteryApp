package com.example.galgu.medicalmystery.ReasearchStackOverides.AnswerFormat;

import com.example.galgu.medicalmystery.ReasearchStackOverides.Step.Body.IntegerWheelQuestionBody;

import org.researchstack.backbone.answerformat.AnswerFormat;

/**
 * Created by galgu on 3/27/2018.
 */

public class IntegerWheelAnswerFormat extends AnswerFormat implements AnswerFormat.QuestionType {
    private int maxValue;
    private int minValue;

    /**
     * Creates an integer answer format with the specified min and max values.
     *
     * @param minValue minimum allowed value
     * @param maxValue maximum allowed value, 0 if no max
     */
    public IntegerWheelAnswerFormat(int minValue, int maxValue) {
        this.maxValue=maxValue;
        this.minValue=minValue;
    }

    /**
     * Returns the maximum allowed value for the question, 0 if no max
     *
     * @return the max value, 0 if no max
     */
    public int getMaxValue()
    {
        return maxValue;
    }

    /**
     * Returns the minimum allowed value for the question
     *
     * @return returns the minimum allowed value for the question
     */
    public int getMinValue()
    {
        return minValue;
    }

    @Override
    public QuestionType getQuestionType() {
        return this;
    }

    @Override
    public Class<?> getStepBodyClass() {
        return IntegerWheelQuestionBody.class;
    }
}
