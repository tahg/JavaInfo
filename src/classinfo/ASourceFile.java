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
public class ASourceFile extends AttributeInfo {
    int sourcefile_index;
    public ASourceFile(ConstantPool cp, DataInputStream dis, int index) throws IOException {
        super(cp, index);
        int length = dis.readInt();
        if(length != 2) throw new IOException();
        sourcefile_index = dis.readUnsignedShort();
    }
}
