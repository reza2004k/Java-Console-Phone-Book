import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Linklist list = new Linklist();
        try {
            FileReader fr=new FileReader("PhoneBook.txt");
            Scanner fs=new Scanner(fr);
            while (fs!=null){
                String firstname=fs.next();
                String lastname=fs.next();
                String tel=fs.next();
                list.add(firstname,lastname,tel);
                fs.nextLine();
            }
        }catch (Exception e){
            System.out.println();
        }
        Menu(list);
    }

    public static void Menu(Linklist list) {
        Scanner input = new Scanner(System.in);
        System.out.println("*_______________Menu/PhoneBook_______________*");
        System.out.println("                    1.Add   " + "\n" + "                2.Search by Name" + "\n" + "                3.Search by Tel" + "\n" + "                    4.Edit" + "\n" + "                   5.Delete" + "\n" + "               6.Check PhoneBook" + "\n" + "                    7.Exit\n");
        int n = input.nextInt();
        switch (n) {
            case 1: {
                System.out.println("FirstName:");
                input.nextLine();
                String firstname = input.nextLine();
                System.out.println("LastName:");
                String lastname = input.nextLine();
                System.out.println("Tel:");
                String tel = input.nextLine();
                boolean b = list.Search(firstname, lastname, tel);
                if (b == true) {
                    System.out.println("This Person exist in your Phonebook!! ");
                } else {
                    list.add(firstname, lastname, tel);
                }
                Menu(list);
            }
            case 2: {
                System.out.println("FirstName:");
                input.nextLine();
                String firstname = input.nextLine();
                System.out.println("LastName:");
                String lastname = input.nextLine();
                System.out.println(list.SearchByName(firstname, lastname));
                Menu(list);
            }
            case 3: {
                System.out.println("Tel:");
                input.nextLine();
                String tel = input.nextLine();
                System.out.println(list.SearchByTel(tel));
                Menu(list);
            }
            case 4: {
                System.out.println("Old Person,FirstName:");
                input.nextLine();
                String oldFirstname = input.nextLine();
                System.out.println("Old Person,LastName:");
                String oldLastname = input.nextLine();
                System.out.println("Old Person,Tel:");
                String oldTel = input.nextLine();
                boolean b = list.Search(oldFirstname, oldLastname, oldTel);
                if (b == true) {
                    System.out.println("New Person,FirstName:");
                    String newFirstname = input.nextLine();
                    System.out.println("New Person,LastName:");
                    String newLastname = input.nextLine();
                    System.out.println("New Person,Tel:");
                    String newTel = input.nextLine();
                    list.Edit(oldFirstname, oldLastname, oldTel, newFirstname, newLastname, newTel);
                    Menu(list);
                } else {
                    System.out.println("Old Person Not exist.!!" + "\n" + "if you want to add This New Person Enter Number 1.");
                    Menu(list);
                }

            }
            case 5: {
                System.out.println("Please enter your contact for deleting!!");
                System.out.println("FirstName:");
                input.nextLine();
                String firstname = input.nextLine();
                System.out.println("LastName:");
                String lastname = input.nextLine();
                System.out.println("Tel:");
                String tel = input.nextLine();
                boolean b = list.Search(firstname, lastname, tel);
                if (b == true) {
                    list.Delete(firstname, lastname, tel);
                } else {
                    System.out.println("No Body Added!!?");
                }
                Menu(list);
            }
            case 6: {
                System.out.println();
                System.out.println(list);
                Menu(list);
            }
            case 7: {
               list.Save(list);
               System.exit(0);
            }
        }
    }
}