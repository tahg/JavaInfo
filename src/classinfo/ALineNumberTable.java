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
public class ALineNumberTable extends AttributeInfo {

    LineNumberTableEntry[] line_number_table;

    public ALineNumberTable(ConstantPool cp, DataInputStream dis, int index) throws IOException {
        super(cp, index);
        int length = dis.readInt();
        int count = dis.readUnsignedShort();
        line_number_table = new LineNumberTableEntry[count];
        for (int i = 0; i < count; i++) {
            line_number_table[i] = new LineNumberTableEntry(dis);
        }
    }
}
