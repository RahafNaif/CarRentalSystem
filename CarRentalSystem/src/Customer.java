public class Customer {
    private int id;
    private String name;
    private Long phone;

    Customer(int id, String name, Long phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
    

    int getId() {
        return id;
    }


    String getName() {
        return name;
    }
    
    public String toString() {
        return "\n Customer information :" + "id=" + id + ", name=" + name + ", phone=" + phone;
    }
    
}
