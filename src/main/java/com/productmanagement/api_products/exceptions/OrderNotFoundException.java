
package com.productmanagement.api_products.exceptions;

public class OrderNotFoundException extends RuntimeException{
        public OrderNotFoundException(String message){
            super(message);
        }
}
