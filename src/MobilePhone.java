import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MobilePhone extends Product {
    private int id;
    private int storage;
    private double screenSize;
    private int battery;
    private int RAM;
    private String color;
    private int camera;
    private Brand brand;
    private static ArrayList<MobilePhone> products = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public MobilePhone(double unitPrice, double discountRate, int stockAmount, String name, Brand brand, int storage, double screenSize, int battery, int RAM, String color, int camera) {
        super(unitPrice, discountRate, stockAmount, name, brand);
        this.id = generateUniqueID(name);
        this.storage = storage;
        this.screenSize = screenSize;
        this.battery = battery;
        this.RAM = RAM;
        this.color = color;
        this.camera = camera;
    }

    public MobilePhone() {

    }

    static {

        products.add(new MobilePhone(3199.0, 0.0, 142, "GALAXY A51", new Brand("SAMSUNG"), 128, 6.5, 4000, 6, "Siyah", 32));
        products.add(new MobilePhone(7379.0, 0.0, 12, "11", new Brand("APPLE"), 64, 6.1, 3046, 6, "Mavi", 5));
        products.add(new MobilePhone(4012.0, 0.0, 165, "Note 10 Pro", new Brand("XIAOMI"), 128, 6.5, 4000, 12, "Beyaz", 35));

    }

    private int generateUniqueID(String name) {
        int generatedID = 0;
        for (int i = 0; i < name.length(); i++) {
            generatedID += name.charAt(i) * 10;
        }
        return generatedID;
    }

    @Override
    public void operation() {
        super.operation();
    }

    @Override
    public void printProduct() {
        printProductList(products);
    }

    public void printProductList(ArrayList<MobilePhone> printProductList) {
        ArrayList<MobilePhone> products = printProductList;

        String format = "| %-8s | %-30s | %-22s | %-12s | %-11s | %-13s | %-11s | %-13s | %-12s | %-10s |\n";
        System.out.format("+----------+--------------------------------+------------------------+--------------+-------------+---------------+-------------+---------------+--------------+------------+\n");
        System.out.format("| ID       | Ürün Adı                       | Fiyat                  | Marka        | Depolama    | Ekran         | Kamera      | Pil           | RAM          | Renk       |\n");
        System.out.format("+----------+--------------------------------+------------------------+--------------+-------------+---------------+-------------+---------------+--------------+------------+\n");

        for (int i = 0; i < products.size(); i++) {
            System.out.format(format, products.get(i).getUniqueID(), products.get(i).getBrand().getName() +" "+products.get(i).getName() ,products.get(i).getUnitPrice() ,products.get(i).getBrand().getName() , products.get(i).getStorage(),
                    products.get(i).getScreenSize(),products.get(i).getCamera(),products.get(i).getBattery(),products.get(i).getRAM(),products.get(i).getColor());
        }

        System.out.format("+----------+--------------------------------+------------------------+--------------+-------------+---------------+-------------+---------------+--------------+------------+\n");
    }

    @Override
    public void addProduct() {


        System.out.print("Fiyat: ");
        int unitePrice = input.nextInt();

        System.out.print("İndirim Oranı: ");
        double discountRate = input.nextDouble();

        System.out.print("Stok Miktarı: ");
        int stockAmount = input.nextInt();

        System.out.print("Ürün Adı: ");
        input.nextLine();
        String name = input.nextLine();

        System.out.print("Marka: ");
        String brand = input.nextLine().toUpperCase();

        System.out.print("Depolama: ");
        int storage = input.nextInt();

        System.out.print("Ekran Boyutu: ");
        double screenSize = input.nextDouble();

        System.out.print("Pil: ");
        int battery = input.nextInt();

        System.out.print("RAM: ");
        int RAM = input.nextInt();

        System.out.print("Renk: ");
        String color = input.nextLine();
        input.nextLine();

        System.out.print("Kamera: ");
        int camera = input.nextInt();

        if(!Brand.getBrandNameList().contains(brand)){
            Brand.getBrands().add(new Brand(brand));
        }

        products.add(new MobilePhone(unitePrice, discountRate, stockAmount, name, new Brand(brand), storage, screenSize, battery, RAM, color, camera));
        System.out.println("Ürün eklendi...");

    }

    @Override
    public void deleteProductByID() {
        System.out.print("Silmek istediğiniz ürünün ID numarasını giriniz: ");
        int ID = input.nextInt();

        if(getProductIDlist().contains(ID)){
            products.remove(getProductIDlist().indexOf(ID));
            System.out.println(ID + " ID numaralı ürün silindi.");
        }else{
            System.out.println("Bu ID numarasına sahip ürün bulunamadı!");
        }
    }

    @Override
    public void filterProductByBrand() {
        ArrayList<MobilePhone> FilteredProducts = new ArrayList<>();

        for(int i = 0; i< Brand.getBrandNameList().size();i++){
            System.out.println(i+1 + " | " + Brand.getBrandNameList().get(i));
        }
        System.out.print("Filtreleme yapmak istediğiniz Markayı seçiniz: ");
        int brandIndex = input.nextInt();
        for(MobilePhone phone: products){
            if(phone.getBrand().getName().equals(Brand.getBrandNameList().get(brandIndex-1))){
                FilteredProducts.add(phone);
            }
        }
        printProductList(FilteredProducts);

    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public static ArrayList<MobilePhone> getProducts() {
        return products;
    }

    public static void setProducts(ArrayList<MobilePhone> products) {
        MobilePhone.products = products;
    }
    public ArrayList<Integer> getProductIDlist(){
        ArrayList<Integer> productIDList = new ArrayList<>();

        for (MobilePhone phone: products) {
            productIDList.add(phone.getId());
        }
        return productIDList;
    }
}
