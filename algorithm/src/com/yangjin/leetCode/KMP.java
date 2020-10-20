package com.yangjin.leetCode;

public class KMP {
    private String pat;
    private int[][] dp;

    public static void main(String[] args) {
        KMP kmp = new KMP("abab");

        int[][] dp = kmp.getDp();
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
//                System.out.print(dp[i][j]+" ");
                if (dp[i][j]>0) {
                    System.out.println(i+":"+j+"="+dp[i][j]);
                }
            }
            System.out.println();
        }
    }

    public KMP(String pat){
        this.pat = pat;
        int len = pat.length();
        int max = 256;
        dp = new int[len][max];
        dp[0][pat.charAt(0)] = 1;
        int x = 0;
        for (int i = 1; i < len; i++) {
            char c = pat.charAt(i);
            for (int j = 0; j < max; j++) {
                if (c==j) {
                    dp[i][j] = i+1;
                } else {
                    dp[i][j] = dp[x][j];
                }
            }
            x = dp[x][pat.charAt(i)];
            System.out.println(x);
        }
    }

    public String getPat() {
        return pat;
    }

    public void setPat(String pat) {
        this.pat = pat;
    }

    public int[][] getDp() {
        return dp;
    }

    public void setDp(int[][] dp) {
        this.dp = dp;
    }
}
