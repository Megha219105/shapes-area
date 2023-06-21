package org.example.utils;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Helper {

    public static Area area = new Area();

    public static List<JSONObject> getRecords(String[] args) {
        List<JSONObject> records = new ArrayList<>();

        try {
            Arrays.asList(args)
                    .stream()
                    .forEach(str -> records.add(new JSONObject(str)));
        } catch (Exception e) {
            System.out.println("The batch failed due to exception "+ e);
            return null;
        }
        return records;
    }

    public static double getTotalArea(List<JSONObject> args) {
        double result = 0;
        for (JSONObject row: args) {
            double shapeArea = area.getArea(row);
            result += shapeArea;
        }

        return result;
    }
}
