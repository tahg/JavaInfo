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
public class CPClass extends CPBase {

    private int name_index;

    public CPClass(ConstantPool cp, DataInputStream dis) throws IOException {
        super(cp);
        name_index = dis.readUnsignedShort();

    }

    @Override
    public int getType() {
        return 7;
    }

    @Override
    public boolean verify() {
        CPBase name = owner.getEntry(name_index);
        return name instanceof CPUtf8;
    }
}
