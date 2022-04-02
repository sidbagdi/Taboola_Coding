/*
1. Write a Java program that take a string input and convert it to an integer without using the build-in parse function.
Example: input value “123”, convert it to an integer type with value 123

Approach: Multiply the sum by 10 and add each digit from the string iteratively.
Edge Cases handled -
1. If the string contains a negative number, the resuting integer is negative
2. If the string has a number which is outside the int range in java, we return the upper or lower limit accordingly.

Time Complexity - O(L) where L is the length of the string.
Space Complexity - O(1)
*/

class ConvertToInt{
 
    public static void main(String args[]){
        String input=args[0]; // Taking input on command line
        int convertedInteger=convertToInteger(input); 
        System.out.println(convertedInteger); // Printing result
    }

    static int convertToInteger(String input){

        boolean isNegative=false;
        int start = 0;
        if(input.charAt(start) == '-' || input.charAt(start) == '+'){ //Checking if there is a leading + or -
            if(input.charAt(start) == '-'){
                isNegative=true;
            }
            start++; // setting start as index 1 if there is a leading character
        }

        long convertedInteger=0;
        for(int i = start; i < input.length(); i++){
            convertedInteger = convertedInteger*10 + (input.charAt(i)-'0'); // generating the number from characters
            if(convertedInteger >= Integer.MAX_VALUE){ // Checking if converted number exceeds int limits
                if(isNegative && convertedInteger >= Integer.MAX_VALUE + 1){ // if converted number is negative and value is equal to integer lower limit
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE; // if number exceeds positive limit, return int maximum value as the result
            }
        }

        return isNegative ? -1*(int)convertedInteger : (int)convertedInteger; // returning the int result
    }

}