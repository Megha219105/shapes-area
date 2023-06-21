package org.example.utils;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AreaTest {

    Area area = new Area();

    @ParameterizedTest
    @DisplayName("Verify get the rectangle area")
    @MethodSource("provideJsonargsRectangle")
    void verifyRectangleArea(String input, double expectArea) {
        JSONObject row = new JSONObject(input);
        double res = area.getRectangleArea(row);
        assertEquals(expectArea, res);
    }

    @ParameterizedTest
    @DisplayName("Verify get the Triangle area")
    @MethodSource("provideJsonargsTriangle")
    void verifyTriangleArea(String input, double expectArea) {
        JSONObject row = new JSONObject(input);
        double res = area.getTriangleArea(row);
        assertEquals(expectArea, res);
    }

    @ParameterizedTest
    @DisplayName("Verify get the square area")
    @MethodSource("provideJsonargsSquare")
    void verifySquareArea(String input, double expectArea) {
        JSONObject row = new JSONObject(input);
        double res = area.getSquareArea(row);
        assertEquals(expectArea, res);
    }

    @ParameterizedTest
    @DisplayName("Verify get the circle area")
    @MethodSource("provideJsonargsCircle")
    void verifyCircleArea(String input, double expectArea) {
        JSONObject row = new JSONObject(input);
        double res = area.getCircleArea(row);
        assertEquals(expectArea, res);
    }

    @ParameterizedTest
    @DisplayName("Verify get the area based on type")
    @MethodSource("provideJsonargs")
    void verifyAreaBasedOnType(String input, double expectArea) {
        JSONObject row = new JSONObject(input);
        double res = area.getArea(row);
        assertEquals(expectArea, res);
    }

    private static Stream<Arguments> provideJsonargsRectangle() {
        return Stream.of(
                Arguments.of("{\"type\": \"rectangle\", \"width\": 5, \"height\": 10}\n" , 50.00),
                Arguments.of("{\"type\": \"parallelogram\", \"width\": 5, \"height\": 5}", 25.00)
        );
    }

    private static Stream<Arguments> provideJsonargsTriangle() {
        return Stream.of(
                Arguments.of("{\"type\": \"triangle\", \"base\": 2, \"height\": 3}\n" , 3.00),
                Arguments.of("{\"type\": \"triangle\", \"base\": 2, \"height\": 18}\n", 18.00)
        );
    }

    private static Stream<Arguments> provideJsonargsCircle() {
        return Stream.of(
                Arguments.of("{\"type\": \"circle\", \"radius\": 4}\n" , 50.24),
                Arguments.of("{\"type\": \"circle\", \"radius\": 7}\n", 153.86)
        );
    }

    private static Stream<Arguments> provideJsonargsSquare() {
        return Stream.of(
                Arguments.of("{\"type\": \"square\", \"side\": 10}\n", 100.00),
                Arguments.of("{\"type\": \"square\", \"side\": 4}\n", 16.00)
        );
    }

    private static Stream<Arguments> provideJsonargs() {
        return Stream.of(
                Arguments.of("{\"type\": \"triangle\", \"base\": 2, \"height\": 3}\n" , 3.00),
                Arguments.of("{\"type\": \"square\", \"side\": 4}\n", 16.00),
                Arguments.of("{\"type\": \"something\", \"side\": 4}\n", 0.00),
                Arguments.of("{\"type\": \"square\", \"height\": 4}\n", 0.00)
        );
    }
}