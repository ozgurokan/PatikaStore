import java.util.Scanner;

public class PatikaStore {

    private Scanner input = new Scanner(System.in);









    public void run(){
        Product product = null;
        Brand brand = new Brand();
        System.out.println("\n PatikaStore Ürün Yönetim Paneli!");
        brand.printBrands();

        boolean logicKey = true;
        while(logicKey){
            System.out.println("1 - Notebook İşlemleri");
            System.out.println("2 - Cep Telefonu işlemleri");
            System.out.println("3 - Marka listele");
            System.out.println("0 - Çıkış Yap");
            System.out.print("Yapmak istedğiniz işlemi seçin: ");
            int choose = input.nextInt();
            switch (choose){
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    logicKey = false;
                    break;
                case 1:
                    product = new Notebook();
                    product.operation();
                    break;
                case 2:
                    product = new MobilePhone();
                    product.operation();
                    break;
                case 3:
                    brand.printBrands();
                    break;
                default:
                    System.out.println("Yanlış tuşlama yaptınız.");
            }

        }

    }


}
