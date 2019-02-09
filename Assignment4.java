public class Assignment4 {
    public static void main(String[] args) {
        System.out.println("------" + "Question 1" + "--------");
        String s = "leetcode";
        System.out.println(firstUniqueChar(s));


        System.out.println("------" + "Question 2" + "--------");
        int n = 38;
        System.out.println(digitSum(n));

        System.out.println("------" + "Question 3" + "--------");
        int[] num = {0, 1, 0, 3, 12};
        moveZeroes(num);
        printArray(num);


        System.out.println("------" + "Question 4" + "--------");
        String str = longestPalindrome("babad");
        System.out.println(str);

        System.out.println("------" + "Question 5" + "--------");

        int N = 3;
        int mat[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}

        };
        rotateMatrix(N,mat);
        displayMatrix(N,mat);

    }


    /*
     * 1. Given a string, find the first non-repeating character in it and return it's
     * index. If it doesn't exist, return -1. s = "leetcode" return 0. s =
     * "loveleetcode" return 2.
     */
    static int firstUniqueChar(String str) {
        if (str == null) {
            return -1;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))) {
                return i;
            }
        }
        return -1;
    }


    /*
     * 2. Given a non-negative integer num, repeatedly add all its digits until the
     * result has only one digit. Input: 38 Output: 2 Explanation: The process is
     * like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
     */
    static int digitSum(int n) {
        int sum = 0;
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            sum = sum + (s.charAt(i) - '0');
        }
        if (sum < 10) {
            return sum;
        } else {
            return digitSum(sum);
        }
    }


    /*
     * 3. Given an array nums, write a function to move all 0's to the end of it while
     * maintaining the relative order of the non-zero elements. Input: [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     */
    static void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j++] = temp;
            } else {
                j++;
            }
        }

    }
    static void printArray(int nums[]) {
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
        System.out.println();
    }



    /*
     * 4. Given a string s, find the longest palindromic substring in s. You may assume
     * that the maximum length of s is 1000. Input: "babad" Output: "bab" Note:
     * "aba" is also a valid answer.
     */
    static String longestPalindrome(String s) {
        int longest_len = 0;
        String longest = "";

        for (int c = 0; c < s.length(); c++)    {
            int i = 1;
            int len = 1;
            while (true)    {
                int left = c - i;
                int right = c + i;

                if (left < 0 || right >= s.length())
                    break;

                if (s.charAt(left) != s.charAt(right))
                    break;

                len = right - left + 1;
                i += 1;
            }
            if (len > longest_len)  {
                longest_len = len;
                longest = s.substring(c-len/2, c+len/2+1);
            }
        }


        for (int c = 0; c < s.length(); c++)    {
            int i = 1;
            int len = 0;
            while (true)    {
                int left = c - i;
                int right = c + i - 1;

                if (left < 0 || right >= s.length())
                    break;

                if (s.charAt(left) != s.charAt(right))
                    break;

                len = right - left + 1;
                i += 1;
            }
            if (len > longest_len)  {
                longest_len = len;
                longest = s.substring(c-len/2, c+len/2);
            }
        }

        return longest;
    }

    /*
     * 5. You are given an n x n 2D matrix representing an image. Rotate the image by
     * 90 degrees (clockwise). Given input matrix = [ [1,2,3], [4,5,6], [7,8,9] ],
     * rotate the input matrix in-place such that it becomes: [ [7,4,1], [8,5,2],
     * [9,6,3] ],
     */
    static void rotateMatrix(int N,int[][] mat) {
        //int N=mat.length;
        for (int x = 0; x < N / 2; x++) {
            for (int y = x; y < N - x - 1; y++) {
                int temp = mat[x][y];
                mat[x][y] = mat[N - 1 - y][x];
                mat[N - 1 - y][x] = mat[N - 1 - x][N - 1 - y];
                mat[N - 1 - x][N - 1 - y] = mat[y][N - 1 - x];
                mat[y][N - 1 - x] = temp;
            }
        }

    }
    static void displayMatrix(int N,int mat[][]){


        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + mat[i][j]);

            System.out.print("\n");
        }
        System.out.print("\n");
    }




}