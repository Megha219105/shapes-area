package org.example.utils;

import org.example.dao.model.Shape;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Area {

    Shape shape;

    public Area(){

    }

    public double getRectangleArea(JSONObject record) {

        return record.getDouble("width")*record.getDouble("height");
    }

    public double getTriangleArea(JSONObject record) {

        return 0.5*record.getDouble("base")*record.getDouble("height");
    }

    public double getCircleArea(JSONObject record) {

        BigDecimal pi = new BigDecimal(Math.PI).setScale(2, RoundingMode.HALF_UP);

        return pi.doubleValue()*Math.pow(record.getDouble("radius"), 2);
    }

    public double getSquareArea(JSONObject record) {

        return Math.pow(record.getDouble("side"), 2);
    }

    public double getArea(JSONObject record) {

        double result = 0;
        String type = record.getString("type");
        Shape shapeType = Shape.valueOfShape(type);


        if(shapeType.name().equalsIgnoreCase(shape.RECTANGLE.name())) {
            result = getRectangleArea(record);
        } else if (shapeType.name().equalsIgnoreCase(shape.TRIANGLE.name())) {
            result = getTriangleArea(record);
        } else if (shapeType.name().equalsIgnoreCase(shape.CIRCLE.name())) {
            result = getCircleArea(record);
        } else if (shapeType.name().equalsIgnoreCase(shape.SQUARE.name())) {
            result = getSquareArea(record);
        }

        return result;
    }

}
