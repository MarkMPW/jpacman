package nl.tudelft.jpacman.board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
/**
* Hero is the main entity we'll be using to . . .
* 
* Please see the {@link com.baeldung.javadoc.Person} class for true identity
* @author Captain America
* 
*/
public class BoardTest {
    private Board board;
    private int width = 1;
    private int height = 1;
    @BeforeEach
    void setUp() {
        Square[][] grid = new Square[width][height];
        grid[0][0] = new BasicSquare();
        board = new Board(grid);
    }

    @Test
    void testInvariant() {
        assertThat(board.invariant()).isNotNull();
    }

    @Test
    void testWidth() {
        assertThat(board.getWidth()).isEqualTo(width);
    }

    @Test
    void testHeight() {
        assertThat(board.getHeight()).isEqualTo(height);
    }

    @Test
    void testSquareAtWithNullSquare() {
        Square[][] grid = new Square[width][height];
        grid[0][0] = null;
        Board boardWithNull = new Board(grid);
        Square square = boardWithNull.squareAt(0, 0);
        assertThat(square).isNull();
    }
}
