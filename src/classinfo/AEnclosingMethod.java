/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package classinfo;

import java.io.DataInputStream;
import java.io.IOException;

/**
 *
 * @author Nathan
 */
public class AEnclosingMethod extends AttributeInfo {
    int class_index;
    int method_index;
    public AEnclosingMethod(ConstantPool cp, DataInputStream dis, int index) throws IOException {
        super(cp, index);
        int length = dis.readInt();
        if(length != 4) throw new IOException();
        class_index = dis.readUnsignedShort();
        method_index = dis.readUnsignedShort();
    }
}
