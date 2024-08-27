class MedianFinder {
    //tow heap small and large
    //max heap and min heap
    // the size of tow heap should be equals
    private  PriorityQueue<Integer> small;
    private  PriorityQueue<Integer> large;


    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> b - a); //max heap
        large = new PriorityQueue<>(); //min heap

    }

    public void addNum(int num) {
        small.offer(num);

        if (!large.isEmpty() && small.peek() > large.peek())
             large.offer(small.poll());

        if (small.size() > large.size() + 1)
            large.offer(small.poll());

        else if (large.size() > small.size()+1)
            small.offer(large.poll());


    }

    public double findMedian() {
        if (small.size() > large.size())
            return small.peek();
        if (large.size() > small.size())
            return large.peek();

        double v = ((double) small.peek() + large.peek()) / 2;
        return v;

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */