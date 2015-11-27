package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Point {
    private ArrayList<PointPosition> positions = new ArrayList<>();
    private InputStream is = MainPoint.class.getResourceAsStream("/coordinates.txt");
    private int x, y;
    private int centerX, centerY;

    public Point() {
        createPoints();
    }

    private void createPoints() {
        String line = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            while ((line = br.readLine()) != null) {
                String[] arr =line.split(" ");
                x = Integer.parseInt(arr[0]);
                y = Integer.parseInt(arr[1]);
                positions.add(new PointPosition(x, y));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findPointsAndCenter(int radius) {
        int N = 0;
        for (PointPosition position : positions) {
            if (position.getX() > radius || position.getY() > radius) {
                System.out.print("");
            } else {
                System.out.println("Point (" + position.getX() + ", " + position.getY() + ")" + " belongs to object");
                centerX += position.getX();
                centerY += position.getY();
                N++;
            }
        }
        centerX = centerX/N;
        centerY = centerY/N;
        System.out.println("Coordinates of center: (" + centerX + ", " + centerY + ")");
    }

    public ArrayList<PointPosition> getPositions() {
        return positions;
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }
}
