/*
Write a Java program that take a input and detect whether there’s integer in
there.
Example: input value “45222” return true, input value “This Is A Test4me” return
true, input value “IAMGOOD” return false

Approach: Iterate over the string and return true if digit encountered. Else return false.

Time Complexity : O(L) where L is the length of the string
Space Complexity : O(1)
*/

class DetectInteger{

    public static void main(String args[]){
        String input = args[0]; // Taking input from command line eg. java DetectInteger IAMGOOD
        boolean result = findInteger(input);
        System.out.println(result);
    }

    static boolean findInteger(String input){
        for(int i=0; i < input.length(); i++){
            if(input.charAt(i) >= '0' && input.charAt(i) <= '9'){ //Checking if current character is digit (can use Character.isDigit() as well)
                return true;
            }
        }
        return false;
    }

}