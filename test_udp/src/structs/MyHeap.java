package structs;

import java.util.Arrays;

public class MyHeap {

    private static final int DEFAULT_INITIAL_CAPACITY = 11;

    transient Object[] queue;

    private int size = 0;

    public MyHeap() {
        queue = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public boolean offer(Integer e) {
        if (e == null)
            throw new NullPointerException();

        int i = size;

        if (i >= queue.length) {
            grow(i + 1);
        }
        size = i + 1;
        if (i == 0) {
            queue[0] = e;
        } else {
            siftUp(i, e);
        }
        return true;
    }

    private void grow(int minCapacity) {
        int oldCapacity = queue.length;
        // Double size if small; else grow by 50%
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                (oldCapacity + 2) :
                (oldCapacity >> 1));
        // overflow-conscious code
        if (newCapacity - Integer.MAX_VALUE - 8 > 0)
            newCapacity = (minCapacity > Integer.MAX_VALUE - 8) ?
                    Integer.MAX_VALUE :
                    Integer.MAX_VALUE - 8;
        queue = Arrays.copyOf(queue, newCapacity);
    }

    private void siftUp(int k, Integer x) {
        siftUpComparable(k, x);
    }

    private void siftUpComparable(int k, Integer x) {

        while (k > 0) {
            //找寻父节点位置
            int parent = (k - 1) >>> 1;
            //找到父节点
            Object e = queue[parent];
            //进行比较如果父节点大于目前节点就break将x放到当前节点
            if (compareTo(x, (Integer) e) >= 0) {

                break;

            }

            //如果小于就继续往上面找
            queue[k] = e;
            k = parent;
        }
        queue[k] = x;

    }

    public boolean add(Integer e) {

        return offer(e);
    }

    public Integer poll() {
        if (size == 0)
            return null;
        int s = --size;
        Integer result = (Integer) queue[0];
        Integer x = (Integer) queue[s];
        queue[s] = null;
        if (s != 0)
            siftDown(0, x);
        return result;
    }

    private void siftDown(int k, Integer x) {
        siftDownComparable(k, x);
    }

    @SuppressWarnings("unchecked")
    private void siftDownComparable(int k, Integer x) {
        // 先找出中间件节点
        int half = size >>> 1;
        while (k < half) {
            // 找到左子节点和右子节点，两个节点进行比较，找出最大的值
            int child = (k << 1) + 1;
            Object c = queue[child];
            int right = child + 1;
            // 左子节点与右子节点比较，取最小的节点
            if (right < size && compareTo((Integer) c, (Integer) queue[right]) > 0) {
//                logger.info("【出队】左右子节点比对，获取最小值。left：{} right：{}", JSON.toJSONString(c), JSON.toJSONString(queue[right]));
                c = queue[child = right];
            }
            // 目标值与c比较，当目标值小于c值，退出循环。说明此时目标值所在位置适合，迁移完成。
            if (compareTo(x, (Integer) c) <= 0) {
                break;
            }
            // 目标值小于c值，位置替换，继续比较
//            logger.info("【出队】替换过程，节点的值比对。上节点：{} 下节点：{} 位置替换", JSON.toJSONString(queue[k]), JSON.toJSONString(c));
            queue[k] = c;
            k = child;
        }
        // 把目标值放到对应位置
//        logger.info("【出队】替换结果，最终更换位置。Idx：{} Val：{}", k, JSON.toJSONString(x));
        queue[k] = x;
    }

    public Integer peek() {
        return (size == 0) ? null : (Integer) queue[0];
    }

    public int compareTo(Integer firstElement, Integer secondElement) {
        return firstElement.compareTo(secondElement);
    }


    public static void main(String[] args) {

        int[] a = new int[]{1,2,3,4,5,6,7};

        int k = 3;
        //父节点寻找方式
        int n = k >>> 1;

        int u = 2;
        //左节点寻找方式
        int s = (u << 1) + 1;

        System.out.println(a[u]+" "+a[s]);

//        MyHeap myHeap = new MyHeap();
//        myHeap.add(1);
//        myHeap.add(2);
//        myHeap.add(3);
//        myHeap.add(0);
//        myHeap.add(5);
//        myHeap.add(6);






    }



}
