package com.example.galgu.medicalmystery.ReasearchStackOverides.Step.Body;

import android.content.res.Resources;
import android.graphics.Color;
import android.media.Image;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.example.galgu.medicalmystery.ClickablePhoto.ClickableImageView;
import com.example.galgu.medicalmystery.R;
import com.example.galgu.medicalmystery.ReasearchStackOverides.AnswerFormat.ImageClickableAreasAnswerFormat;
import com.squareup.picasso.Picasso;

import org.researchstack.backbone.result.StepResult;
import org.researchstack.backbone.step.QuestionStep;
import org.researchstack.backbone.step.Step;
import org.researchstack.backbone.ui.step.body.BodyAnswer;
import org.researchstack.backbone.ui.step.body.StepBody;

/**
 * Created by galgu on 3/27/2018.
 */

public class ImageClickableAreasQuestionBody<T> implements StepBody {


    private final ImageClickableAreasAnswerFormat format;
    private final StepResult result;

    public ImageClickableAreasQuestionBody(Step step, StepResult result) {

        QuestionStep questionStep = (QuestionStep)step;
        format = (ImageClickableAreasAnswerFormat)questionStep.getAnswerFormat();
        
        this.result = result == null ? new StepResult<>(step) : result;

    }

    @Override
    public View getBodyView(int viewType, LayoutInflater inflater, ViewGroup parent) {
        ClickableImageView clickableImageView =new ClickableImageView(parent.getContext());


        clickableImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

        clickableImageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        Picasso.get().load(format.getImageURL()).into(clickableImageView);

        clickableImageView.setAdjustViewBounds(true);
        clickableImageView.addShapes(format.getshapes());
        return clickableImageView;
    }

    @Override
    public StepResult getStepResult(boolean skipped) {
        if (skipped) {
            result.setResult(null);
        } else {
            result.setResult(1);
        }
        return result;
    }

    @Override
    public BodyAnswer getBodyAnswerState() {
        return BodyAnswer.VALID;
    }
}
