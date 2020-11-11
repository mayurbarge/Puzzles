package backtracking

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object KnightTour extends App {
  val board = new BoardConfiguration()
  val initial = Cell(Integer.MIN_VALUE, new Position(1,1))

  var visited = new ListBuffer[Cell]()
  var path = new ListBuffer[Cell]()




}

case class BoardConfiguration() {
  val MAX = 8

  val cells = {
    val rows = List("1","2","3","4","5","6","7","8")
    val cols = List("1","2","3","4","5","6","7","8")
    for {
      r <- rows
      c <- cols
    } yield {
      Cell(Integer.MIN_VALUE, Position(r.toInt, c.toInt))
    }
  }

  def getCells(positions: List[Position]) = positions.flatMap(position => cells.find(position == _.position))
}
case class Cell(visited:Int, position: Position)
case class Position(row:Int, col: Int)

/*

#include<stdio.h>
#define N 8

int solveKTUtil(int x, int y, int movei, int sol[N][N], int xMove[],
                int yMove[]);

/* A utility function to check if i,j are valid indexes for N*N chessboard */
int isSafe(int x, int y, int sol[N][N])
{
    if ( x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1)
        return 1;
    return 0;
}

/* A utility function to print solution matrix sol[N][N] */
void printSolution(int sol[N][N])
{
    for (int x = 0; x < N; x++)
    {
        for (int y = 0; y < N; y++)
            printf(" %2d ", sol[x][y]);
        printf("\n");
    }
}

/* This function solves the Knight Tour problem using Backtracking.  This
function mainly uses solveKTUtil() to solve the problem. It returns false if
no complete tour is possible, otherwise return true and prints the tour.
Please note that there may be more than one solutions, this function
prints one of the feasible solutions.  */
bool solveKT()
{
    int sol[N][N];

    /* Initialization of solution matrix */
    for (int x = 0; x < N; x++)
        for (int y = 0; y < N; y++)
            sol[x][y] = -1;

    /* xMove[] and yMove[] define next move of Knight.
       xMove[] is for next value of x coordinate
       yMove[] is for next value of y coordinate */
    int xMove[8] = {  2, 1, -1, -2, -2, -1,  1,  2 };
    int yMove[8] = {  1, 2,  2,  1, -1, -2, -2, -1 };

    // Since the Knight is initially at the first block
    sol[0][0]  = 0;

    /* Start from 0,0 and explore all tours using solveKTUtil() */
    if(solveKTUtil(0, 0, 1, sol, xMove, yMove) == false)
    {
        printf("Solution does not exist");
        return false;
    }
    else
        printSolution(sol);

    return true;
}

/* A recursive utility function to solve Knight Tour problem */
int solveKTUtil(int x, int y, int movei, int sol[N][N], int xMove[N],
                int yMove[N])
{
   int k, next_x, next_y;
   if (movei == N*N)
       return true;

   /* Try all next moves from the current coordinate x, y */
   for (k = 0; k < 8; k++)
   {
       next_x = x + xMove[k];
       next_y = y + yMove[k];
       if (isSafe(next_x, next_y, sol))
       {
         sol[next_x][next_y] = movei;
         if (solveKTUtil(next_x, next_y, movei+1, sol, xMove, yMove) == true)
             return true;
         else
             sol[next_x][next_y] = -1;// backtracking
       }
   }

   return false;
}

/* Driver program to test above functions */
int main()
{
    solveKT();
    getchar();
    return 0;
}
 */
