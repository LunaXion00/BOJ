import java.util.*;
class Solution {
    static boolean[] possible;
    public String[] solution(String[] expressions) {
        Queue<String> unknown = new LinkedList<>();
        possible = new boolean[10];
        int maxDigit = findMaxDigit(expressions);
        Arrays.fill(possible,maxDigit+1, 10, true);
        for(String exp : expressions){
            if(exp.contains("X")) {
                unknown.offer(exp);
                continue;
            }
            StringTokenizer st = new StringTokenizer(exp, "+-= ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int result = Integer.parseInt(st.nextToken());
            for(int i = 2; i<=9; i++){
                if(possible[i]){
                    if(exp.contains("+")) check_plus(first, second, result, i);
                    else check_minus(first, second, result, i);
                }
            }
        }
        List<String> answer = new ArrayList<>();
        while(!unknown.isEmpty()){
            String exp = unknown.poll();
            StringTokenizer st = new StringTokenizer(exp, "= ");
            int first = Integer.parseInt(st.nextToken());
            char operator = st.nextToken().charAt(0);
            int second = Integer.parseInt(st.nextToken());
            int result = -1;
            for(int i = 2; i<=9; i++){
                if(possible[i]) {
                    int temp = calc(first, second, operator, i);
                    if(result == -1) result = temp;
                    else if(result != temp) {
                        result = -1;
                        break;
                    }
                }
            }
            if(result == -1) answer.add(first + " "+ operator+" "+second+" = ?");
            else answer.add(first + " "+ operator+" "+second+" = "+ result);
        }
        return answer.toArray(new String[answer.size()]);
    }
    public void check_plus(int first, int second, int result, int i){
        int conv_first = convert(first, i);
        int conv_second = convert(second, i);
        int conv_result = convert(result, i);
        if(conv_first + conv_second != conv_result) possible[i] = false;
    }
    public void check_minus(int first, int second, int result, int i){
        int conv_first = convert(first, i);
        int conv_second = convert(second, i);
        int conv_result = convert(result, i);
        if(conv_first - conv_second != conv_result) possible[i] = false;
    }
    public int convert(int num, int i){
        int result = 0, power = 0;
        while(num > 0){
            result += (num%10)*Math.pow(i, power++);
            num /= 10;
        }
        return result;
    }
    public int calc(int first, int second, char operator, int i){
        int conv_first = convert(first, i);
        int conv_second = convert(second, i);
        if(operator == '+') return convertToI(conv_first+conv_second, i);
        else return convertToI(conv_first-conv_second, i);
    }
    public int convertToI(int result, int N){
        if (result == 0) return 0;

        int converted = 0;
        int place = 1;

        while (result > 0) {
            int digit = result % N;
            result /= N;
            converted += digit * place;
            place *= 10;
        }

        return converted;
    }
    public int findMaxDigit(String[] expressions){
        int max = -1;
        for (String exp : expressions) {
            for (char c : exp.toCharArray()) {
                if (Character.isDigit(c)) {
                    int digit = c - '0';
                    if (digit > max) {
                        max = digit;
                    }
                }
            }
        }
        return max;
    }
}