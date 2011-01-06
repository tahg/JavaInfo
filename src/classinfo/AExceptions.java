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
public class AExceptions extends AttributeInfo {

    int[] exception_index_table;

    public AExceptions(ConstantPool cp, DataInputStream dis, int index) throws IOException {
        super(cp, index);
        int length = dis.readInt();
        int count = dis.readUnsignedShort();
        for (int i = 0; i < count; i++) {
            exception_index_table[i] = dis.readUnsignedShort();
        }
    }
}
