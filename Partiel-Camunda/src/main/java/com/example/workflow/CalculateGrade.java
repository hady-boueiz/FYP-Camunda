package com.example.workflow;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import java.util.ArrayList;
import javax.inject.Named;

@Named
public class CalculateGrade implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        ArrayList<String> criteria = new ArrayList();
        criteria.add("deadlines");
        criteria.add("template");
        criteria.add("FR");
        criteria.add("NFR");
        criteria.add("metrics");
        float res = 0.0F;

        for (int i = 0; i < criteria.size(); i++) {
            if ((Boolean)execution.getVariable(criteria.get(i))) {
                res++;
            }
        }

        res /= (float)criteria.size();
        res *= 100;
        execution.setVariable("Report Grade", Float.toString(res) + "/100");
    }
}