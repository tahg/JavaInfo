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
public class LineNumberTableEntry {
    int start_pc;
    int line_number;
    public LineNumberTableEntry(DataInputStream dis) {
        try {
            start_pc = dis.readUnsignedShort();
            line_number = dis.readUnsignedShort();
        } catch (IOException ex) {
        }
    }
}
