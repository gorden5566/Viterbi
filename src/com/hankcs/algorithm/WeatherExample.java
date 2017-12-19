package com.hankcs.algorithm;

import static com.hankcs.algorithm.WeatherExample.Weather.*;
import static com.hankcs.algorithm.WeatherExample.Activity.*;

public class WeatherExample {
    /**
     * 隐含状态
     */
    enum Weather {
        Rainy,
        Sunny,
    }

    /**
     * 可见状态
     */
    enum Activity {
        walk,
        shop,
        clean,
    }

    /**
     * 隐含状态链 states=('Rainy','Sunny')
     */
    static int[] states = new int[]{Rainy.ordinal(), Sunny.ordinal()};
    /**
     * 可见状态链 observations=('walk','shop','clean')
     */
    static int[] observations = new int[]{walk.ordinal(), shop.ordinal(), clean.ordinal()};
    /**
     * 初始概率(隐含状态) start_probability={'Rainy':0.6,'Sunny':0.4}
     */
    static double[] start_probability = new double[]{0.6, 0.4};
    /**
     * 转换概率(隐含状态 -> 隐含状态)
     *
     * transition_probability={
     *   'Rainy':{'Rainy':0.7,'Sunny':0.3},
     *   'Sunny':{'Rainy':0.4,'Sunny':0.6},
     * }
     */
    static double[][] transition_probability = new double[][]{
            {0.7, 0.3},
            {0.4, 0.6},
    };
    /**
     * 输出概率(隐含状态 -> 可见状态)
     *
     * emission_probability={
     *   'Rainy':{'walk':0.1,'shop':0.4,'clean':0.5},
     *   'Sunny':{'walk':0.6,'shop':0.3,'clean':0.1},
     * }
     */
    static double[][] emission_probability = new double[][]{
            {0.1, 0.4, 0.5},
            {0.6, 0.3, 0.1},
    };

    public static void main(String[] args) {
        int[] result = Viterbi.compute(observations, states, start_probability, transition_probability, emission_probability);
        for (int r : result) {
            System.out.print(Weather.values()[r] + " ");
        }
        System.out.println();
    }
}
