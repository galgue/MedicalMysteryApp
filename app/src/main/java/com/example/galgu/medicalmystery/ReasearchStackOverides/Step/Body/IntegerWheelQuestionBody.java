package com.example.galgu.medicalmystery.ReasearchStackOverides.Step.Body;

import android.content.res.Resources;
import android.hardware.Camera;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

import com.example.galgu.medicalmystery.R;
import com.example.galgu.medicalmystery.ReasearchStackOverides.AnswerFormat.IntegerWheelAnswerFormat;

import org.researchstack.backbone.result.StepResult;
import org.researchstack.backbone.step.QuestionStep;
import org.researchstack.backbone.step.Step;
import org.researchstack.backbone.ui.step.body.BodyAnswer;
import org.researchstack.backbone.ui.step.body.StepBody;

/**
 * Created by galgu on 3/27/2018.
 */

public class IntegerWheelQuestionBody<T> implements StepBody {

    private StepResult result;
    private int max;
    private int min;
    private IntegerWheelAnswerFormat format;
    private NumberPicker numberWheel;

    public IntegerWheelQuestionBody(Step step, StepResult result) {

        QuestionStep questionStep = (QuestionStep)step;
        format = (IntegerWheelAnswerFormat)questionStep.getAnswerFormat();
        min = format.getMinValue();
        max = format.getMaxValue();
        this.result = result == null ? new StepResult<>(step) : result;

    }

    @Override
    public View getBodyView(int viewType, LayoutInflater inflater, ViewGroup parent) {

        LinearLayout view = new LinearLayout(parent.getContext());

        Resources res = parent.getResources();
        LinearLayout.MarginLayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.leftMargin = res.getDimensionPixelSize(R.dimen.rsb_margin_left);
        layoutParams.rightMargin = res.getDimensionPixelSize(R.dimen.rsb_margin_right);
        view.setLayoutParams(layoutParams);
        view.setOrientation(LinearLayout.VERTICAL);

        numberWheel = new NumberPicker(view.getContext());
        numberWheel.setMinValue(min);
        numberWheel.setMaxValue(max);


        view.addView(numberWheel);

        return view;
    }

    @Override
    public StepResult getStepResult(boolean skipped) {

        if (skipped) {
            result.setResult(null);
        } else {
            result.setResult(numberWheel.getValue());
        }
        return result;
    }

    @Override
    public BodyAnswer getBodyAnswerState() {
        return BodyAnswer.VALID;
    }
}
