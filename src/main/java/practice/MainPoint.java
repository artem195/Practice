package practice;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Kirill Zhitelev on 16.07.2015.
 */
public class MainPoint {
    private static Point point = new Point();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        CreateImage image = new CreateImage(1000, 600, point);
        System.out.print("Radius = ");
        int radius = sc.nextInt();
        point.findPointsAndCenter(radius);

        image.drawImage(radius);
    }

}
