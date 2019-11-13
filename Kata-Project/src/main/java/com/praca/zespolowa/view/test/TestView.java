package com.praca.zespolowa.view.test;

import com.praca.zespolowa.view.View;

/**
 * Created By wegrzyna on 13.11.2019
 */
public class TestView implements View {
    private String string;
    private Integer integer;
    private String info;
    private String error;

    @Override
    public String readString(String label) {
        return string;
    }

    @Override
    public int readInt(String label) {
        return integer;
    }

    @Override
    public void info(String message) {
        info = message;
    }

    @Override
    public void error(String message) {
        error = message;
    }

    public void setReadString(String string) {
        this.string = string;
    }

    public void setReadInt(Integer integer) {
        this.integer = integer;
    }

    public String getInfo() {
        return info;
    }

    public String getError() {
        return error;
    }
}