package org.example.heapmemory;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

public class PanamaOffHeapDemo {

    public static void main(String[] args) {

        String javaString = "Hello Panama";
        //An arena controls the lifecycle of native memory segments, providing both flexible allocation and timely deallocation.
        //ByteBuffer.allocateDirect(100 * 1024 * 1024) -older way - since Java 1.4

        try (Arena arena = Arena.ofConfined()) {
            MemorySegment cString =
                    arena.allocateFrom(javaString);

            // Read back
            String readBack = cString.getString(0);
            System.out.println("Read back: " + readBack);
        }
    }
}
