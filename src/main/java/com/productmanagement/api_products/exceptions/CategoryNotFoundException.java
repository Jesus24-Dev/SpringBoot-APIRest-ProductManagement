
package com.productmanagement.api_products.exceptions;


public class CategoryNotFoundException extends RuntimeException{
        public CategoryNotFoundException(String message){
            super(message);
        }
}
