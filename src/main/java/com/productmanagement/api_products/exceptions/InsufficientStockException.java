
package com.productmanagement.api_products.exceptions;

public class InsufficientStockException extends RuntimeException{
        public InsufficientStockException(String message){
            super(message);
        }
}
