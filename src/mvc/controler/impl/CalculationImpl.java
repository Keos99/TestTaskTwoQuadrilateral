package mvc.controler.impl;

import mvc.controler.Calculation;
import mvc.model.entity.Point;

import java.util.List;

import static java.lang.Math.abs;

public class CalculationImpl implements Calculation {

    @Override
    public boolean IsPointInsidePolygon (List<Point> p, Point userpoint) {

        int number = p.size();
        boolean flag = false;
        int i1, i2, S, S1, S2, S3;

        for (int i = 0; i < number; i++) {
            i1 = i < number - 1 ? i + 1 : 0;

            while (!flag) {
                i2 = i1 + 1;

                if (i2 >= number){
                    i2 = 0;
                }
                if (i2 == (i < number-1 ? i + 1 : 0)){
                    break;
                }

                S = abs (p.get(i1).getX() * (p.get(i2).getY() - p.get(i).getY())
                        + p.get(i2).getX() * (p.get(i).getY() - p.get(i1).getY())
                        + p.get(i).getX() * (p.get(i1).getY() - p.get(i2).getY()));

                S1 = abs (p.get(i1).getX() * (p.get(i2).getY() - userpoint.getY())
                        + p.get(i2).getX() * (userpoint.getY() - p.get(i1).getY())
                        + userpoint.getX() * (p.get(i1).getY() - p.get(i2).getY()));

                S2 = abs (p.get(i).getX() * (p.get(i2).getY() - userpoint.getY())
                        + p.get(i2).getX() * (userpoint.getY() - p.get(i).getY())
                        + userpoint.getX() * (p.get(i).getY() - p.get(i2).getY()));

                S3 = abs (p.get(i1).getX() * (p.get(i).getY() - userpoint.getY())
                        + p.get(i).getX() * (userpoint.getY() - p.get(i1).getY())
                        + userpoint.getX() * (p.get(i1).getY() - p.get(i).getY()));

                if (S == S1 + S2 + S3) {
                    flag = true;
                    break;
                }

                i1 = i1 + 1;
                if (i1 >= number){
                    i1 = 0;
                }
            }
            if (!flag){
                break;
            }
        }
        return flag;
    }

    @Override
    public boolean isPointOnEdges(List<Point> points, Point userpoint){
        return isPointBelongToSegment(points.get(0), points.get(1), userpoint) ||
                isPointBelongToSegment(points.get(1), points.get(2), userpoint) ||
                isPointBelongToSegment(points.get(2), points.get(3), userpoint) ||
                isPointBelongToSegment(points.get(3), points.get(0), userpoint);
    }

    private boolean isPointBelongToSegment(Point point1, Point point2, Point userPoint) {
        int dx1 = point2.getX() - point1.getX();
        int dy1 = point2.getY() - point1.getY();
        int dx = userPoint.getX() - point1.getX();
        int dy = userPoint.getY() - point1.getY();

        return (dx1 * dy - dx * dy1) == 0;
    }

    @Override
    public boolean isPointOnTop(List<Point> points, Point userpoint) {
        return points.get(0).equals(userpoint)
                || points.get(1).equals(userpoint)
                || points.get(2).equals(userpoint)
                || points.get(3).equals(userpoint);
    }
}
