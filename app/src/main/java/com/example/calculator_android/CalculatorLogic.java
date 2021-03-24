package com.example.calculator_android;

import java.io.Serializable;

public class CalculatorLogic implements Serializable {

    private double firstNumber;
    private double secondNumber;
    private int actionSelected;

    int[] numbers = new int[] {
            R.id.button1,
            R.id.button2,
            R.id.button3,
            R.id.button4,
            R.id.button5,
            R.id.button6,
            R.id.button7,
            R.id.button8,
            R.id.button9,
            R.id.button_zero,
            R.id.button_point,
            R.id.button_Cancel
    };

    int[] numbers_action = new int[]{
            R.id.button_division,
            R.id.button_multiplication,
            R.id.button_subtraction,
            R.id.button_addition,
            R.id.button_equality
    };

    StringBuilder input = new StringBuilder();

    private State state;

    private enum State {
        firstArgInput,
        secondArgInput,
        resultShow
    }

    public CalculatorLogic(){
        state = State.firstArgInput;
    }

    public void onNumPressed(int buttonId){
        if(state == State.resultShow){
            state = State.firstArgInput;
        }
        if(input.length() < 9){
            switch (buttonId){
                case R.id.button_zero:
                    if(input.length() !=0){
                        input.append("0");
                    }
                    break;
                case R.id.button1:
                    input.append("1");
                    break;
                case R.id.button2:
                    input.append("2");
                    break;
                case R.id.button3:
                    input.append("3");
                    break;
                case R.id.button4:
                    input.append("4");
                    break;
                case R.id.button5:
                    input.append("5");
                    break;
                case R.id.button6:
                    input.append("6");
                    break;
                case R.id.button7:
                    input.append("7");
                    break;
                case R.id.button8:
                    input.append("8");
                    break;
                case R.id.button9:
                    input.append("9");
                    break;
                case R.id.button_point:
                    input.append(".");
                    break;
                case R.id.button_Cancel:
                    input.setLength(0);
                    break;
            }
        }
    }

    public void onActionPressed(int actionId) {
        if (actionId == R.id.button_equality && state == State.secondArgInput) {
            secondNumber = Double.parseDouble(input.toString());
            state = State.resultShow;
            input.setLength(0);
            switch (actionSelected){
                case R.id.button_multiplication:
                    input.append(firstNumber * secondNumber) ;
                    break;
                case R.id.button_division:
                    input.append(firstNumber / secondNumber) ;
                    break;
                case R.id.button_subtraction:
                    input.append(firstNumber - secondNumber) ;
                    break;
                case R.id.button_addition:
                    input.append(firstNumber + secondNumber) ;
                    break;
            }
        } else if (input.length() > 0 && state == State.firstArgInput) {
            firstNumber = Double.parseDouble(input.toString());
            state = State.secondArgInput;
            input.setLength(0);
        switch (actionId) {
            case R.id.button_multiplication:
                actionSelected = R.id.button_multiplication;
                break;
            case R.id.button_division:
                actionSelected = R.id.button_division;
                break;
            case R.id.button_subtraction:
                actionSelected = R.id.button_subtraction;
                break;
            case R.id.button_addition:
                actionSelected = R.id.button_addition;
                break;
            case R.id.button_equality:
                actionSelected = R.id.button_equality;
                break;
        }
    }
    }

    public String getText(){
        return input.toString();
    }
}
