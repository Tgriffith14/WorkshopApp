package com.griffith.tyler.interactivestory.model;

/**
 * Created by Tyler on 8/27/2015.
 */
public class Page {
    private int imageID;
    private String text;
    private Choice choice1;
    private Choice choice2;



    private boolean isFinal = false;

    public Page (int id, String text, Choice choice1, Choice choice2) {
        imageID = id;
        this.text = text;
        this.choice1 = choice1;
        this.choice2 = choice2;
    }
    public Page (int id, String text) {
        imageID = id;
        this.text = text;
        choice1 = null;
        choice2 = null;
        isFinal = true;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Choice getChoice1() {
        return choice1;
    }

    public void setChoice1(Choice choice1) {
        this.choice1 = choice1;
    }

    public Choice getChoice2() {
        return choice2;
    }

    public void setChoice2(Choice choice2) {
        this.choice2 = choice2;
    }

    public int getImageID() {
        return imageID;
    }
    public void setImageID (int id) {
        imageID = id;
    }
    public boolean isFinal() {
        return isFinal;
    }

    public void setIsFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }
}
