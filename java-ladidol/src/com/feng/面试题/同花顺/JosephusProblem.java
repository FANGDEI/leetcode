package com.feng.面试题.同花顺;

import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {
    public static List<Integer> getRemainingPlayers(int totalPlayers, int rounds) {
        List<Integer> players = new ArrayList<>();
        for (int i = 1; i <= totalPlayers; i++) {
            players.add(i);
        }

        int index = 0;
        for (int r = 0; r < rounds; r++) {
            int size = players.size();
            int count = 0;

            while (count < size) {
                index = (index + 1) % players.size();
                count++;

                if (count % 5 == 0) {
                    players.remove(index);
                    index--;
                }
            }
        }

        return players;
    }

    public static void main(String[] args) {
        int totalPlayers = 64;
        int rounds = 3;

        List<Integer> remainingPlayers = getRemainingPlayers(totalPlayers, rounds);
        System.out.println("Remaining players after " + rounds + " rounds:");
        for (int player : remainingPlayers) {
            System.out.print(player + " ");
        }
    }
}