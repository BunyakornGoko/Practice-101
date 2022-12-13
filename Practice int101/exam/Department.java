package tutorial.exam;

import java.util.Arrays;

public class Department {
    /*
    2. Create a Department class in "exam" package containing
    the following instance variables, which are all private:
    (1) code: int (auto-generated starting from 400 onward).
    (2) title: String (can not be changed after initialization).
    (3) staff: Person[].
    (4) count: int, for keeping track of the number of staff in the array.
     */

    private static int nextCode = 400;

    private int code;
    private String title;
    private Person[] staff;
    private int count; // ในการนับ staff ใน Person[]

    /*
    2.1) Create a constructor: Department(String title) where
    (a) This constructor will auto-generate the code starting from 400 onward.
    (b) The title must not be null or blank. Use your old school name as the default.
    (c) Initialize the staff as an array of size equals to 10 + your date of birth (the date only).
     */
    public Department(String title) {
        this.code = nextCode++;
        if(!Person.isValidString(title)) {
            this.title = "Watprapadoo";
        }

        this.title = title;
        this.staff = new Person[10 + 5];
    }

    /*
    2.2) Create three public getters for code, title, and count. No setter.
     */
    public int getCode() {
        return this.code;
    }

    public String getTitle() {
        return this.title;
    }

    public int getCount() {
        return this.count;
    }

    /*
    2.3) Create a public method: addStaff(String firstname, String lastname, int type).
    This method will create a Person (without checking the type), add this person
    into the staff array, and return true. However, if the array is full or the firstname
    or the lastname is null or blank, do not create a Person but return false instead.
     */
    public boolean addStaff(String firstName, String lastName, int type) {
        if(this.count == this.staff.length) return false;

        if(!Person.isValidString(firstName)) return false;
        if(!Person.isValidString(lastName)) return false;

        this.staff[this.count++] = new Person(firstName, lastName, type);
        return true;
    }

    /*
    2.4) Create a public method: getTypeCount(int type): int. This method will return
    the number of staffs that have type equals to the input argument.
     */
    public int getTypeCount(int type) { // staff.type = type
        int count = 0; // กำหนดค่าให้เป็น 0
        for(int i = 0; i < this.count; i++) {
            if(this.staff[i].getType() == type) {
                count++;
            }
        }

        return count;
    }

    /*
    2.5) Create a public method: getAllCodes(): int[]. This method will return an array
    containing the codes of all staffs and the size of the array must be the same as
    the number of staffs in the department.
     */
    public int[] getAllCodes() {
        int[] codes = new int[this.count]; // เท่ากับจำนวนของ staff ใน object นี้
        for(int i = 0; i < this.count; i++) {
            codes[i] = this.staff[i].getCode(); // code[0] = staff[0].getCode();
        }

        return codes;
    }

    /*
    2.6) Create a public method: getStaff(int code): Person. This method will return
    the person in the staff array that match the code in the argument.
    Null will be returned if no staff with that code.
     */
    public Person getStaff(int code) {
        // for
        for(int i = 0; i < this.count; i++) {
            if(this.staff[i].getCode() == code) {
                return this.staff[i];
            }
        }

        return null;

        // foreach
//        for(Person person : this.staff) {
//            if(person.getCode() == code) {
//                return person;
//            }
//        }
//
//        return null;
    }

    /*
    2.7) Override a public method: toString(): String. This method will return
    a string representation of the department in the following format.
    [Department: CODE (TITLE) COUNT] where CODE, TITLE, and COUNT
    are the code, the title, and the number of staffs in the department respectively.
     */
    @Override
    public String toString() {
        return String.format("[Department: %d (%s) %d]", this.code, this.title, this.count);
    }

    /*
    2.8) Create a public method: getAllTypes(): int[]. This method will return an array
    containing all types of staffs in the department. Make sure that there are
    no duplicate types in the array and the size of the array equals to the number
    of distinct types.
     */
    public int[] getAllTypes() {
        int[] types = new int[10]; // types = {};
        int count = 0;
        for(int i = 0; i < this.count; i++) {
            if(!isTypeExist(this.staff[i].getType(), types)) {
                count++;
                types[i] = this.staff[i].getType(); // type of staff
            }
        }

        return Arrays.copyOf(types, count);
    }

    private boolean isTypeExist(int type, int[] types) {
        for(int i = 0; i < types.length; i++) {
            if(types[i] == type) return true;
        }
        return false;
    }


 }
