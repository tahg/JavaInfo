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
public class LocalVariableTypeTableEntry {
    int start_pc;
    int length;
    int name_index;
    int signature_index;
    int index;
    public LocalVariableTypeTableEntry(DataInputStream dis) {
        try {
            start_pc = dis.readUnsignedShort();
            length = dis.readUnsignedShort();
            name_index = dis.readUnsignedShort();
            signature_index = dis.readUnsignedShort();
            index = dis.readUnsignedShort();
        } catch (IOException ex) {
        }
    }
}
