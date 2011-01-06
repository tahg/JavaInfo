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
public abstract class CPRef extends CPBase {
    int class_index, name_and_type_index;
    CPRef(ConstantPool cp, DataInputStream dis) throws IOException {
        super(cp);
        class_index = dis.readUnsignedShort();
        name_and_type_index = dis.readUnsignedShort();
    }

    @Override
    public boolean verify() {
        return owner.getEntry(class_index) instanceof CPClass &&
                owner.getEntry(name_and_type_index) instanceof CPNameAndType;
    }
}
