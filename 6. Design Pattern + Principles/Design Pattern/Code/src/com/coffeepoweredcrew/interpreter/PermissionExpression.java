package com.coffeepoweredcrew.interpreter;

//Abstract expression
public interface PermissionExpression {

	boolean interpret(User user); 
}
