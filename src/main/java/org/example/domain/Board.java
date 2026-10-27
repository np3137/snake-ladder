package org.example.domain;

import java.util.Objects;

public class Board
{
   private final int size;
   private final Cell[] cells;

   public Board(int size)
   {
      if(size <= 1)
      {
         throw new IllegalArgumentException("Board size must be greater than 1.");
      }
      this.size = size;
      this.cells = new Cell[size+1];

      createCells();
   }

   private void createCells()
   {
      for(int i=1;i<=size;i++)
      {
          cells[i] = new Cell(new Position(i));
      }
   }

   private Cell getCell(Position position)
   {
      validatePosition(position);
      return cells[position.getValue()];
   }

   public void addJump(Jump jump)
   {
        Objects.requireNonNull(jump);

        validatePosition(jump.getStart());
        validatePosition(jump.getEnd());

        getCell(jump.getStart()).addJump(jump);
   }

   public boolean isWinningPosition(Position position)
   {
       return position.getValue()==size;
   }

   public Position resolveLanding(Position landPosition)
   {
       Cell landedCell = getCell(landPosition);
       Jump jump = landedCell.getJump();
       return jump==null?landPosition:jump.getEnd();
   }

   public boolean isOnBoard(Position position)
   {
      int value = position.getValue();
      return value>=1 && value<=size;
   }

   private void validatePosition(Position position)
   {
      if(!isOnBoard(position))
      {
         throw new IllegalStateException("Position must lie within the board.");
      }
   }

}
