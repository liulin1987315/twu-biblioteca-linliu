package com.twu.biblioteca.menu;

import com.twu.biblioteca.constants.ConstantOutputMessage;
import com.twu.biblioteca.constants.ConstantProductProperty;
import com.twu.biblioteca.product.ProductInfo;
import com.twu.biblioteca.utils.OutputUtils;

import java.util.Scanner;

public class ProductMenuCtl {

    public static void productMenu(String option) {
        showProductMenu(option);
        chooseProductMenuOption(option);
    }

    public static void chooseProductMenuOption(String option) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while (!input.equalsIgnoreCase("exit")) {
            if (option.equals("1")) {
                BookMenuCtl.chooseBookMenuOption(option, input);
            } else if (option.equals("2")) {
                MovieMenuCtl.chooseMovieMenuOption(option, input);
            } else {
                OutputUtils.outputMessage(ConstantOutputMessage.OPTION_INVALID);
            }
        }
    }

    public static void showProductMenu(String option) {
        if (option.equals("1")) {
            BookMenuCtl.showBookMenu();
        } else if (option.equals("2")) {
            MovieMenuCtl.showMovieMenu();
        } else {
            OutputUtils.outputMessage(ConstantOutputMessage.OPTION_INVALID);
        }
    }

    public static void checkoutProduct(String productType, String productName) {
        if (new ProductInfo().isProductAvailableToCheckout(productType, productName)) {
            new ProductInfo().setProductStatus(productType, productName, "checkout");
            outputCheckoutMessage(productType);
        } else {
            outputCheckoutErrorMessage(productType);
        }
    }

    public static void outputCheckoutMessage(String productType) {
        if (productType.equals(ConstantProductProperty.BOOK_TYPE)) {
            OutputUtils.outputMessage(ConstantOutputMessage.SUCCESSFUL_CHECKOUT);
        } else {
            OutputUtils.outputMessage(ConstantOutputMessage.SUCCESSFUL_CHECKOUT_MOVIE);
        }
    }

    public static void outputCheckoutErrorMessage(String productType) {
        if (productType.equals(ConstantProductProperty.BOOK_TYPE)) {
            OutputUtils.outputMessage(ConstantOutputMessage.UNSUCCESSFUL_CHECKOUT);
        } else {
            OutputUtils.outputMessage(ConstantOutputMessage.UNSUCCESSFUL_CHECKOUT_MOVIE);
        }
    }
}