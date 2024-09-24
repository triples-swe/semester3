package oop;

import java.net.*; // Импортируем классы для работы с сетевыми соединениями
import java.io.*; // Импортируем классы для работы с вводом-выводом

public class Server {
    public static void main(String[] args) {
        try {
            System.out.println("Сервер запущен!"); // Уведомление о запуске сервера

            // Создаем серверные сокеты для получения и отправки сообщений
            ServerSocket receiverSocket1 = new ServerSocket(3020);
            ServerSocket receiverSocket2 = new ServerSocket(3021);
            ServerSocket senderSocket = new ServerSocket(3030);

            // Ожидаем подключения от клиентов
            Socket receiver1 = receiverSocket1.accept(); // Подключение от первого клиента
            Socket sender = senderSocket.accept(); // Подключение от отправителя
            Socket receiver2 = receiverSocket2.accept(); // Подключение от второго клиента

            // Читаем сообщение от отправителя
            BufferedReader reader = new BufferedReader(new InputStreamReader(sender.getInputStream()));
            String msg = reader.readLine(); // Читаем сообщение
            String[] data = msg.split(" ", 2); // Разделяем на идентификатор получателя и само сообщение
            String recipientId = data[0]; // Получаем идентификатор получателя
            String message = data[1]; // Получаем само сообщение

            // Определяем, какому клиенту отправить сообщение
            Socket recipientSocket = recipientId.equals("0") ? receiver1 : receiver2;

            // Отправляем сообщение выбранному клиенту
            try (PrintStream ps = new PrintStream(recipientSocket.getOutputStream())) {
                ps.println(message); // Отправляем сообщение
                ps.flush(); // Очищаем поток
            } finally {
                recipientSocket.close(); // Закрываем сокет получателя
            }

        } catch (IOException e) {
            System.out.println("Ошибка: " + e); // Обработка исключений: выводим сообщение об ошибке
        }
    }
}
