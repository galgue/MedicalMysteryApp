package com.example.galgu.medicalmystery.ReasearchStackOverides.Step;

import org.researchstack.backbone.step.InstructionStep;

/**
 * Created by galgu on 3/23/2018.
 */

public class ConditionalIntractionStep extends InstructionStep implements ConditionalNext {
    private int nextStep;
    private int prevStep;

    public ConditionalIntractionStep(String identifier, String title, String detailText, int nextStep, int prevStep) {
        super(identifier, title, detailText);
        this.nextStep=nextStep;
        this.prevStep=prevStep;
    }

    @Override
    public int getNextID(int ansID) {
        return nextStep;
    }

    @Override
    public int getPrevID() {
        return prevStep;
    }
}
