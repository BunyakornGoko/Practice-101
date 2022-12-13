package exam;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tinnapop
 */
public class Person {
    private int code;
    private String firstname;
    private String lastname;
    private int type;
    private static double nextcode = 023D;

    public Person(String firstname, String lastname) {
        this(firstname,lastname,1);
        
    }
    
    public Person(String firstname, String lastname, int type) {
        this.firstname = isValidString(firstname) ? firstname : "Default";
        this.lastname = isValidString(lastname) ? lastname : "Default";
        this.code = (int) nextcode++;
        if(type > 0) {
            this.type = type ;
        }
        else{
            this.type = 1;
        }
       
    }
    
    public static boolean isValidString(String str){
        if (str == null) return false;
        if (str.isBlank()) return false;
        return true;
    }

    public int getCode() {
        return code;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getType() {
        return type;
    }

    public void setFirstname(String firstname) {
       if(isValidString(firstname)){
           this.firstname = firstname;
       }
    }

    public void setLastname(String lastname) {
         if(isValidString(lastname)){
           this.firstname = lastname;
       }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public String toString() {
         return String.format("[Person: %d (%s %s) %d]", this.code, this.firstname, this.lastname, this.type);
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person o = (Person) obj;
        return this.code == o.getCode();
    }
    
    
    
    
    

    
    
    
    
    
    
}
