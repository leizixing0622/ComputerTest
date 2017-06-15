package com.org.chomsky;

public class Principle {

    private String left;
    private String right;

    public Principle(String left, String right) {
        this.left = left;
        this.right = right;
    }

    public Principle() {

    }

    public String getLeft() {

        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }
}
