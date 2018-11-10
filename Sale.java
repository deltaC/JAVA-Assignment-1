import java.util.*;
/**
 * The main class that the user interacts with to register products and then buy them.
 * 
 * @author (Tisa Majumder) 
 * @version (7th Septmeber 2018)
 */
public class Sale
{
    private ProductList prodList;
    private SaleTransaction transaction; 
    /**
     * Default constructor for objects of class Sale
     */
    public Sale()
    {
        prodList = new ProductList();
        transaction = new SaleTransaction();
    }

    /**
     * Non default constructor for objects of class Sale
     */
    public Sale(ProductList newProdList, SaleTransaction newTransaction)
    {
        prodList = newProdList;
        transaction = newTransaction;
    }
    
    /*
     * Accessor method for Product List
     */
    private ProductList getProdList()
    {
        return prodList;
    }
    
    /*
     * Accessor method for Transaction
     */
    private SaleTransaction getTransaction()
    {
        return transaction;
    }
    
    /*
     * Mutator method for Product List
     */
    private void setProdList(ProductList newProdList)
    {
        prodList = newProdList;
    }
    
    /*
     * Mutator method for Transaction
     */
    private void setTransaction(SaleTransaction newTransaction)
    {
        transaction = newTransaction;
    }
    
    /**
     * A method to validate the product details entered by the user of string type
     */
    private boolean validString(String value, int min, int max) {
        boolean inRange = false;
        int valueLength = value.trim().length();
        if ((valueLength >= min && valueLength <= max))
            inRange = true;
        return inRange;
    }

    /**
     * An input method to get product details from the that takes a parameter
     */
    private String stringInput(String displayMessage)
    {
        Scanner console = new Scanner(System.in);
        System.out.println(displayMessage);
        String input = console.nextLine();
        return input;
    }
    
     /**
     * An input method that takes input by the user without any parameters and stores it as a string
     */
    private String input()
    {
       Scanner console = new Scanner(System.in);
       return console.nextLine(); 
    }
    
    private void displayMenu()
    {
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println("Welcome to the Simple Inventory Management System");
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println("");
        System.out.println("Please Select from the following options:");
        System.out.println("Press 1 to register a product for Sale");
        System.out.println("Press 2 to add a product to the Cart");
        System.out.println("Press 3 to remove a product to the Cart");
        System.out.println("Press 4 to view all available products");
        System.out.println("Press 5 to check out");
        System.out.println("Press 6 to Get Help");
        System.out.println("Press 7 to Exit");
        System.out.println("");
        System.out.println("Please enter your Choice:");
    }
    
    /**
     * A method that is called by the user to start the whole program.
     */
    public void startProgram()
    {
        boolean proceed = false;
        int numOption = 0;
        /*
         * Checks the option chosen and tells the user if the input type is wrong.
         * Reference used: https://stackoverflow.com/questions/19925047/how-to-check-the-input-is-an-integer-or-not-in-java
         */
        do
        {
            displayMenu();
            String option = input();
            try 
            {
                numOption = Integer.parseInt(option);
                proceed = true;
            }
            catch (NumberFormatException e) 
            {
                System.out.println("Please enter a valid choice from 1-7.");
                proceed = false;
            }
        } while (proceed == false);
        switch (numOption)
        {
            case 1: prodRegister(); break;
            case 2: prodAdd(); break;
            case 3: prodRemove(); break;
            case 4: prodView(); break;
            case 5: checkOut(); break;
            case 6: help(); break;
            case 7: exit(); break;
            default: System.out.println("Please choose from options 1 to 7."); displayMenu(); break;
        }
    } 
    
    /**
     * A method to let the user register products for sale by accepting valid name, description and price for the product.
     */
    private void prodRegister()
    {
        if (prodList.checkProdNum() < 5)
        {
            boolean proceed = false;
            String prodName = "";
            do
            {   
                prodName = stringInput("Please enter the name of the product");
                if (validString (prodName, 3, 25))
                    proceed = true;
                else
                    System.out.println("Product name must be between 3 and 25 charachters!");
            } while (proceed == false);
            proceed = false;
            String prodDesc = "";
            do
            {
                prodDesc = stringInput("Please enter a description of the product");
                if (validString (prodDesc, 1, 50))
                    proceed = true;
                else
                    System.out.println("Product description must be between 1 and 50 charachters!");
            } while (proceed == false);
            proceed = false;
            String prodInput ="";
            double prodPrice = 0.00;
            do
            {
                 prodInput = stringInput("Please enter a price for the product.");
                 try 
                 {
                     prodPrice = Double.parseDouble(prodInput);
                     proceed = true;
                 }
                 catch (NumberFormatException e) 
                 {
                     System.out.println("Please enter a valid price!");
                     proceed = false;
                 }
            } while (proceed == false);
            RandomNumberGenerator randomQty = new RandomNumberGenerator(0,10);
            int qtyAvail = randomQty.randomNumber();
            RandomNumberGenerator randomMin = new RandomNumberGenerator(1,5);
            int minOrder = randomMin.randomNumber();
            prodList.inputProdDetails(prodName, prodDesc, prodPrice, qtyAvail, minOrder);
            System.out.println("You have registered your product(s)!");
            startProgram();
        } 
        else
        {
            System.out.println("You have already registered 5 product(s).");
            startProgram();
        }
    }
        
    /**
     * A method to check if the product can be bought by the user or not. It displays an error message if the available quantity is less than the minimum quantity required for purchase.
     */
    private boolean buyingPossibility(int p)
    {
            boolean buy = false;
            int canBuy = prodList.getProdQtyHand(p);
            int needToBuy = prodList.getProdMinQty(p);
            if (canBuy >= needToBuy)
                return true;
            else 
            {
                System.out.println("Sorry you can't buy the product as minimum quantity to be bought is less than the quantity available");
                return false;
            }
    }
    
    /**
     * A method to add product to the cart after checking if the products have been registered then checking if the cart has less than three elements in it and finally checking if the available quantity is
     * more than the quantity required for purchase. 
     */
    private void prodAdd() 
    {
       if(prodList.notNullArray())
       {
           if (transaction.checkCartNum() < 3)
           {
               String cartName;
               String cartDesc;
               double cartPrice;
               int cartQty;
               int cartOrder;
               System.out.println("The following products are available for purchase:");
               prodList.displayProduct();
               System.out.println();
               String optionChosen = stringInput("Please enter selected product:");
               int option = Integer.parseInt(optionChosen);
               int p = option - 1;  // to match the product position in the product list array
               if (buyingPossibility(p))
               {        
                   cartName = prodList.getProdName(p);
                   cartDesc = prodList.getProdDesc(p);
                   cartPrice = prodList.getProdPrice(p);   
                   cartQty = prodList.getProdQtyHand(p);
                   cartOrder = prodList.getProdMinQty(p);
                   transaction.addToCart(cartName, cartDesc, cartPrice, cartQty, cartOrder);
                   transaction.displayCart();
                   System.out.println("Your total cart value is: " + transaction.totalAmount());
                   startProgram();
               } 
               else 
               {
                   startProgram();
               }
           } 
           else
           {
                System.out.println("Your have already added 3 products in your cart.");
                startProgram();
           }
       }
       else
       {
           System.out.println("Please register products first!");
           startProgram();
       }
    }
    
    /**
     * A method to let the user remove a product already added to the cart.
     */
    private void prodRemove()
    {
       if (transaction.notNullArray())
       { 
            System.out.println("The following products are available in your cart:");
            transaction.displayCart();
            boolean proceed = false;
            String userInput;
            int input = 0;
            do
            {
                userInput = stringInput("Please enter the product number you wish to remove.");
                try 
                {
                    input = Integer.parseInt(userInput);
                    proceed = true;
                }
                catch (NumberFormatException e) 
                {
                System.out.println("Please enter a valid product number.");
                proceed = false;
                }
            } 
            while (proceed == false);
            transaction.removeFromCart(input);
            transaction.displayCart();
            startProgram();
       }
        else
       {
            System.out.println("Please add to cart first.");
            startProgram();
       }
    }

    /**
     * A method to let the user view the registered products and if no product is registered it prompts the user to register a product.
     */
    private void prodView()
    {
        if (prodList.notNullArray())
        {
            System.out.println("The following products are available for purchase:");
            prodList.displayProduct();
            System.out.println();
            startProgram();
        } 
        else 
        {
            System.out.println("Please register products first.");
            startProgram();
        }
    }
    
    /**
     * A method to checkout with the products added in the cart and complete shopping.  
     */
    private void checkOut()
    {
        if (transaction.notNullArray())
        {
            transaction.displayCart();
            transaction.reduceQty();
            transaction.acceptableQty(); 
            RandomNumberGenerator randomCode = new RandomNumberGenerator(1000,9999);
            int saleCode = randomCode.randomNumber();
            transaction.setSaleCode(saleCode);
            System.out.println ("Sale Code: " + transaction.getSaleCode());
            System.out.println ("You made a total purchase of: " + transaction.totalAmount());
            System.out.println ("Thank you for shopping with us!");
            transaction.emptyCart();
            transaction.setTotalCost(0);
            String userChoice = stringInput("Do you wish to continue shopping? (Y/N)");
            if (userChoice.equalsIgnoreCase("Y"))
                startProgram();
            else 
                exit();
        }
        else
        {
            System.out.println("Please add to cart first!");
            startProgram();
        }
    }

    /**
     * A method to display a help menu with brief description of what each options do and then asks user whether to continue with the program or exit it. 
     */
    private void help()
    {
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println("Simple Inventory Management System Help Menu!");
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println("");
        System.out.println("You have the following options available!");
        System.out.println("Option 1 lets you register a product to be sold. You can only register a maximum of 5 products.");
        System.out.println("Option 2 lets you add a product to the Cart for purchase. You can only add 3 products at a time.");
        System.out.println("Option 3 lets you remove a product from list of products added to the Cart.");
        System.out.println("Option 4 lets you view all available products that have been registered for sale.");
        System.out.println("Option 5 lets you finalize your purchase by making the final payment.");
        System.out.println("Option 6 lets you access the help menu.");
        System.out.println("Optiom 7 exits the system.");
        System.out.println("");
        String userChoice = stringInput("Do you wish to continue? (Y/N)");
        if (userChoice.equalsIgnoreCase("Y"))
            startProgram();
        else 
            exit();
    }

    /**
     * A method to stop the system and terminate the current JVM. 
     * Reference used: https://stackoverflow.com/questions/22452930/terminating-a-java-program
     */
    private void exit()
    {
        System.out.println("Thank you for using Inventory Management System!");
        System.exit(0);
    }
}

