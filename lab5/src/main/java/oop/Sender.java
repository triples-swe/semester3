package oop;

import java.util.Scanner; // Импортируем класс для работы с вводом данных
import java.io.*; // Импортируем классы для работы с вводом-выводом
import java.net.*; // Импортируем классы для работы с сетевыми соединениями
import java.util.ArrayList; // Импортируем класс для работы с динамическими массивами

public class Sender {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Создаем объект Scanner для считывания ввода с клавиатуры
        Socket socket = null; // Сокет для подключения к серверу

        try {
            // Список доступных получателей
            ArrayList<String> receiverNames = new ArrayList<>();
            receiverNames.add("Receiver1");
            receiverNames.add("Receiver2");

            // Вывод доступных получателей
            System.out.println("Доступные получатели: ");
            for (int i = 0; i < receiverNames.size(); i++) {
                System.out.println(i + " - " + receiverNames.get(i));
            }

            // Запрашиваем у пользователя номер получателя
            System.out.print("Введите номер получателя: ");
            String receiverIndex = scan.nextLine(); // Получаем номер получателя

            // Запрашиваем у пользователя сообщение
            System.out.print("Введите сообщение: ");
            String message = scan.nextLine(); // Получаем сообщение

            // Устанавливаем соединение с сервером
            socket = new Socket(InetAddress.getLocalHost(), 3030);
            System.out.println("Сообщение отправлено!"); // Уведомление об отправке сообщения

            // Отправляем сообщение
            try (PrintStream ps = new PrintStream(socket.getOutputStream())) {
                ps.println(receiverIndex + " " + message); // Форматируем строку с номером получателя и сообщением
                ps.flush(); // Очищаем поток
            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e); // Вывод сообщения об ошибке
        } finally {
            // Закрываем сокет, если он был успешно открыт
            if (socket != null) {
                try {
                    socket.close(); // Отключение от сервера
                } catch (IOException e) {
                    System.out.println("Ошибка при закрытии сокета: " + e);
                }
            }
            scan.close(); // Закрываем Scanner
        }
    }
}