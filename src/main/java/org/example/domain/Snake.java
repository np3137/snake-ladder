package org.example.domain;

public final class Snake extends Jump
{
   public Snake(Position head, Position tail)
   {
       super(head, tail);
       if(head.getValue() <= tail.getValue())
       {
          throw new IllegalArgumentException("Snake must move Downwards");
       }
   }
}
