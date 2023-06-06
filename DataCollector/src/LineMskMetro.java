public class LineMskMetro {

    private String number;
    private String name;

    public  LineMskMetro(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString(){
        return  "\nЛиния: " + name + "\n" +
                "Номер линии: " + number + "\n";
    }
}
