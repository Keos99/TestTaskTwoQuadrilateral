package mvc.controler;

import mvc.controler.impl.CalculationImpl;
import mvc.model.FileHandler;
import mvc.model.entity.Point;
import mvc.model.impl.FileHandlerImpl;
import mvc.view.MainView;
import mvc.view.impl.MainViewImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    private Point userpoint;
    private File file;
    private FileHandler model;
    private MainView view;
    private Calculation calculation;
    private Scanner scanner;
    private List<String> numbers;
    private List<Point> points;

    public MainController(String[] args){
        model = new FileHandlerImpl();
        view = new MainViewImpl();
        calculation = new CalculationImpl();
        scanner = new Scanner(System.in);
        run(args);
    }

    private void run(String[] args) {
        if (args.length != 0){
            acceptArguments(args);
        } else {
            requestArguments();
        }
        numbers = model.processFile(file);
        points = stringListToPointList(numbers);
        locationOfPoint(points, userpoint);

    }

    private void acceptArguments(String[] args) {
        userpoint = new Point();
        file = model.getFilePath(args[0]);
        userpoint.setX(Integer.parseInt(args[1]));
        userpoint.setY(Integer.parseInt(args[2]));
    }

    private void requestArguments(){
        view.enterPath();
        file = model.getFilePath(scanner.nextLine());
        view.enterPoint();
        userpoint = stringCoordinatesToPoint(scanner.nextLine());
    }

    private Point stringCoordinatesToPoint(String numbers){
        String[] input = numbers.split(" ");
        return new Point(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
    }

    private List<Point> stringListToPointList(List<String> numbers){
        List<Point> temp = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            temp.add(stringCoordinatesToPoint(numbers.get(i)));
        }
        return temp;
    }

    private void locationOfPoint(List<Point> points, Point userpoint){
        if (calculation.isPointOnTop(points, userpoint)){
            view.pointIsTopOfQuad();
        } else if (calculation.isPointOnEdges(points, userpoint)){
            view.pointLiesOnSidesOfQuad();
        } else if (calculation.IsPointInsidePolygon(points, userpoint)){
            view.pointInsideTheQuad();
        } else {
            view.pointOutsideQuad();
        }
    }
}
