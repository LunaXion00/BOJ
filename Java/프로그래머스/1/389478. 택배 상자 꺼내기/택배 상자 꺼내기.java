class Solution {
    public int solution(int n, int w, int num) {
       int answer = 0;
        int r = (num - 1) / w;
        int c = (r % 2 == 0) ? (num - 1) % w : (w - 1 - (num - 1) % w);

        for (; r < (n + w - 1) / w; r++) {
            int cnt = (r % 2 == 0) ? c + r * w : (w - 1 - c) + r * w;
            if (cnt < n) answer++;
        }

        return answer;
    }
}