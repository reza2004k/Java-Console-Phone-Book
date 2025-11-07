import java.io.FileWriter;

public class Linklist {
    Node head = null;

    public void add(String firstname, String lastname, String tel) {
        Node n = new Node(new Person(firstname, lastname, tel));
        n.next = this.head;
        this.head = n;
    }

    public String toString() {
        Node t = this.head;
        String s = "";
        while (t != null) {
            s += t.person.toString() + "\n";
            t = t.next;
        }
        return s;
    }

    public boolean Search(String firstname, String lastname, String tel) {
        Node t = this.head;
        while (t != null) {
            if (t.person.getFirstname().compareTo(firstname) == 0 && t.person.getLastname().compareTo(lastname) == 0 && t.person.getTel().compareTo(tel) == 0) {
                return true;
            }
            t = t.next;
        }
        return false;
    }


    public String SearchByName(String firstname, String lastname) {
        Node t = this.head;
        while (t != null) {
            if (t.person.getFirstname().compareTo(firstname) == 0 && t.person.getLastname().compareTo(lastname) == 0) {
                return "Number:" + t.person.getTel();
            }
            t = t.next;
        }
        return "Tel Not Found!";
    }

    public String SearchByTel(String tel) {
        Node t = this.head;
        while (t != null) {
            if (t.person.getTel().compareTo(tel) == 0) {
                return "FirstName:" + t.person.getFirstname() + "\n" + "LastName:" + t.person.getLastname();
            }
            t = t.next;
        }
        return "Person Not Found!";
    }

    public void Edit(String oldFirstname, String oldLastname, String oldTel, String newFirstname, String newLastname, String newTel) {
        Node t = head;
        while (t != null) {
            if (t.person.getFirstname().compareTo(oldFirstname) == 0 && t.person.getLastname().compareTo(oldLastname) == 0 && t.person.getTel().compareTo(oldTel) == 0) {
                t.person.setFirstname(newFirstname);
                t.person.setLastname(newLastname);
                t.person.setTel(newTel);
            }
            t = t.next;
        }
    }

    public void Delete(String firstname, String lastname, String tel) {
        Node n = head;
        if (n != null && n.person.getFirstname().compareTo(firstname) == 0 && n.person.getLastname().compareTo(lastname) == 0 && n.person.getTel().compareTo(tel) == 0) {
            this.head = n.next;
        }
        while (n != null && n.next != null && n.next.person.getFirstname().compareTo(firstname) != 0 && n.next.person.getLastname().compareTo(lastname) != 0 && n.next.person.getTel().compareTo(tel) != 0) {
            n = n.next;
        }
        if (n.next != null) {
            n.next = n.next.next;
        }
    }

    public void Save(Linklist list) {
        try {
            FileWriter fw = new FileWriter("PhoneBook.txt");
            Node t = head;
            while (t != null) {
                fw.write(t.person.getFirstname()+" "+t.person.getLastname()+" "+t.person.getTel());
                fw.write("\n");
                t = t.next;
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
