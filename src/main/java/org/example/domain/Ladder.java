package org.example.domain;

public final class Ladder extends Jump
{
   public Ladder(Position bottom, Position top)
   {
      super(bottom, top);
      if(bottom.getValue()>=top.getValue())
      {
         throw new IllegalArgumentException("Ladder must move upward.");
      }
   }
}
