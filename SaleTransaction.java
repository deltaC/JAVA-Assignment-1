/**
 * The class is responsible for final sale, it creates the cart for the user and allows to add and remove product from it.
 * 
 * @author (Tisa Majumder) 
 * @version (7th Septmeber 2018)
 */
public class SaleTransaction
{
    private int saleCode;
    private Product[] items;
    private double totalCost;

    /**
     * Default Constructor for objects of class Sale Transaction.
     */
    public SaleTransaction()
    {
        saleCode = 0;
        items = new Product[3];
        totalCost = 0.00;
    }
    
    /**
     * Non-Default Constructor for objects of class Sale Transaction.
     */
    public SaleTransaction(int newSaleCode, Product newProduct[], double newCost)
    {
        saleCode = newSaleCode;
        items = newProduct;
        totalCost = newCost;
    }
    
    /**
     * A method to check if a product is added to cart twice then the minimum available quantity in is more than the quantity required for purchase.
     */
    public void acceptableQty()
    {
        for (int i = 0; i < items.length; i++)
        {
            if (items[i] != null)
            {
                String nameOne = items[i].getName();
                for (int j = 1; j < items.length; j++)
                {  
                    if (items[j] != null)
                    {
                        String nameTwo = items[j].getName();
                        int qtyHandTwo = items[j].getQtyOnHand();
                        int minQtyTwo = items[j].getMinOrderQty();
                        if(nameOne.equals(nameTwo) && (qtyHandTwo < minQtyTwo))
                        {
                            items[j] = null;
                        }
                        break;
                    }
                }
            }
        }
    }
    
    /**
     * A method to add items chosen by user to the cart.
     */
    public void addToCart(String name, String desc, Double price, int qty, int order)    
    {
       for (int i = 0; i < items.length; i++)
       {
           if (items[i] == null)
           {
              items[i] = new Product(name, desc, price, qty, order);
              break;
           } 
           else 
           {
               System.out.println("You can't buy more than 3 products!");
           }
       }
    }
    
    /**
     * A method to check the number of items added in the cart
     */
    public int checkCartNum()
    {
        int count = 0;
        for (int i = 0; i < items.length; i++)
        {
            if (items[i] != null)
                count++;
        }
        return count;
    }
    
    /*
     * A method to display the items available in cart
     */
    public void displayCart()
    {
       int j = 1;
       for (int i = 0; i < items.length; i++)
       {
           if (items[i] != null)
           {
               System.out.println("Product added " + j + " :");
               items[i].display();
               j++;
           }
       }
    }
    
    /**
     * A method to empty the cart after checkout
     */
    public void emptyCart()
    {
       for (int i = 0; i < items.length; i++)
       {
            items[i] = null;
       }
    }
    
    /*
     * Accessor method for items
     */
    public Product[] getItems()
    {
        return items;
    }
    
    /*
     * Accessor method for Sale Code
     */
    public int getSaleCode()
    {
        return saleCode;
    }
       
    /*
     * Accessor method for Total Cost
     */
    public double getTotalCost()
    {
        return totalCost;
    }
    
    /**
     * A method to check if element of an array is null or not.
     */
    public boolean notNullArray()
    {
        for (int i = 0; i <= items.length; i++)
       {
           if (items[i] != null)
                return true;
        break;
       }
       return false;
    }
    
    /**
     * A method to reduce the quantity available on hand of a product.
     */
    public void reduceQty()
    {
        for (int i = 0; i < items.length; i++)
        {
            if (items[i] != null)
            {
                int qtyHand = items[i].getQtyOnHand();
                int minQty = items[i].getMinOrderQty();
                int newQtyHand = qtyHand - minQty;
                items[i].setQtyOnHand(newQtyHand);
            }
        }
    }
    
    /**
     * A method to remove the selected product from the cart.
     */
    public void removeFromCart(int index)    
    {
       Product newItems[] = new Product[3];
       index = index - 1;
       for (int i = 0; i < items.length; i++)
       {
           if ( i != index)
           {
               newItems[i] = items[i];
           }
       }
       items = newItems;
    }
    
    /*
     * Mutator method for Sale code
     */
    public void setSaleCode(int code)
    {
        saleCode = code;
    }
    
    /*
     * Mutator method for Items
     */
    public void setItems(Product[] newItems)
    {
        items = newItems;
    }
    
    /*
     * Mutator method for Total Cost
     */
    public void setTotalCost(double newTotalCost)
    {
        totalCost = newTotalCost;
    }
        
    /**
     * A method to return the total cost of the items in the cart
     */
    public double totalAmount()
    {
       totalCost = 0;
        for (int i = 0; i < items.length; i++)
       {
           if (items[i] != null)
              totalCost += items[i].getPrice() * items[i].getMinOrderQty();
       }
       return totalCost;
    }
  
}
  
   
  
 
    
      
