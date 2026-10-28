package org.example.domain;

import java.util.Objects;

public class Board
{
   private final int size;
   private final Cell[] cells;

   public Board(int size)
   {
      if(size<=1)
      {
         throw new IllegalStateException("Board size must be greater than 1.");
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

   public void addJump(Jump jump)
   {
      Objects.requireNonNull(jump);
      validatePosition(jump.getStart());
      validatePosition(jump.getEnd());

      Cell startCell = getCell(jump.getStart());
      startCell.addJump(jump);
   }

   public boolean isOnBoard(Position position)
   {
      int cellNumber = position.getValue();
      return cellNumber >= 1 && cellNumber <= size;
   }

   public boolean isWinningPosition(Position position)
   {
      return position.getValue() == size;
   }

   public Position resolveLanding(Position landedPosition)
   {
      Cell landedCell = getCell(landedPosition);
      Jump jump = landedCell.getJump();
      if (jump == null)
      {
         return landedPosition;
      }
      return jump.getEnd();
   }

   private Cell getCell(Position position)
   {
      validatePosition(position);
      return cells[position.getValue()];
   }

   private void validatePosition(Position position)
   {
      if (!isOnBoard(position))
      {
         throw new IllegalArgumentException("Position is outside the board");
      }
   }
}