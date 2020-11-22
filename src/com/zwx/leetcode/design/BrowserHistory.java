package com.zwx.leetcode.design;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {

    List<String> history;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
    }

    public void visit(String url) {
        if( !history.contains(url)){
            return;
        }
    }

    public String back(int steps) {
        return null;

    }

    public String forward(int steps) {
        return "";
    }
}
