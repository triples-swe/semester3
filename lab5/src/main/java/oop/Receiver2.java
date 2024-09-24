package oop;

import java.io.*; // Импортируем классы для работы с вводом-выводом
import java.net.*; // Импортируем классы для работы с сетевыми соединениями

public class Receiver2 {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 3021); // Подключение к серверу
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) { // Буфер для чтения сообщения

            String msg = reader.readLine(); // Читаем сообщение
            if (msg != null) {
                System.out.println("Сообщение получено: " + msg); // Вывод сообщения
            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e); // Вывод сообщения об ошибке
        }
    }
}
