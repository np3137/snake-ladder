package org.example.domain;

import java.util.Objects;

public abstract class Jump
{
   private final Position start;
   private final Position end;

   protected Jump(Position start, Position end)
   {
       this.start = Objects.requireNonNull(start);
       this.end = Objects.requireNonNull(end);
   }

   public Position getStart()
   {
      return start;
   }

   public Position getEnd()
   {
      return end;
   }
}
