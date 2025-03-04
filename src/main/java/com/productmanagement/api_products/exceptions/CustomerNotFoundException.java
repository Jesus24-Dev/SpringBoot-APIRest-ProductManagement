
package com.productmanagement.api_products.exceptions;

public class CustomerNotFoundException extends RuntimeException{
        public CustomerNotFoundException(String message){
            super(message);
        }
}
