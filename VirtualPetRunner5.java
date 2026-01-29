import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class VirtualPetRunner5
{
    // Prints out menu and returns user choice
    public static int getChoice(Scanner input)
    {
      int selection = 0;
      while (selection < 1 || selection > 6)
      {
         System.out.println("\n╔════════════════════════════════════════╗");
         System.out.println("║   🐾 VIRTUAL PET MAIN MENU 🐾   ║");
         System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║  1. ℹ️  Get Pet Information      ║");
        System.out.println("║  2. 🍎 Feed Pet                 ║");
        System.out.println("║  3. 🎮 Play with Pet            ║");
        System.out.println("║  4. 💊 Give Medicine            ║");
        System.out.println("║  5. 🧼 Clean Pet                ║");
        System.out.println("║  6. 👋 Quit                     ║");
         System.out.println("╚════════════════════════════════════════╝");
         System.out.print("➤ Enter your choice: ");
         selection = input.nextInt();
        if (selection < 1 || selection > 6) {
          System.out.println("❌ Invalid choice! Please enter 1-6.");
        }
      }
      return selection;
    }
    
    // Prints out food options and returns user choice
    public static int getPantry(Scanner input)
    {   
      int selection = 0;
      System.out.println("\n╔════════════════════════════════════════╗");
      System.out.println("║   🥘 PANTRY INVENTORY 🥘        ║");
      System.out.println("╠════════════════════════════════════════╣");
      System.out.println("║  1. 🍎 Apple                   ║");
      System.out.println("║  2. 🧁 Cupcake                 ║");
      System.out.println("║  3. 🥦 Broccoli                ║");
      System.out.println("║  4. 🥔 Potato                  ║");
      System.out.println("║  5. ↩️  Return to Menu          ║");
      System.out.println("╚════════════════════════════════════════╝");
      while (selection < 1 || selection > 5)
      {
        System.out.print("➤ Enter your choice: ");
        selection = input.nextInt();
        if (selection < 1 || selection > 5) {
           System.out.println("❌ Invalid choice! Please enter 1-5.");
        }
      }
      return selection;

    }
    
     // Prints out game options and returns user choice
    public static int getGame(Scanner input)
    {
      int selection = 0;
      System.out.println("\n╔════════════════════════════════════════╗");
      System.out.println("║   🎯 GAME OPTIONS 🎯            ║");
      System.out.println("╠════════════════════════════════════════╣");
      System.out.println("║  1. 🪙 Coin Toss                ║");
      System.out.println("║  2. 🏀 Hoop Jumping             ║");
      System.out.println("║  3. 🧠 Simon Says               ║");
      System.out.println("║  4. ↩️  Return to Menu          ║");
      System.out.println("╚════════════════════════════════════════╝");
      while (selection < 1 || selection > 4)
      {
        System.out.print("➤ Enter your choice: ");
        selection = input.nextInt();
        if (selection < 1 || selection > 4) {
           System.out.println("❌ Invalid choice! Please enter 1-4.");
        }
      }
      return selection;
    }
    
   // Displays a picture of the pet
    public static void printPet(String emo)
    {
        System.out.println(" /\\_/\\");  
        System.out.println("( o.o )"); 
        System.out.println(" > " + emo + " <");
    }
    
    public static void main(String[] args) 
    {
        // CHANGE THIS VARIABLE VALUE TO TEST AT A DIFFERENT SPEED
        final int INTERVAL_IN_SECONDS = 10;
        
        // Sets up Scanner for user input
        Scanner input = new Scanner(System.in);
        
        VirtualPet5 myPet = new VirtualPet5("Dog");
        
        // Instantiates Food objects
        Food apple = new Food("Apple", 2, 1, 1); 
        Food cupcake = new Food("Cupcake", 1, 2, 2);
        Food broccoli = new Food("Broccoli", 3, -1, 1);
        Food potato = new Food("Potato", 2, 0, 2);
        
        // Instantiates Game objects
        Game coinToss = new Game("Coin Toss", 1, 0);
        Game hoopJumping = new Game("Hoop Jumping", 2, 2);
        Game simonSays = new Game("Simon Says", 1, 2);
        
        // Sets up a ScheduledExecutorService object that will call updateStatus
        // every 1 minute.
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> { myPet.updateStatus(); }, 0, INTERVAL_IN_SECONDS, TimeUnit.SECONDS);
        
        System.out.println(myPet);
        printPet("ᵔ");

        int choice = getChoice(input);        
        while (choice != 6)
        {
            if(choice == 1)
            {
              System.out.println(myPet);
            }
            else if (choice == 2)
            {
                System.out.println("Select a food option from the pantry.");
                int food = getPantry(input);
                Food f = null;
                if (food == 1)
                  f = apple;
                else if (food == 2)
                  f = cupcake;
                else if (food == 3)
                  f = broccoli;
                else if (food == 4)
                  f = potato;
                if (f != null)
                {
                  myPet.feed(f);
                  System.out.println("\n\nYou have fed " + myPet.getName() 
                                        + " 1 " + f.getName());
                }
            }
            else if (choice == 3)
            {
                System.out.println("Select a game to play.");
                int game = getGame(input);
                Game g = null;
                if (game == 1)
                  g = coinToss;
                else if (game == 2)
                  g = hoopJumping;
                else if (game == 3)
                  g = simonSays;
                if (g != null)
                {
                  boolean hasWon = myPet.play(g);
                  System.out.println("\n\nYou have played " + g.getName() 
                                        + " with " + myPet.getName());
                  if (hasWon)
                     System.out.println(myPet.getName() + " has won!");
                  else
                     System.out.println(myPet.getName() + " has lost!");
                }
            }
              else if (choice == 4)
              {
                myPet.giveMedicine();
                System.out.println("\n\nYou have given medicine to " + myPet.getName() + ".");
              }
              else if (choice == 5)
              {
                myPet.clean();
                System.out.println("\n\nYou have cleaned " + myPet.getName() + ".");
              }
            if (myPet.getEnergyLevel() >= 5  && myPet.getHappinessLevel() >= 5)
                printPet("ᵕ");
            else
                printPet("ᵔ");
            System.out.println(myPet.getName().toUpperCase());
            choice = getChoice(input);
        }
        scheduler.shutdown();
    }
}
