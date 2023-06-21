package org.example.utils;

import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HelperTest {

    @Test
    @DisplayName("Test the records are generated from steam")
    void verifyRecordsList() {
        String input = "{\"type\": \"rectangle\", \"width\": 5, \"height\": 10}\n" +
                "{\"type\": \"triangle\", \"base\": 2, \"height\": 3}\n" +
                "{\"type\": \"circle\", \"radius\": 4}\n" +
                "{\"type\": \"rectangle\", \"width\": 5, \"height\": 5}";

        List<JSONObject> result = Helper.getRecords(getStrArray(input));

        assertNotNull(result);
        assertEquals(4, result.size());
        assertTrue(result.get(0) instanceof JSONObject);
    }

    @ParameterizedTest
    @DisplayName("Verify get the total area")
    @MethodSource("provideJsonargs")
    void verifyTotalArea(String input, double expectedArea) {

        List<JSONObject> inputs = Helper.getRecords(getStrArray(input));
        assertNotNull(inputs);

        double area = Helper.getTotalArea(inputs);
        assertEquals(expectedArea, area);
    }

    private static Stream<Arguments> provideJsonargs() {
        return Stream.of(
                Arguments.of("{\"type\": \"rectangle\", \"width\": 5, \"height\": 10}\n" +
                        "{\"type\": \"triangle\", \"base\": 2, \"height\": 3}\n" +
                        "{\"type\": \"circle\", \"radius\": 4}\n" +
                        "{\"type\": \"rectangle\", \"width\": 5, \"height\": 5}", 128.24),
                Arguments.of("{\"type\": \"rectangle\", \"width\": 5, \"height\": 10}\n" +
                        "{\"type\": \"rectangle\", \"width\": 5, \"height\": 5}", 75.00),
                Arguments.of("{\"type\": \"parallelogram\", \"width\": 5, \"height\": 5}", 0.00)
        );
    }

    @Test
    void verifyUseValidData() {

        String input = "{\"type\": \"triangle\", \"base\": , \"height\": 3}\n" +
                "{\"type\": \"circle\", \"radius\": 4}\n" + "Something else";

        List<JSONObject> inputs = Helper.getRecords(getStrArray(input));
        assertNotNull(inputs);
        double area = Helper.getTotalArea(inputs);

        assertEquals(50.24, area);

    }

    private static String[] getStrArray(String input){
        return Arrays.asList(input.split("\n")).toArray(new String[0]);
    }
}