package hash_table;

public class Country {
    String name;
    String language;
    int population;

    public Country(String name, String language, int population){
        this.name = name;
        this.language = language;
        this.population = population;
    }

    public String toString() {
        return "Name: " + name + " Language: " + language + " Population: " + population;
    }


    public static void main(String[] args) {
        Country pk = new Country("Pakistan", "Urdu", 1200);
        Country in = new Country("India", "Hindi", 4000);
        Country id = new Country("Indonesia", "bahasa", 3000);
        Country sa = new Country("Saudi Arabia", "Arabic", 1000);

        HashTable hb = new HashTable();

        hb.put("pk", pk);
        hb.put("in", in);
        hb.put("id", id);
        hb.put("sa", sa);

        System.out.println(hb.get("pk"));
        System.out.println(hb.get("in"));
    }
}
