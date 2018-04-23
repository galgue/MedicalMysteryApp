package com.example.galgu.medicalmystery;

import android.content.Context;
import android.net.Uri;

import com.example.galgu.medicalmystery.ClickablePhoto.PolyShape;
import com.example.galgu.medicalmystery.ReasearchStackOverides.AnswerFormat.ImageClickableAreasAnswerFormat;
import com.example.galgu.medicalmystery.ReasearchStackOverides.AnswerFormat.IntegerWheelAnswerFormat;
import com.example.galgu.medicalmystery.ReasearchStackOverides.AnswerFormat.SeekBarAnswerFormat;
import com.example.galgu.medicalmystery.ReasearchStackOverides.Step.ConditionalIntractionStep;
import com.example.galgu.medicalmystery.ReasearchStackOverides.Step.ConditionalMultiChoiceQuestionStep;
import com.example.galgu.medicalmystery.ReasearchStackOverides.Step.ConditionalRangeQuestionStep;
import com.example.galgu.medicalmystery.ReasearchStackOverides.Step.ConditionalSingleChoiceQuestionStep;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.researchstack.backbone.answerformat.AnswerFormat;
import org.researchstack.backbone.answerformat.ChoiceAnswerFormat;
import org.researchstack.backbone.model.Choice;
import org.researchstack.backbone.step.InstructionStep;
import org.researchstack.backbone.step.QuestionStep;
import org.researchstack.backbone.step.Step;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by galgu on 3/28/2018.
 */

public class FirstSurvey {

    private static String getXML(Context ctx){
        String content = "";

        try(BufferedReader br = new BufferedReader(new InputStreamReader(ctx.getAssets().open("qe.txt")))) {
            for(String line; (line = br.readLine()) != null; ) {
                content+=line;
            }
            // line is not visible here.
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    public static Map<Integer,Step> getSteps(Context ctx){
        Map<Integer,Step> steps = new HashMap<>();

        int start = 1; //TODO: miss in the xml

        try {
            JSONObject questions = new JSONObject(getXML(ctx));

            addStep(start,questions,steps,-1);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return steps;
    }

    private static void addStep(int place, JSONObject questions, Map<Integer, Step> steps,int prvPlace) {

        if(steps.containsKey(place)) return;

        try {
            //JSONObject question = questions.getJSONObject(""+place);
            //String type = question.getString("Type");


//            switch (type){
//                case "Multiple":
//                    makeMultipleQuestionStep(question,questions,steps,place,prvPlace);
//                    break;
//                case "Single":
//                    makeSingleQuestionStep(question,questions,steps,place,prvPlace);
//                    break;
//                case "Number":
//                    makeNumberQuestionStep(question,questions,steps,place,prvPlace);
//                    break;
//                case "Range":
//                    makeRangeQuestionStep(question,questions,steps,place,prvPlace);
//                    break;
//                default:
//                    List<Choice> answers = new LinkedList<>();
//                    int next= -1;
//
//                    JSONArray answersArr = question.getJSONArray("Choices");
//
//                    int i = 0;
//                    JSONObject ans = answersArr.getJSONObject(i);
//                    int id = ans.getInt("ID");
//                    String ansStr = ans.getString("Answer");
//
//                    next=ans.getInt("Next");
//                    addStep(next,questions,steps,place);
//
//                    answers.add(new Choice(ansStr,id));
//
//
//                    InstructionStep instructionStep = new ConditionalIntractionStep(
//                            ""+place,
//                            type,
//                            "TODO",
//                            next,prvPlace);
//
//
//                    steps.put(place,instructionStep);
//                    break;
//
//            }
            String ssss=Uri.parse("R.drawable.bodyfront").getPath();
            ImageClickableAreasAnswerFormat answerFormat = new ImageClickableAreasAnswerFormat("file:///android_asset/bodyfront.png",
                    303,436);

            answerFormat.addShape(getPolyShapeFromCords("140,60,167,60,169,81,138,81"));
            answerFormat.addShape(getPolyShapeFromCords("130,81,116,115,93,112,98,80"));
            answerFormat.addShape(getPolyShapeFromCords("176,81,204,82,212,110,190,121"));
            answerFormat.addShape(getPolyShapeFromCords("132,82,116,137,190,138,174,83"));
            answerFormat.addShape(getPolyShapeFromCords("116,139,188,140,186,181,120,183"));
            answerFormat.addShape(getPolyShapeFromCords("91,149,110,155,117,117,98,113"));
            answerFormat.addShape(getPolyShapeFromCords("192,121,208,115,216,149,198,155"));
            answerFormat.addShape(getPolyShapeFromCords("91,151,111,157,110,170,87,163"));
            answerFormat.addShape(getPolyShapeFromCords("197,156,215,151,220,162,200,169"));
            answerFormat.addShape(getPolyShapeFromCords("122,185,184,185,189,202,121,202"));
            answerFormat.addShape(getPolyShapeFromCords("78,207,96,212,108,171,85,165"));
            answerFormat.addShape(getPolyShapeFromCords("200,171,222,166,230,207,215,211"));
            answerFormat.addShape(getPolyShapeFromCords("215,212,229,210,234,223,220,228"));
            answerFormat.addShape(getPolyShapeFromCords("69,223,87,229,82,258,68,266,54,240"));
            answerFormat.addShape(getPolyShapeFromCords("219,231,236,222,251,241,240,265,226,259"));
            answerFormat.addShape(getPolyShapeFromCords("120,205,118,219,153,231,191,221,190,204"));
            answerFormat.addShape(getPolyShapeFromCords("116,222,152,233,149,290,117,276"));
            answerFormat.addShape(getPolyShapeFromCords("119,282,148,294,144,319,122,318"));
            answerFormat.addShape(getPolyShapeFromCords("159,292,186,278,184,313,163,320"));
            answerFormat.addShape(getPolyShapeFromCords("118,321,150,323,141,392,127,389"));
            answerFormat.addShape(getPolyShapeFromCords("160,325,189,315,180,387,165,391"));
            answerFormat.addShape(getPolyShapeFromCords("126,409,142,415,142,396,128,393"));
            answerFormat.addShape(getPolyShapeFromCords("165,395,180,389,181,407,164,414"));
            answerFormat.addShape(getPolyShapeFromCords("156,232,190,224,188,274,159,288"));



            QuestionStep questionStep = new ConditionalMultiChoiceQuestionStep(
                    ""+place,
                    "well fuck",
                    (AnswerFormat)answerFormat,
                    -1,
                    -1);

            steps.put(place,questionStep);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static PolyShape getPolyShapeFromCords(String cords){
        PolyShape polyShape = new PolyShape(303,436);
        String[] points = cords.split(",");
        //TODO: throw exeption if not even
        for (int i = 0; i < points.length; i+=2){
            polyShape.addPoint(Integer.parseInt(points[i]),Integer.parseInt(points[i+1]));
        }
        return polyShape;
    }


    private static void makeInstractionStep(JSONObject question,
                                          JSONObject questions,
                                          Map<Integer, Step> steps,
                                          int place,
                                          int prvPlace) throws JSONException {

        int next= -1;

        JSONArray answersArr = question.getJSONArray("Choices");

        int i = 0;
        JSONObject ans = answersArr.getJSONObject(i);
        int id = ans.getInt("ID");
        String ansStr = ans.getString("Answer");

        next=ans.getInt("Next");
        addStep(next,questions,steps,place);



        InstructionStep instructionStep = new ConditionalIntractionStep(
                ""+place,
                question.getString("Question"),
                ansStr,
                next,prvPlace);


        steps.put(place,instructionStep);
    }

    private static void makeMultipleQuestionStep(JSONObject question,
                                                 JSONObject questions,
                                                 Map<Integer, Step> steps,
                                                 int place,
                                                 int prvPlace) throws JSONException {


        JSONArray answersArr = question.getJSONArray("Choices");
        Choice[] answers = new Choice[answersArr.length()];
        int next=-1;

        for(int i = 0;i<answersArr.length();i++){
            JSONObject ans = answersArr.getJSONObject(i);
            int id = ans.getInt("ID");
            String ansStr = ans.getString("Answer");

            //in the first time we find the next
            if(i==0){
                next=ans.getInt("Next");
                addStep(next,questions,steps,place);
            }
            answers[i] = (new Choice(ansStr,id));
        }

        AnswerFormat answerFormat = new ChoiceAnswerFormat(AnswerFormat.ChoiceAnswerStyle
                .MultipleChoice,
                (answers));

        QuestionStep questionStep = new ConditionalMultiChoiceQuestionStep(
                ""+place,
                question.getString("Question"),
                answerFormat,
                next,
                prvPlace);

        steps.put(place,questionStep);
    }

    private static void makeSingleQuestionStep(JSONObject question,
                                          JSONObject questions,
                                          Map<Integer, Step> steps,
                                          int place,
                                          int prvPlace) throws JSONException {

        JSONArray answersArr = question.getJSONArray("Choices");
        Choice[] answers = new Choice[answersArr.length()];
        Map<Integer, Integer> next= new HashMap<>();


        for(int i = 0;i<answersArr.length();i++){
            JSONObject ans = answersArr.getJSONObject(i);
            int id = ans.getInt("ID");
            String ansStr = ans.getString("Answer");
            int nextPlace = ans.getInt("Next");

            addStep(nextPlace,questions,steps,place);

            next.put(id,nextPlace);

            answers[i]=(new Choice(ansStr,id));
        }


        AnswerFormat answerFormat = new ChoiceAnswerFormat(AnswerFormat.ChoiceAnswerStyle
                .SingleChoice,
                (answers));

        QuestionStep questionStep = new ConditionalSingleChoiceQuestionStep(
                ""+place,
                question.getString("Question"),
                answerFormat,
                next,
                prvPlace);

        steps.put(place,questionStep);
    }

    private static void makeNumberQuestionStep(JSONObject question,
                                               JSONObject questions,
                                               Map<Integer, Step> steps,
                                               int place,
                                               int prvPlace) throws JSONException {

        JSONArray answersArr = question.getJSONArray("Choices");
        Map<Integer, Integer> next= new HashMap<>();

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(int i = 0;i<answersArr.length();i++){
            JSONObject ans = answersArr.getJSONObject(i);
            int id = ans.getInt("ID");
            String ansStr = ans.getString("Answer");
            int nextPlace = ans.getInt("Next");

            addStep(nextPlace,questions,steps,place);

            int sMin=Integer.parseInt(ansStr.split("-")[0]);
            int sMax=Integer.parseInt(ansStr.split("-")[1]);

            if(min>sMin)min=sMin;
            if(max<sMax)max=sMax;

            next.put(min,nextPlace);
        }


        AnswerFormat answerFormat = new IntegerWheelAnswerFormat(min,max);

        QuestionStep questionStep = new ConditionalRangeQuestionStep(
                ""+place,
                question.getString("Question"),
                answerFormat,
                next,
                prvPlace);

        steps.put(place,questionStep);
    }

    private static void makeRangeQuestionStep(JSONObject question,
                                               JSONObject questions,
                                               Map<Integer, Step> steps,
                                               int place,
                                               int prvPlace) throws JSONException {

        JSONArray answersArr = question.getJSONArray("Choices");
        Map<Integer, Integer> next= new HashMap<>();

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(int i = 0;i<answersArr.length();i++){
            JSONObject ans = answersArr.getJSONObject(i);
            int id = ans.getInt("ID");
            String ansStr = ans.getString("Answer");
            int nextPlace = ans.getInt("Next");

            addStep(nextPlace,questions,steps,place);

            int sMin=Integer.parseInt(ansStr.split("-")[0]);
            int sMax=Integer.parseInt(ansStr.split("-")[1]);

            if(min>sMin)min=sMin;
            if(max<sMax)max=sMax;

            next.put(min,nextPlace);
        }


        AnswerFormat answerFormat = new SeekBarAnswerFormat(min,max);

        QuestionStep questionStep = new ConditionalRangeQuestionStep(
                ""+place,
                question.getString("Question"),
                answerFormat,
                next,
                prvPlace);

        steps.put(place,questionStep);
    }



}
