package org.example.heapmemory;

public class HeapMemoryDemo {

    public static void main(String[] args) {

        System.out.println("Allocating memory on HEAP...");
        Runtime runtime = Runtime.getRuntime();
        long maxHeap = runtime.maxMemory();
        long totalHeap = runtime.totalMemory();
        System.out.println("Max Heap Size   : " + toMB(maxHeap) + " MB");
        System.out.println("Total Heap Size : " + toMB(totalHeap) + " MB");

        long freeHeapBeforeAllocation = runtime.freeMemory();
        long usedHeapBeforeAllocation = totalHeap - freeHeapBeforeAllocation;
        System.out.println("Before allocation Used Heap Size  : " + toMB(usedHeapBeforeAllocation) + " MB");
        System.out.println("Before allocation Free Heap Size  : " + toMB(freeHeapBeforeAllocation) + " MB");
        byte[] heapData = new byte[100 * 1024 * 1024]; //100MB

        long freeHeap = runtime.freeMemory();
        long usedHeap = totalHeap - freeHeap;
        System.out.println("Used Heap Size  : " + toMB(usedHeap) + " MB");
        System.out.println("Free Heap Size  : " + toMB(freeHeap) + " MB");
    }

    private static long toMB(long bytes) {
        return bytes / (1024 * 1024);
    }
}
