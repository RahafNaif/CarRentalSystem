public class Driver {
    
	private int id;
    private String name;

    Driver(int id, String name) {
    	
        this.id = id;
        this.name = name;
    }

  
    public String toString() {
        return "\n Driver information :" + "id=" + id + ", name=" + name ;
    }
    
    
    
}
