public class Line {

    private String number;
    private String name;

    public Line(String name, String number) {
        this.name = name;
        this.number = number;
    }


    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return  "\nЛиния: " + name + "\n" +
                "Номер линии: " + number + "\n";
    }
}
