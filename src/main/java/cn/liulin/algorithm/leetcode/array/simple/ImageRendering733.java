package cn.liulin.algorithm.leetcode.array.simple;

import com.alibaba.fastjson.JSON;

/**
 * cn.liulin.algorithm.leetcode.array.simple$
 * 733. 图像渲染
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 * 给你一个坐标(sr, sc)表示图像渲染开始的像素值（行 ，列）和一个新的颜色值newColor，让你重新上色这幅图像。
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，
 * 接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，
 * 重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 * 最后返回经过上色渲染后的图像。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flood-fill
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author ll
 * @date 2021-10-19 10:17:15
 **/
public class ImageRendering733 {
    /**
     * 自定义：深度优先搜索
     * @author ll
     * @date 2021-10-19 10:36:43
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return int[][]
     **/
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldValue = image[sr][sc];
        if (oldValue == newColor) {
            return image;
        }
        image[sr][sc] = newColor;
        dealImage(image, sr, sc, oldValue, newColor);
        return image;
    }

    private void dealImage(int[][] image, int sr, int sc, int oldValue, int newColor) {
        if (sr - 1 >= 0 && image[sr - 1][sc] == oldValue) {
            image[sr - 1][sc] = newColor;
            dealImage(image, sr - 1, sc, oldValue, newColor);
        }
        if (sr + 1 < image.length && image[sr + 1][sc] == oldValue) {
            image[sr + 1][sc] = newColor;
            dealImage(image, sr + 1, sc, oldValue, newColor);
        }
        if (sc - 1 >= 0 && image[sr][sc - 1] == oldValue) {
            image[sr][sc - 1] = newColor;
            dealImage(image, sr, sc - 1, oldValue, newColor);
        }
        if (sc + 1 < image[0].length && image[sr][sc + 1] == oldValue) {
            image[sr][sc + 1] = newColor;
            dealImage(image, sr, sc + 1, oldValue, newColor);
        }
    }

    public static void main(String[] args) {
        int[][] img = {{0,0,0},{0,1,1}};
        System.out.println(JSON.toJSONString(new ImageRendering733().floodFill(img, 1, 1, 1)));
    }

    public int[][] floodFill3(int[][] image, int sr, int sc, int color) {
        int oldValue = image[sr][sc];
        if (oldValue == color) {
            return image;
        }
        image[sr][sc] = color;
        floodAllFile(image, sr, sc, oldValue, color);
        return image;
    }

    private void floodAllFile(int[][] image, int sr, int sc, int oldValue, int newColor) {
        if (sr - 1 >= 0 && image[sr - 1][sc] == oldValue) {
            image[sr - 1][sc] = newColor;
            dealImage(image, sr - 1, sc, oldValue, newColor);
        }
        if (sr + 1 < image.length && image[sr + 1][sc] == oldValue) {
            image[sr + 1][sc] = newColor;
            dealImage(image, sr + 1, sc, oldValue, newColor);
        }
        if (sc - 1 >= 0 && image[sr][sc - 1] == oldValue) {
            image[sr][sc - 1] = newColor;
            dealImage(image, sr, sc - 1, oldValue, newColor);
        }
        if (sc + 1 < image[0].length && image[sr][sc + 1] == oldValue) {
            image[sr][sc + 1] = newColor;
            dealImage(image, sr, sc + 1, oldValue, newColor);
        }
    }
}
