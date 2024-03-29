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

代码存放于路径：cn.liulin.algorithm.dhdesign.responchain

每一个对象都可以处理请求，但是能够处理请求的范围不一样，当下级对象无法处理请求时，转到上级对象进行处理请求。

比如请假申请，部门主管->公司经理->公司董事长，每个级别能够处理的申请范围不一样

使多个对象都有机会处理请求，从而避免请求的发起者和接收者之间的耦合关系，将这个对象连成一条链，并沿着这条链处理请求，直到有一个对象能够处理它为止。

职责链模式相当于，一个请求当前对象无法处理，就会转到下个对象处理，直到获得处理结果为止。

[职责链模式](https://blog.csdn.net/qq_43479628/article/details/114838375)

### 2.2 委派模式

代码存放于路径：cn.liulin.algorithm.dhdesign.delegate

委派模式主要表现形式，当前对象需要做一件事，但是并不知道具体怎么干，需要委托另一个对象分配任务
如班主任想要举办活动，但是不知道哪些同学擅长哪些运动，于是委托班长安排合适的运动给合适的同学。

[委派模式](https://blog.csdn.net/qq_43479628/article/details/115179926)

### 2.3 模板方法模式

代码存放于路径：cn.liulin.algorithm.dhdesign.template

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

#### 3.1.19 第414题.第三大的数

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.ThirdNum414

解题方法：

​	1.自定义：先排序再找数字

​	2.三指针法

#### 3.1.20 第448题.找到所有数组中消失的数字

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.AllArrayMissNum448

解题方法：

​	1.自定义：哈希法

​	2.鸽笼算法:

因为Nums的长度就是区域[1, n]的n，且nums[i]在[1,n]中，所以nums的每个值-1刚好是角标值

每个数字的值-1就是角标，将角标对应的值置为负数，则不是负数的数字所在角标+1的值肯定没出现

​	3.官方题解法：

#### 3.1.21 第453题.最小操作次数使数组元素相等

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.MinOperaArrayEqualsElements453

解题方法：

官方数学法：给数组除某个元素外的所有元素+1，即对该元素进行-1

首先找出最小的数，然后算出每个数变更到最小数的次数

#### 3.1.22 第463题.岛屿的周长

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.PerimeterOfTheIsland463

解题方法：

自定义法：相邻比减2进行-1

两个小岛如果相连，则该小岛的周长会减去2，所以只需要判断一个小岛左上是否存在小岛即可

#### 3.1.23 第485题. 最大连续 1 的个数

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.MaxNumberOfConseOne485

解题方法：

自定义法：一次遍历

#### 3.1.24 第495题. 提莫攻击

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.TimoAttack495

解题方法：

自定义法：单次扫描

#### 3.1.25 第500题. 键盘行

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.KeyboardLine500

解题方法：

自定义法：暴力法

#### 3.1.26 第506题. 相对名次

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.RelativeRanking506

解题方法：

自定义法：暴力法

#### 3.1.27 第561题. 数组拆分 I

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.ArraySplittingI561

解题方法：

自定义法：排序，每次挑第二大的数据

#### 3.1.28 第566题. 重塑矩阵

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.ReshapingTheMatrix566

解题方法：

自定义法：二维数组的一维表示

#### 3.1.29 第575题. 分糖果

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.DivideCandy575

解题方法：

自定义：暴力法

#### 3.1.30 第594.题. 最长和谐子序列

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.LongestHarmonicSubsequence594

解题方法：

官方法：哈希+一次扫描

#### 3.1.31第598题. 范围求和 II

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.LongestHarmonicSubsequence594

解题方法：

官方法：一遍遍历

#### 3.1.32第599题.  两个列表的最小索引总和

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.MinimumIndexOfList599

解题方法：

官方法：使用哈希表（线性） [Accepted]

#### 3.1.33第605题.  种花问题

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.FlowerPlanting605

解题方法：

官方法：数学题解法（贪心）

#### 3.1.34第628题.  三个数的最大乘积

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.MaxProductOfThreeNumbers628

解题方法：

官方法：排序解题法

官方法：线性扫描

#### 3.1.35第643题.  子数组最大平均数 I

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.MaxAverageNumberOfSubArraysI643

解题方法：

自定义：暴力法超时

官方法：滑动窗口

#### 3.1.36第645题.  错误的集合

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.WrongSet645

解题方法：

自定义：纯数学法

#### 3.1.37第661题.  图片平滑器

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.WrongSet645

解题方法：

官方法：方法 1：遍历矩阵

#### 3.1.38第674题. 最长连续递增序列

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.LongestContinuousIncreasingSequence674

解题方法：

自定义：贪心算法

#### 3.1.39第697题. 数组的度

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.DegreeOfArray697

解题方法：

自定义：三MAP法

官方：单Map

#### 3.1.40第704题. 二分查找

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.BinarySearch704

解题方法：

自定义：二分查找法

#### 3.1.41第705题. 设计哈希集合

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.DesignHashSet705

解题方法：

官方法：数组链表形式

#### 3.1.42第706题. 设计哈希映射

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.DesignHashMapping706

解题方法：

官方题解法：设计链表数组

#### 3.1.43第717题. 1比特与2比特字符

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.OneBitAndTwoBitCharacters717

解题方法：

官方题解法：贪心

#### 3.1.44第720题. 词典中最长的单词

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.LongestWordDictionary720

解题方法：

官方题解法：暴力法

#### 3.1.45第724题. 寻找数组的中心下标

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.FindCenterSubOfArray724

解题方法：

自定义，双向匹配法

官方：前缀和

#### 3.1.46第733题. 图像渲染

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.ImageRendering733

解题方法：

自定义：深度优先搜索

#### 3.1.47第744题. 寻找比目标字母大的最小字母

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.FindSmallThanTarget744

解题方法：

自定义：二分查找法

#### 3.1.48第746题. 使用最小花费爬楼梯

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.UseMinCostClimbStairs746

解题方法：

首先确定爬到第一阶梯和第二阶梯不需要花费任何体力即d[0] = d[1] = 0;

之后的阶梯花费体力= d[i-1] + 前一个阶梯所需体力 或者 d[i-2]+前两个阶梯所需体力，找出其中小的那个就是当前阶梯需要花费的体力

依次类推，累计前两个阶梯的值即可

#### 3.1.49第747题. 至少是其他数字两倍的最大数

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.MaxNumberTwiceTwoFigure747

解题方法：

自定义：线性扫描

#### 3.1.49第766题. 托普利茨矩阵

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.ToplitzMatrix766

解题方法：

自定义：遍历

#### 3.1.50第804. 唯一摩尔斯密码词题. 唯一摩尔斯密码词

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.UniqueMorseCodeWord804

解题方法：

自定义：哈希集合

#### 3.1.51第806题. 写字符串需要的行数

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.NumberLineOfWriteStr806

解题方法：

自定义：顺序遍历

#### 3.1.52第812题. 最大三角形面积

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.MaxTriangleArea812

解题方法：

海伦公式

```
边长求值
p = (a + b + c) / 2
S = sqrt(p * (p - a) * (p - b) * (p - c))
```

鞋带公式

```
坐标点求值
S=|(x1 * y2 + x2 * y3 + x3 * y1 - y1 * x2 - y2 * x3 - y3 * x1)|/2
```

#### 3.1.53第821题. 字符的最短距离

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.MinDistanceOfCharacters821

解题方法：

自定义：对比法

最小数组

#### 3.1.54第832题. 翻转图像

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.FlipImage832

解题方法：

自定义：双指针

#### 3.1.55第852题. 山脉数组的峰顶索引

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.PeakIndexOfMountainRangeArray852

解题方法：

自定义：二分查找法，找出最小的大于下一个数的角标

#### 3.1.56 第867题. 转置矩阵

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.TransposeMatrix867

解题方法：

自定义：模拟

#### 3.1.57 第883题. 三维形体投影面积

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.ProjectedAreaOfThreeDimensional883

解题方法：

自定义：数学

#### 3.1.58第888题. 公平的糖果棒交换

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.FairCandyBarExchange888

解题方法：

官方：哈希算法

#### 3.1.59 第892题. 三维形体的表面积

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.SurfaceAreaOfThreeDimensional892

解题方法：

自定义：数学法

#### 3.1.60 第896题. 单调数列

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.MonotoneSequence896

解题方法：

自定义：数学法

#### 3.1.61 第905题. 按奇偶排序数组

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.SortArraysByParity905

解题方法：

自定义：双指针法

#### 3.1.62 第908题. 最小差值 I

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.MinimumDifferenceI908

解题方法：

自定义：数学法

#### 3.1.63 第929题. 独特的电子邮件地址

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.UniqueEmailAddress929

解题方法：

自定义：哈希

#### 3.1.64 第937题. 重新排列日志文件

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.RearrangeLogFiles937

解题方法：

自定义排序

#### 3.1.65 第941题. 有效的山脉数组

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.ValidMountainArray941

解题方法：

官方：线性扫描

#### 3.1.66 第942题. 增减字符串匹配

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.InOrDeStrMatch942

解题方法：

自定义：算法

#### 3.1.67 第944题. 删列造序

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.DeleteOrder944

解题方法：

自定义：贪心

#### 3.1.68 第953题. 验证外星语词典

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.VerifyAlienLanguageDic953

解题方法：

自定义：检查邻近单词

#### 3.1.69 第977题. 有序数组的平方

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.SquareOfOrderedArray977

解题方法：

自定义：双指针法

#### 3.1.70 第989题. 数组形式的整数加法

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.IntegerAdditionInArray989

解题方法：

自定义：逐位相加

#### 3.1.71 第999题. 可以被一步捕获的棋子数

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.NumOfPieceCapturedOneStep999

解题方法：

自定义：四个while

官方：方向数组

#### 3.1.72 第1002题. 查找共用字符

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.FindCommonCharacters1002

解题方法：

自定义：暴力法

官方：计数法

#### 3.1.73 第1013题. 将数组分成和相等的三个部分

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.DivideArrayToThreePartsEquals1013

解题方法：

官方：数学法

#### 3.1.74 第1018题. 可被 5 整除的二进制前缀

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.BinaryPrefixDivideByFive1018

解题方法：

官方：遍历法

#### 3.1.75 第1051题. 高度检查器

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.HeightChecker1051

解题方法：

官方：桶排序法

#### 3.1.76 第1089题. 复写零

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.DuplicateZero1089

解题方法：

官方：两次遍历

#### 3.1.77 第1128题. 等价多米诺骨牌对的数量

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.NumberOfEquivalentDominoPairs1128

解题方法：

官方：二元组表示 + 计数

#### 3.1.78 第1160题. 拼写单词

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.SpellingWords1160

解题方法：

自定义：哈希表记数

#### 3.1.79 第1184题. 公交站间的距离

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.DistanceBetweenBusStops1184

解题方法：

自定义：遍历法

#### 3.1.80 第1200题. 最小绝对差

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.MinimumAbsoluteDifference1200

解题方法：

自定义：求最小值

#### 3.1.81 第1207题. 独一无二的出现次数

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.UniqueOccurrences1207

解题方法：

自定义：双hash法

#### 3.1.82 第1217题. 玩筹码

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.PlayingChips1217

解题方法：

自定义：蠢材暴力法

大神解读法 将移动转为奇偶数法

#### 3.1.83 第1232题. 缀点成线

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.DottedLine1232

解题方法：

自定义：双点求直线方程

#### 3.1.84 第1252题. 奇数值单元格的数目

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.NumberOfOddValueCells1252

解题方法：

自定义：数学法

#### 3.1.84 第1260题. 二维网格迁移

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.MeshMigration1260

解题方法：

自定义：取模

#### 3.1.85 第1275题. 找出井字棋的获胜者

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.FindTheWinner1275

解题方法：

自定义：模拟

#### 3.1.86 第1287题. 有序数组中出现次数超过25%的元素

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.ElementsOrderArray1287

解题方法：

自定义：全部遍历法

官方：遍历计算法

#### 3.1.87 第1299题. 将每个元素替换为右侧最大元素

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.ReplaceEachEleWithLastRight1299

解题方法：

官方：逆序遍历

#### 3.1.88 第1331题. 数组序号转换

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.ArraySequenceNumberConversion1331

解题方法：

自定义：hash法

#### 3.1.89 第1337题. 矩阵中战斗力最弱的 K 行

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.RowWithWeakestInMatrix1337

解题方法：

二分查找法+堆

#### 3.1.90 第1346题. 检查整数及其两倍数是否存在

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.CheckIntMultipleExist1346

解题方法：

自定义：暴力法

#### 3.1.91 第1351题. 统计有序矩阵中的负数 

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.NegativeNumberInOrder1351

解题方法：

自定义：二分查找法

#### 3.1.92 第1356题. 根据数字二进制下 1 的数目排序

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.SortAccordUnderBinary1356

解题方法：

自定义：暴力法

#### 3.1.93 第1365题. 有多少小于当前数字的数字

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.SortAccordUnderBinary1356

解题方法：

自定义：计数排序

#### 3.1.94 第748题. 最短补全词

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.ShortestComplement748

解题方法：

自定义：计数排序

#### 3.1.95 第1380题. 矩阵中的幸运数

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.LuckyNumbersInTheMatrix1380

解题方法：

自定义：暴力法

官方：模拟

#### 3.1.96 第1385题. 两个数组间的距离值

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.DistanceValueBetweenTwoArrays1385

解题方法：

自定义：模拟

官方： 二分查找法

#### 3.1.97 第1389题. 按既定顺序创建目标数组

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.CreateTheTargetArray1389

解题方法：

自定义：模拟

#### 3.1.98 第1394题. 找出数组中的幸运数

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.FindTheLuckyNumber1394

解题方法：

自定义：一维数组

#### 3.1.99 第1413题. 逐步求和得到正数的最小值

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.SumStepPositiveNumber1413

解题方法：

自定义：基本算法

#### 3.1.100 第1431题. 拥有最多糖果的孩子

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.ChildrenWithTheMostCandy1431

解题方法：

自定义：遍历

#### 3.1.101 第1437题. 是否所有 1 都至少相隔 k 个元素

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.AreAllLeastElementsApart1437

解题方法：

自定义：遍历

#### 3.1.102 第1450题. 在既定时间做作业的学生人数

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.NumberOfStudentsDoingHomework1450

解题方法：

自定义：遍历

#### 3.1.103 第1460题. 通过翻转子数组使两个数组相等

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.MakeTheTwoArraysEqual1460

解题方法：

自定义：遍历

#### 3.1.104 第1464题. 数组中两元素的最大乘积

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.MaximumProductOfTwoElements1464

解题方法：

自定义：遍历

#### 3.1.105 第1470题. 重新排列数组

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.RearrangeArray1470

解题方法：

自定义：遍历

#### 3.1.106 第1475题. 商品折扣后的最终价格

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.FinalPriceAfterCommodityDiscount1475

解题方法：

自定义：遍历

#### 3.1.107 第1480题. 一维数组的动态和

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.DynamicSumOfArray1480

解题方法：

自定义：原地修改

#### 3.1.108 第1512题. 好数对的数目

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.NumberOfGoodPairs1512

解题方法：

自定义：暴力遍历

官方：等差数列

#### 3.1.109 第1534题. 统计好三元组

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.CountTriples1534

解题方法：

自定义：枚举

#### 3.1.110 第1539题. 第 k 个缺失的正整数

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.TheMissingPositiveInteger1539

解题方法：

自定义：枚举

#### 3.1.111 第1550题. 存在连续三个奇数的数组

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.ThereAreThreeConsecutiveOddArrays1550

解题方法：

自定义：枚举

#### 3.1.112 第1566题. 重复至少 K 次且长度为 M 的模式

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.RepeatThePatternWithLength1566

解题方法：

自定义：枚举

#### 3.1.113 第1560题. 圆形赛道上经过次数最多的扇区

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.TheSectorWithTheMostPasses1560

解题方法：

自定义：枚举

#### 3.1.114 第1572题. 矩阵对角线元素的和

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.SumOfDiagonalElementsOfMatrix1572

解题方法：

自定义：逐行取数

#### 3.1.115 第1582题. 二进制矩阵中的特殊位置

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.SpecialPositionsInBinaryMatrix1582

解题方法：

自定义：逐行取数

#### 3.1.116 第1588题. 所有奇数长度子数组的和

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.SumOfAllOddLengthSubarrays1588

解题方法：

自定义：暴力循环法

#### 3.1.117 第1598题. 文件夹操作日志搜集器

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.FolderOperationLogCollector1598

解题方法：

自定义：计数法

#### 3.1.118 第1608题. 特殊数组的特征值

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.EigenvaluesOfSpecialArrays1608

解题方法：

自定义：暴力排序法

#### 3.1.119 第1619题. 删除某些元素后的数组均值

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.ArrayMeanAfter1619

解题方法：

自定义：暴力排序法

#### 3.1.120 第1629题. 按键持续时间最长的键

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.KeyWithTheLongestKeyDuration629

解题方法：

自定义：一次遍历

#### 3.1.121 第1636题. 按照频率将数组升序排序

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.SortTheArrayInAscendingOrderByFrequency1636

解题方法：

自定义：暴力法

#### 3.1.122 第1646题. 获取生成数组中的最大值

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.GetTheMaximumValue1646

解题方法：

官方：模拟

#### 3.1.123 第1652题. 拆炸弹

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.BombRemoval1652

解题方法：

自定义：滑动计算

#### 3.1.124 第1656题. 设计有序流

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.DesignOrderedFlow1656

解题方法：

自定义：暴力法

#### 3.1.125 第350题. 两个数组的交集 II

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.ArrayIntersection350

解题方法：

自定义：哈希表法

#### 3.1.126 第36题. 有效的数独

代码存放路径：cn.liulin.algorithm.leetcode.array.medium.ValidSudoku36

解题方法：

自定义：集合法

官方：三维数组+一次遍历法

#### 3.1.127 第73题. 矩阵置零

代码存放路径：cn.liulin.algorithm.leetcode.array.medium.MatrixZero73

解题方法：

自定义：双数组法

#### 3.1.128 第189题. 轮转数组

代码存放路径：cn.liulin.algorithm.leetcode.array.medium.RotationArray189

解题方法：

自定义：数组翻转

#### 3.1.129 第344题. 反转字符串

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.ReverseString344

解题方法：

自定义：数组翻转

#### 3.1.130 第557题. 反转字符串中的单词 III

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.ReverseWordIII557	

解题方法：

自定义：数组翻转

#### 3.1.131 第695题. 岛屿的最大面积

代码存放路径：cn.liulin.algorithm.leetcode.array.medium.MaximumArea695

解题方法：

自定义：数组翻转

#### 3.1.132 第542题. 01 矩阵

代码存放路径：cn.liulin.algorithm.leetcode.array.medium.Matrix542

解题方法：

自定义：广度优先搜索

#### 3.1.133 第994题. 腐烂的橘子

代码存放路径：cn.liulin.algorithm.leetcode.array.medium.RottenOranges994

解题方法：

自定义：广度优先搜索

#### 3.1.134 第75题. 颜色分类

代码存放路径：cn.liulin.algorithm.leetcode.array.medium.ColorClassification75

解题方法：

自定义：双指针

#### 3.1.135 第56题. 合并区间

代码存放路径：cn.liulin.algorithm.leetcode.array.medium.ConsolidationInterval56

解题方法：

自定义：排序

#### 3.1.136 第48题. 旋转图像

代码存放路径：cn.liulin.algorithm.leetcode.array.medium.RotateImage48

解题方法：

自定义：排序

#### 3.1.137 第59题. 螺旋矩阵 II

代码存放路径：cn.liulin.algorithm.leetcode.array.medium.SpiralMatrixII59

解题方法：

自定义：模拟

#### 3.1.138 第240题. 搜索二维矩阵 II

代码存放路径：cn.liulin.algorithm.leetcode.array.medium.SearchTwoMatrix240

解题方法：

自定义：Z字形查找

#### 3.1.139 第435题. 无重叠区间

代码存放路径：cn.liulin.algorithm.leetcode.array.medium.NonOverlappingInterval435

解题方法：

自定义：排序

#### 3.1.140 第334题. 递增的三元子序列

代码存放路径：cn.liulin.algorithm.leetcode.array.medium.Increasing334

解题方法：

自定义：贪心

#### 3.1.141 第238题. 除自身以外数组的乘积

代码存放路径：cn.liulin.algorithm.leetcode.array.medium.Product238

解题方法：

自定义：贪心

#### 3.1.142 第560题. 和为 K 的子数组

代码存放路径：cn.liulin.algorithm.leetcode.array.medium.SubarrayK560

解题方法：

自定义：贪心

#### 3.1.143 第169题. 多数元素

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.MostElements169

解题方法：

自定义：排序

#### 3.1.144 第15题. 多数元素

代码存放路径：cn.liulin.algorithm.leetcode.array.medium.SumOfThreeNumbers15

解题方法：

自定义：排序

### 3.2 字符串

#### 3.2.1 第387题. 字符串中的第一个唯一字符

代码存放路径：cn.liulin.algorithm.leetcode.string.simple.FirstUniqueCharacter387

解题方法：

自定义：数组法

#### 3.2.2 第383题. 赎金信

代码存放路径：cn.liulin.algorithm.leetcode.string.simple.RansomLetter383

解题方法：

自定义：数组法

#### 3.2.3 第242题. 有效的字母异位词

代码存放路径：cn.liulin.algorithm.leetcode.string.simple.ValidLetterHeteronyms242

解题方法：

自定义：数组法

#### 3.2.4 第3题. 无重复字符的最长子串

代码存放路径：cn.liulin.algorithm.leetcode.string.medium.LongestSubstring3

解题方法：

自定义：哈希表和滑动窗口

#### 3.2.5 第567题. 字符串的排列

代码存放路径：cn.liulin.algorithm.leetcode.string.medium.Arrangement567

解题方法：

自定义：哈希表和滑动窗口

#### 3.2.6 第415题. 字符串相加

代码存放路径：cn.liulin.algorithm.leetcode.string.simple.StringAddition415

解题方法：

自定义：哈希表和滑动窗口

#### 3.2.7 第409题. 最长回文串

代码存放路径：cn.liulin.algorithm.leetcode.string.simple.LongestPalindrome409

解题方法：

自定义：哈希表和滑动窗口

#### 3.2.8 第290题. 单词规律

代码存放路径：cn.liulin.algorithm.leetcode.string.simple.RulesOfWords290

解题方法：

自定义：哈希表

#### 3.2.9 第763题. 划分字母区间

代码存放路径：cn.liulin.algorithm.leetcode.string.medium.Dividing763

解题方法：

自定义：哈希表+贪心

#### 3.2.10 第49题. 字母异位词分组

代码存放路径：cn.liulin.algorithm.leetcode.string.medium.Grouping49

解题方法：

自定义：哈希表

#### 3.2.11 第43题. 字符串相乘

代码存放路径：cn.liulin.algorithm.leetcode.string.medium.StringMultiplication43

解题方法：

自定义：模拟或数组乘积

#### 3.2.12 第187题. 重复的DNA序列

代码存放路径：cn.liulin.algorithm.leetcode.string.medium.RepeatedDNA187

解题方法：

自定义：哈希表

#### 3.2.13 第5题. 最长回文子串

代码存放路径：cn.liulin.algorithm.leetcode.string.medium.Longest5

解题方法：

自定义：哈希表

### 3.3 链表

#### 3.3.1 第141题. 环形链表

代码存放路径：cn.liulin.algorithm.leetcode.linkedlist.simple.CircularLinkedList141

解题方法：

自定义：哈希表

官方：快慢指针

#### 3.2.2 第21题. 合并两个有序链表

代码存放路径：cn.liulin.algorithm.leetcode.string.simple.MergeOrderLinkedList21

解题方法：

官方：递归

#### 3.2.3 第203题. 移除链表元素

代码存放路径：cn.liulin.algorithm.leetcode.string.simple.RemoveLinkedListElements203

解题方法：

自定义：递归

#### 3.2.3 第206题.反转链表

代码存放路径：cn.liulin.algorithm.leetcode.string.simple.ReverseLinkedList206

解题方法：

自定义：迭代

#### 3.2.4 第83题. 删除排序链表中的重复元素

代码存放路径：cn.liulin.algorithm.leetcode.string.simple.DeleteDuplicateElements83

解题方法：

自定义：一次遍历

#### 3.2.5 第876题. 链表的中间结点

代码存放路径：cn.liulin.algorithm.leetcode.string.simple.NodeOfLinkedList876

解题方法：

自定义：一次遍历

#### 3.2.6 第19题. 删除链表的倒数第 N 个结点

代码存放路径：cn.liulin.algorithm.leetcode.linkedlist.medium.DeleteTheNode19

解题方法：

自定义：一次遍历

#### 3.2.7 第2题. 两数相加

代码存放路径：cn.liulin.algorithm.leetcode.linkedlist.medium.AddTwoNumbers2

解题方法：

自定义：循环进位

#### 3.2.8 第142题. 环形链表 II

代码存放路径：cn.liulin.algorithm.leetcode.linkedlist.medium.CircularII142

解题方法：

自定义：循环进位

#### 3.2.9 第160题. 相交链表

代码存放路径：cn.liulin.algorithm.leetcode.linkedlist.medium.CircularII142

解题方法：

自定义：哈希表，数学法

#### 3.2.10 第82题. 删除排序链表中的重复元素 II

代码存放路径：cn.liulin.algorithm.leetcode.linkedlist.medium.DeleteList82

解题方法：

自定义：顺序遍历

#### 3.2.11 第24题. 两两交换链表中的节点

代码存放路径：cn.liulin.algorithm.leetcode.linkedlist.medium.SwitchTheNodes24

解题方法：

自定义：顺序遍历

#### 3.2.12 第707题. 设计链表

代码存放路径：cn.liulin.algorithm.leetcode.linkedlist.medium.MyLinkedList

解题方法：

自定义：创建链表

### 3.4 栈\队列

#### 3.4.1 第20题. 有效的括号

代码存放路径：cn.liulin.algorithm.leetcode.stack.simple.ValidParentheses20

解题方法：

自定义：栈

#### 3.4.2 第232题. 用栈实现队列

代码存放路径：cn.liulin.algorithm.leetcode.stack.simple.ImplementingQueueWithStack232

解题方法：

自定义：栈

### 3.5 树

#### 3.5.1 第144题. 二叉树的前序遍历

代码存放路径：cn.liulin.algorithm.leetcode.tree.simple.PreorderTraversalOfBinaryTree144

解题方法：

自定义：树的前序遍历

#### 3.5.2 第94题. 二叉树的中序遍历

代码存放路径：cn.liulin.algorithm.leetcode.tree.simple.MiddleOrderTraversalOfBinaryTree94

解题方法：

自定义：树的中序遍历

#### 3.5.3 第145题. 二叉树的后序遍历

代码存放路径：cn.liulin.algorithm.leetcode.tree.simple.MiddleOrderTraversalOfBinaryTree94

解题方法：

自定义：树的后序遍历

#### 3.5.4 第102题.  二叉树的层序遍历

代码存放路径：cn.liulin.algorithm.leetcode.tree.medium.SequenceTraversalOfBinaryTree102

解题方法：

自定义：递归法

#### 3.5.5 第104题. 二叉树的最大深度

代码存放路径：cn.liulin.algorithm.leetcode.tree.simple.MaximumDepthOfBinaryTree104

解题方法：

自定义：递归法

#### 3.5.6 第101题. 对称二叉树

代码存放路径：cn.liulin.algorithm.leetcode.tree.simple.SymmetricBinaryTree101

解题方法：

自定义：递归法

#### 3.5.7 第226题. 翻转二叉树

代码存放路径：cn.liulin.algorithm.leetcode.tree.simple.FlipBinaryTree226

解题方法：

自定义：递归法

#### 3.5.8 第112题. 路径总和

代码存放路径：cn.liulin.algorithm.leetcode.tree.simple.PathSum112

解题方法：

自定义：递归法

#### 3.5.9 第700题. 二叉搜索树中的搜索

代码存放路径：cn.liulin.algorithm.leetcode.tree.simple.SearchInBinarySearchTree700

解题方法：

自定义：迭代法

#### 3.5.10 第701题. 二叉搜索树中的插入操作

代码存放路径：cn.liulin.algorithm.leetcode.tree.medium.InsertBinarySearchTree701

解题方法：

自定义：迭代法

#### 3.5.11 第98题. 验证二叉搜索树

代码存放路径：cn.liulin.algorithm.leetcode.tree.medium.ValidateBinarySearchTree98

解题方法：

自定义：中序遍历

#### 3.5.12 第653题. 两数之和 IV - 输入 BST

代码存放路径：cn.liulin.algorithm.leetcode.tree.simple.SumOfTwoIV653

解题方法：

自定义：中序遍历

#### 3.5.13 第235题. 二叉搜索树的最近公共祖先

代码存放路径：cn.liulin.algorithm.leetcode.tree.simple.SumOfTwoIV653

解题方法：

自定义：递归

#### 3.5.14 第617题. 合并二叉树

代码存放路径：cn.liulin.algorithm.leetcode.tree.simple.MergeBinaryTree617

解题方法：

自定义：递归

#### 3.5.15 第116题. 填充每个节点的下一个右侧节点指针

代码存放路径：cn.liulin.algorithm.leetcode.tree.medium.PopulateTheNext116

解题方法：

自定义：递归

### 3.6 算法

#### 3.6.1 第278题. 第一个错误的版本

代码存放路径：cn.liulin.algorithm.leetcode.algorithm.simple.FirstWrongVersion278

解题方法：

自定义：二分查找法

#### 3.6.2 第77题. 组合

代码存放路径：cn.liulin.algorithm.leetcode.algorithm.medium.Combination77

解题方法：

自定义：二分查找法

#### 3.6.3 第46题. 全排列

代码存放路径：cn.liulin.algorithm.leetcode.algorithm.medium.FullArrangement46

解题方法：

自定义：二分查找法

#### 3.6.4 第784题. 字母大小写全排列

代码存放路径：cn.liulin.algorithm.leetcode.algorithm.medium.LettersFullCase784

解题方法：

自定义：二分查找法

#### 3.6.5 第70题. 爬楼梯

代码存放路径：cn.liulin.algorithm.leetcode.algorithm.simple.ClimbStairs70

解题方法：

自定义：滚筒法

#### 3.6.6 第198题. 打家劫舍

代码存放路径：cn.liulin.algorithm.leetcode.algorithm.medium.HouseRaiding198

解题方法：

自定义：滚筒法

#### 3.6.7 第231题. 2 的幂

代码存放路径：cn.liulin.algorithm.leetcode.algorithm.simple.PowerOfTwo231

解题方法：

自定义：滚筒法

#### 3.6.8 第191题. 位1的个数

代码存放路径：cn.liulin.algorithm.leetcode.algorithm.simple.NumberOfBitOne191

解题方法：

自定义：滚筒法

#### 3.6.9 第136题. 只出现一次的数字

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.NumbersOnlyOnce136

解题方法：

自定义：异或算法

#### 3.6.10 第169题. 多数元素

代码存放路径：cn.liulin.algorithm.leetcode.array.simple.NumbersOnlyOnce136

解题方法：

自定义：排序除法

#### 3.6.11 第15题. 三数之和

代码存放路径：cn.liulin.algorithm.leetcode.array.medium.SumOfThree15

解题方法：

自定义：排序，双指针

### 3.7 动态规划

#### 3.7.1 第509题. 斐波那契数

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.simple.Fibonacci509

解题方法：

自定义：递归

#### 3.7.2 第1137题. 泰波那契数

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.simple.Tabonacci1137

解题方法：

自定义：滚筒法

#### 3.7.3 第198题. 打家劫舍

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.BeatingFamilies198

解题方法：

自定义：滚筒法

#### 3.7.4 第213题. 打家劫舍 II

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.HousebreakingII213

解题方法：

自定义：复制滚筒法

#### 3.7.5 第740题. 删除并获得点数

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.DeleteGetPoints740

解题方法：

自定义：复制滚筒法

#### 3.7.6 第55题. 跳跃游戏

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.JumpingGame55

解题方法：

自定义：复制滚筒法

#### 3.7.7 第45题. 跳跃游戏 II

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.JumpingGameII45

解题方法：

自定义：复制滚筒法

#### 3.7.8 第53题. 最大子数组和

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.Maximum53

解题方法：

自定义：复制滚筒法

#### 3.7.9 第918题. 环形子数组的最大和

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.MaximumSum918

解题方法：

自定义：复制滚筒法

#### 3.7.10 第152题. 乘积最大子数组

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.ProductMaximum152

解题方法：

自定义：复制滚筒法

#### 3.7.11 第1567题. 乘积为正数的最长子数组长度

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.PositiveProduct1567

解题方法：

自定义：复制滚筒法

#### 3.7.12 第1014题. 最佳观光组合

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.SightseeingCombination1014

解题方法：

自定义：复制滚筒法

#### 3.7.13 第121题. 买卖股票的最佳时机

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.simple.SellStocks121

解题方法：

自定义：复制滚筒法

#### 3.7.14 第122题. 买卖股票的最佳时机 II

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.SellStocksII122

解题方法：

自定义：复制滚筒法

#### 3.7.15 第309题. 最佳买卖股票时机含冷冻期

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.BestTimeSellStock309

解题方法：

自定义：复制滚筒法

#### 3.7.16 第139题. 单词拆分

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.WordSplitting139

解题方法：

自定义：复制滚筒法

#### 3.7.17 第42题. 接雨水

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.hard.RainwaterConnection42

解题方法：

自定义：复制滚筒法

#### 3.7.18 第413题. 等差数列划分

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.Division413

解题方法：

自定义：复制滚筒法

#### 3.7.19 第91题. 解码方法

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.DecodingMethod91

解题方法：

自定义：复制滚筒法

#### 3.7.20 第264题.丑数 II

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.UglyNumberII264

解题方法：

自定义：复制滚筒法

#### 3.7.21 第96题. 不同的二叉搜索树

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.DifferentBinary96

解题方法：

自定义：复制滚筒法

#### 3.7.22 第118题. 杨辉三角

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.simple.YanghuiTriangle118

解题方法：

自定义：复制滚筒法

#### 3.7.23 第119题. 杨辉三角II

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.simple.YanghuiTriangleII119

解题方法：

自定义：复制滚筒法

#### 3.7.24 第931题. 下降路径最小和

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.MinimumSum931

解题方法：

自定义：复制滚筒法

#### 3.7.25 第120题. 三角形最小路径和

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.TriangularMin120

解题方法：

自定义：复制滚筒法

#### 3.7.26 第1314题. 矩阵区域和

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.MatrixArea1314

解题方法：

自定义：复制滚筒法

#### 3.7.27 第304题. 二维区域和检索 - 矩阵不可变

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.MatrixArea1314

解题方法：

自定义：复制滚筒法

#### 3.7.28 第62题. 不同路径

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.DifferentPaths62

解题方法：

自定义：复制滚筒法

#### 3.7.29 第63题. 不同路径 II

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.DifferentPathsII63

解题方法：

自定义：复制滚筒法

#### 3.7.30 第64题. 最小路径和

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.MinimumPathAnd64

解题方法：

自定义：复制滚筒法

#### 3.7.31 第221题. 最大正方形

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.MaximumSquare221

解题方法：

自定义：复制滚筒法

#### 3.7.32 第5题. 最长回文子串

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.LongestPalindromeSubstring5

解题方法：

自定义：复制滚筒法

#### 3.7.33 第516题. 最长回文子序列

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.LongestPalindrome516

解题方法：

自定义：复制滚筒法

#### 3.7.34 第300题. 最长递增子序列

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.LongestIncreasing300

解题方法：

自定义：复制滚筒法

#### 3.7.35 第376题. 摆动序列

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.SwingSequence376

解题方法：

自定义：复制滚筒法

#### 3.7.36 第1143题. 最长公共子序列

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.LongestCommon1143

解题方法：

自定义：复制滚筒法

#### 3.7.37 第322题. 零钱兑换

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.Change322

解题方法：

自定义：复制滚筒法

#### 3.7.38 第518题. 零钱兑换 II

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.ChangeII518

解题方法：

自定义：复制滚筒法

#### 3.7.39 第377题. 组合总和 Ⅳ

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.TotalCombinationIV377

解题方法：

自定义：复制滚筒法

#### 3.7.40 第343题. 整数拆分

代码存放路径：cn.liulin.algorithm.leetcode.dynamic.medium.IntegerSplitting343

解题方法：

自定义：复制滚筒法

### 3.8编程

#### 3.8.1 第1523题. 在区间范围内统计奇数数目

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.CountTheOdd1523

解题方法：

自定义：数学计算法

官方：前缀和（区间尾的奇数数量包含区级始的奇数数量）

#### 3.8.2 第1491题. 去掉最低工资和最高工资后的工资平均值

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.AverageWageAfter1491

解题方法：

自定义：数学计算法

#### 3.8.3 第191题. 位1的个数

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.NumberOfBitOne191

解题方法：

自定义：数学计算法

官方：对数字的每一位做&运算，2^i次方，如果结果不为0，就说明该位置不是0，是1

​			对数字的最低1去值计算，当结果为0，就说明1去完了，统计次数

#### 3.8.4 第1281题. 整数的各位积和之差

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.DifferenceBetween1281

解题方法：

自定义：数学计算法

官方：通过对10不断取余数，得到每一位数

#### 3.8.5 第976题. 三角形的最大周长

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.MaximumPerimeter976

解题方法：

自定义：数学计算法

#### 3.8.6 第1779题. 找到最近的有相同 X 或 Y 坐标的点

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.FindTheNearest1779

解题方法：

自定义：数学计算法

#### 3.8.7 第1822题. 数组元素积的符号

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.SymbolOfArray1822

解题方法：

自定义：数学计算法

#### 3.8.8 第1502题. 判断能否形成等差数列

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.JudgeWhether1502

解题方法：

自定义：数学计算法

#### 3.8.9 第202题. 快乐数

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.HappyNumber202

解题方法：

自定义：数学计算法

#### 3.8.10 第1790题. 仅执行一次字符串交换能否使两个字符串相等

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.CanTwoStrings1790

解题方法：

自定义：数学计算法

#### 3.8.11 第589题. N 叉树的前序遍历

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.PreorderTraversal589

解题方法：

自定义：数学计算法

#### 3.8.12 第496题. 下一个更大元素 I

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.NextLargerElement496

解题方法：

自定义：栈+哈希表

#### 3.8.13 第1232题. 缀点成线

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.LacingPointFormingLine1323

解题方法：

自定义：两点式，一般式

Ax + By + C = 0

(y - y2) / (x - x2) = (y - y1) / (x - x1)

#### 3.8.14 第1588题. 所有奇数长度子数组的和

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.SumOfAll1588

解题方法：

自定义：暴力法

官方：前缀和

#### 3.8.15 第283题. 移动零

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.MoveZero283

解题方法：

自定义：暴力法

官方：双指针

#### 3.8.16 第1672题. 最富有客户的资产总量

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.TotalAssets1672

解题方法：

自定义：对比法

#### 3.8.17 第1572题. 矩阵对角线元素的和

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.SumOfDiagonal1572

解题方法：

自定义：对比法

#### 3.8.18 第566题. 重塑矩阵

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.ReshapeMatrix566

解题方法：

自定义：数学法

#### 3.8.19 第1768题. 交替合并字符串

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.Alternately1768

解题方法：

自定义：数学法

#### 3.8.20 第1678题. 设计 Goal 解析器

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.DesigningGoalParser1678

解题方法：

自定义：数学法

#### 3.8.21 第389题. 找不同

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.FindDifference389

解题方法：

自定义：计数法

官方：求和，位运算

#### 3.8.22 第709题. 转换成小写字母

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.ConvertToLower709

解题方法：

自定义：根据ASCII码值计算

#### 3.8.23 第1309题. 解码字母到整数映射

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.DecodingLetter1309

解题方法：

自定义：根据ASCII码值计算

#### 3.8.24 第953题. 验证外星语词典

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.VerifyingAnAlien953

解题方法：

自定义： 根据index位置计算

#### 3.8.25 第1290题. 二进制链表转整数

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.BinaryLinked1290

解题方法：

自定义： 根据index位置计算

#### 3.8.26 第876题. 链表的中间结点

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.IntermediateNode876

解题方法：

自定义： 快慢指针

#### 3.8.27 第104题. 二叉树的最大深度

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.MaximumDepth104

解题方法：

自定义： 递归

#### 3.8.28 第404题. 左叶子之和

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.SumOfLeft404

解题方法：

自定义： 递归

#### 3.8.29 第1356题. 根据数字二进制下 1 的数目排序

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.SortAccording1356

解题方法：

自定义： 排序

#### 3.8.30 第232题. 用栈实现队列

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.MyQueue232

解题方法：

自定义： 栈

#### 3.8.31 第242题. 有效的字母异位词

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.ValidAlphabetic242

解题方法：

自定义： 数组

#### 3.8.32 第217题. 存在重复元素

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.DuplicateElements217

解题方法：

自定义： 哈希表

#### 3.8.33 第1603题. 设计停车系统

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.DesignParking1603

解题方法：

自定义：数据表

#### 3.8.34 第303题. 区域和检索 - 数组不可变

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.RegionAndRetrieval303

解题方法：

自定义：前缀和

#### 3.8.35 第896题. 单调数列

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.Monotone896

解题方法：

自定义：一次遍历

#### 3.8.36 第28题. 找出字符串中第一个匹配项的下标

代码存放路径：cn.liulin.algorithm.leetcode.code.medium.FirstMatch28

解题方法：

自定义：朴素算法

#### 3.8.37 第110题. 平衡二叉树

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.Balance110

解题方法：

官方：自顶向下

自底向上

#### 3.8.38 第459题. 重复的子字符串

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.DuplicateSubstrings459

解题方法：

自定义：暴力

#### 3.8.39 第150题. 逆波兰表达式求值

代码存放路径：cn.liulin.algorithm.leetcode.code.medium.Evaluation150

解题方法：

自定义：栈

#### 3.8.40 第66题. 加一

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.AddOne66

解题方法：

自定义：暴力

#### 3.8.41 第1367题. 二叉树中的链表

代码存放路径：cn.liulin.algorithm.leetcode.code.medium.ListInBinary1367

解题方法：

官方：暴力

#### 3.8.42 第43题. 字符串相乘

代码存放路径：cn.liulin.algorithm.leetcode.code.medium.StringMultiplication43

解题方法：

官方：暴力

#### 3.8.43 第67题. 二进制求和

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.BinarySummation67

解题方法：

官方：暴力

#### 3.8.44 第989题. 数组形式的整数加法

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.IntegerAddition989

解题方法：

官方：暴力

#### 3.8.45 第739题. 每日温度

代码存放路径：cn.liulin.algorithm.leetcode.code.medium.DailyTemperature739

解题方法：

官方：暴力

#### 3.8.46 第58题. 最后一个单词的长度

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.LengthLast58

解题方法：

官方：暴力

#### 3.8.47 第48题. 旋转图像

代码存放路径：cn.liulin.algorithm.leetcode.code.medium.RotateImage48

解题方法：

官方：对称转换

#### 3.8.48 第1886题. 判断矩阵经轮转后是否一致

代码存放路径：cn.liulin.algorithm.leetcode.code.simple.JudgeWhether1886

解题方法：

官方：旋转转换

#### 3.8.49 第54题. 螺旋矩阵

代码存放路径：cn.liulin.algorithm.leetcode.code.medium.SpiralMatrix54

解题方法：

官方：旋转转换
