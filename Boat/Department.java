package exam;

import static exam.Person.*;


public class Department {
    private static int nextcode = 400;
    private int code;
    private String title;
    private Person[] staff;
    private int count;

    public Department(String title) {
        this.code = nextcode++;
        if(!isValidString(title)) {
            this.title = "Bangpakok";
                }
        else this.title = title;
        
        this.staff = new Person[30];
    }

   
    public int getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getCount() {
        return count;
    }
    
    public boolean addStaff(String firstname, String lastname, int type){
        if (this.count == this.staff.length) return false;
        if (!isValidString(lastname))return false;
        if (!isValidString(firstname)) return false;
        
        this.staff[this.count++] = new Person(firstname,lastname,type);
        return true;
    }
//    
//    public int getTypeCount(int type){
//        int typecount = 0;
//        for (int i = 0; i < this.staff.length; i++) {
//            if(type == this.staff[i].getType())
//             typecount++;
//        }
//        
//        return typecount;
//    }
    
    public int getTypeCount(int type){
        int typecount = 0;
        for (int i = 0; i < this.count; i++) {
            if(type == this.staff[i].getType())
             typecount++;
        }
        
        return typecount;
    }
    
    public int[] getAllCodes(){
        int[] codes = new int[this.count];
        for (int i = 0; i < this.count; i++) {
            codes[i] = this.staff[i].getCode();
        }
        return codes;
    }
    
    public Person getStaff(int code){
        for (int i = 0; i < this.staff.length; i++) {
            if (code == this.staff[i].getCode()) {
                return this.staff[i];
            }
        }
      return null;
    }
    
    public int[] getAllTypes(){
        
        int[] alltype = new int[1];
        int notation = 0;
         for(int i = 0; i < this.count; i++){
             
             for (int j = 0; j < alltype.length; j++) {
                 
                 if(alltype[j] != this.staff[i].getType()){
                    int[] newArray = new int[alltype.length + 1]; 
                    System.arraycopy(alltype, 0, newArray, 0, count);
                    alltype = newArray;
                    alltype[notation++] = this.staff[i].getType();
                    break;
                 }
                 
             } 
             
         }
         return alltype;
    }
//    private void expand(int[] A) {
//        int[] newArray = new int[A.length + 1]; 
//        System.arraycopy(A, 0, newArray, 0, count);
//        A = newArray;
//    }
    
   
}
