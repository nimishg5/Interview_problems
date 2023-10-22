package com.test.selfpractice.leetcode;

import java.util.Arrays;

public class KokoEatingBananas {

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3,6,7,11}, 8));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        if (piles.length == h) {
            return piles[piles.length-1];
        }

        boolean looping = true;

        int minSpeed = piles[piles.length-1];
        int chances = h;
        int tempSpeed = piles[piles.length-2];

        while (looping) {
            for (int i=piles.length-1; i>=0; i--) {
                int val = (int) Math.ceil((double)piles[i] / tempSpeed);
                chances -= val;
            }

            if (chances < 0) {
                looping = false;
            } else {
                minSpeed = Math.min(minSpeed , tempSpeed);
            }
            chances = h;
            tempSpeed--;
        }

        return minSpeed;
    }

}
