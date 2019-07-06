package mvc.view.impl;

import mvc.view.MainView;

public class MainViewImpl implements MainView {
    @Override
    public void enterPath() {
        System.out.println("Введите путь к файлу:");
    }

    @Override
    public void enterPoint() {
        System.out.println("Введите координаты:");
    }

    @Override
    public void pointInsideTheQuad() {
        System.out.println("Точка внутри четырехугольника.");
    }

    @Override
    public void pointLiesOnSidesOfQuad() {
        System.out.println("Точка лежит на сторонах четырехугольника.");
    }

    @Override
    public void pointIsTopOfQuad() {
        System.out.println("Точка - вершина четырехугольника.");
    }

    @Override
    public void pointOutsideQuad() {
        System.out.println("Точка снаружи четырехугольника.");
    }
}
