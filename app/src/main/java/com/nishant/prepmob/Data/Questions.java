package com.nishant.prepmob.Data;

public class Questions {

    String id, questionCategory, questionType, question, opt1, opt2, opt3, opt4, correctopt;

    public Questions(String id, String questionCategory, String questionType, String question, String opt1, String opt2, String opt3, String opt4, String correctopt) {
        this.id = id;
        this.questionCategory = questionCategory;
        this.questionType = questionType;
        this.question = question;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.opt4 = opt4;
        this.correctopt = correctopt;
    }

    public String getId() {
        return id;
    }

    public String getQuestionCategory() {
        return questionCategory;
    }

    public String getQuestionType() {
        return questionType;
    }

    public String getQuestion() {
        return question;
    }

    public String getOpt1() {
        return opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public String getOpt4() {
        return opt4;
    }

    public String getCorrectopt() {
        return correctopt;
    }
}
