class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int len = A.length;
        double[] sum = new double[len];

        sum[0] = A[0];
        for (int i = 1; i < len; i++) {
            sum[i] += sum[i - 1] + A[i];
        }

        return backTrack(A, len, sum, 0, K, new double[len][K + 1]);
    }

    public double backTrack(int[] A, int len, double[] sum, int index, int K, double[][] dp) {
        if (K == 1) {
            return (sum[len - 1] - sum[index] + A[index]) / (len - index);
        }

        if (dp[index][K] != 0) {
            return dp[index][K];
        }

        for (int i = index; i <= len - K; i++) {
            dp[index][K] = Math.max(dp[index][K], (((sum[i] - sum[index] + A[index]) * 1.0) / (i - index + 1)) + backTrack(A, len, sum, i + 1, K - 1, dp));
        }

        return dp[index][K];
    }
}


// class Solution {
//     double[][] preCalculated;

//     public double largestSumOfAverages(int[] A, int K) {
//         this.preCalculated = new double[A.length][A.length];
//         if (K == 1) {
//             return (double) Arrays.stream(A).sum() / A.length;
//         }
//         return recc(A, K, 0);
//     }

//     private double recc(int[] A, int K, int S) {
//         if (K == 1) {

//             double average = 0.0;
//             if (this.preCalculated[S][A.length - S] != 0.0) {
//                 average = this.preCalculated[S][A.length - S];
//             } else {
//                 for (int j = S; j < A.length; j++) {
//                     average += A[j];
//                 }
//                 this.preCalculated[S][A.length - S] = average;
//             }

//             return average / (A.length - S);
//         }

//         double maxi = 0.0;
//         for (int i = S + 1; i < A.length - K + 2; i++) {

//             double average = 0.0;
//             if (this.preCalculated[S][i - S] != 0.0) {
//                 average = this.preCalculated[S][i - S];
//             } else {
//                 for (int j = S; j < i; j++) {
//                     average += A[j];
//                 }
//                 this.preCalculated[S][i - S] = average;
//             }

//             maxi = Math.max(maxi, average / (i - S) + recc(A, K - 1, i));
//         }
//         return maxi;
//     }
// }



// def largestSumOfAverages(self, A: List[int], K: int) -> float:
//         if (K == 1):
//             return sum(A) / len(A)

//         maxi = 0
//         for i in range(1, len(A) - K + 2):
//             maxi = max((sum(A[:i]) / len(A[:i])) + self.largestSumOfAverages(A[i:], K - 1), maxi)

//         return maxi