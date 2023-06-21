package org.example.dao.model;

/**
 * Enumeration of all shapes
 */
public enum Shape {

    /**
     * Rectangle shape
     */
    RECTANGLE("rectangle"),

    /**
     * Circle shape
     */
    CIRCLE("circle"),

    /**
     * Triangle shape
     */
    TRIANGLE("triangle"),
    /**
     * Square shape
     */
    SQUARE("square"),
    /**
     * Unknown shape
     */
    UNKNOWN("unknown")
    ;

    private final String shapeType;

    Shape(String shapeType) {this.shapeType = shapeType;}

    public static Shape valueOfShape(String shapeType) {
        for (Shape s : values()) {
            if (s.shapeType.equals(shapeType)) {
                return s;
            }
        }
        return Shape.valueOf("UNKNOWN");
    }

    public String getShapeType() {
        return shapeType;
    }
}
