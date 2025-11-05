package com.odc.plugins.checkvest;

import com.getcapacitor.Logger;

public class CheckVest {

    public String echo(String value) {
        Logger.info("Echo", value);
        return value;
    }


    // Accepts the image as a base64 STRING and feeds it directly to the model (model must declare STRING input and BOOL output).
    public boolean checkHasVest(String imageString, boolean showLogs) {
        try {
            if (imageString != null) {
                Logger.info("checkHasVest", "imageString: " + imageString);
                return true;
            } else {
                // FIX: use Logger.warn or provide an Exception to Logger.error
                Logger.warn("checkHasVest: imageString is null");
                return false;
            }

            /*  
            // Uncomment below when model.tflite is ready
            if (t == null) {
                MappedByteBuffer model = loadModel("model.tflite");
                t = new Interpreter(model, new Interpreter.Options());
            }

            int[] inShape = t.getInputTensor(0).shape();
            DataType inType = t.getInputTensor(0).dataType();
            if (inType != DataType.STRING) {
                Logger.warn("vestvalidator.checkHasVest: Model input[0] is not STRING; got " + inType);
                return false;
            }

            String[] strings = new String[] { imageString != null ? imageString : "" };
            ByteBuffer inputBuffer = encodeStringTensor(strings);

            int[] outShape = t.getOutputTensor(0).shape();
            int outElements = 1;
            for (int d : outShape) outElements *= d;

            DataType outType = t.getOutputTensor(0).dataType();
            if (outType != DataType.BOOL) {
                Logger.warn("vestvalidator.checkHasVest: Unsupported output dtype (expected BOOL): " + outType);
                return false;
            }

            ByteBuffer outBuffer = ByteBuffer.allocateDirect(outElements).order(ByteOrder.nativeOrder());
            t.run(inputBuffer, outBuffer);

            outBuffer.rewind();
            boolean hasVest = (outBuffer.get(0) != 0);
            if (showLogs) {
                Logger.info("checkHasVest", "Result=" + hasVest);
            }
            return hasVest;
            */

        } catch (Exception e) {
            // FIX: Logger.error expects (tag, Throwable)
            Logger.error("checkHasVest", e);
            return false;
        }
    }
}
