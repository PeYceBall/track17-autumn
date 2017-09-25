package ru.track;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


/**
 * Задание 1: Реализовать два метода
 *
 * Формат файла: текстовый, на каждой его строке есть (или/или)
 * - целое число (int)
 * - текстовая строка
 * - пустая строка (пробелы)
 *
 * Числа складываем, строки соединяем через пробел, пустые строки пропускаем
 *
 *
 * Пример файла - words.txt в корне проекта
 *
 * ******************************************************************************************
 *  Пожалуйста, не меняйте сигнатуры методов! (название, аргументы, возвращаемое значение)
 *
 *  Можно дописывать новый код - вспомогательные методы, конструкторы, поля
 *
 * ******************************************************************************************
 *
 */
public class CountWords {

    String skipWord;

    public CountWords(String skipWord) {
        this.skipWord = skipWord;
    }

    /**
     * Метод на вход принимает объект File, изначально сумма = 0
     * Нужно пройти по всем строкам файла, и если в строке стоит целое число,
     * то надо добавить это число к сумме
     * @param file - файл с данными
     * @return - целое число - сумма всех чисел из файла
     */
    public long countNumbers(File file) throws Exception {
        long summ = 0;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        try
        {
            String s;
            while((s = reader.readLine()) != null)
            {
                if(s.equals(this.skipWord))
                {
                    continue;
                }


                boolean flag = true;

                for(int i = 0; i < s.length(); i++)
                {
                    if(Character.isLetter(s.charAt(i)))
                    {
                        flag = false;
                        break;
                    }
                }

                if(flag)
                {
                    summ += new Long(s);
                }
            }
        }
        catch (Exception e)
        {
            throw e;
        }
        finally {
            reader.close();
        }

        return summ;
    }


    /**
     * Метод на вход принимает объект File, изначально результат= ""
     * Нужно пройти по всем строкам файла, и если в строка не пустая и не число
     * то надо присоединить ее к результату через пробел
     * @param file - файл с данными
     * @return - результирующая строка
     */
    public String concatWords(File file) throws Exception {
        StringBuilder result = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        try
        {
            String s;
            while ((s = reader.readLine()) != null)
            {
                if(s.equals(this.skipWord))
                {
                    continue;
                }

                if(s.isEmpty())
                {
                    continue;
                }

                boolean flag = false;
                for(int i = 0; i < s.length(); i++)
                {
                    if(Character.isLetter(s.charAt(i)) )
                    {
                       flag = true;
                       break;
                    }
                }

                if(flag)
                {
                    result.append(s);
                    result.append(" ");
                }

            }
        }
        catch(Exception e)
        {
            throw e;
        }
        finally {
            reader.close();
        }

        return result.toString();
    }

}

