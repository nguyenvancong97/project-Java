package fx19840.java.asm1;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class asm1 {
    public static Scanner sc= new Scanner(System.in);
    static final String SOFTWARE_NAME = "NGAN HANG SO";
    static final String AUTHOR = "FX19840";
    static final String VERSION = "@v1.0.0";
    static final String[] PROVINCE = {
            "001-Ha Noi"
            , "002-Ha Giang"
            , "004-Cao Bang"
            , "006-Bac Kan"
            , "008-Tuyen Quang"
            , "010-Lao Cai"
            , "011-Dien Bien"
            , "012-Lai Chau"
            , "014-Son La"
            , "015-Yen Bai"
            , "017-Hoa Binh"
            , "019-Thai Nguyen"
            , "020-Lang Son"
            , "022-Quang Ninh"
            , "024-Bac Giang"
            , "025-Phu Tho"
            , "026-Vinh Phuc"
            , "027-Bac Ninh"
            , "030-Hai Duong"
            , "031-Hai Phong"
            , "033-Hung Yen"
            , "034-Thai Binh"
            , "035-Ha Nam"
            , "036-Nam Dinh"
            , "037-Ninh Binh"
            , "038-Thanh Hoa"
            , "040-Nghe An"
            , "042-Ha Tinh"
            , "044-Quang Binh"
            , "045-Quang Tri"
            , "046-Thua Thien Hue"
            , "048-Da Nang"
            , "049-Quang Nam"
            , "051-Quang Ngai"
            , "052-Binh Dinh"
            , "054-Phu Yen"
            , "056-Khanh Hoa"
            , "058-Ninh Thuan"
            , "060-Binh Thuan"
            , "062-Kon Tum"
            , "064-Gia Lai"
            , "066-Dak Lak"
            , "067-Dak Nong"
            , "068-Lam Dong"
            , "070-Binh Phuoc"
            , "072-Tay Ninh"
            , "074-Binh Duong"
            , "075-Dong Nai"
            , "077-Ba Ria Vung Tau"
            , "079-Ho Chi Minh"
            , "080-Long An"
            , "082-Tien Giang"
            , "083-Ben Tre"
            , "084-Tra Vinh"
            , "086-Vinh Long"
            , "087-Dong Thap"
            , "089-An Giang"
            , "091-Kien Giang"
            , "092-Can Tho"
            , "093-Hau Giang"
            , "094-Soc Trang"
            , "095-Bac Lieu"
            , "096-Ca Mau"};
    static final String[] GENDER_BIRTH = {"019", "220", "421", "622", "823", "119", "320", "521", "722", "923"};
          //    danh muc chinh
    public static void mainMenu(){
        System.out.println("+-----------------+---------------------+------------------+");
        System.out.println("| " + SOFTWARE_NAME + " | " + AUTHOR + VERSION + "         |");
        System.out.println("+-----------------+---------------------+------------------+");
        System.out.println("| 1.Nhập CCCD                                               ");
        System.out.println("| 0.Thoát                                                   ");
        System.out.println("+-----------------+---------------------+------------------+");
        System.out.println("Chức năng: ");
    }
    public static void main(String[] args) {
        try{
            mainMenu();
            switch (chooseNumber(0,1)){
                case 0:
                    return;
                case 1:
                    verifyMenu();
                    int code = chooseNumber(0,2);
                    switch (code){
                        case 0: return;
                        case 1:
                        case 2:
                            String verifyCode = createVerifyCode(code);
                            if(!checkVerifiedCode(verifyCode))
                                return;
                            else {
                                System.out.println("Vui lòng nhập số CCCD: ");
                                String text = validateIdCardInput();
                                if(text.contentEquals("false"))return;
                                else{
                                    childMenu(text);
                                }
                            }
                            break;
                    }

            }
        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }
    //Nhập số hợp lệ
    public static int chooseNumber(int min, int max) {
        int chon;
        while (true){
            try{
                chon = sc.nextInt();
                if(chon < min || chon > max){
                    System.out.println("Vui lòng nhập số nguyên nằm trong đoạn [ " + min + " ... " + max + "]" );
                }
                else{
                    sc.nextLine();
                    return chon;
                }
            }catch(InputMismatchException e){
                sc.nextLine();
                System.out.println("Vui lòng nhập số nguyên nằm trong đoạn  [ " + min + " ... " + max + "]" );
            }
        }
    }


    // Tạo mã xác thực
    public static String createVerifyCode(int option){
        //mã xác thực từ 100 đến 999
        if(option == 1){
            return String.valueOf(createRandomNumber(100,999));
        }
        //mã xác thực 6 ký tự [0..9, A..Z, a..z]
        StringBuilder maXacThuc = new StringBuilder();
        for (int i = 0; i < 6; i++) {

            int choice = createRandomNumber(0,2);
            switch (choice){
                //bien choice = 0: Lấy ngẫu nhiên số từ 0 đến 9;
                case 0:
                    maXacThuc.append((char)(createRandomNumber(48,57)));
                    break;
                //biến choice = 1: lấy ngẫu nhiên ký tự từ A đến Z;
                case 1:
                    maXacThuc.append((char)(createRandomNumber(65,90)));
                    break;
                //biến choice =2: lấy ngẫu nhiên ký tự từ a đến z;
                default:
                    maXacThuc.append((char)(createRandomNumber(97,122)));
                    break;
            }

        }return maXacThuc.toString();


    }

    //Tạo 1 số ngẫu nhiên nằm trong đoạn [min, max]
    public static int createRandomNumber(int min, int max){
        return min + (int) ((max - min + 1)* Math.random());
    }
    //Thực hiện các chức năng tra cứu, sau khi người dùng nhập mã CCCD hợp lệ
    private static void childMenu(String cccd) {
        do{
            int number;
            showChildMenu();
            number = chooseNumber(0,3);
            switch (number){
                case 0:
                    sc.close();
                    return;
                case 1:
                    System.out.println("Nơi sinh: " + findProvinceName(cccd.substring(0,3)));
                    break;
                case 2:
                    System.out.println(searchGenderBirth(cccd));
                    break;
                case 3:
                    System.out.println("Số ngẫu nhiên: " + cccd.substring(6));
                    break;
            }
        }
        while (true);
    }

    private static void showChildMenu() {
        System.out.println("\t| 1. Kiểm tra nơi sinh");
        System.out.println("\t| 2. Kiểm tra tuổi, giới tính");
        System.out.println("\t| 3. Kiểm tra số ngẫu nhiên");
        System.out.println("\t| 0. Thoát");
        System.out.println("Chức năng: ");
    }

    //Tìm giới tính và năm sinh
    private static String searchGenderBirth(String cccd) {
        String result = "Giới Tinh: ";
        for(String gen_bir: GENDER_BIRTH){
            if (cccd.charAt(3) == gen_bir.charAt(0)) {
                if(cccd.charAt(3)%2==0)result += "Nam |";
                else result += "Nữ |";
                result +=gen_bir.substring(1) + cccd.substring(4,6);
                break;
            }
        }
        return result;
    }

    //Buộc người dùng phải nhập CCCD hợp lệ, hoặc thoát chương trình
    public static String validateIdCardInput() {
        while (true){
            String text = sc.nextLine();
            //text là "no"
//            if(text.toLowerCase().contentEquals("no"))
//                return  "false";
            //text là mã số cccd hợp lệ
            if(checkIdCard(text)==0)return text;
            else{
                System.out.println("CCCD không hợp lệ");
//                System.out.println("Vui lòng nhâp lại, hoặc nhập \"No\" để thoát)");
                switch (checkIdCard(text)){
                    case -3:
                        System.out.println("Lỗi: CCCD có độ dài khác 12 ký tự");
                        break;
                    case -2:
                        System.out.println("Lỗi: CCCD có chứa ký tự không phải là SỐ");
                        break;
                    case -1:
                        System.out.println("Lỗi: Không tồn tại mã tỉnh");
                        break;
                }
            }
        }
    }
    //Kiểm tra mã CCCD mà người dùng nhập vào
    //Nếu k hợp lệ, ghi chi tiết lý do
    public static int checkIdCard(String cccd) {
        if(cccd.length()!=12) return -3;//sai độ dài
        else{
            for (int i = 0; i < 12; i++) {
                if(cccd.charAt(i)<48 || cccd.charAt(i)>57){
                    return -2; //không hợp lệ vì có chứa ký tự là chữ
                }
            }
            if(findProvinceName(cccd.substring(0,3)).contentEquals(""))
                return -1;//Không hợp lệ vì k tồn tại mã tỉnh
            else return 0;
        }
    }

    private static String findProvinceName(String provinceCode) {
        for(String province: PROVINCE){
            if(province.startsWith(provinceCode)){
                return province.substring(4);
            }
        }
        return "";//Chuỗi rỗng là k tồn tại mã tỉnh
    }


    private static boolean checkVerifiedCode(String maXacThuc) {
        System.out.println("Nhập mã xác thực: " + maXacThuc);
        while (true){
            String text = sc.nextLine();

            //chuoix là "no"
            if(text.toLowerCase().contentEquals("no"))
                return false;
            else if (text.contentEquals(maXacThuc)) return true;
            else {
                System.out.println("Mã xác thực không đúng");
                System.out.println("Vui lòng nhập lại, hoặc nhập \"No\" để thoát");
            }
        }
    }

    private static void verifyMenu() {
        System.out.println("Chọn độ khó của mã xác thực: ");
        System.out.println("\t| 1. Easy");
        System.out.println("\t| 2. Hard");
        System.out.println("\t| 0. Thoát");
        System.out.println("Chức năng: ");


    }
}
