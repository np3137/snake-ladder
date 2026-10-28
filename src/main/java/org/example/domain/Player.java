package org.example.domain;

import java.util.Objects;

public class Player
{
    private final String name;
    private Position currentPosition;

    public Player(String name)
    {
       this.name = Objects.requireNonNull(name);
       currentPosition = new Position(0);
    }

    public String getName()
    {
       return name;
    }

    public Position getCurrentPosition()
    {
       return currentPosition;
    }

    public void moveTo(Position position)
    {
       this.currentPosition = Objects.requireNonNull(position);
    }

}
