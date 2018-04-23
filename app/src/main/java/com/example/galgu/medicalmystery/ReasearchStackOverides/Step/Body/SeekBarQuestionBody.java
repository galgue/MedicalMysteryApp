package com.example.galgu.medicalmystery.ReasearchStackOverides.Step.Body;

import android.content.res.Resources;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.galgu.medicalmystery.R;
import com.example.galgu.medicalmystery.ReasearchStackOverides.AnswerFormat.SeekBarAnswerFormat;

import org.researchstack.backbone.result.StepResult;
import org.researchstack.backbone.step.QuestionStep;
import org.researchstack.backbone.step.Step;
import org.researchstack.backbone.ui.step.body.BodyAnswer;
import org.researchstack.backbone.ui.step.body.StepBody;


/**
 * Created by galgu on 3/26/2018.
 */

public class SeekBarQuestionBody<T> implements StepBody {

    private int min;
    private int length;
    private int selectedAnswer;
    private SeekBarAnswerFormat format;
    StepResult result;

    public SeekBarQuestionBody(Step step, StepResult result) {

        QuestionStep questionStep = (QuestionStep)step;
        format = (SeekBarAnswerFormat)questionStep.getAnswerFormat();
        min = format.getMinValue();
        length = format.getLengthValue();
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

        SeekBar seekBar = new SeekBar(view.getContext());
        seekBar.setMax(length);

        selectedAnswer=min;

        final TextView numText = new TextView(view.getContext());
        numText.setText(""+min);
        numText.setGravity(Gravity.CENTER_HORIZONTAL);
        numText.setTextSize(50);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                numText.setText(""+(min+seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                selectedAnswer=min+seekBar.getProgress();
            }
        });

        view.addView(seekBar);
        view.addView(numText);

        return view;
    }

    @Override
    public StepResult getStepResult(boolean skipped) {

        if (skipped) {
            result.setResult(null);
        } else {
            result.setResult(selectedAnswer);
        }
        return result;
    }

    @Override
    public BodyAnswer getBodyAnswerState() {
        return BodyAnswer.VALID;
    }

}
