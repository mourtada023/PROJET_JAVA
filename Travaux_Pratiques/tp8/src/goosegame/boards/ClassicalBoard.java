package goosegame.boards;
import goosegame.cells.*;

public class ClassicalBoard extends Board
{

      /**
     * Constructor of this. It calls the the constructor of the Mother class ( Board) using super
     * @param nbOfCells the number of cells
     */
	public ClassicalBoard() {
		super(64);
	}

    /**
     * Method to initialize the board
     */
	public void initBoard(){
		Cell[] cells = new Cell[64];

		cells[0] = new StartCell(0);

		for (int i = 1; i < 64; i++) {
			cells [i] = new Cell(i);
		}

		int[] gooseCells = {9, 18, 27, 36, 45, 54};

		for (int i : gooseCells) {
			cells [i] = new GooseCell(i);
		}

		cells[19] = new WaitCell(19,2);

		cells[31] = new TrapCell(31);
		cells[52] = new TrapCell(52);

		cells[6] = new TeleportCell(6);
		cells[42] = new TeleportCell(42);
		cells[58] = new TeleportCell(58);

		this.setCells(cells);
	}

}
