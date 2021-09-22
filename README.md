# authentic_algorithm
来源于不同书籍的算法学习
## 1、算法图解
代码存放于路径：cn.liulin.algorithm.diagram
### 1.1 二分查找法 
代码路径： cn.liulin.algorithm.diagram.BinarySearchMethod

为什么需要二分查找法，在排序队列中，如果需要找到一个数，二分查找法可能是最有效的

比如1~100，查找63

第一次，50 小 （1+100） / 2

第二次，75 大 （50+100） / 2

第三次，62 小 （50+75） / 2

第四次，68 大 （62+75） / 2

第五次，65 大 （62+68） / 2

第六次，63 等 （62+65） / 2

所以只需要6次，而普通查询，则需要63次，随着数据量的不断增大，两者查询速度也会不断增大

二分查找法时间表示O(log n), 普通查询O(n)

<font color="red">注意：当角标位置对应的元素小于或者大于目标元素，角标位置本身的元素不再算入，则小于时，起始角标应该对应中间角标+1，则大于时，结束角标应该对应中间角标-1</font>

### 1.2 选择排序

代码路径： cn.liulin.algorithm.diagram.SelectSort

```java
151,2,343,53,65,75,23,12,14,6,67,87
找出上面最小的数2，与第一位151交换
2,151,343,53,65,75,23,12,14,6,67,87
再找出 151,343,53,65,75,23,12,14,6,67,87 最小的数6，与第一位151交换
2,6,343,53,65,75,23,12,14,151,67,87
依次进行，直到最后排序完毕
```

相当于每次查询当前临时数组中最小的一位数，放在最前面，最终排序完毕

所需时间n*(n-1)*(n-2).....1 最终O(n^2)

### 1.3 递归

代码路径： cn.liulin.algorithm.diagram.Recursion

递归最主要就是要弄明白什么是基准条件，什么是递归条件，从而满足递归开始结束因素

### 1.4 快速排序

代码路径： cn.liulin.algorithm.diagram.QuickSort

快速排序，主要利用了分而治之的思路，选定基准值，分隔比他大的数组及比他小的数组，再到两个数组中，重新选定基准值

比如 151,2,343,53,65,75,23,12,14,6,67,87 ，想要做到基准值右边大，左边小

选定基准值baseX = a[0] = 151, low = 0, high = 11

此时a[0]就是一个坑等着右边小的填，a[11] < baseX ,所以此时a[0] = a[11] = 87, low++;

此时a[11]就是一个坑等着左边大的填，a[1] < baseX 循环low++ 直到 a[2] > baseX， 所以此时a[11] = a[2] = 343, high++

......

直到不满足low <= high之后

可以预见基准值右边大，左边小，然后分而治之

### 1.5 广度优先搜索

代码路径：cn.liulin.algorithm.diagram.BreadthFirstSearch

图片示例路径：cn/liulin/algorithm/diagram/BreadthFirstSearch.png

广度优先搜索；

​	1、可解决A点到B点是否有路径

​	2、可解决A点到B点最短路径

例如：从朋友圈找到iphone经销商

首先从自己的朋友开始找，找不到就从朋友的朋友找，直到找到为止

将自己的朋友加入队列（先进先出FIFO）,找不到就把朋友的朋友加入队列，当然要排除已加入队列的人

## 2、大话设计模式

代码存放于路径：cn.liulin.algorithm.dhdesign

### 2.1 职责链模式

代码存放于路径：cn.liulin.algorithm.dhdesign.zzl

每一个对象都可以处理请求，但是能够处理请求的范围不一样，当下级对象无法处理请求时，转到上级对象进行处理请求。

比如请假申请，部门主管->公司经理->公司董事长，每个级别能够处理的申请范围不一样

使多个对象都有机会处理请求，从而避免请求的发起者和接收者之间的耦合关系，将这个对象连成一条链，并沿着这条链处理请求，直到有一个对象能够处理它为止。

职责链模式相当于，一个请求当前对象无法处理，就会转到下个对象处理，直到获得处理结果为止。

[职责链模式](https://blog.csdn.net/qq_43479628/article/details/114838375)

### 2.2 委派模式

代码存放于路径：cn.liulin.algorithm.dhdesign.wp

委派模式主要表现形式，当前对象需要做一件事，但是并不知道具体怎么干，需要委托另一个对象分配任务
如班主任想要举办活动，但是不知道哪些同学擅长哪些运动，于是委托班长安排合适的运动给合适的同学。

[委派模式](https://blog.csdn.net/qq_43479628/article/details/115179926)

### 2.3 模板方法模式

代码存放于路径：cn.liulin.algorithm.dhdesign.mb

模板方法模式，定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。

模板方法模式是通过把不变行为搬移到超类，去除子类中的重复代码来体现它的优势

当不变的和可变的行为在方法的子类实现中混合在一起的时候，不变的行为就会在子类中重复出现，我们通过模板方法模式把这些行为搬移到单一的地方，这样就帮助子类摆脱重复的不变行为的纠缠。

[模板方法模式](https://blog.csdn.net/qq_43479628/article/details/117661651)

## 3、LeetCode

代码存放路径：cn.liulin.algorithm.leetcode

### 3.1 数组

 代码存放路径：cn.liulin.algorithm.leetcode.array

#### 3.1.1 第1题.两数之和

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.TwoNumSum1

解题方法：

​	1.暴力破解法：取出数组中的每一个数，然后与后面的数相加对比是否为target

​	2.利用hashMap：将查询过的每一个数存储起来，查询target-x的结果是否在hashMap中存在

#### 3.1.2 第26题.删除有序数组中的重复项

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.DelSortArrayRepeatNum26

解题方法：

​	1.自定义双指针法: 定义重复值对象，并设定新数组长度，使用角标不断递增查询值，若是不一样，则替换值

​	2.官方双指针法：使用快指针和慢指针，快指针用于判定每个角标的值，满指针用于该数组准确的值

#### 3.1.3 第27题.移除元素

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.DelElement27

解题方法：

​	1.自定义双指针法，比较nt

​	2.官方双指针法: 其中一个指针负责存储返回的数据，另一个指针负责轮询数据

​	3.官方双指针法2: 分左指针，右指针，左指针从左边开始，如果等于val，就与右指针对应的数交换，左右指针相等时结束循环

#### 3.1.4 第35题.搜索插入位置

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.SearchInsertPosition35

解题方法：

​	1.自定义二分查找法：不再详细描述

​	2.官方二分查找法：完美套入所有条件

#### 3.1.5 第53题.最大子序和

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.MaximumSuborderSum53

解题方法：

​	1.官方题解法：动态规划

​		设定一个值pre存储，Nums[i]与f{i-1} + nums[i]较大值，f{i-1}就是i值之前的数组和；

​		设定一个值max存储 pre和max的较大值，遍历数组完毕后，返回max即可

​	2.官方题解法：分治法

​		对于一个数组，可以分为左右两个区间，该数组的最大子序和mSum，可能是左右区间的mSum的较大值，也有可能是左区间数组的 rSum +左区间数组lSum，对于每一个区间又是一个数组，数组的lSum取值为左区间的lSum，或者lSum + 右区间的iSum， 数组的rSum取值为右区间的rSum, 或者rSum + 左区间的iSum

所以每一个数组所拥有的属性为mSum, rSum, lSum, iSum

#### 3.1.6 第66题.加一

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.AddOne66

解题方法：

​	1.自定义：通过末位加1然后判断结果值

​	2.结合实际法：如果数组每一位都是9才有可能增加1，否则在数组循环的时候就结束了

#### 3.1.7 第88题.合并两个有序数组

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.MergeTwoOrderArray88

解题方法：

​	1.自定义：双指针法

​	2.官方：双指针法

​	3.官方：逆双指针法

#### 3.1.8 第108题.将有序数组转换为二叉搜索树

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.ConvertArrayToBinarySearchTree108

解题方法：

​	1.自定义：递归中序靠左遍历

#### 3.1.9 第118题.杨辉三角

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.YangHuiTriangle118

解题方法：

​	1.自定义：数学推导法

#### 3.1.10 第119题.杨辉三角II

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.YangHuiTriangleTwo119

解题方法：

​	1.自定义：递推法

​	2.官方题解法：滚筒法

​	3.进一步优化滚筒法

#### 3.1.11 第121题. 买卖股票的最佳时机

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.BestTimeBuyAndSellStocks121

解题方法：

​	1.自定义：一次遍历

#### 3.1.12 第167题. 两数之和 II - 输入有序数组

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.TwoNumSumOrderArrayTwo167

解题方法：

​	1.自定义：map存储

​	2.官方题解法：双指针法

​	3.官方题解法：二分查找法

#### 3.1.13 第217题. 存在重复元素

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.DuplicateElements217

解题方法：

​	1.官方题解法：哈希

#### 3.1.14 第219题. 存在重复元素 II

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.DuplicateElementsTwo219

解题方法：

​	1.官方题解法：散列表

#### 3.1.15 第228题. 汇总区间

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.SummaryInterval228

解题方法：

​	1.自定义版本： 顺序遍历

#### 3.1.16 第268题.丢失的数字

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.MissingNumber268

解题方法：

​	1.自定义：哈希法

​	2.官方：排序法

​	3.高斯算法

#### 3.1.17 第283题.移动零

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.MoveZero283

解题方法：

​	1.自定义：强行记录法

​	2.官方双指针法：左值针left指向已处理数据尾部，右指针指向未处理头部，左右指针之间的区域就是0

#### 3.1.18 第303题.区域和检索 - 数组不可变

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.ArrayImmutable303

解题方法：

​	1.官方：纯数学法初始化提高速度
