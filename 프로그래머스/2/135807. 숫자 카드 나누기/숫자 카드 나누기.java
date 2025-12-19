class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0], gcdB = arrayB[0];
        for(int i = 1; i<arrayA.length; i++){
            gcdA = gcd(arrayA[i], gcdA);
            gcdB = gcd(arrayB[i], gcdB);
        }
        if(!divide(arrayA, gcdB)) answer = Math.max(answer, gcdB);
        if(!divide(arrayB, gcdA)) answer = Math.max(answer, gcdA);
        return answer;
    }
    private int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a%b);
    }
    private boolean divide(int[] arr, int g){
        for(int a : arr){
            if(a % g == 0) return true;
        }
        return false;
    }
}