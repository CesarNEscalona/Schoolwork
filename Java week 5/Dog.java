public class Dog
{
   // instance variables vs. class(static)
   private String breed;
   private double weight;
   private boolean vaccinated;
   private int idNum;
   private static int idGen=100;
   
   // default constructor
   public Dog()
   {
      this.breed = "";
      this.idNum = idGen;
      idGen++;  // add 1 to the id generator so next time the dog has an 
   }
   
   public void assignId()
   {
      this.idNum = idGen;
      idGen++; 
   }
   
   // parameterized constructor
   public Dog(String breed, double weight, boolean vaccinated)
   {
      this.breed = breed;
      this.weight = weight;
      this.vaccinated = vaccinated;
      assignId();
   }
   
   
   // @Override
   public String toString()
   {
      return "\nId: " + idNum + "\nBreed: "+breed +"\nWeight: "+ weight + "\nVaccine: "+ vaccinated ;
   }
   
   // main method
   public static void main(String[] args)
   {
      // construct a dog named fido
      Dog fido = new Dog();
      // print out the state of fido
      System.out.println(fido.toString());
      
      // construct a dog named lassie
      Dog lassie = new Dog("Collie", 85.3, false);
      System.out.println(lassie);
   }
}   // end of class