package com.example.galgu.medicalmystery.ReasearchStackOverides.Task;

import com.example.galgu.medicalmystery.ReasearchStackOverides.Step.ConditionalNext;

import org.researchstack.backbone.result.TaskResult;
import org.researchstack.backbone.step.Step;
import org.researchstack.backbone.task.OrderedTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by galgu on 3/22/2018.
 */

public class JumpStepTask extends OrderedTask {

    protected Map<Integer, Step> idToStep;
    private int first;

    public JumpStepTask(String identifier, List<Step> steps) {
        super(identifier, steps);

    }

    public JumpStepTask(String identifier, Step... steps) {
        this(identifier, Arrays.asList(steps));
    }

    public JumpStepTask(String identifier, Map<Integer, Step> steps,int first) {
        this(identifier, new ArrayList<Step>(steps.values()));
        idToStep=steps;
        this.first=first;
    }

    @Override
    public Step getStepAfterStep(Step step, TaskResult result) {

        if (step == null) {
            return idToStep.get(first);
        }

        String currentIdentifier = step == null ? null : step.getIdentifier();
        ConditionalNext cstep = (ConditionalNext)step;

        Integer next;

        try {
            next = (Integer) result.getStepResult(currentIdentifier).getResult();
            if(next==null ){
                return null;
            }
            next = cstep.getNextID(next);

            if (next.intValue() == -1) {
                return null;
            }

            return(idToStep.get(next));
        }
        catch (Exception e){

        }
        next = cstep.getNextID(-1);

        if (next.intValue() == -1) {
            return null;
        }

        return(idToStep.get(next));
    }

    @Override
    public Step getStepBeforeStep(Step step, TaskResult result) {
        ConditionalNext cstep = (ConditionalNext)step;
        int prv = cstep.getPrevID();

        if (prv == -1) {
            return null;
        }

        return(idToStep.get(prv));
    }

    @Override
    public TaskProgress getProgressOfCurrentStep(Step step, TaskResult result) {
        int current = step == null ? -1 : steps.indexOf(step);
        return new TaskProgress(current, steps.size());
    }
}
