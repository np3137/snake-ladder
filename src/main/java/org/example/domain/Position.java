package org.example.domain;

import java.util.Objects;

public final class Position
{
   private final int value;

   public Position(int value)
   {
      if(value<0)
      {
         throw new IllegalArgumentException("Values cannot be negative.");
      }
      this.value = value;
   }

   public int getValue()
   {
       return value;
   }

   public Position moveBy(int steps)
   {
      Position nextPosition = new Position(value + steps);
      return nextPosition;
   }

   @Override
   public boolean equals(Object object)
   {
      if(this == object)
      {
         return true;
      }

      if(object == null || getClass() != object.getClass())
      {
         return false;
      }

      Position position = (Position)object;
      return value==((Position) object).value;
   }

   @Override
   public int hashCode()
   {
      return Objects.hash(value);
   }
}
/*
String a = new String("Neha");
String b = new String("Neha");
sout(a==b);
sout(a.equals(b));
*/