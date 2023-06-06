public class Main
{
    public static void main(String[] args)
    {
 /**
        System.out.println("Поиск файлов json и csv:");
        FileSearch fileSearch = new FileSearch();
        System.out.println(fileSearch.fileSearch("data/folders/"));

        System.out.println("\n Парсинг файла формата .csv:");
        CsvParser csvParser = new CsvParser();
        csvParser.getMapFromCsvFile("data/folders/0/5/dates-2.csv");
        System.out.println("Вывод списка дат файла dates-2.csv:");
        System.out.println(csvParser.getNamesOrDates(CsvParser.Type.DATES));
        System.out.println("Вывод списка имен станций файла dates-2.csv:");
        System.out.println(csvParser.getNamesOrDates(CsvParser.Type.NAMES));

        System.out.println("Парсинг JSON файла:");
        JsonParser jsonParser = new JsonParser();
        try {
            jsonParser.getJsonFile("data/folders/4/6/depths-3.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        jsonParser.getStationsAndDepths().forEach(System.out::println);

        System.out.println("Парсинг веб-сайта");
        WebParser webParser = new WebParser("https://skillbox-java.github.io/");
        System.out.println("Станции и номера линий:");
        System.out.println(webParser.getStations());
        System.out.println("Имена линий и их номера");
        System.out.println(webParser.getLines());


//        System.out.println("Список линий: \n");
////        webParser.getLines().forEach(System.out::println);
//        System.out.println("Список станций: \n");
//        webParser.getStations().forEach(System.out::println);
//        System.out.println(webParser.getHtmlCode());

        System.out.println("Создание и запись JSON-файла:");
        JsonFileOutput output = new JsonFileOutput();
        try {
            output.writeStationsJson();
        } catch (IOException e) {
            e.printStackTrace();
        }
  */

        FileSearch fileSearch = new FileSearch("data/folders");
//        System.out.println(fileSearch.fileNames());
        System.out.println(fileSearch.getFilePath("dates-2.csv"));
    }
}
