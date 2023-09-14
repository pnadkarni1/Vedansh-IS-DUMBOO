import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalcTest {

    //@BeforeEach tag
    //means that whatever code we put in there, executes before each method runs
    // none of the methods in SimpleCalc are static
    //so we need an object

    SimpleCalc easyCalc;

    @BeforeEach
    void setup() {

        easyCalc = new SimpleCalc();

    }

    @DisplayName("Add method two (+) nums")
    @Test

    void add_twoPos_shouldPass () {

        int sum = easyCalc.add(5, 6);
        assertEquals(11, sum);

    }

    @DisplayName("Add method first num negative")
    @Test

    void add_firstNumNeg_shouldMake0AndPass () {

        int sum = easyCalc.add(-9, 4);
        assertEquals(4, sum);

    }

    @DisplayName("Add method second num neg")
    @Test

    void add_secNumNeg_shouldMake0AndPass () {

        int sum = easyCalc.add(9, -4);
        assertEquals(9, sum);

    }

    @DisplayName("Div method divisor neg")
    @Test

    void div_divisorNeg_shouldThrowIllegal () {

        assertThrows(IllegalArgumentException.class, () -> easyCalc.division(-9, 7));

    }

    @AfterEach

    void teardown () {

        easyCalc = null;

    }

    @DisplayName("isOdd all odds ")
    @ParameterizedTest
    @ValueSource(ints = {1,5, 9, -15, -7, 21, 99, -273, 1001})

    void isOdd_allOdds_shouldReturnTrue (int num) {

        boolean odd = easyCalc.isOddNumber(num);
        assertTrue(odd);

    }

    @DisplayName("isOdd all evens")
    @ParameterizedTest
    @ValueSource(ints = {2, 10, 100, 1000})

    void isOdd_allEvens_shouldReturnFalse (int num) {

        boolean odd = easyCalc.isOddNumber(num);
        assertFalse(odd);

    }

}