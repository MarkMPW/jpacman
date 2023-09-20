package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        assertThat(unit.hasSquare()).isFalse();
    }


    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
        BasicSquare testSqure = new BasicSquare();
        unit.occupy(testSqure);
        assertThat(unit.getSquare()).isEqualTo(testSqure);
        assertThat(testSqure.getOccupants()).contains(unit);
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
        BasicSquare testSquare1 = new BasicSquare();
        BasicSquare testSquare2 = new BasicSquare();

        unit.occupy(testSquare1);
        unit.occupy(testSquare2);

        assertThat(unit.getSquare()).isEqualTo(testSquare2);
        assertThat(testSquare1.getOccupants()).doesNotContain(unit);
        assertThat(testSquare2.getOccupants()).contains(unit);
    }
}
