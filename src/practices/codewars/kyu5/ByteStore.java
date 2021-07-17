package practices.codewars.kyu5;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * A {@code ByteStore} stores bytes.
 */
public class ByteStore {
  private String mode;
  private ByteBuffer byteBuffer;

  public ByteStore() {
    this.byteBuffer = ByteBuffer.allocate(1100 * 1024 * 1024);
    this.byteBuffer.limit(0);
  }

  /**
   * Switch store to write or read mode. After switch to write mode, store is empty
   * and bytes may be written. After switch to read mode, written bytes may be read.
   * Initially, store is neither in read nor write mode.
   * @param write switch to write mode or read mode?
   * @throws IOException if store is already in given mode or an I/O error occurs
   */
  public void reset(boolean write) throws IOException {
    // TODO
    String requestedMode = write ? "write" : "read";
    if (requestedMode.equals(this.mode)) throw new IOException("The store is already in given mode");
    if (write) this.byteBuffer.limit(0);
    if (!write) this.byteBuffer.position(0);
    this.mode = requestedMode;
  }

  /**
   * Copy {@code len} bytes from {@code buf} starting at offset {@code off} into this store.
   * @param buf bytes
   * @param off offset
   * @param len length
   * @return 0 if {@code len} is 0, -1 if store is full or not in write mode, number of written bytes otherwise
   * @throws IOException if an I/O error occurs
   */
  public int write(byte[] buf, int off, int len) throws IOException {
    // TODO
    if (len==0) return 0;
    int numberOfBytes = Math.min(len, buf.length-off);
    int newLimit = this.byteBuffer.limit() + numberOfBytes;
    if(newLimit > this.byteBuffer.capacity() || !"write".equals(this.mode)) return -1;
    this.byteBuffer.limit(newLimit);
    this.byteBuffer.put(buf, off, numberOfBytes);
    return numberOfBytes;
  }

  /**
   * Copy at most {@code len} bytes from this store into {@code buf} starting at offset {@code off}.
   * @param buf bytes
   * @param off offset
   * @param len length
   * @return 0 if {@code len} is 0, -1 if store is empty or not in read mode, number of read bytes otherwise
   * @throws IOException if an I/O error occurs
   */
  public int read(byte[] buf, int off, int len) throws IOException {
    // TODO
    if (len==0) return 0;
    if (!this.byteBuffer.hasRemaining() || !"read".equals(this.mode)) return -1;
    int numberOfBytes = Math.min(len, this.byteBuffer.remaining());
    this.byteBuffer.get(buf, off, numberOfBytes);
    return numberOfBytes;
  }
}
