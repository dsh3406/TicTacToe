/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author suhyu
 */
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    public static int move(int[][] board, int move, String player){
        int row = 0;int col = 0;
    
        if(move == 7 || move == 8 || move == 9){
            row = 0;
        } if(move == 4 || move == 5 || move == 6){
            row = 1;
        } if(move == 1 || move == 2 || move == 3){
            row = 2;
        }
        if(move == 1 || move == 4 || move == 7){
            col = 0;
        }
        if(move == 2 || move == 5 || move == 8){
            col = 1;
        }
        if(move == 3 || move == 6 || move == 9){
            col = 2;
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(row == i && col == j && player.equals("P1")){
                    board[row][col] = 1;
                }
                if(row == i && col == j && player.equals("P2")){
                    board[row][col] = 2;
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        int winner = isWinner(board);
        if(winner == 1){
            return 1;
        }
        return 0;
    }
    
    public static int isWinner(int[][] board){
        for(int i = 0; i < board.length; i++){ 
            if(board[i][0] == 1 && board[i][1] == 1 && board[i][2] == 1){
                System.out.println("Player 1 Win!");
                return 1;
            }
            if(board[i][0] == 2 && board[i][1] == 2 && board[i][2] == 2){
                System.out.println("Player 2 Win!");
                return 1;
            }
            if(board[0][i] == 1 && board[1][i] == 1 && board[2][i] == 1){
                System.out.println("Player 1 Win!");
                return 1;
            }
            if(board[0][i] == 2 && board[1][i] == 2 && board[2][i] == 2){
                System.out.println("Player 2 Win!");
                return 1;
            }
            
        }
        if(board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1){
                System.out.println("Player 1 Win!");
                return 1;
            }
        if(board[0][0] == 2 && board[1][1] == 2 && board[2][2] == 2){
            System.out.println("Player 2 Win!");
            return 1;
        }
        if(board[0][2] == 1 && board[1][1] == 1 && board[2][0] == 1){
                System.out.println("Player 1 Win!");
                return 1;
            }
        if(board[0][2] == 2 && board[1][1] == 2 && board[2][0] == 2){
            System.out.println("Player 2 Win!");
            return 1;
        }
        return 0;
    }
    public static int checkIllegalMove(int move, Set<Integer> set){
        if(move < 1 || move > 9){
            System.out.println("Illegal Move.");
            return 1;
        }
        if(!set.add(move)){
            System.out.println("Move Already Made.");
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        int[][] tictoc = new int[3][3];
        int p1Move, p2Move; String p1 = "P1"; String p2 = "P2";
        Set <Integer> set = new HashSet<Integer>();
        Scanner scan = new Scanner(System.in);
        int isOver = 0; int illegalMove = 0;
        while(true){
            System.out.print("P1: ");
            p1Move = scan.nextInt();
            illegalMove = checkIllegalMove(p1Move, set);
            if(illegalMove == 1){
                System.out.print("P1: ");
                p1Move = scan.nextInt();
            }
            isOver = move(tictoc, p1Move, p1);
            if(isOver == 1){
                break;
            }
            System.out.print("P2: ");
            p2Move = scan.nextInt();
            illegalMove = checkIllegalMove(p2Move, set);
            if(illegalMove == 1){
                System.out.print("P2: ");
                p2Move = scan.nextInt();
            }
            isOver = move(tictoc, p2Move, p2);
            if(isOver == 1){
                break;
            }
            
        }
    }
    
}
