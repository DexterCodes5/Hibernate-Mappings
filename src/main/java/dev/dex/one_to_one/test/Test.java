package dev.dex.one_to_one.test;

public class Test {
    public static void main(String[] args) {

    }
}

class C1 {
    int x;
    C2 c2;

    @Override
    public String toString() {
        return "C1{" +
                "x=" + x +
                ", c2=" + c2 +
                '}';
    }
}

class C2 {
    int x;
    C1 c1;

    @Override
    public String toString() {
        return "C2{" +
                "x=" + x +
                ", c1=" + c1 +
                '}';
    }
}
