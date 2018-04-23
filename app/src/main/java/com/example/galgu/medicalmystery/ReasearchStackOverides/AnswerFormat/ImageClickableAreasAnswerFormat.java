package com.example.galgu.medicalmystery.ReasearchStackOverides.AnswerFormat;

import android.graphics.Point;
import android.graphics.Rect;
import android.media.Image;
import android.widget.ImageView;

import com.example.galgu.medicalmystery.ClickablePhoto.ClickableImageView;
import com.example.galgu.medicalmystery.ClickablePhoto.PolyShape;
import com.example.galgu.medicalmystery.R;
import com.example.galgu.medicalmystery.ReasearchStackOverides.Step.Body.ImageClickableAreasQuestionBody;
import com.squareup.picasso.Picasso;

import org.researchstack.backbone.answerformat.AnswerFormat;

import java.net.URI;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by galgu on 3/27/2018.
 */

public class ImageClickableAreasAnswerFormat extends AnswerFormat implements AnswerFormat.QuestionType{

    private List<PolyShape> shapes;
    private float realWidth,realHeight;
    String imageURL;

    public ImageClickableAreasAnswerFormat(String imageURL,  float realWidth, float realHeight) {
        this.imageURL=imageURL;
        this.shapes = new LinkedList<>();
        this.realWidth=realWidth;
        this.realHeight=realHeight;
    }

    public String getImageURL() {
        return imageURL;
    }

    public List<PolyShape> getshapes() {
        return shapes;
    }

    public void addShape(PolyShape polyShape){
        if(polyShape.isPoly())
            shapes.add(polyShape);
    }

    @Override
    public QuestionType getQuestionType() {
        return this;
    }
    @Override
    public Class<?> getStepBodyClass() {
        return ImageClickableAreasQuestionBody.class;
    }

}
