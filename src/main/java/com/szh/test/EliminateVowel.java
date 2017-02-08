package com.szh.test;

/**
 * Created by zhihaosong on 16-9-26.
 */
public class EliminateVowel {
    private String str;

    public EliminateVowel(String str) {
        this.str = str;
    }

    public static String strings = "aeiou";

    public String eliminateVowelString() {
        String result = "";
        if (str == null)
            return null;
        for (Character s : str.toCharArray()) {
            if (strings.contains(s.toString().toLowerCase()))
                continue;
            result = result + s.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        // System.out.println(new EliminateVowel().eliminateVowelString("aeAEEEoussadWFSDGRRRRRREEEEEEEE"));
        String str = "";
        System.out.println(str.length());
    }
}
