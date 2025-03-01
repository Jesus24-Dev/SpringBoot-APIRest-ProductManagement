
package com.productmanagement.api_products.exceptions;

public class OrderProductNotFoundException extends RuntimeException{
        public OrderProductNotFoundException(String message){
            super(message);
        }
}
