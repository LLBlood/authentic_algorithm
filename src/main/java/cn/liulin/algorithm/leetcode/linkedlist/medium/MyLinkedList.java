package cn.liulin.algorithm.leetcode.linkedlist.medium;

/**
 * cn.liulin.algorithm.leetcode.linkedlist.medium$
 * 707. 设计链表
 * @author ll
 * @date 2022-08-11 17:12:07
 **/
public class MyLinkedList {
    int val;
    MyLinkedList next;
    MyLinkedList prev;

    public MyLinkedList() {

    }

    public int get(int index) {
        if (index < 0) {
            return -1;
        }
        MyLinkedList cur = this;
        int curIndex = 0;
        while (cur.prev != null) {
            cur = cur.prev;
        }
        while (cur != null && curIndex < index) {
            cur = cur.next;
            curIndex++;
        }
        if (cur != null && cur != this) {
            return cur.val;
        }
        return -1;
    }

    public void addAtHead(int val) {
        MyLinkedList cur = this;
        while (cur.prev != null) {
            cur = cur.prev;
        }
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.val = val;
        myLinkedList.next = cur;
        cur.prev = myLinkedList;
    }

    public void addAtTail(int val) {
        MyLinkedList cur = this;
        MyLinkedList prev = cur.prev;
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.val = val;
        if (prev != null) {
            prev.next = myLinkedList;
            myLinkedList.prev = prev;
        }
        myLinkedList.next = cur;
        cur.prev = myLinkedList;
    }

    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
        } else {
            MyLinkedList cur = this;
            int curIndex = 0;
            while (cur.prev != null) {
                cur = cur.prev;
            }
            while (cur != null && cur != this) {
                if (curIndex == index - 1) {
                    MyLinkedList tempNext = cur.next;
                    MyLinkedList myLinkedList = new MyLinkedList();
                    myLinkedList.val = val;
                    cur.next = myLinkedList;
                    myLinkedList.prev = cur;
                    myLinkedList.next = tempNext;
                    if (tempNext != null) {
                        tempNext.prev = myLinkedList;
                    }
                    break;
                }
                curIndex++;
                cur = cur.next;
            }
        }
    }

    public void deleteAtIndex(int index) {
        MyLinkedList cur = this;
        int curIndex = 0;
        while (cur.prev != null) {
            cur = cur.prev;
        }
        while (cur != null && cur != this) {
            if (curIndex == index) {
                MyLinkedList tempPre = cur.prev;
                MyLinkedList tempNext = cur.next;
                if (tempPre != null) {
                    tempPre.next = tempNext;
                }
                if (tempNext != null) {
                    tempNext.prev = tempPre;
                }
                break;
            }
            curIndex++;
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(3, 0);
        myLinkedList.deleteAtIndex(2);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);
        for (int i = 0; i < 6; i++) {
            System.out.println(myLinkedList.get(i));
        }
        myLinkedList.get(4);
        myLinkedList.addAtHead(4);
        myLinkedList.addAtIndex(5, 0);
        myLinkedList.addAtHead(6);
    }
}
