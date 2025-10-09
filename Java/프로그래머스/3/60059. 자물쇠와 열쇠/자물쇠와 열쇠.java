class Solution {
    int n, m, original_start, original_end, ex_len;
    int[][] extend;
    public boolean solution(int[][] key, int[][] lock) {
        n = lock.length; m = key.length; original_start = m-1; original_end = m-1+n; ex_len = (m-1)*2+n;
        extend = new int[ex_len][ex_len];
        for(int i = 0; i<ex_len; i++){
            for(int j = 0; j<ex_len; j++){
                if(i>=original_start && i< original_end && j>=original_start && j<original_end) extend[i][j] = lock[i-original_start][j-original_start];
                else extend[i][j] = 0;
            }
        }
        for(int i = 0; i<4; i++){
            if(check(i, key)) return true;
            else rotate(key);
        }
        return false;
    }
    public boolean check(int index, int[][] key){
        for(int i = 0; i<original_end; i++){
            for(int j = 0; j<original_end; j++){
                for(int a = 0; a<m; a++){
                    for(int b = 0; b<m; b++){
                        extend[i+a][j+b] += key[a][b];
                    }
                }
                boolean flag = true;
                for(int a = original_start; a<original_end; a++){
                    for(int b = original_start; b< original_end; b++){
                        if(extend[a][b] != 1) {
                            flag = false;
                            break;
                        }
                    }
                    if(!flag) break;
                }
                if(flag) return true;
                
                for(int a = 0; a<m; a++){
                    for(int b = 0; b<m; b++){
                        extend[i+a][j+b] -= key[a][b];
                    }
                }
            }
        }
        return false;
    }
    public void rotate(int[][] key){
        int[][] temp = new int[m][m];
        for(int i=0; i<key.length; i++){
            for(int j=0; j<key.length; j++){
                temp[i][j] = key[j][key.length-i-1];
            }
        }
        for(int i=0; i<key.length; i++){
            for(int j=0; j<key.length; j++){
                key[i][j] = temp[i][j];
            }
        }
    }
}