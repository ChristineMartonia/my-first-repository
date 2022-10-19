/******************** Importing Essential Libraries ************************/

import java.util.*;
import java.util.jar.Attributes.Name;
import java.io.*;


/*************************** MENU OF EMS ****************************/

class MainMenu
{
  public void menu()
  {
    System.out.println("##*******************************************##");
    System.out.println("##                PET CHECKER                ##");
    System.out.println("##===========================================##");
    System.out.println("##                                           ##");
    System.out.println("##          Press 1 : To Add  Pet            ##");
    System.out.println("##          Press 2 : To Remove Pet          ##");
    System.out.println("##          Press 3 : To Display Pet         ##");
    System.out.println("##          Press 1 : To Exit portal         ##");
    System.out.println("##                                           ##");
    System.out.println("##===========================================##");
    /**System.out.println("Press 2 : To See an Employee Details ");
    System.out.println("Press 3 : To Remove an Employee");
    System.out.println("Press 4 : To Update Employee Details");
    System.out.println("Press 5 : To Exit the EMS Portal");*/

  }
}

/************************ To add pet *********************/

class Pet_Add
{
    public void createFile()
    {
        Scanner sc=new Scanner(System.in);

        PetDetail petD=new PetDetail();
        petD.getInfo();
        
        try{
            File f1=new File("file"+petD.pet_name+".txt");
            if(f1.createNewFile()){
                FileWriter myWriter = new FileWriter("file"+petD.pet_kind+".txt");
                myWriter.write("Pet Name:"+petD.pet_name+"\n"+
                "Pet Kind     :"+petD.pet_kind+"\n"+"Pet Color  :"+petD.pet_color);
                myWriter.close();
                System.out.println("\nWelcome " +petD.pet_name+ ". A cute " +petD.pet_kind+". I like your "+petD.pet_color+ " colored skin!");

                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            }
            else {
                System.out.println("\nInvalid input :(");
                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            }
        }
        catch(Exception e){System.out.println(e);}
    }
}

/************************* Taking Employee Details ************************/

class PetDetail
{
    public String pet_color;
    public String pet_kind;
    public String pet_name;
    String name;
    String kind;
    String color;
    int numObj;
    public PetDetail(String pet_name2, String pet_kind2, String pet_color2) {
    }
    public PetDetail() {
    }
    public void getInfo() {

        Scanner sc=new Scanner(System.in);

        System.out.println("How many pet do you want to create? ");
        int numObj = sc.nextInt();
        List<PetDetail> petArray = new ArrayList <PetDetail>();

        for(int i = 0; i < numObj; i ++){
            System.out.print("Enter Pet " +i+  " name --------: ");
            sc.nextLine();
            pet_name = sc.nextLine();
            System.out.print("Pet " +i+  " is a (dog,cat,etc.)? -: ");
            pet_kind = sc.nextLine();
            System.out.print("Enter Pet  " +i+ " color ----------: ");
            pet_color = sc.nextLine();
        }
       
    }
}

/************************ To Show details of Employee *********************/

class Pet_Show
{
  public void viewFile(String s) throws Exception
  {
    File file = new File("file"+s+".txt");
    Scanner sc = new Scanner(file);

    while (sc.hasNextLine())
     {
       System.out.println(sc.nextLine());
     }
   }
}

/***************************** To Remove Employee *************************/

class Pet_Remove
{
    public void removeFile(String Name)
    {

    File file = new File("file"+Name+".txt");
      if(file.exists())
       {
         if(file.delete());
         {
           System.out.println("\nPet has been removed Successfully");
         }
       }
      else
       {
            System.out.println("\nPet does not exists :( ");
       }
     }
}

/************************ To Update details of Employee ********************/

class Employee_Update
{
  public void updateFile(String s,String o,String n) throws IOException
  {
   File file = new File("file"+s+".txt");
   Scanner sc = new Scanner(file);
   String fileContext="";
   while (sc.hasNextLine())
       {
         fileContext =fileContext+"\n"+sc.nextLine();
       }
   FileWriter myWriter = new FileWriter("file"+s+".txt");
   fileContext = fileContext.replaceAll(o,n);
   myWriter.write(fileContext);
   myWriter.close();

  }
}


/************************ To Exit from the EMS Portal *********************/

class CodeExit
{
  public void out()
  {
    System.out.println("\n*****************************************");
    System.out.println("$ cat Thank You For Using my Software :) ");
    System.out.println("*****************************************");
    System.out.println("\t\t/~ <0d3d by Abhinav Dubey\n");
    System.exit(0);
  }
}


/***************************** Main Class *******************************/
class PetChecker
{
  public static void main(String arv[])
  {
    /** To clear the output Screen **/
    System.out.print("\033[H\033[2J");

    Scanner sc=new Scanner(System.in);
    Pet_Show epv =new Pet_Show();

    int i=0;

    /*** Callining Mainmenu Class function ****/
    MainMenu obj1 = new MainMenu();
    obj1.menu();

    /*** Initialising loop for Menu Choices ***/
    while(i<4)
    {

      System.out.print("\nPlease Enter choice :");
      i=Integer.parseInt(sc.nextLine());

      /** Switch Case Statements **/
      switch(i)
      {
        case 1:
        {
        /** Creating class's object and calling Function using that object **/
        Pet_Add ep =new Pet_Add();
        ep.createFile();

        System.out.print("\033[H\033[2J");
        obj1.menu();
        break;
        }
        case 2:
        {
          System.out.print("\nPlease Enter Pet's name you want to remove :");
          String s=sc.nextLine();
          try
          {
            epv.viewFile(s);}
            catch(Exception e){System.out.println(e);}


            System.out.print("\nPress Enter to Continue...");
            sc.nextLine();
            System.out.print("\033[H\033[2J");
            obj1.menu();
            break;
          }

        case 3:
        {
          System.out.print("\nPlease Enter Employee's ID :");
          String s=sc.nextLine();
          Pet_Remove epr =new Pet_Remove();
          epr.removeFile(s);

          System.out.print("\nPress Enter to Continue...");
          sc.nextLine();
          System.out.print("\033[H\033[2J");
          obj1.menu();
          break;
        }
        case 4:
        {
            System.out.print("\nPlease Enter Employee's ID :");
            String I=sc.nextLine();
            try
            {
              epv.viewFile(I);
            }
            catch(Exception e)
            {
              System.out.println(e);
            }
            Employee_Update epu = new Employee_Update();
            System.out.print("Please Enter the detail you want to Update :");
    	      System.out.print("\nFor Example :\n");
            System.out.println("If you want to Change the Name, then Enter Current Name and Press Enter. Then write the new Name then Press Enter. It will Update the Name.\n");
            String s=sc.nextLine();
            System.out.print("Please Enter the Updated Info :");
            String n=sc.nextLine();
            try
            {
              epu.updateFile(I,s,n);

              System.out.print("\nPress Enter to Continue...");
              sc.nextLine();
              System.out.print("\033[H\033[2J");
              obj1.menu();
              break;
            }
            catch(IOException e)
            {
              System.out.println(e);
            }
        }
        case 5:
        {
          CodeExit obj = new CodeExit();
          obj.out();
        }
      }
    }
  }
}

/****************************** CODED BY ABHINAV DUBEY ************************/
