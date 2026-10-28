package org.example;

import org.example.domain.*;
import org.example.domain.dice.Dice;
import org.example.domain.dice.StandardDice;
import org.example.domain.jump.Ladder;
import org.example.domain.jump.Snake;
import org.example.service.Game;

import java.util.List;

public class SnakeAndLadderDemo
{

    public static void main(String[] args) {

        Board board = new Board(100);
        board.addJump(
                new Ladder(new Position(4), new Position(25))
        );
        board.addJump(
                new Ladder(new Position(13), new Position(46))
        );
        board.addJump(
                new Snake(new Position(40), new Position(3))
        );
        board.addJump(
                new Snake(new Position(99), new Position(10))
        );

        List<Player> players = List.of(
                new Player("Neha"),
                new Player("Riya")
        );

        Dice dice = new StandardDice();
        Game game = new Game(dice, board, players);
        game.play();
    }
}