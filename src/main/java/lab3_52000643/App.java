package lab3_52000643;

import lab3_52000643.pojo.Manufacture;
import lab3_52000643.pojo.Phone;

public class App {
    public static void main(String[] args) {
        ///////////////////Phone
        //them 3 phone vao data
        PhoneDAO phoneDAO = new PhoneDAO();
        phoneDAO.add(new Phone("iPhone 14 Pro Max", 12000, "Deep Purple", "VN", 10));
        phoneDAO.add(new Phone("iPhone 15 Pro Max", 13000, "Deep Blue", "VN", 20));
        phoneDAO.add(new Phone("iPhone 16 Pro Max", 16000000, "Pink", "USB", 1));
        //lay phone co id=1
        System.out.println(phoneDAO.get(1).toString());


        //thay doi ten cho phone co id=1 bang ten moi "Iphone 15 ProMax"
        Phone phoneUpdate = phoneDAO.get(1);
        phoneUpdate.setName("Iphone 15 ProMax");
        phoneDAO.update(phoneUpdate);

        //lay danh sach all phone
        for(Phone phone : phoneDAO.getAll()) {
            System.out.println(phone.toString());
        }
        //Phone co gia ban cao nhat
        System.out.println(phoneDAO.getHighestSellingPrice().toString());
        //Phone tang theo ten QG, neu trung ten QG thi sx giam theo GIA
        for(Phone phone : phoneDAO.sortByCountryName()) {
            System.out.println(phone.toString());
        }
        //Ton tai Phone nao co gia >50M (true/false)
        System.out.println(phoneDAO.checkAbove50M());
        //Phone mau hong va >15M
        System.out.println(phoneDAO.getPinkAndOver15M().toString());


        ////////////////////// Manufacture
        ManufactureDAO manufactureDAO = new ManufactureDAO();

        manufactureDAO.add(new Manufacture("VN Phone", "VN", 20));
        manufactureDAO.add(new Manufacture("USA Phone", "USB", 30));
        manufactureDAO.add(new Manufacture("USB Phone", "US", 80));
        manufactureDAO.add(new Manufacture("US Pe", "US", 670));


        for(Manufacture manufacture : manufactureDAO.getAll()) {
            System.out.println(manufacture.toString());
        }
        //Nha Sx xo tren 100 NV
        System.out.println("All manufacturers have more than 100 employee: " + manufactureDAO.checkMoreThan100Employee());
        //Tong cac NV
        System.out.println("Employee count: " + manufactureDAO.countAllEmployee());
        //Tra nha SX cuoi cung
        try {
            System.out.println("The last manufacture in us: " + manufactureDAO.inUS());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
