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
public class ASignature extends AttributeInfo {
    int signature_index;
    public ASignature(ConstantPool cp, DataInputStream dis, int index) throws IOException {
        super(cp, index);
        int length = dis.readInt();
        if(length != 2) throw new IOException();
        signature_index = dis.readUnsignedShort();
    }
}
