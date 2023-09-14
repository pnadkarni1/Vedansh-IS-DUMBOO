import com.sun.jdi.connect.Connector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    //when testing complex objects
    //we need parameter to use
    //we do this by building a Stream of Arguments
    //Arguments.of() for us takes two values
    //an object to test and the expected output

    private static Stream<Arguments> provideName_fullNameListHasFullName() {

        return Stream.of (

                Arguments.of(new Person("Bill", null, "Dauterive"), false),
                Arguments.of(new Person("Phillip", "J.", "Fry"), true),
                Arguments.of(new Person("Daphne", "Anne ", "Blake"), true),
                Arguments.of(new Person("Quincy", "", "Magoo"), false),
                Arguments.of(new Person("Leopold", " ", "Stotch"), false)

        );


    }

    //@MethodSource tag is the private method we just made above this

    @DisplayName("Seeing if a Person has a full name or not")
    @ParameterizedTest
    @MethodSource("provideName_fullNameListHasFullName")
    void hasFullName_mixOfNames_shouldReturn2True3False(Person p,  boolean expected) {

        boolean fullName = p.hasFullName();
        assertEquals(expected, fullName);

    }

}