import java.util.concurrent.Semaphore;

public class ProdCon {
    static final int K = 10;
    static Semaphore semOs = new Semaphore(0);
    static Semaphore semProc = new Semaphore(0);
    static Semaphore mutex = new Semaphore(1);
    static int packetsInMemory = 0;

    static byte[] getDataPacket() { return new byte[0]; }
    static byte[][] readNetBuffer() { return new byte[0][0]; }
    static void fillPackets(byte[][] data) {}

    public static void receive() {
        for (;;) {
            try {
                mutex.acquire();
                if (packetsInMemory == 0) {
                    semOs.release();
                    mutex.release();
                    semProc.acquire();
                    mutex.acquire();
                }
                
                byte[] packet = getDataPacket();
                packetsInMemory--;
                
                mutex.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void handle() {
        for (;;) {
            try {
                semOs.acquire();
                
                byte[][] data = readNetBuffer();
                fillPackets(data);
                
                mutex.acquire();
                packetsInMemory = K;
                for (int i = 0; i < K; i++) {
                    semProc.release();
                }
                mutex.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}