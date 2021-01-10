package com.company;

import java.io.File;
import java.nio.file.Files;

public class Filewalker {

    // Рекурсивный метод листинга файлов
    public void walk( String path ) {

        File root = new File( path );
        File[] list = root.listFiles();

        if (list == null) return;

        for ( File f : list ) {
            if ( f.isDirectory() ) {
                walk( f.getAbsolutePath() );
                System.out.println( "Dir: " + f.getAbsoluteFile() );
            }
            else {
                System.out.println( "File: " + f.getAbsoluteFile() );
            }
        }
    }

    public static void main(String[] args) {

        File newFile1 = new File("C:\\Temp\\example.txt");

        // Создание файла
        try {
            if (newFile1.createNewFile())
                System.out.println("Файл создан");
            else
                System.out.println("Файл уже существует");
        }
        catch (Exception e) {
            System.err.println(e);
        }

        // Переименование файла
        File newFile2 = new File("C:\\Temp\\example2.txt");
        if (newFile1.renameTo(newFile2)) {
            System.out.println("Файл переименован успешно");;
        } else {
            System.out.println("Файл не был переименован");
        }

        File newFile3 = new File("C:\\Temp\\example3.txt");
        // Удаление файла
        if (newFile3.delete()) {
            System.out.println("Файл example3.txt удален");
        };

        // Копирование файла
        try {
            Files.copy(newFile2.toPath(), newFile3.toPath());
            System.out.println("Файл скопирован");
        }
        catch (Exception e) {
            System.err.println(e);
        }

        // Удаление файла
        if (newFile2.delete()) {
            System.out.println("Файл example2.txt удален");
        };

        // Рекурсивно показываем содержимое папки
        Filewalker fw = new Filewalker();
        fw.walk("C:\\Temp" );

    }
}
