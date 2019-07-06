package mvc.controler;

import mvc.model.entity.Point;

import java.util.List;

public interface Calculation {
    boolean IsPointInsidePolygon (List<Point> p, Point userpoint);
    boolean isPointOnEdges(List<Point> points, Point userpoint);
    boolean isPointOnTop(List<Point> points, Point userpoint);
}
