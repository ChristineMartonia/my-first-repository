import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Midterm_Martonia {
    class CodeExit{
        public void out()
        {
            System.out.println("##*******************************************##");
            System.out.println("##           THANK YOU FOR USING             ##");
            System.out.println("##              PET CHECKER                  ##");
            System.out.println("##===========================================##");
            System.exit(0);
        }
    }

    static class Pet {
        String name;
        String kind;
        String color;
        String concern;

        public Pet(String name, String kind, String color, String Concern) {
            this.name = name;
            this.kind = kind;
            this.color = color;
            this.concern;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        

        public String getKind() {
            return kind;
        }
        public void setKind(String kind) {
            this.kind = kind;
        }


        public String getColor() {
            return color;
        }
        public void setColor(String color) {
            this.colore = color;
        }


        void Welcome() {
            System.out.println("\nWelcome to Pet's Haven " + getName() + ". A cute " + getKind() +". with a "+ getColor() + " colored fur!. Let's check your " + get.concern());
        }

        void cureAnotherConcern(String concern) {
            setConcern(concern);
        }

    }

    static class PetException extends Exception {
        public PetException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) throws PetException {
        List<Pet> Pets = new ArrayList<Pet>();
        try (Scanner s = new Scanner(System.in)) {
            while (true) {
                System.out.println("##*******************************************##");
                System.out.println("##                PET CHECKER                ##");
                System.out.println("##===========================================##");
                System.out.println("##                                           ##");
                System.out.println("##          Press 1 : To Add  Pet            ##");
                System.out.println("##          Press 2 : To Remove Pet          ##");
                System.out.println("##          Press 3 : To Display Pet         ##");
                System.out.println("##          Press 4 : To Exit portal         ##");
                System.out.println("##                                           ##");
                System.out.println("##===========================================##");
                System.out.print("\n Choose Action to take: ");
                char choice = s.next().toLowerCase().charAt(0);
                switch (choice) {
                    case '1':

                        System.out.println("Enter Pet's name: ");
                        String pet = s.next().toUpperCase();

                        if (pet.length()> 0) {
                            System.out.print("Pet is a (dog,cat,etc.)? -: ");
                            String kind = s.nextline();
                            System.out.print("Enter Pet  color ----------: ");
                            String color = s.nextLine();
                            System.out.print("Enter Pet concern (eyes, nose, arm..) ----------: ");
                            String concern = s.nextLine();

                            if (concern.length() < 0) {
                                throw new PetException(
                                    "Pls.input details");
                            } else {
                                Pet newPet = new Pet(pet, kind, color,concern);
                                Pets.add(newPet);
                                System.out.println("\nWelcome to Pet's Haven " + pet+ ". A cute " +kind+". with a "+color+ " colored fur!. Let's check your " +concern+ "!");
                                break;
                            }
                        } else {
                            throw new PetException("Invalid input. Try again");
                        }
                        break;

                    case '2':
                        System.out.println("Enter pet's name you want to remove: ");
                        String remove = s.next().toUpperCase();

                        if (!Pet.contains(remove)) {
                            System.out.println("Sorry " +remove+ " doesn't exist!");
                            break;
                        }
                        int index = Pets.indexOf(remove);
                        System.out.println( "Goodbye! " +remove+ " Hope you are finally cured!");
                        Pets.remove(index + 1);
                        break;
                    case '3':
                        for (int i = 0; i < Pets.size(); i++) {
                            Pets.get(i).Introduction();
                            System.out.println("Warning!! Emergency!!!! for pet who has another concern !!");
                            System.out.println("Input another concern: ");
                            String concern = s.next().toLowerCase();
                            if (concern > 0) {
                                System.out.println("We'll need to run some tests. Is it okay? (yes/no)");
                                char test = s.next().toLowerCase().charAt(0);
                                if (test == 'yes') {
                                    System.out.println(" The test is successful, we already give medicine to your pet!");
                                    break;
                                }
                                Pets.get(i).cureAnotherConcern(concern);
                                System.out.println(Pets.get(i).getName() + " has another concern with  " + Pets.get(i).getConcern());
                                
                                        
                            } else {
                                System.out.println(Pets.get(i).getName() + " doesn't have any concern "
                                        + Pets.get(i).getConcern());
                            }

                        }
                        break;
                    case '4':
                        CodeExit obj = new CodeExit();
                        obj.out();
                        break;
                    default:
                        System.out.println("##*******************************************##");
                        System.out.println("##               INVALID CHOICE              ##");
                        System.out.println("##===========================================##");
                        continue;
                }
            }
        }

    }
}