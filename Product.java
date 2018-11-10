import java.util.Scanner;
/**
 * The class is responsible for creating a product.
 * 
 * @author (Tisa Majumder) 
 * @version (7th Septmeber 2018)
 */
public class Product
{
    private String name;
    private String desc;
    private double price;
    private int qtyOnHand;
    private int minOrderQty;

    /**
     * Default constructor for the product class
     */
    public Product()
    {
        // initialise instance variables
        name = "Default name";
        desc = "Default desc";
        price = 0.00;
        qtyOnHand = 0;
        minOrderQty = 0;
    }
    
    /**
     * Non-Default constructor for the product class
     */
    public Product(String newName, String newDesc, double newPrice, int newQtyOnHand, int newMinOrderQty)
    {
        // initialise instance variables
        name = newName;
        desc = newDesc;
        price = newPrice;
        qtyOnHand = newQtyOnHand;
        minOrderQty = newMinOrderQty;
    }
    
    /*
     * A display method to show the current status of the Product class
     */
    public void display()
    {
        System.out.println("Name: " + name);
        System.out.println(" Description: " + desc);
        System.out.println(" Quantity: " + qtyOnHand);
        System.out.println(" Price: " + price);
        System.out.println(" Min Order Quantity: " + minOrderQty);
        System.out.println();
    }
    
    /*
     * An accessor method to get the description of the product
     */
    public String getDesc()
    {
        return desc;
    }
    
    /*
     * An accessor method to get the minimum order quantity of the product
     */
    public int getMinOrderQty()
    {
        return minOrderQty;
    }
    
    /*
     * An accessor method to get the name of the product
     */
    public String getName()
    {
        return name;
    }
      
    /*
     * An accessor method to get the price of the product
     */
    public double getPrice()
    {
        return price;
    }
    
    /*
     * An accessor method to get the available quantity of the product
     */
    public int getQtyOnHand()
    {
        return qtyOnHand;
    }
    
    /*
     * A mutator method to set the description of the product
     */
    public void setDesc(String newDesc)
    {
        desc = newDesc;
    }
    
    /*
     * A mutator method to set the minimum order quantity of the product
     */
    public void setMinOrderQty(int newMinOrderQty)
    {
        minOrderQty = newMinOrderQty;
    }
    
    /*
     * A mutator method to set the name of the product
     */
    public void setName(String newName)
    {
        name = newName;
    }
      
    /*
     * A mutator method to set the price of the product
     */
    public void setPrice(double newPrice)
    {
        price = newPrice;
    }
    
    /*
     * A mutator method to set the available quantity of the product
     */
    public void setQtyOnHand(int newQtyOnHand)
    {
         qtyOnHand = newQtyOnHand;
    }
    
}