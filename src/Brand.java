import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class Brand  implements Comparable<Brand>{
    private int id;
    private String name;
    private static TreeSet<Brand> brands = new TreeSet<>();





    public Brand(String name) {
        this.id = generateUniqueID(name);
        this.name = name;
    }

    public Brand(){

    }

    @Override
    public int compareTo(Brand b) {
        return this.getName().compareTo(b.getName());
    }




    public void printBrands(){
        System.out.println("______________________");
        System.out.println("|   Markalarımız      |");
        System.out.println("----------------------");
        System.out.printf("| %8s | %-8s |","ID", "MARKA" );
        System.out.println();

        for (Brand brand : brands){
            //System.out.printf("%10s",brand.getId(), "%50s" , brand.getName());

            System.out.printf("| %8s | %-8s |",brand.getId(), brand.getName() );
            System.out.println();
        }

        System.out.println("----------------------");
    }

    static {
        brands.add(new Brand("SAMSUNG"));
        brands.add(new Brand("LENOVO"));
        brands.add(new Brand("APPLE"));
        brands.add(new Brand("HUAWEI"));
        brands.add(new Brand("CASPER"));
        brands.add(new Brand("ASUS"));
        brands.add(new Brand("HP"));
        brands.add(new Brand("XIAOMI"));
        brands.add(new Brand("MONSTER"));
    }



    private int generateUniqueID(String name){
        int generatedID= 0;
        for(int i= 0; i< name.length(); i++){
            generatedID += name.charAt(i) * 10;
        }
        return generatedID;
    }

    public static ArrayList<String> getBrandNameList(){
        ArrayList<String> brandNameList = new ArrayList<>();
        for(Brand brand: brands){
            brandNameList.add(brand.getName());
        }

        return brandNameList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static TreeSet<Brand> getBrands() {
        return brands;
    }

    public static void setBrands(TreeSet<Brand> brands) {
        Brand.brands = brands;
    }
}
