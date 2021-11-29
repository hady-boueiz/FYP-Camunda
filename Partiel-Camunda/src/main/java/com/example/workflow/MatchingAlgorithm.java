package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named
public class MatchingAlgorithm implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        double mean = 0.0;
        String grade1 = "0.0";
        String grade2 = "0.0";
        grade1 = (String)execution.getVariable("grade1");
        grade2 = (String)execution.getVariable("grade2");

        double grade1Double = Double.parseDouble(grade1);
        double grade2Double = Double.parseDouble(grade2);
        mean = (grade1Double + grade2Double) / 2.0;

        if (mean >= 15) {
            execution.setVariable("selectedChoice", "Murex");
        }
        else if (mean >= 14) {
            execution.setVariable("selectedChoice", "CME");
        }
        else {
            execution.setVariable("selectedChoice", "Javista");
        }
    }
}
