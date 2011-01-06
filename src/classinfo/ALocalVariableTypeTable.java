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
public class ALocalVariableTypeTable extends AttributeInfo {

    LocalVariableTypeTableEntry[] local_variable_type_table;

    public ALocalVariableTypeTable(ConstantPool cp, DataInputStream dis, int index) throws IOException {
        super(cp, index);
        int length = dis.readInt();
        int count = dis.readUnsignedShort();
        local_variable_type_table = new LocalVariableTypeTableEntry[count];
        for (int i = 0; i < count; i++) {
            local_variable_type_table[i] = new LocalVariableTypeTableEntry(dis);
        }
    }
}
