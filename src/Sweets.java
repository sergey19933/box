import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Sweets {
    private String name;
    private int weight;
    private int price;
    private String uniqueParameter;
    BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
    int w;
    int p;

    public Sweets(String name, int weight, int price, String uniqueParameter) throws IOException {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.uniqueParameter = uniqueParameter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUniqueParameter() {
        return uniqueParameter;
    }

    public void setUniqueParameter(String uniqueParameter) {
        this.uniqueParameter = uniqueParameter;
    }


    @Override
    public String toString() {
        return "Sweets{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", uniqueParameter='" + uniqueParameter + '\'' +
                ", bf=" + bf +
                ", w=" + w +
                ", p=" + p +
                '}';
    }
}
