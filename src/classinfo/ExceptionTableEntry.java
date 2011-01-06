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
public class ExceptionTableEntry {

    int start_pc, end_pc, handler_pc, catch_type;

    public ExceptionTableEntry(DataInputStream dis) {
        try {
            start_pc = dis.readUnsignedShort();
            end_pc = dis.readUnsignedShort();
            handler_pc = dis.readUnsignedShort();
            catch_type = dis.readUnsignedShort();
        } catch (IOException ex) {
        }
    }
}
