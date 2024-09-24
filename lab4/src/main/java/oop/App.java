package oop;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class App {
    public static void main(String[] args) {
        // Создаем главное окно приложения
        JFrame frame = new JFrame("Circle Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);

        // Инициализируем начальные параметры круга
        int x = 0; // Координата X центра круга
        int y = 0; // Координата Y центра круга
        int radius = 20; // Радиус круга
        int speedX = 5; // Скорость движения по оси X
        int speedY = 5; // Скорость движения по оси Y

        // Основной цикл анимации
        while (true) {
            // Обновляем координаты круга
            x += speedX;
            y += speedY;

            // Проверяем, не вышла ли фигура за границы окна и меняем направление движения круга
            if (x + radius > frame.getWidth()) {
                x = frame.getWidth() - radius; // Корректируем позицию при столкновении с правой границей
                speedX *= -1; // Меняем направление движения по оси X
            }

            if (x - radius < 0) {
                x = radius; // Корректируем позицию при столкновении с левой границей
                speedX *= -1; // Меняем направление движения по оси X
            }

            if (y + radius > frame.getHeight()) {
                y = frame.getHeight() - radius; // Корректируем позицию при столкновении с нижней границей
                speedY *= -1; // Меняем направление движения по оси Y
            }

            if (y - radius < 0) {
                y = radius; // Корректируем позицию при столкновении с верхней границей
                speedY *= -1; // Меняем направление движения по оси Y
            }

            // Удаляем все из окна и добавляем в него измененный круг
            frame.getContentPane().removeAll();
            frame.getContentPane().add(new Circle(x, y, radius)); // Создаем круг с обновленными координатами/радиусом
            frame.getContentPane().validate();
            frame.getContentPane().repaint(); // Перерисовываем окно

            try {
                Thread.sleep(20); // Задержка для управления частотой кадров
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Circle extends JPanel {
        private int x;
        private int y;
        private int radius;

        // Конструктор класса Circle
        public Circle(int x, int y, int radius) {
            this.x = x; // Устанавливаем координату X
            this.y = y; // Устанавливаем координату Y
            this.radius = radius; // Устанавливаем радиус
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g); // Вызываем метод родительского класса
            Graphics2D g2d = (Graphics2D) g; // Преобразуем Graphics в Graphics2D
            g2d.setColor(Color.BLUE); // Устанавливаем цвет круга
            // Рисуем круг с заданными координатами и радиусом
            g2d.fill(new Ellipse2D.Double(x - radius, y - radius,
                    2 * radius, 2 * radius));
        }
    }
}