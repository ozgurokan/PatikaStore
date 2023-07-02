import java.util.ArrayList;
import java.util.Scanner;

public class Notebook extends Product {
    private int storage;
    private double screenSize;
    private int RAM;
    private int id;
    private static ArrayList<Notebook> products = new ArrayList<>();
    private Scanner input = new Scanner(System.in);


    public Notebook(double unitPrice, double discountRate, int stockAmount, String name, Brand brand, int storage, double screenSize, int RAM) {
        super(unitPrice, discountRate, stockAmount, name, brand);
        this.storage = storage;
        this.screenSize = screenSize;
        this.RAM = RAM;
        this.id = generateUniqueID(name);
    }

    public Notebook() {

    }

    static {
        products.add(new Notebook(7000.0, 0.0, 12, "Matebook 14", new Brand("HUAWEI"), 512, 14.0, 32));
        products.add(new Notebook(3699.0, 0.0, 23, "V14 IGL", new Brand("LENOVO"), 1024, 14.0, 8));
        products.add(new Notebook(8199.0, 0.0, 33, "TUF Gaming", new Brand("ASUS"), 2048, 15.6, 32));

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

    public void printProductList(ArrayList<Notebook> printProductList) {
        ArrayList<Notebook> products = printProductList;

        String format = "| %-8s | %-30s | %-22s | %-12s | %-11s | %-13s | %-11s |\n";
        System.out.format("+----------+--------------------------------+------------------------+--------------+-------------+---------------+-------------+\n");
        System.out.format("| ID       | Ürün Adı                       | Fiyat                  | Marka        | Depolama    | Ekran         | RAM         |\n");
        System.out.format("+----------+--------------------------------+------------------------+--------------+-------------+---------------+-------------+\n");

        for (int i = 0; i < products.size(); i++) {
            System.out.format(format, products.get(i).getUniqueID(), products.get(i).getBrand().getName() + " " + products.get(i).getName(), products.get(i).getUnitPrice(), products.get(i).getBrand().getName(), products.get(i).getStorage(),
                    products.get(i).getScreenSize(), products.get(i).getRAM());
        }

        System.out.format("+----------+--------------------------------+------------------------+--------------+-------------+---------------+-------------+\n");
    }

    @Override
    public void printProduct() {
        printProductList(products);
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

        System.out.print("RAM: ");
        int RAM = input.nextInt();


        if (!Brand.getBrandNameList().contains(brand)) {
            Brand.getBrands().add(new Brand(brand));
        }

        products.add(new Notebook(unitePrice, discountRate, stockAmount, name, new Brand(brand), storage, screenSize, RAM));
        System.out.println("Ürün eklendi...");

    }

    @Override
    public void deleteProductByID() {
        System.out.print("Silmek istediğiniz ürünün ID numarasını giriniz: ");
        int ID = input.nextInt();

        if (getProductIDlist().contains(ID)) {
            products.remove(getProductIDlist().indexOf(ID));
            System.out.println(ID + " ID numaralı ürün silindi.");
        } else {
            System.out.println("Bu ID numarasına sahip ürün bulunamadı!");
        }
    }

    @Override
    public void filterProductByBrand() {
        ArrayList<Notebook> FilteredProducts = new ArrayList<>();

        for (int i = 0; i < Brand.getBrandNameList().size(); i++) {
            System.out.println(i + 1 + " | " + Brand.getBrandNameList().get(i));
        }
        System.out.print("Filtreleme yapmak istediğiniz Markayı seçiniz: ");
        int brandIndex = input.nextInt();
        for (Notebook notebook : products) {
            if (notebook.getBrand().getName().equals(Brand.getBrandNameList().get(brandIndex - 1))) {
                FilteredProducts.add(notebook);
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

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Integer> getProductIDlist() {
        ArrayList<Integer> productIDList = new ArrayList<>();

        for (Notebook notebook : products) {
            productIDList.add(notebook.getId());
        }
        return productIDList;
    }

}
