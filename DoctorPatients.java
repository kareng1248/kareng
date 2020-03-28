import Tester.*; 

public class DoctorPatients{ 
  public static Examples E = new Examples(); 
  public static void main(String[] args){ 
    Tester.run(E);
  }
  
}

class Examples{ 
  Examples(){}
  /*
   * 
   */
  
  void testDoctor(Tester t) { 
    Doctor a2 = new Doctor("D", "K",1938);
  
    t.checkExpect(a2.patients, new MtList());
    Patient b2 = new Patient("Ana", 2002, 2, a2);
    t.checkExpect(a2.patients,new ConsList( b2, new MtList()));
    
    t.checkExpect(b2.doctor, a2);
     
    Patient b4 = new Patient("Mike", 2000, 2, a2);
    Doctor a3 = new Doctor("M", "F",1958);
    t.checkExpect(a3.patients, new MtList());
    Patient b3 = new Patient("Bob", 1980, 5, a3);
    t.checkExpect(a3.patients,new ConsList( b3, new MtList()));
    // sameDoctor
    // b3.sameDoctor("Ana") , false 
    // b4.sameDoctor("Ana") , true 
  }
}
// represent patients
class Patient{
   String name;
   int yob;
   int quantity;
   Doctor doctor;
   Patient(String name, int yob, int quantity, Doctor doctor) {
     this.name = name;
     this.yob = yob;
     this.quantity = quantity;
     this.doctor = doctor;
     this.doctor.addPatient(this) ;
    }
  // boolean sameDoctor(String name ) { 
     /*
      * this.doctor : Doctor 
      * this.doctor.patients : IList ( list of patients ) 
      * this.doctor.patients.contains ( name) : boolean 
      *  Define a method contains that finds if the list of patients contains the given name 
      * 
      */ 
     
  // }
 }
// represent doctors
class Doctor {
   String fst;
   String lst;
   int dob;
   IList patients = new MtList();
   Doctor(String fst, String lst, int dob) {
      this.fst = fst;
      this.lst = lst;
      this.dob = dob;
    }
   
   void addPatient(Patient patient) {
      this.patients = new ConsList(patient, this.patients);
      return ;
    }
    
   }
// represent patients as a list of patients 
interface IList { 
  
}
class MtList implements IList{ 
  MtList(){}
}
class ConsList implements IList{ 
  Patient fst;
  IList rst;
  ConsList(Patient fst, IList rst){
    this.fst = fst; 
    this.rst = rst; 
  }
}

