package org.example.domain;

import org.example.domain.jump.Jump;

import java.util.Objects;

public class Cell
{
   private final Position position;
   private Jump jump;

   public Cell(Position position)
   {
      this.position = Objects.requireNonNull(position);
   }

   public Jump getJump()
   {
      return jump;
   }

   public void addJump(Jump jump)
   {
       Objects.requireNonNull(jump);
       if (!position.equals(jump.getStart()))
       {
           throw new IllegalArgumentException("Jump must start from this cell");
       }

       if (this.jump != null)
       {
           throw new IllegalStateException("A cell can have only one jump");
       }

       this.jump = jump;
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

        Cell cell = (Cell)object;
        return position.equals(cell.position);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(position);
    }
}
