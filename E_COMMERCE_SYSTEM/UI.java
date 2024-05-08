package E_COMMERCE_SYSTEM;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class UI {
    private List<Product> products;
    private List<Cart> cart;
    private User user;

    public UI() {
        products = new ArrayList<>();
        cart = new ArrayList<>();
        user = new User("John Doe", "1234567890");

        // Add dummy products
        products.add(new Product("Product 1", 10.99));
        products.add(new Product("Product 2", 19.99));
        products.add(new Product("Product 3", 5.99));
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the E-commerce System!");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        user.setName(name);
        System.out.print("Enter your Phone no. : ");
        String Mobile_no = scanner.nextLine();
        user.setMobileNo(Mobile_no);

        System.out.println("Hello, " + user.getName() + "!");

        showProductList();
        addToCart(scanner);
        showBill();

        scanner.close();
    }

    private void showProductList() {
        System.out.println("Available Products:");
        System.out.println("-------------------");
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println((i + 1) + ". " + product.getName() + " - $" + product.getPrice());
        }
        System.out.println();
    }

    private void addToCart(Scanner scanner) {
        System.out.println("Enter the product number to add to cart (0 to exit): ");
        int productNumber = scanner.nextInt();

        while (productNumber != 0) {
            if (productNumber < 0 || productNumber > products.size()) {
                System.out.println("Invalid product number. Please try again.");
            } else {
                Product selectedProduct = products.get(productNumber - 1);
                System.out.print("Enter the quantity: ");
                int quantity = scanner.nextInt();

                Cart cartItem = new Cart(cart.size() + 1, selectedProduct.getName(), selectedProduct.getPrice(), quantity);
                cart.add(cartItem);

                System.out.println("Product added to cart: " + cartItem.getItemName());
                
            }

            System.out.print("Enter the product number to add to cart (0 to exit): ");
            productNumber = scanner.nextInt();
            System.out.println();
        }
    }

    private void showBill() {
        System.out.println("Your Cart:");
        System.out.println("----------");
        System.out.println("ID\t Item Name\t\t\t\t  Cost\t     Quantity\t   Total\n");

        double grandTotal = 0;
        for (Cart item : cart) {
            System.out.printf("%s%n", item.toString());

            grandTotal += item.getTotal();
        }

        System.out.println("\n\nGrand Total: $" + grandTotal);
        System.out.println("Thank You for shopping! Your goods will be delivered at your address at the earliest.");
    }
}