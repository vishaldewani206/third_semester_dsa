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
        Country pk = new Country("pk", "Urdu", 1200);
        Country in = new Country("in", "Hindi", 4000);
        Country id = new Country("id", "bahasa", 3000);
        Country sa = new Country("sa", "Arabic", 1000);

        HashTable hb = new HashTable();

        hb.put(120, pk);
        hb.put(121, in);
        hb.put(122, id);
        hb.put(123, sa);

        System.out.println(hb.get(122));
        System.out.println(hb.get(123));
    }
}
