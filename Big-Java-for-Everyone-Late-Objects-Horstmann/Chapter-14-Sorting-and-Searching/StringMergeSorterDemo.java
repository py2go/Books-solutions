package chapter14;

import java.util.Arrays;

public class StringMergeSorterDemo {
    public static void main(String[] args) {
        String[] randomStuff = { "Potato", "Champ", "New-York", "Supernatural", "Vice-versa", "Dishonor", "Dreams",
                "Obscene", "Cartography", "Buy", "Broken", "Sticks", "Tokyo", "Royal", "Bibliography", "Solution",
                "Lost", "Impressed", "Failure", "Reader", "Cat", "Distance", "Gourmet", "Investigator", "Sing", "Eye",
                "Highlight", "Dragon", "World", "Sky", "Rule", "Glassy", "Debugger", "Dreams", "Analyse", "Best",
                "Belief", "Snow", "Promises", "Drive", "Initiative", "Pong", "Hurt", "White", "Azure", "Carrot",
                "Aroma", "West", "Hotline", "Claim" };
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        StringMergeSorter.sort(randomStuff);
        stopwatch.stop();
        stopwatch.showElapsedTime();
        System.out.println(Arrays.toString(randomStuff));
    }
}
