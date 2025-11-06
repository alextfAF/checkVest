package com.odc.plugins.checkvest;

import android.content.Context;
import android.content.res.AssetFileDescriptor;

import com.getcapacitor.Logger;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.Interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class CheckVest {

    private final Context context;
    private Interpreter interpreter;

    public CheckVest(Context context) {
        this.context = context;
    }

    public String echo(String value) {
        Logger.info("Echo", value);
        return value;
    }

    /**
     * Memory-map the model file from assets for efficient loading.
     */
    private MappedByteBuffer loadModel() throws IOException {
        AssetFileDescriptor afd = context.getAssets().openFd("model.lite");
        FileInputStream is = new FileInputStream(afd.getFileDescriptor());
        FileChannel channel = is.getChannel();
        long start = afd.getStartOffset();
        long length = afd.getDeclaredLength();
        MappedByteBuffer mapped = channel.map(FileChannel.MapMode.READ_ONLY, start, length);
        channel.close();
        is.close();
        afd.close();
        return mapped;
    }

    /**
     * Encodes a string array into a TensorFlow Lite input buffer.
     */
    private ByteBuffer encodeStringTensor(String[] strings) {
        // Simplified example — you can adjust this depending on your model’s preprocessing
        int maxLen = 256;
        ByteBuffer buffer = ByteBuffer.allocateDirect(maxLen).order(ByteOrder.nativeOrder());
        for (String s : strings) {
            byte[] bytes = s.getBytes();
            buffer.put(bytes, 0, Math.min(bytes.length, maxLen));
        }
        buffer.rewind();
        return buffer;
    }

    /**
     * Accepts the image as a base64 string and feeds it to the TensorFlow Lite model.
     * The model must declare STRING input and BOOL output.
     */
    public boolean checkHasVest(String imageString, boolean showLogs) {
        try {
            if (interpreter == null) {
                MappedByteBuffer model = loadModel();
                interpreter = new Interpreter(model, new Interpreter.Options());
            }

            int[] inShape = interpreter.getInputTensor(0).shape();
            DataType inType = interpreter.getInputTensor(0).dataType();

            if (inType != DataType.STRING) {
                Logger.warn("checkHasVest", "Model input[0] is not STRING; got " + inType);
                return false;
            }

            String[] strings = new String[]{imageString != null ? imageString : ""};
            ByteBuffer inputBuffer = encodeStringTensor(strings);

            int[] outShape = interpreter.getOutputTensor(0).shape();
            int outElements = 1;
            for (int d : outShape) outElements *= d;

            DataType outType = interpreter.getOutputTensor(0).dataType();
            if (outType != DataType.BOOL) {
                Logger.warn("checkHasVest", "Unsupported output dtype (expected BOOL): " + outType);
                return false;
            }

            ByteBuffer outBuffer = ByteBuffer.allocateDirect(outElements).order(ByteOrder.nativeOrder());
            interpreter.run(inputBuffer, outBuffer);

            outBuffer.rewind();
            boolean hasVest = (outBuffer.get(0) != 0);

            if (showLogs) {
                Logger.info("checkHasVest", "Result=" + hasVest);
            }

            return hasVest;

        } catch (Exception e) {
            Logger.error("checkHasVest", e);
            return false;
        }
    }
}