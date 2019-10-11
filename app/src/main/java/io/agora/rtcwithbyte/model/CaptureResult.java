package io.agora.rtcwithbyte.model;

import java.nio.ByteBuffer;

/**
 * 拍照结果类
 */
public class CaptureResult {
    private ByteBuffer byteBuffer;
    private int width;
    private int height;

    public CaptureResult() {
    }

    public CaptureResult(ByteBuffer byteBuffer, int width, int height) {
        this.byteBuffer = byteBuffer;
        this.width = width;
        this.height = height;
    }

    public ByteBuffer getByteBuffer() {
        return byteBuffer;
    }

    public void setByteBuffer(ByteBuffer byteBuffer) {
        this.byteBuffer = byteBuffer;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
