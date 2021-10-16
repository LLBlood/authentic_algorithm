package cn.liulin.algorithm.leetcode.array.simple;

/**
 * 661. 图片平滑器
 * 包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度(向下舍入) ，
 * 平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
 */
public class PictureSmoother661 {
    /**
     * 官方法：方法 1：遍历矩阵
     * @param img
     * @return
     */
    public int[][] imageSmoother(int[][] img) {
        int[][] newImg = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                int count = 0;
                for (int ni = i - 1; ni <= i + 1; ni++) {
                    for (int nj = j - 1; nj <= j + 1; nj++) {
                        if (ni >= 0 && nj >= 0 && ni < img.length && nj < img[0].length) {
                            newImg[i][j] += img[ni][nj];
                            count++;
                        }
                    }
                }
                newImg[i][j] /= count;
            }
        }
        return newImg;
    }
}
