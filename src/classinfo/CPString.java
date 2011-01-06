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
public class CPString extends CPBase {

    int string_index;

    CPString(ConstantPool cp, DataInputStream dis) throws IOException {
        super(cp);
        string_index = dis.readUnsignedShort();
    }

    @Override
    public int getType() {
        return 8;
    }

    @Override
    public boolean verify() {
        return owner.getEntry(string_index) instanceof CPUtf8;
    }
}
