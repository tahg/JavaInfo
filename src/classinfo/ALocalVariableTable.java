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
public class ALocalVariableTable extends AttributeInfo {

    LocalVariableTableEntry[] local_variable_table;

    public ALocalVariableTable(ConstantPool cp, DataInputStream dis, int index) throws IOException {
        super(cp, index);
        int length = dis.readInt();
        int count = dis.readUnsignedShort();
        local_variable_table = new LocalVariableTableEntry[count];
        for (int i = 0; i < count; i++) {
            local_variable_table[i] = new LocalVariableTableEntry(dis);
        }
    }
}
