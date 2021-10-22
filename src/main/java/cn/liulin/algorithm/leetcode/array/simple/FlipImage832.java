package cn.liulin.algorithm.leetcode.array.simple;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 832. 翻转图像
 * 给定一个二进制矩阵A，我们想先水平翻转图像，然后反转图像并返回结果。
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转[1, 1, 0]的结果是[0, 1, 1]。
 * 反转图片的意思是图片中的0全部被1替换，1全部被0替换。例如，反转[0, 1, 1]的结果是[1, 0, 0]。
 * @author ll
 * @date 2021-10-22 10:14:20
 **/
public class FlipImage832 {
    /**
     * 自定义：双指针
     * @author ll
     * @date 2021-10-22 10:30:53
     * @param image
     * @return int[][]
     **/
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j <= (image[i].length - 1) / 2; j++) {
                int i1 = image[i][j];
                int i2 = image[i][image[i].length - 1 - j];
                image[i][image[i].length - 1 - j] = i1^1;
                image[i][j] = i2^1;
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
        System.out.println(new FlipImage832().flipAndInvertImage(image));
    }
}
