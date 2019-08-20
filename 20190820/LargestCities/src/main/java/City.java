import java.util.*;

public class City {

    public String name;
    public int population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public static void main(String[] args) {
        City new_york = new City("New York", 8654321);
        City los_angeles = new City("Los Angeles", 4563218);
        City chicago = new City("Chicago", 2716520);
        City denver = new City("Denver", 704621);
        City des_moines = new City("Des Moines", 217521);
        City atlanta = new City("Atlanta", 486213);


        Map<String, City> cities = new HashMap<>();
//        Map<String, City> cities = new HashMap<>();

        cities.put("New York", new_york);
        cities.put("California", los_angeles);
        cities.put("Illinos", chicago);
        cities.put("Colorado", denver);
        cities.put("Iowa", des_moines);
        cities.put("Georgia", atlanta);

        Set<String> myKeys = cities.keySet();
        for (String key : myKeys) {
            System.out.println("State: " + key + "/ City: " + cities.get(key).getName() + "/ Population: " + cities.get(key).getPopulation());
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("Give me a population number");
        int userNum = Integer.parseInt(scan.nextLine());
        for (String key : myKeys) {
            if (cities.get(key).getPopulation() >= userNum) {
                System.out.println("State: " + key + "/ City: " + cities.get(key).getName() + "/ Population: " + cities.get(key).getPopulation());
            }
        }


    }

}
