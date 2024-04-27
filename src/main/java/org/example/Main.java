package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);




        int choice;

            do {
                System.out.println("========MENU=========");
                System.out.println("1. Them moi sinh vien ");
                System.out.println("2. In Sinh vueb");
                System.out.println("3. Xoa sinh vien");
                System.out.println("4. Cap nhat thong tin sinh vien");
                System.out.println("5. Tim kiem thong tin sinh vien theo ten");
                System.out.println("6. Sap sep danh sach theo A-Z hoac Z-A");
                System.out.println("7. Thoat chuong trinh ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        printStudent();
                        break;
                    case 3:
                        DeleteStudent();
                    case 4:
                        UpdateStudent();
                    case 5:
                        searchStudent();
                    case 6:
                        ArrangeStudent();


                }


            }

            while (choice != 7);




        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

    }

    public static void addStudent() {

        Scanner sc1 = new Scanner(System.in);

        System.out.print("Nhập số lượng sinh viên cần thêm : ");
        int n= sc1.nextInt();
        sc1.nextLine();
        while (n>0)
        {

            System.out.print("Nhap ten sinh vien :");
            String name = sc1.nextLine();
            System.out.print("Nhap so dien thoai : ");
            String sdt = sc1.nextLine();
            System.out.print("Nhap ngay thang nam sinh : ");
            String date = sc1.nextLine();
            System.out.print("Nhap dia chi : ");
            String diachi = sc1.nextLine();
            System.out.print("Nhap ma lop :");
            String malop = sc1.nextLine();

            if (!checkPhoneNumber(sdt) || !checkDateOfBirth(date)) {
                System.out.print("Thông tin không hợp lệ, vui lòng nhập lại");
            }


            students.add(new Student(name, sdt, date, diachi, malop));

            System.out.println("Thêm sinh viên thành công ");
            n--;

        }




    }

    public static void printStudent() {

        for (Student s : students) {
            System.out.println(s.getName());
            System.out.println(s.getAddress());
            System.out.println(s.getPhoneNumber());
            System.out.println(s.getClassCode());
            System.out.println(s.getdob());


        }

//        System.out.print("");
    }


    public static void DeleteStudent() {
        Scanner sc2 = new Scanner(System.in);
        System.out.print("Nhập vào tên sinh viên cần xóa : ");
        String name = sc2.nextLine();
        boolean check = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equalsIgnoreCase(name)) {
                students.remove(i);
                System.out.print("Xóa sinh viên thành công");
                check = true;

            }


        }
        System.out.println(!check);

        if (check == false) {

            System.out.print("Không tìm thấy sinh viên");
//            System.out.print(checkt);

        }


    }


    public static void UpdateStudent() {

        Scanner sc2 = new Scanner(System.in);
        System.out.print("Nhập vào sinh viên muốn cập nhât : ");
        String name = sc2.nextLine();

        boolean check = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equalsIgnoreCase(name)) {
                System.out.println("Nhập thông tin mới cho sinh viên : ");
                System.out.print("Nhập số điện thoại : ");
                String phoneNumber = sc2.nextLine();
                System.out.print("Nhập ngày tháng năm sinh : ");
                String dob = sc2.nextLine();
                System.out.print("Nhập địa chỉ : ");
                String address = sc2.nextLine();
                System.out.print("Nhập vào mã lớp : ");
                String malop = sc2.nextLine();


                if (!checkPhoneNumber(phoneNumber) || !checkDateOfBirth(dob)) {
                    System.out.print("Thông tin không hợp lệ , vui lòng nhập lại ");

                }
                students.set(i, new Student(name, dob, phoneNumber, address, malop));
                check = true;

            }

        }
        if (check == false) {
            System.out.print("Không tìm thấy thông tin sinh viên để cập nhật ");
        }

    }


    public static void searchStudent() {
        Scanner sc3 = new Scanner(System.in);
        System.out.print("Nhập vào tên sinh viên muốn tìm kiếm : ");
        String name = sc3.nextLine();
        boolean check = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equalsIgnoreCase(name)) {
                System.out.println(students.get(i).getdob());
                System.out.println(students.get(i).getAddress());
                System.out.println(students.get(i).getClassCode());
                System.out.println(students.get(i).getPhoneNumber());
                System.out.println(students.get(i).getClass());
                check = true;
            }


        }

        if (check == false) {
            System.out.print("Không tìm thấy sinh viên");
        }
    }

    private static boolean checkPhoneNumber(String number) {


        return number.matches("0\\d{9}");


    }

    public static void ArrangeStudent() {
        Scanner sc4= new Scanner(System.in);
        System.out.print("1. Sắp xếp từ A-Z");
        System.out.print("2. Sắp xếp từ Z-A ");
        int choice=sc4.nextInt();


        switch (choice)
        {
            case 1:
                Collections.sort(students, new StudentComparator());
            case 2:
                Collections.sort(students,new StudentReverseComparator());
        }




    }

    private static boolean checkDateOfBirth(String dob) {
        if (dob.length() != 8) {
            return false;
        }


        int day = Integer.parseInt(dob.substring(0, 2));
        int month = Integer.parseInt(dob.substring(2, 4));
        int year = Integer.parseInt(dob.substring(4, 8));

        if (day < 1 || day > 31) {
            return false;
        }

        if (month < 1 || month > 12) {
            return false;
        }
        if (year < 1910 || year > 2010) {
            return false;
        }

        return true;


    }
}