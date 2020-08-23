package com.plumbox;

import javax.swing.*;
import java.util.Scanner;

import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int sticks = (int)(Math.random()*9) + 21;
        System.out.println("There are " + sticks + " sticks.");

        System.out.println("Player - Select 1 to go first, select 2 to go second.");
        boolean turn = true;
        if(reader.nextInt() == 1) {
            turn = true;
        }
        else {
            turn = false;
        }

        // REPEAT UNTIL NO MORE STICKS
        int picks = 0;
        while(true) {
            // do-block
            System.out.println("Game - " + sticks + " sticks left.");
            if (turn == true) {
                // player pick
                System.out.println("Player: Select 1 to 3 sticks to pick.");
                picks = reader.nextInt();
                if (picks > 3) {
                    picks = 3;
                    System.out.println("Player: No cheating! Picks reset to 3");
                }
                else if (picks < 1) {
                    picks = 1;
                    System.out.println("Player: No cheating! Picks reset to 1");
                }
            }
            else {
                // computer pick
                if (sticks % 4 != 0) {
                    picks = sticks % 4;
                }
                else {
                    picks = (int)(Math.random()*2) + 1;
                }
                System.out.println("Computer: pick" + picks + " sticks.");
            }
            // termination? - for end of game
            sticks = sticks - picks;
            if (sticks <= 0) {
                System.out.println("The winner is " + ((turn) ? "player" : "computer"));
                break;
            }

            // next frame, no winner yet
            turn = !turn;
        }
    }
}
