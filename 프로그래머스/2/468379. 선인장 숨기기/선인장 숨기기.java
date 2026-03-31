import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int INF = drops.length + 1; // 한 번도 비를 맞지 않는 경우

        int[] time = new int[m * n];
        Arrays.fill(time, INF);
        for (int i = 0; i < drops.length; i++) {
            time[drops[i][0] * n + drops[i][1]] = i + 1;
        }

        int rows = m - h + 1;
        int cols = n - w + 1;

        // 각 열에 대해 세로 크기 h짜리 슬라이딩 윈도우 최솟값
        int[] colMin = new int[rows * n];
        for (int c = 0; c < n; c++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int r = 0; r < m; r++) {
                while (!dq.isEmpty() && time[dq.peekLast() * n + c] >= time[r * n + c]) dq.pollLast();
                dq.addLast(r);
                if (dq.peekFirst() <= r - h) dq.pollFirst();
                if (r >= h - 1) colMin[(r - h + 1) * n + c] = time[dq.peekFirst() * n + c];
            }
        }

        // colMin의 각 행에 대해 가로 크기 w짜리 슬라이딩 윈도우 최솟값
        int[] winMin = new int[rows * cols];
        for (int r = 0; r < rows; r++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int c = 0; c < n; c++) {
                while (!dq.isEmpty() && colMin[r * n + dq.peekLast()] >= colMin[r * n + c]) dq.pollLast();
                dq.addLast(c);
                if (dq.peekFirst() <= c - w) dq.pollFirst();
                if (c >= w - 1)
                    winMin[r * cols + (c - w + 1)] = colMin[r * n + dq.peekFirst()];
            }
        }

        // winMin 최댓값 위치 탐색
        int maxTime = -1;
        int[] result = {0, 0};
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (winMin[r * cols + c] > maxTime) {
                    maxTime = winMin[r * cols + c];
                    result = new int[]{r, c};
                }
            }
        }
        return result;
    }
}
