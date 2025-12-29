import java.util.*;
class Solution {
    static String[][] op = { { "+", "-", "*" }, { "+", "*", "-" }, { "-", "*", "+" }, { "-", "+", "*" }, { "*", "-", "+" }, { "*", "+", "-" } };
    public long solution(String expression) {
        long answer = 0;
        for(String[] priority:op){
            List<Long> numbers = new ArrayList<>();
            List<String> operators = new ArrayList<>();
            makeList(expression, numbers, operators);
            answer = Math.max(answer, calculate(priority, numbers, operators));
        }
        return answer;
    }
    private void makeList(String expression, List<Long> numbers, List<String> operators){
        String[] num = expression.split("[\\*+\\-]");
        for(String n : num){
            numbers.add(Long.parseLong(n));
        }
        for(int i = 0; i<expression.length(); i++){
            if(expression.charAt(i)=='+'||expression.charAt(i)=='-'||expression.charAt(i)=='*') operators.add(String.valueOf(expression.charAt(i)));
        }
    }
    private long calculate(String[] priority, List<Long> numbers, List<String> operators){
        long result = 0;
        while(operators.size() > 0){
            for(int i = 0; i<3; i++){
                while(operators.contains(priority[i])){
                    int index = operators.indexOf(priority[i]);
                    long a = numbers.remove(index);
                    long b = numbers.remove(index);
                    String operator = operators.remove(index);
                    if(operator.equals("+")){
                        numbers.add(index, a+b);
                    } 
                    else if(operator.equals("-")){
                        numbers.add(index, a-b);
                    }
                    else if(operator.equals("*")){
                        numbers.add(index, a*b);
                    }
                }
            }
        }
        return Math.abs(numbers.get(0));
    }
}