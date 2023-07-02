import java.util.ArrayList;
import java.util.Scanner;

public abstract class Product {
    private int uniqueID;
    private double unitPrice;
    private double discountRate;
    private int stockAmount;
    private String name;
    private Brand brand;
    private Scanner input = new Scanner(System.in);
    private ArrayList<Product> products = new ArrayList<>();


    public Product(double unitPrice, double discountRate, int stockAmount, String name, Brand brand) {
        this.unitPrice = unitPrice;
        this.discountRate = discountRate;
        this.stockAmount = stockAmount;
        this.name = name;
        this.brand = brand;
        this.uniqueID = generateUniqueID(name);
    }

    public Product() {

    }

    public void operation() {


        boolean logic = true;
        while (logic) {
            System.out.println("------------------------");
            System.out.println("1 - Ürün Ekle");
            System.out.println("2 - Ürün Sil");
            System.out.println("3 - Ürünleri listele");
            System.out.println("4 - Filtreleme");
            System.out.println("0 - Ana menüye dön");

            System.out.print("Yapmak istediğiniz işlemi seçiniz: ");
            int choose = input.nextInt();
            switch (choose) {
                case 0:
                    logic = false;
                    System.out.println("Ana menüye dönülüyor. ");
                    break;
                case 1:
                    this.addProduct();
                    break;
                case 2:
                    this.deleteProductByID();
                    break;
                case 3:
                    this.printProduct();
                    break;
                case 4:
                    this.filterProductByBrand();
                    break;
                default:
                    System.out.println("Geçersiz seççim yaptınız.");

            }
        }
    }


    public void printProduct() {

    }

    public void addProduct() {


    }

    public void deleteProductByID() {


    }

    public void filterProductByBrand() {

    }

    private int generateUniqueID(String name) {
        int generatedID = 0;
        for (int i = 0; i < name.length(); i++) {
            generatedID += name.charAt(i) * 10;
        }
        return generatedID;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {

        if (unitPrice < 0) {
            this.unitPrice = 0;
        }
        this.unitPrice = unitPrice;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        if (discountRate < 0) {
            this.discountRate = 0;
        }
        this.discountRate = discountRate;
    }

    public int getStockAmount() {

        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {

        if (stockAmount < 0) {
            this.stockAmount = 0;
        }
        this.stockAmount = stockAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getUniqueID() {
        return this.uniqueID;
    }

}
