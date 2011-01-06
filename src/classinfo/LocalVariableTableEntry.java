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
public class LocalVariableTableEntry {
    int start_pc;
    int length;
    int name_index;
    int descriptor_index;
    int index;
    public LocalVariableTableEntry(DataInputStream dis) {
        try {
            start_pc = dis.readUnsignedShort();
            length = dis.readUnsignedShort();
            name_index = dis.readUnsignedShort();
            descriptor_index = dis.readUnsignedShort();
            index = dis.readUnsignedShort();
        } catch (IOException ex) {
        }
    }
}
