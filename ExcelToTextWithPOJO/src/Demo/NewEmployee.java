package Demo;

import java.util.Date;

public class NewEmployee {
    private Double id;
    private String firstName;
    private String lastName;
    private Date dateofBirth;

    public NewEmployee(){}

   public NewEmployee(Double id, String firstName, String lastName, Date dateofBirth) {
       super();
       this.id = id;
       this.firstName = firstName;
       this.lastName = lastName;
       this.dateofBirth= dateofBirth;
   }

   public Double getId() {
       return id;
   }

   public void setId(Double id) {
       this.id = id;
   }

   public String getFirstName() {
       return firstName;
   }

   public void setFirstName(String firstName) {
       this.firstName = firstName;
   }

   public String getLastName() {
       return lastName;
   }

   public void setLastName(String lastName) {
       this.lastName = lastName;
   }    
   public Date getdateofBirth() {
       return dateofBirth;
   }

   public void setdateofBirth(Date dateofBirth) {
       this.dateofBirth = dateofBirth;
   } 
}