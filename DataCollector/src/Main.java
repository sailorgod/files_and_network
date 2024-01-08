import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {

        System.out.println("Поиск файлов json и csv:");
        FileSearch fileSearch = new FileSearch("data/folders");
        System.out.println(fileSearch.getFilePaths());

        System.out.println("\n Парсинг файла формата .csv:");
        CsvParser csvParser = new CsvParser("data/folders/0/5/dates-2.csv");
        System.out.println("Вывод списка станций и дат файла dates-2.csv:");
        System.out.println(csvParser.namesAndDates());

        System.out.println("Парсинг JSON файла:");
        JsonParser jsonParser = new JsonParser("data/folders/2/4/");
        System.out.println("Вывод списка станций и их глубины:");
        jsonParser.stationsAndDepths().forEach(System.out::println);

        System.out.println("Парсинг веб-сайта");
        WebParser webParser = new WebParser();
        System.out.println("Станции и номера линий:");
        System.out.println(webParser.getStations());
        System.out.println("Имена линий и их номера");
        System.out.println(webParser.getLines());

        System.out.println("Создание и запись JSON-файла:");
        JsonFileOutput output = new JsonFileOutput();
        try {
            output.writeStationsJson();
            output.writeMapJson();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
