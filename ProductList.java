/**
 * This class is responsible for storing a list of products registered by the user.
 * 
 * @author (Tisa Majumder) 
 * @version (7th Septmeber 2018)
 */
public class ProductList
{
    private Product[] listOfProducts;
    
    /**
     * Default Constructor for objects of class ProductList
     */
    public ProductList()
    {
       listOfProducts = new Product[5];
    }
    
    /**
     * Non-Default Constructor for objects of class ProductList
    */
    public ProductList(Product[] newProd)
    {
       listOfProducts = newProd;
    }
    
    /**
     * A method to get a count of the number of actual products in the list.
     */
    public int checkProdNum()
    {
       int count = 0;
        for (int i = 0; i < listOfProducts.length; i++)
       {
           if (listOfProducts[i] != null)
                count++;
       }
       return count;
    }
    
    /**
     * A method to display all the products added in the list.
     */
    public void displayProduct()
    {
       int j = 1;
       for (int i = 0; i < listOfProducts.length; i++)
       {
          if (listOfProducts[i] != null)
          {
              System.out.println("Select product " + j + " :");
              listOfProducts[i].display();
              j++;
          }
       }
    }
            
    /*
     *An accessor method to get the listOfProducts
     */
    public Product[] getListOfProducts()
    {
        return listOfProducts;
    }
    
    /*
     * A method to get the description of the product from product class
     */
    public String getProdDesc(int j)    
    {
       return listOfProducts[j].getDesc();
    }
    
    /*
     * A method to get the name of the product from product class
     */
    public String getProdName(int j)    
    {
       return listOfProducts[j].getName();
    }
      
    /*
     * A method to get the price of the product from product class
     */
    public double getProdPrice(int j)    
    {
       return listOfProducts[j].getPrice();
    }
    
    /*
     * A method to get the minimum purchase quantity of the product from product class
     */
    public int getProdMinQty(int j)    
    {
       return listOfProducts[j].getMinOrderQty();
    }
    
    /*
     * A method to get the minimum available quantity of the product from product class
     */
    public int getProdQtyHand(int j)    
    {
       return listOfProducts[j].getQtyOnHand();
    }
    
    /**
     * A nethod to assign the values obtained by user to the product class
     */
    public void inputProdDetails(String name, String desc, Double price, int qty, int order)    
    {
       for (int i = 0; i < listOfProducts.length; i++)
       {
           if (listOfProducts[i] == null)
           {
              listOfProducts[i] = new Product(name, desc, price, qty, order);
              break;
           }
       }
    }
    
    /*
     * A mutator method to set the listOfProducts
     */
    public void setListOfProducts(Product[] newList)
    {
        listOfProducts = newList;
    }
    
    /**
     * A method to check if an element of an array is null or not.
     */   
    public boolean notNullArray()
    {
       for (int i = 0; i < listOfProducts.length; i++)
       {
          if (listOfProducts[i] != null)
                return true;
          break;
       }
       return false;
    }
}
    
