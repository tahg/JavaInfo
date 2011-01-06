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
public class ASourceDebugExtension extends AttributeInfo {
    String debug_extension;
    public ASourceDebugExtension(ConstantPool cp, DataInputStream dis, int index) throws IOException {
        super(cp, index);
        dis.readUnsignedShort();
        debug_extension = dis.readUTF();
    }
}
