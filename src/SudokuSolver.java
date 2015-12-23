import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;

public class SudokuSolver {
    private Cell[][] cells = new Cell[9][9];
    public void solveSudoku(char[][] board) {
         for(int i = 0;i < 9;i++)
            for(int j = 0;j < 9;j++)
                cells[i][j] = new Cell(i, j, 0);
        // Decoding input board into the internal cell matrix.
        // As we do it - constraints are propagated and even additional values are set as we go
        // (in the case if it is possible to unambiguously deduce them).
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !set(i, j, board[i][j] - '0'))
                    return; // sudoku is either incorrect or unsolvable
            }
        }
        // if we're lucky we've already got a solution,
        // however, if we have empty cells we need to use backtracking to fill them
        if (!findValuesForEmptyCells())
            return; // sudoku is unsolvable
        // copying the solution back to the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (cells[i][j].value != 0)
                    board[i][j] = (char) (cells[i][j].value + '0');
            }
        }
    }
    
    boolean set(int i, int j, int v) {
        Cell c = cells[i][j];
        if(c.value == v)
            return true;
        if(c.used.get(v))
            return false;
        
        c.value = v;
        c.used.set(1, 10);
        c.used.clear(v);
        
        for (int k = 0; k < 9; k++) {
            // to the row: 
            if (i != k && !updateConstraints(k, j, v))
                return false;
            // to the column:
            if (j != k && !updateConstraints(i, k, v))
                return false;
            // to the 3x3 square:
            int ix = (i / 3) * 3 + k / 3;
            int jx = (j / 3) * 3 + k % 3;
            if (ix != i && jx != j && !updateConstraints(ix, jx, v))
                return false;
        }
        return true;
    }
    
    boolean updateConstraints(int i, int j, int excludedValue) {
        Cell c = cells[i][j];
        if (c.used.get(excludedValue))
            return true;
        if (c.value == excludedValue)
            return false;

        c.used.set(excludedValue);
        if (c.used.cardinality() < 8)
            return true;
        for (int v = 1; v <= 9; v++)
            if (!c.used.get(v))
                return set(i, j, v);
        
        System.out.println("error");
		return false;//not used
    }
    
    ArrayList<Cell> pq = new ArrayList<Cell>();
    boolean findValuesForEmptyCells(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (cells[i][j].value == 0)
                    pq.add(cells[i][j]);
            }
        }
        Collections.sort(pq, new Comparator<Cell>(){
            public int compare(Cell o1, Cell o2) {
                if (o1.used.cardinality() < o2.used.cardinality())
                    return 1;
                else if (o1.used.cardinality() > o2.used.cardinality())
                    return -1;
                else
    				return 0;
    		}
        });
        // for(int i = 0;i < pq.size();i++)
        //     System.out.println(pq.get(i).used.size());
        return backtrack(0);
    }

    // Finds value for all empty cells with index >=k
    boolean backtrack(int k){
        if (k >= pq.size())
            return true;
        Cell c = pq.get(k);
        // fast path - only 1 possibility
        if (c.value != 0)
            return backtrack(k + 1);
        // slow path >1 possibility.
        // making snapshot of the state
        Cell[][] snapshot = new Cell[9][9];
        for(int i = 0;i < 9;i++)
            for(int j = 0;j < 9;j++){
                snapshot[i][j] = new Cell(i, j, cells[i][j].value);
                snapshot[i][j].used = (BitSet) cells[i][j].used.clone();
            }
        
        BitSet used = (BitSet) c.used.clone();
        for (int v = 1; v <= 9; v++) {
            if (!used.get(v)) {
                if (set(c.i, c.j, v)) {
                    if (backtrack(k + 1))
                        return true;
                }
                // restoring from snapshot,
                // note: computationally this is cheaper
                // than alternative implementation with undoing the changes
                for(int i = 0;i < 9;i++)
                    for(int j = 0;j < 9;j++){
                    cells[i][j].value = snapshot[i][j].value;
                    cells[i][j].used = (BitSet) snapshot[i][j].used.clone();
                }
            }
        }
        return false;
    } 
    
    
    class Cell{
        int i, j, value;
        BitSet used = new BitSet(10);
        
        public Cell(int i, int j, int value){
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }
}
