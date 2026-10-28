package org.example.service;

import org.example.domain.Board;
import org.example.domain.Player;
import org.example.domain.Position;
import org.example.domain.dice.Dice;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Game
{
   private final Dice dice;
   private final Board board;

   private final Queue<Player> players;

   public Game(Dice dice, Board board, List<Player> playerList)
   {
      this.dice = dice;
      this.board = board;
      this.players = new ArrayDeque<>(playerList);
   }

   public void play()
   {
      while(true)
      {
        Player currentPlayer = players.peek();
        players.poll();

        int nextStep = dice.roll();
        Position currentPosition = currentPlayer.getCurrentPosition();
        Position nextPosition = currentPosition.moveBy(nextStep);
        if(board.isOnBoard(nextPosition))
        {
           nextPosition = board.resolveLanding(nextPosition);
           currentPlayer.moveTo(nextPosition);
        }
        System.out.println(
                  currentPlayer.getName()
                          + " rolled " + nextStep
                          + " and is at "
                          + currentPlayer
                          .getCurrentPosition()
                          .getValue()
        );

        if(board.isWinningPosition(currentPlayer.getCurrentPosition()))
        {
            System.out.println(
                    currentPlayer.getName() + " won!"
            );
            return;
        }
        players.offer(currentPlayer);
      }
   }
}
