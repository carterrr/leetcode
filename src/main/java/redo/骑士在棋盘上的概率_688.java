package redo;

class 骑士在棋盘上的概率_688 {
    int[][] moves = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[n][n][k + 1]; // 多一层  递推到k层
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                dp[i][j][0] = 1; // 从i j 出发 移动0步  仍在棋盘的概率为1  最终结果
            }
        }

        for(int p = 1; p <= k; p ++) {   // 三维dp  轮次在最外一层  从第一层到k层
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    for(int[] move : moves) {
                        int x = i + move[0];
                        int y = j + move[1];
                        if(x < 0 || x >= n || y < 0 || y >=n) continue;
                        dp[i][j][p] += dp[x][y][p - 1] /8 ; // 每个点的概率等于移动后  仍在棋盘概率 * 1/8
                    }
                }
            }
        }

        return dp[row][column][k];
    }
}